/*
 Show all procedures and functions.
 */
SHOW PROCEDURE STATUS;
SHOW FUNCTION STATUS;
-- Show details of the procedure or function
SHOW CREATE PROCEDURE GetUserName;
SHOW CREATE FUNCTION VipLevel;

/* The command SET GLOBAL log_bin_trust_function_creators=1;
   is used in MySQL or MariaDB to allow users without the SUPER privilege to create or alter
   stored functions and triggers.
 */
SET GLOBAL log_bin_trust_function_creators=1;
SHOW GRANTS FOR CURRENT_USER;

/* Creating new tables */
CREATE TABLE BOOKS (
                       BOOK_ID int(11) NOT NULL AUTO_INCREMENT,
                       TITLE varchar(255) NOT NULL,
                       PUBYEAR int(4) NOT NULL,
                       PRIMARY KEY (BOOK_ID)
);

CREATE TABLE READERS (
                         READER_ID int(11) NOT NULL AUTO_INCREMENT,
                         FIRSTNAME varchar(255) NOT NULL,
                         LASTNAME varchar(255) NOT NULL,
                         PESELID varchar(11) NOT NULL,
                         PRIMARY KEY (READER_ID)
);

CREATE TABLE RENTS (
                       RENT_ID int(11) NOT NULL AUTO_INCREMENT,
                       BOOK_ID int(11) NOT NULL,
                       READER_ID int(11) NOT NULL,
                       RENT_DATE datetime NOT NULL,
                       RETURN_DATE datetime,
                       PRIMARY KEY (RENT_ID),
                       FOREIGN KEY (BOOK_ID) REFERENCES BOOKS(BOOK_ID),
                       FOREIGN KEY (READER_ID) REFERENCES READERS(READER_ID)
);

/* Inserting some data */
INSERT INTO READERS(FIRSTNAME, LASTNAME, PESELID)
VALUES ('John', 'Smith', '83012217938');

INSERT INTO READERS(FIRSTNAME, LASTNAME, PESELID)
VALUES ('Curtis', 'Wilson', '75121002790');

INSERT INTO READERS(FIRSTNAME, LASTNAME, PESELID)
VALUES ('Cathy', 'Booker', '90112801727');

INSERT INTO READERS(FIRSTNAME, LASTNAME, PESELID)
VALUES ('Marissa', 'Cain', '84061908044');

INSERT INTO READERS(FIRSTNAME, LASTNAME, PESELID)
VALUES ('Muriel', 'Fulton', '76081409269');

COMMIT;

INSERT INTO BOOKS(TITLE, PUBYEAR)
VALUES ('The Stranger', 1942);

INSERT INTO BOOKS(TITLE, PUBYEAR)
VALUES ('In Search of Lost Time', 1927);

INSERT INTO BOOKS(TITLE, PUBYEAR)
VALUES ('The Trial', 1925);

INSERT INTO BOOKS(TITLE, PUBYEAR)
VALUES ('The Little Prince', 1943);

INSERT INTO BOOKS(TITLE, PUBYEAR)
VALUES ('Man\'s Fate', 1933);

COMMIT;

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (1, 1, DATE_SUB(CURDATE(), INTERVAL 10 DAY), null);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (2, 1, DATE_SUB(CURDATE(), INTERVAL 10 DAY), null);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (4, 1, DATE_SUB(CURDATE(), INTERVAL 10 DAY), DATE_SUB(CURDATE(), INTERVAL 5 DAY));

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (1, 3, DATE_SUB(CURDATE(), INTERVAL 8 DAY), null);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (5, 3, DATE_SUB(CURDATE(), INTERVAL 4 DAY), DATE_SUB(CURDATE(), INTERVAL 2 DAY));

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (5, 4, DATE_SUB(CURDATE(), INTERVAL 10 DAY), DATE_SUB(CURDATE(), INTERVAL 8 DAY));

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (5, 5, DATE_SUB(CURDATE(), INTERVAL 8 DAY), null);

COMMIT;

/* Creating procedures and functions in MySql
DELIMITER $$ -> First, we change the default separator (delimiter) from a semicolon to the double dollar sign $$.
   // procedure definition
DELIMITER ; -> The last line restores the default separator, which is the semicolon.
*/
DELIMITER $$

CREATE PROCEDURE ListBooks()
BEGIN
    SELECT * FROM BOOKS;
END $$

DELIMITER ;
/* Calling procedures */
CALL ListBooks();

/* Modifying already created procedures
DROP PROCEDURE IF EXISTS <procedure_name>; -> First, delete the procedure you will be modifying
*/
DROP PROCEDURE IF EXISTS ListBooks;

DELIMITER $$

CREATE PROCEDURE ListBooks()
BEGIN
    SELECT BOOK_ID, TITLE, PUBYEAR FROM BOOKS;
END $$

DELIMITER ;

CALL ListBooks();

/*
Creating functions
DELIMITER $$

CREATE FUNCTION <function_name>([<args>]) RETURNS <typed_returned> [NOT] DETERMINISTIC
BEGIN
    RETURN 'String';
END $$

DELIMITER ;
*/
DROP FUNCTION IF EXISTS VipLevel;

DELIMITER $$

CREATE FUNCTION VipLevel() RETURNS VARCHAR(20) DETERMINISTIC
BEGIN
    RETURN 'Standard customer';
END $$

DELIMITER ;
/* Calling functions */
SELECT VipLevel() AS LEVEL;

/*
Local Variables ->
DECLARE <var_name><var_type> [DEFAULT <default_value>]

The variable type can be any of the data types available in MySQL, for example: VARCHAR(50).
Each declared variable initially has the value NULL.
If you want to give it an initial value, you can use the optional DEFAULT phrase, where <default_value> should specify the initial default value of the variable.
 */
DROP FUNCTION IF EXISTS VipLevel;

DELIMITER $$

CREATE FUNCTION VipLevel() RETURNS VARCHAR(20) DETERMINISTIC
BEGIN
    DECLARE result VARCHAR(20) DEFAULT 'Standard customer';
    RETURN result;
END $$

DELIMITER ;

SELECT VipLevel() AS LEVEL;

/*
Global Variables (session variables) ->
DECLARE @<var_name><var_type> [DEFAULT <default_value>]

Assigning value to a variable ->
SET <var_name> = <value>

If statement ->
IF <condition> THEN
   <instructions_if_true>
ELSEIF <condition2> THEN
   <instructions_if_true2>
ELSE
   <else_instructions>
END IF

Logic operators -> AND OR NOT
*/
DROP FUNCTION IF EXISTS VipLevel;

DELIMITER $$

CREATE FUNCTION VipLevel(booksrented INT) RETURNS VARCHAR(20) DETERMINISTIC -- [1]
BEGIN									                                    -- [2]
    DECLARE result VARCHAR(20) DEFAULT 'Standard customer';	                -- [3]
    IF booksrented >= 10 THEN						                        -- [4]
        SET result = 'Gold customer';					                        -- [5]
    ELSEIF booksrented >= 5 AND booksrented < 10 THEN			            -- [6]
        SET result = 'Silver customer';				                        -- [7]
    ELSEIF booksrented >= 2 AND booksrented < 5 THEN			            -- [8]
        SET result = 'Bronze customer';		           		                -- [9]
    ELSE				      					                                -- [10]
        SET result = 'Standard customer';				                        -- [11]
    END IF;				    				                                -- [12]
    RETURN result;
END $$

DELIMITER ;

SELECT VipLevel(2) AS LEVEL;

/**********************************************************************************************/
SELECT * FROM READERS;
SELECT * FROM RENTS;

SELECT COUNT(*) FROM RENTS WHERE READER_ID=1 GROUP BY EXTRACT(MONTH FROM RENT_DATE);

ALTER TABLE READERS ADD VIP_LEVEL VARCHAR(20);

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

