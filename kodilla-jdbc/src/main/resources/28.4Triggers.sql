/*
Triggers -> procedures which are called BEFORE/AFTER some event happens.
Trigger type: BEFORE, AFTER.
Type of event that activates the trigger: DELETE, UPDATE, INSERT.

CREATE TRIGGER <trigger_name> <trigger_type> <event_type> ON <table>
FOR EACH ROW
BEGIN
   <instructions>
END

In triggers, we can use the NEW and OLD variables representing the record after changes
and the record before changes. We can use respectively:

In triggers for INSERT – we have access to the NEW variable (no OLD variable)
In triggers for DELETE – we have access to the OLD variable (no NEW variable)
In UPDATE triggers – we have access to both the NEW variable and the OLD variable.
 */
SET @RENTS_QTY = 0; -- Global variable declaration

DELIMITER $$

CREATE TRIGGER RENTS_COUNTER BEFORE INSERT ON RENTS
    FOR EACH ROW
BEGIN
    SET @RENTS_QTY = @RENTS_QTY + 1;
END $$

DELIMITER ;

SELECT  @RENTS_QTY;

/* Deleteing triggers */
DROP TRIGGER RENTS_COUNTER;

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES(1, 3, DATE_SUB(CURDATE(), INTERVAL 5 DAY), NULL);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES(2, 3, DATE_SUB(CURDATE(), INTERVAL 2 DAY), NULL);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES(3, 1, DATE_SUB(CURDATE(), INTERVAL 5 DAY), NULL);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES(2, 4, DATE_SUB(CURDATE(), INTERVAL 3 DAY), NULL);

COMMIT;

