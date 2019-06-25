DROP TABLE IF EXISTS users cascade;
DROP TABLE IF EXISTS curriculums cascade;
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
    credit int,
    password text not null,
    curriculums int,
    role varchar,
    FOREIGN KEY (curriculums) REFERENCES curriculums(curriculumId)
);



create table purchases(
    purchaseId serial PRIMARY KEY,
    userId int,
    curriculumId int,
    FOREIGN KEY (userId) REFERENCES users(userId),
    FOREIGN KEY (curriculumId) REFERENCES curriculums(curriculumId)
);


