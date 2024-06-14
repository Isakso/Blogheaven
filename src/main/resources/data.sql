-- Insert data into the 'ADDRESS' table
INSERT INTO ADDRESS (POSTAL_CODE, CITY, STREET, COUNTRY)
VALUES
    (21678, 'Gävle', 'Stockholmsvägen 23', 'Sweden'),
    (21451, 'Umeå', 'Arenagatan 83', 'Sweden'),
    (24567, 'Uppsala', 'Scheelegatan 45', 'Sweden'),
    (23111, 'Malmö', 'Mariedalsvägen 20', 'Sweden'),
    (21678, 'Rodeodrive', 'Oaklahoma 21', 'USA');

-- Insert data into the 'BLOG' table
INSERT INTO BLOG (TITLE, AUTHOR, CONTENT, PUBLICATION_DATE)
VALUES
    ('My First Blog', 'Alice Johnson', 'First blog post content.', '2024-05-01'),
    ('Exploring the Mountains', 'Bob Smith', 'Mountain hiking adventure.', '2024-05-15'),
    ('Tech Trends 2024', 'Charlie Brown', 'Latest tech trends.', '2024-05-28'),
    ('Healthy Living Tips', 'Dana White', 'Healthy lifestyle tips.', '2024-06-01'),
    ('Travel Guide: Paris', 'Eve Black', 'Guide for Paris travel.', '2024-06-10');

-- Insert data into the 'USERS' table
INSERT INTO USERS (ADDRESS_ID, BLOG_ID, NAME, EMAIL, FIRST_NAME, LAST_NAME, MEMBER_TYPE, PHONE_NO)
VALUES
    (1, 1, 'Anders Lundberg', 'anders@gmail.com', 'Anders', 'Lundberg', 'standard', '+46 70 123 45 67'),
    (2, 2, 'Markovich Bosanova', 'markobosa@outlook.com', 'Markovich', 'Bosanova', 'enhanced', '+46 70 234 56 78'),
    (4, 3, 'Mansa Musa', 'mansa@musa.nomail.com', 'Mansa', 'Musa', 'premium', '+46 70 345 67 89'),
    (3, 4, 'Israel Houton', 'israel@outlook.com', 'Israel', 'Houton', 'enhanced', '+46 70 456 78 90'),
    (5, 5, 'Mordecai Manire', 'manire@yahoo.nomail.com', 'Mordecai', 'Manire', 'premium', '+46 70 567 89 01');
