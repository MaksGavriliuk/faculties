CREATE TABLE faculties
(
    id      BIGSERIAL PRIMARY KEY,
    name    VARCHAR(255) NOT NULL,
    dean_id BIGINT          NOT NULL
);

CREATE TABLE departments
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    faculty_id BIGINT       NOT NULL,
    FOREIGN KEY (faculty_id) REFERENCES faculties (id)
);