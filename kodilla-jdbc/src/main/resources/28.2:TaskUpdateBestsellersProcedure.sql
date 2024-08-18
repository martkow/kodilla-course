/*
Task 28.2: The aim of the task is to write a procedure that identifies bestsellers,
i.e. books whose copies are borrowed more than twice a month.
*/
SELECT * FROM RENTS;

SELECT
    book_id,
    COUNT(*) AS total_rents,
    COUNT(DISTINCT DATE_FORMAT(rent_date, '%Y-%m')) AS unique_months, -- Number of unique months for which books were borrowed
    COUNT(*) / COUNT(DISTINCT DATE_FORMAT(rent_date, '%Y-%m')) AS rents_per_month
FROM rents
WHERE book_id IN (SELECT book_id FROM books)
GROUP BY book_id
HAVING rents_per_month > 2;


ALTER TABLE BOOKS ADD COLUMN BESTSELLER BINARY DEFAULT 0;
SELECT * FROM BOOKS;

DROP PROCEDURE IF EXISTS  UpdateBestsellers;

DELIMITER $$

CREATE PROCEDURE UpdateBestsellers()
    BEGIN
        DECLARE BOOK_RENTS, MONTH_RENTS, BK_ID INT;
        DECLARE RENTS_PER_MONTH DECIMAL(5,2);

        DECLARE FINISHED BINARY DEFAULT 0;
        DECLARE ALL_BOOKS CURSOR FOR SELECT BOOK_ID FROM BOOKS;
        DECLARE CONTINUE HANDLER FOR NOT FOUND SET FINISHED=1;
        OPEN ALL_BOOKS;

        WHILE (FINISHED = 0) DO
            FETCH ALL_BOOKS INTO BK_ID;

            IF (FINISHED = 0) THEN
                SELECT COUNT(*) FROM RENTS
                WHERE BOOK_ID = BK_ID INTO BOOK_RENTS;

                IF (BOOK_RENTS != 0) THEN
                    SELECT COUNT(DISTINCT DATE_FORMAT(rent_date, '%Y-%m')) FROM RENTS
                    WHERE BOOK_ID = BK_ID INTO MONTH_RENTS;

                    SET RENTS_PER_MONTH = BOOK_RENTS / MONTH_RENTS;

                    IF (RENTS_PER_MONTH > 2) THEN
                        UPDATE BOOKS SET BESTSELLER = 1
                        WHERE BOOK_ID = BK_ID;
                    END IF;
                END IF;
            END IF;
        END WHILE;

        CLOSE ALL_BOOKS;
    END $$

DELIMITER ;

CALL UpdateBestsellers();
