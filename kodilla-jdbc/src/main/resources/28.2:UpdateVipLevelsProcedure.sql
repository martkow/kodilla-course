DROP PROCEDURE IF EXISTS UpdateVipLevels;

DELIMITER $$

CREATE PROCEDURE UpdateVipLevels()
BEGIN
    DECLARE BOOKSREAD, DAYS, RDR_ID INT;
    DECLARE BOOKSPERMONTH DECIMAL(5,2);

    -- Cursor --
    DECLARE FINISHED BINARY DEFAULT 0; -- Loop control variable definition

    DECLARE ALL_READERS CURSOR FOR SELECT READER_ID FROM READERS; -- Cursor of name ALL_READERS declaration, it iterates through all readers fetching readers id.
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET FINISHED=1; -- We declare a HANDLER for the NOT FOUND event – it will set the value of the FINISHED variable to 1 when the data in the cursor ends.
    OPEN ALL_READERS;

    WHILE (FINISHED = 0) DO
            FETCH ALL_READERS INTO RDR_ID; -- We retrieve one record from the cursor. Since the cursor only returns the value of the READER_ID column from the READERS table, its value is stored in a single variable called RDR_ID.

            IF (FINISHED = 0) THEN -- We check whether by any chance we have reached the end of the set of data returned by the cursor. We need to perform such an additional check inside the WHILE loop, because the loop condition will be checked only after all the instructions contained in the loop have been executed.
                SELECT COUNT(*) FROM RENTS
                WHERE READER_ID = RDR_ID
                INTO BOOKSREAD;

                SELECT DATEDIFF(MAX(RENT_DATE), MIN(RENT_DATE)) + 1 FROM RENTS --  This calculates the difference in days between the latest (MAX(RENT_DATE)) and the earliest (MIN(RENT_DATE)) rental dates for this reader. + 1: This adds 1 to the difference to include both the first and the last day in the count.
                WHERE READER_ID = RDR_ID
                INTO DAYS;

                SET BOOKSPERMONTH = BOOKSREAD / DAYS * 30;

                UPDATE READERS
                SET VIP_LEVEL = VipLevel(BOOKSPERMONTH)
                WHERE READER_ID = RDR_ID;
                COMMIT; -- We confirm the changes we have made for the record (modified records are locked for editing by other users until the changes are approved).
            END IF;
        END WHILE ;

    CLOSE ALL_READERS;
END $$

DELIMITER ;

CALL UpdateVipLevels();