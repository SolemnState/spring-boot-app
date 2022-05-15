-- CREATE database db;
CREATE schema IF NOT EXISTS test;
CREATE TABLE IF NOT EXISTS test.date (
                                    date_id SERIAL PRIMARY KEY,
                                    value varchar(250) NOT NULL
);

INSERT INTO test.date(value)
VALUES
    ('10.12.2020'),
    ('14.11.2021'),
    ('10.07.2022');
commit;
