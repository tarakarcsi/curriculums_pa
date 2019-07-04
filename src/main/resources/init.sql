DROP TABLE IF EXISTS curriculums cascade;
DROP TABLE IF EXISTS users cascade;
DROP TABLE IF EXISTS purchases cascade;

create table curriculums(
    curriculumId serial PRIMARY KEY,
    title text,
    price int,
    content text
);

create table users(
    userId serial primary key,
    email varchar(40) not null,
    name varchar(40),
    credit int,
    password text not null,
    curriculums int,
    isAdmin boolean,
    FOREIGN KEY (curriculums) REFERENCES curriculums(curriculumId)
);



create table purchases(
    purchaseId serial PRIMARY KEY,
    userId int,
    curriculumId int,
    FOREIGN KEY (userId) REFERENCES users(userId),
    FOREIGN KEY (curriculumId) REFERENCES curriculums(curriculumId)
);


INSERT INTO users(email, name, password, isAdmin) VALUES ('admin1@curriculums.com', 'admin1', 'admin1', true);
INSERT INTO users(email, name, password, isAdmin) VALUES ('admin2@curriculums.com', 'admin2', 'admin2', true);
INSERT INTO users(email, name, password, isAdmin) VALUES ('user1@curriculums.com', 'user1', 'user1', false);
INSERT INTO users(email, name, password, isAdmin) VALUES ('user2@curriculums.com', 'user2', 'user2', false);
