DROP TABLE IF EXISTS topics cascade;
DROP TABLE IF EXISTS curriculums cascade;
DROP TABLE IF EXISTS users cascade;
DROP TABLE IF EXISTS admins cascade;
DROP TABLE IF EXISTS purchases cascade;

create table topics(
    topicId serial PRIMARY KEY,
    title text
);

create table curriculums(
    curriculumId serial PRIMARY KEY,
    title text,
    price int,
    content text,
    topicId int,
    FOREIGN KEY (topicId) REFERENCES topics(topicId)
);

create table users(
    userId serial primary key,
    email varchar(40) not null,
    name varchar(40),
    credit int,
    password text not null,
    curriculums int,
    FOREIGN KEY (curriculums) REFERENCES curriculums(curriculumId)
);

create table admins(
    adminId serial primary key,
    email varchar(40) not null,
    name varchar(40),
    password text
);

create table purchases(
    purchaseId serial PRIMARY KEY,
    userId int,
    curriculumId int,
    FOREIGN KEY (userId) REFERENCES users(userId),
    FOREIGN KEY (curriculumId) REFERENCES curriculums(curriculumId)
);




INSERT INTO users(email, name, password) VALUES ('user1@curriculums.com', 'user1', 'user1');
INSERT INTO users(email, name, password) VALUES ('user2@curriculums.com', 'user2', 'user2');
INSERT INTO admins(email, name, password) VALUES ('admin1@curriculums.com', 'admin1', 'admin1');
INSERT INTO admins(email, name, password) VALUES ('admin2@curriculums.com', 'admin2', 'admin2');

INSERT INTO topics(title) VALUES ('javaScript');
INSERT INTO topics(title) VALUES ('Python');
INSERT INTO topics(title) VALUES ('SCRUM');

INSERT INTO curriculums(title, price, content, topicId) VALUES ('What is JavaScript?', 0, 'https://developer.mozilla.org/en-US/docs/Learn/JavaScript/First_steps/What_is_JavaScript', 1);
INSERT INTO curriculums(title, price, content, topicId) VALUES ('First splash into JavaScript', 5, 'https://developer.mozilla.org/en-US/docs/Learn/JavaScript/First_steps/A_first_splash', 1);

INSERT INTO curriculums(title, price, content, topicId) VALUES ('What is Python? Executive Summary', 0, 'https://www.python.org/doc/essays/blurb/', 2);
INSERT INTO curriculums(title, price, content, topicId) VALUES ('Getting Python, first steps', 5, 'https://realpython.com/python-first-steps/#2-getting-python-a-prelim', 2);

INSERT INTO curriculums(title, price, content, topicId) VALUES ('What is SCRUM?', 0, 'https://www.scrum.org/resources/what-is-scrum', 3);
INSERT INTO curriculums(title, price, content, topicId) VALUES ('Basic SCRUM Rules', 5, 'https://www.visual-paradigm.com/scrum/10-basic-scrum-rules/', 3);

