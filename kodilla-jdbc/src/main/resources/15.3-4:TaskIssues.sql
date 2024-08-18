-- CREATING TABLES
CREATE TABLE ISSUESLISTS (
                             ID SERIAL PRIMARY KEY,
                             NAME VARCHAR(100) NOT NULL
);

CREATE TABLE ISSUES (
                        ID SERIAL PRIMARY KEY,
                        ISSUESLIST_ID BIGINT UNSIGNED NOT NULL,
                        SUMMARY VARCHAR(100) NOT NULL,
                        DESCRIPTION VARCHAR(500),
                        USER_ID_ASSIGNEDTO BIGINT UNSIGNED,
                        FOREIGN KEY (ISSUESLIST_ID) REFERENCES ISSUESLISTS(ID),
                        FOREIGN KEY (USER_ID_ASSIGNEDTO) REFERENCES USERS(ID)
);

-- INSERTING DATA
INSERT INTO ISSUESLISTS (NAME) VALUES
                                   ('ToDo'),
                                   ('In progress'),
                                   ('Done');

INSERT INTO ISSUES (ISSUESLIST_ID, SUMMARY, DESCRIPTION, USER_ID_ASSIGNEDTO)
VALUES (1, 'Task 1 for ToDo', 'Description of Task 1', NULL),
       (1, 'Task 2 for ToDo', 'Description of Task 2', 2),
       (1, 'Task 3 for ToDo', 'Description of Task 3', 3),
       (1, 'Task 4 for ToDo', 'Description of Task 4', 4),
       (1, 'Task 5 for ToDo', 'Description of Task 5', NULL),
       (2, 'Task 1 for In progress', 'Description of Task 1', 1),
       (2, 'Task 2 for In progress', 'Description of Task 2', 1),
       (2, 'Task 3 for In progress', 'Description of Task 3', 2),
       (2, 'Task 4 for In progress', 'Description of Task 4', 3),
       (2, 'Task 5 for In progress', 'Description of Task 5', 4),
       (3, 'Task 1 for Done', 'Description of Task 1', 3),
       (3, 'Task 2 for Done', 'Description of Task 2', 4),
       (3, 'Task 3 for Done', 'Description of Task 3', 5),
       (3, 'Task 4 for Done', 'Description of Task 4', 1),
       (3, 'Task 5 for Done', 'Description of Task 5', 2);

-- SELECTING DATA
SELECT I.SUMMARY, I.DESCRIPTION, IL.NAME
FROM ISSUES I LEFT JOIN ISSUESLISTS IL on I.ISSUESLIST_ID = IL.ID;

SELECT I.SUMMARY, I.DESCRIPTION, U.FIRSTNAME, U.LASTNAME
FROM ISSUES I LEFT JOIN USERS U on I.USER_ID_ASSIGNEDTO = U.ID;

SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS TASKS_NUMBER
FROM USERS U JOIN ISSUES I on U.ID = I.USER_ID_ASSIGNEDTO
GROUP BY U.ID;