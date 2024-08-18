/*
When working with real-world production systems, it is often necessary to have precise
audit information about changes that have occurred in tables.

What is audit information? It refers to details about all operations performed on a table—such as
inserting, modifying, and deleting records—along with the date and time when
these actions were performed.

Audit information is typically stored either in application logs or in so-called audit tables
(sometimes referred to as shadow tables).
*/
DROP TABLE RENTS_AUD;

CREATE TABLE RENTS_AUD (
                           EVENT_ID INT(11) NOT NULL AUTO_INCREMENT,
                           EVENT_DATE DATETIME NOT NULL,
                           EVENT_TYPE VARCHAR(10) DEFAULT NULL,
                           RENT_ID INT(11) NOT NULL,
                           OLD_BOOK_ID INT(11), -- A series of fields used to store information about the table's content before the change.
                           NEW_BOOK_ID INT(11), -- A series of fields used to store information about the table's content after the change.
                           OLD_READER_ID INT(11),
                           NEW_READER_ID INT(11),
                           OLD_RENT_DATE DATETIME,
                           NEW_RENT_DATE DATETIME,
                           OLD_RETURN_DATE DATETIME,
                           NEW_RETURN_DATE DATETIME,
                           PRIMARY KEY (EVENT_ID)
);

DROP TRIGGER RENTS_INSERT;

DELIMITER $$

CREATE TRIGGER RENTS_INSERT AFTER INSERT ON RENTS
    FOR EACH ROW
BEGIN
    -- We insert a new record into the audit table – this is our "log".
    INSERT INTO  RENTS_AUD (EVENT_DATE, EVENT_TYPE, RENT_ID, NEW_BOOK_ID, NEW_READER_ID, NEW_RENT_DATE, NEW_RETURN_DATE)
        VALUES (CURTIME(), 'INSERT', NEW.RENT_ID, NEW.BOOK_ID, NEW.READER_ID, NEW.RENT_DATE, NEW.RETURN_DATE); -- The new (inserted) record is represented inside the trigger by a variable named NEW.
END $$

DELIMITER ;

INSERT INTO RENTS (BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (2, 4, DATE_SUB(CURDATE(), INTERVAL 5 DAY), NULL);

COMMIT;

SELECT * FROM RENTS_AUD;

/***********************************************************************************/
DROP TRIGGER RENTS_DELETE;

DELIMITER $$

CREATE TRIGGER RENTS_DELETE AFTER DELETE ON RENTS
    FOR EACH ROW
BEGIN
    -- We insert a new record into the audit table – this is our "log".
    INSERT INTO  RENTS_AUD (EVENT_DATE, EVENT_TYPE, RENT_ID, OLD_BOOK_ID, OLD_READER_ID, OLD_RENT_DATE, OLD_RETURN_DATE)
    VALUES (CURTIME(), 'DELETE', OLD.RENT_ID, OLD.BOOK_ID, OLD.READER_ID, OLD.RENT_DATE, OLD.RETURN_DATE); -- The new (inserted) record is represented inside the trigger by a variable named NEW.
END $$

DELIMITER ;

DELETE FROM RENTS WHERE RENT_ID = 15;

COMMIT;

SELECT * FROM RENTS_AUD;

/***********************************************************************************/
DROP TRIGGER RENTS_UPDATE;

DELIMITER $$

CREATE TRIGGER RENTS_UPDATE AFTER UPDATE ON RENTS
    FOR EACH ROW
BEGIN
    -- We insert a new record into the audit table – this is our "log".
    INSERT INTO  RENTS_AUD (EVENT_DATE, EVENT_TYPE, RENT_ID, OLD_BOOK_ID, OLD_READER_ID, OLD_RENT_DATE, OLD_RETURN_DATE,  NEW_BOOK_ID, NEW_READER_ID, NEW_RENT_DATE, NEW_RETURN_DATE)
    VALUES (CURTIME(), 'UPDATE', OLD.RENT_ID, OLD.BOOK_ID, OLD.READER_ID, OLD.RENT_DATE, OLD.RETURN_DATE, NEW.BOOK_ID, NEW.READER_ID, NEW.RENT_DATE, NEW.RETURN_DATE); -- The new (inserted) record is represented inside the trigger by a variable named NEW.
END $$

DELIMITER ;

UPDATE RENTS SET BOOK_ID = 1
WHERE RENT_ID = 14;

COMMIT;

SELECT * FROM RENTS_AUD;
