/*
 Task 28.5: Create table STATS cointanining satistics and view BESTSELLERS_COUNT.
            Create an event which use the view to save statistics to STATS
 */
 DROP TABLE STATS;
 CREATE TABLE STATS (
                        STAT_ID INT AUTO_INCREMENT PRIMARY KEY,
                        STAT_DATE DATETIME NOT NULL,
                        STAT VARCHAR(20) NOT NULL,
                        VALUE INT NOT NULL
 );

CREATE VIEW BESTSELLERS_COUNT AS
    SELECT COUNT(*) AS VALUE FROM BOOKS WHERE BESTSELLER = true;

DELIMITER $$

CREATE EVENT UPDATE_BESTSELLERS
    ON SCHEDULE EVERY 1 MINUTE
    DO
        BEGIN
            DECLARE B_VALUE INT;

            CALL UpdateBestsellers();

            SELECT * FROM BESTSELLERS_COUNT INTO B_VALUE;

            INSERT INTO STATS (STAT_DATE, STAT, VALUE)
                VALUES (CURTIME(), 'BESTSELLERS', B_VALUE);
        END $$

DELIMITER ;

DROP EVENT UPDATE_BESTSELLERS;

SELECT * FROM BESTSELLERS_COUNT;
SELECT * FROM STATS;