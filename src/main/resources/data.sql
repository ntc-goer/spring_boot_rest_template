-- Insert with all values provided
INSERT INTO users (userName, birthDate)
VALUES ('JohnDoe', '1990-05-15T10:30:00');
INSERT INTO users (userName, birthDate)
VALUES ('JaneSmith', '1985-12-20T08:00:00');
INSERT INTO users (userName, birthDate)
VALUES ('PeterJones', '2002-03-10T14:45:30');

-- Inserting with only the required fields (userName) and letting the database handle the timestamp.
-- This assumes your database has a default value or allows nulls for birthDate
INSERT INTO users (userName)
VALUES ('AliceJohnson');
INSERT INTO users (userName)
VALUES ('BobWilliams');

-- Inserting with explicit NULL for birthDate
INSERT INTO users (userName, birthDate)
VALUES ('EvaBrown', NULL);

-- More examples with different date/time formats (adapt to your database's accepted formats)
INSERT INTO users (userName, birthDate)
VALUES ('DavidLee', '1978-09-25 16:20:00'); -- Space instead of 'T'
INSERT INTO users (userName, birthDate)
VALUES ('SusanDavis', '2005-01-01 00:00:00');
-- Midnight

--Example with timezone offset (if your database supports it)
INSERT INTO users (userName, birthDate)
VALUES ('TomWilson', '1993-07-08T11:10:00+02:00'); -- Timezone offset of +02:00



INSERT INTO posts (title, content, userId)
VALUES
    ('Post Title 1', 'Content for post 1', 1),
    ('Post Title 2', 'Content for post 2', 2),
    ('Post Title 3', 'Content for post 3', 3),
    ('Post Title 4', 'Content for post 4', 4),
    ('Post Title 5', 'Content for post 5', 3),
    ('Post Title 6', 'Content for post 6', 2),
    ('Post Title 7', 'Content for post 7', 3),
    ('Post Title 8', 'Content for post 8', 1),
    ('Post Title 9', 'Content for post 9', 7);