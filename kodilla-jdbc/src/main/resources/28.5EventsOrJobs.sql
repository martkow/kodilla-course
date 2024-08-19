/*
 Events -> In MySQL, an event is a task that is scheduled to run automatically at specified
 intervals or at a particular time.

 In Oracle, for instance, this is known as the job scheduler or simply jobs.
 */
 -- To show running processes in DB
 SHOW PROCESSLIST;
-- To turn on mechanism event
SET GLOBAL EVENT_SCHEDULER=ON;
/*
 Create event ->
                CREATE EVENT <event_name>
                ON SCHEDULE <schedule>
                DO <instructions>

<schedule> -> available scheduling methods are:

AT <timestamp>[ + INTERVAL <interval>]:
 Executes the instructions at the specified time (timestamp), optionally extended to repeat at
 the specified time interval (interval).
EVERY <interval>:
 Executes the instructions at the specified time interval (interval),
 starting from the moment the event is defined.
For the interval, you need to provide a number of units and the unit of measurement, which can be:
 YEAR, QUARTER, MONTH, WEEK, DAY, HOUR, MINUTE, SECOND.
 */
USE KODILLA_COURSE; -- Switch to DB KODILLA_COURSE

-- We define a new event called UPDATE_VIPS, which is to be executed every minute, and its action is to call the stored procedure UpdateVipLevels().
CREATE EVENT UPDATE_VIPS
    ON SCHEDULE EVERY 1 MINUTE
    DO CALL UpdateVipLevels();

UPDATE READERS SET VIP_LEVEL = 'Not set';
SELECT * FROM READERS;

-- Deleting events
DROP EVENT UPDATE_VIPS;
