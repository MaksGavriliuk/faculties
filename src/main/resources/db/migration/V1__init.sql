CREATE TABLE faculties
(
    id      BIGSERIAL INT PRIMARY KEY,
    name    VARCHAR(255) NOT NULL ,
    dean_id INT NOT NULL
);

CREATE TABLE departments
(
    id         BIGSERIAL INT PRIMARY KEY,
    name       VARCHAR(255) NOT NULL ,
    faculty_id INT NOT NULL ,
    FOREIGN KEY (faculty_id) REFERENCES faculties (id)
);