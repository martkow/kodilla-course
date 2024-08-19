/*

 */
CREATE TABLE PHONES (
                        PHONE_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        PHONE_NUM INT,
                        FIRSTNAME VARCHAR(50),
                        LASTNAME VARCHAR(50)
);

DROP PROCEDURE FillTestData;

DELIMITER $$

CREATE PROCEDURE FillTestData()
    BEGIN
        DECLARE K INT DEFAULT 0;

        WHILE (K < 100000) DO
                INSERT INTO PHONES (PHONE_NUM,
                                    FIRSTNAME,
                                    LASTNAME)
                VALUES(ROUND(RAND()*1000000000),
                       CONCAT('Firstname number ', K),
                       CONCAT('Lastname number ', K));
/*
Executing COMMITs after a certain increment of changes ->
Executing a COMMIT operation is quite time-consuming and affects performance.
If we perform batch operations – that is, we modify many records in the database in one processing cycle,
it is worth dividing these changes into "packages" of several dozen or several hundred records
(sometimes more) committed with one collective COMMIT,
in order to minimize the impact of the COMMIT operation on the performance of the batch operation.
 */
                IF (MOD(K, 5000) = 0) THEN
                    COMMIT;
                END IF;

                SET K = K + 1;
        END WHILE;
        COMMIT;
    END $$

DELIMITER ;

CALL FillTestData();

SELECT * FROM PHONES;

/*
 Performance Analysis ->
 The table will be populated with a histogram showing the distribution of phone numbers
 (how many numbers fall within a given range).
 The ranges will be set at intervals of one thousand numbers.
 The distribution of numbers in the PHONES table should be approximately even,
 as the built-in pseudorandom number generator in MySQL has a uniform distribution
 (meaning each number within the draw range is selected with the same probability).
*/
CREATE TABLE PHONE_STATS (
                            ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                            RANGE_FROM INT,
                            RANGE_TO INT,
                            QUANTITY INT
);

DELIMITER $$

CREATE PROCEDURE CalcPhoneStats()
BEGIN
    DECLARE K INT DEFAULT 0;
    DECLARE QTY INT;

    DELETE FROM PHONE_STATS;
    COMMIT;

    WHILE (K < 100000000) DO
            SELECT COUNT(*)
            FROM PHONES
            WHERE PHONE_NUM BETWEEN K-99999 AND K   -- [-99 999,0], [1, 100 000], [100 001, 200 000], ...
            INTO QTY;

            INSERT INTO PHONE_STATS (RANGE_FROM, RANGE_TO, QUANTITY)
            VALUES (K-99999, K, QTY);
            COMMIT;

            SET K = K + 100000;
    END WHILE;
END $$

DELIMITER ;

CALL CalcPhoneStats();
SELECT * FROM PHONE_STATS;

/*
Why did it take so long to call CalcPhonesStats()?
The PHONES table contains one hundred thousand phone numbers.
The table is searched each time by checking the number of numbers that fall within the given range.
This is a large amount of data to search.
Especially since the search is based on comparing each record with the requested boundary values
of the ranges.
Is there any way to speed this up? -> indexes.

BTREE index -> Balanced Tree

 */

/*
Analyse sql statements -> EXPLAIN <sql_statement>

<possible_keys>: null
<keys>: null
for this select; no indexes are available and used.

Query Plan:
*/
EXPLAIN SELECT COUNT(*)
        FROM PHONES
        WHERE PHONE_NUM BETWEEN 1 AND 100000;

-- Create index:
-- CREATE INDEX <index_name> ON <table_name> (<columns>)
-- where <index_name> is the name under which the index will be created
-- <table_name> is the table to which the index is to be applied
-- <columns> is the name of the column (or several columns separated by commas) for which the index is to be created.

-- At this point, a new structure (balanced tree) was created next to the PHONES table, which speeds up searching in the PHONES table by the PHONE_NUM column.
CREATE INDEX PHONE_NO ON PHONES (PHONE_NUM);

SHOW INDEXES FROM PHONES;