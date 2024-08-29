CREATE TABLE IF NOT EXISTS crabs (
    id int primary key,
    name varchar(63) not null,
    age int
);

INSERT INTO crabs (id, name, age) VALUES (1, 'Mark', 5);
