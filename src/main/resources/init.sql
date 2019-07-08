DROP TABLE IF EXISTS curriculums cascade;
DROP TABLE IF EXISTS sections cascade;
DROP TABLE IF EXISTS pages cascade;
DROP TABLE IF EXISTS users cascade;
DROP TABLE IF EXISTS admins cascade;
DROP TABLE IF EXISTS purchases cascade;

create table curriculums(
    curriculumId serial PRIMARY KEY,
    title text,
    price int,
    content text
);

create table sections(
    sectionId serial PRIMARY KEY,
    curriculumId int,
    FOREIGN KEY (curriculumId) REFERENCES curriculums(curriculumId)
);

create table pages(
    pageId serial PRIMARY KEY,
    sectionId int,
    FOREIGN KEY (sectionId) REFERENCES sections(sectionId)
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
