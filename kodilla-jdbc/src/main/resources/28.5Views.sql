/*
 Views -> A view in a database is a virtual table that is created by a query from one or
 more underlying tables in the database.
 Unlike a physical table, a view does not store data itself but instead provides a way to
 look at data that is stored in other tables.

 CREATE VIEW <view_name> [<columns>] AS <select_expresion>

 optionally <columns> contains names of columns which could be different from those from select_expression.
 */
DROP VIEW BOOKS_AND_READERS;

CREATE VIEW BOOKS_AND_READERS AS
SELECT RD.READER_ID, RD.FIRSTNAME, RD.LASTNAME, BK.TITLE, RT.RENT_DATE, RT.RETURN_DATE
FROM READERS RD, BOOKS BK, RENTS RT
WHERE RT.BOOK_ID = BK.BOOK_ID AND RT.READER_ID = RD.READER_ID
ORDER BY RT.RENT_DATE;

SELECT * FROM BOOKS_AND_READERS;
SELECT * FROM BOOKS_AND_READERS
         WHERE RENT_DATE > DATE_SUB(CURDATE(), INTERVAL 5 DAY)
ORDER BY LASTNAME;