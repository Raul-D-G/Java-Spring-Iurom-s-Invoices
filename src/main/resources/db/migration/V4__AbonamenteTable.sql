CREATE TABLE abonamente (
    id UUID NOT NULL PRIMARY KEY,
    nume VARCHAR(100) NOT NULL,
    pret FLOAT NOT NULL,
    valabilitate DATE NOT NULL,
    limitaFacturi DATE NOT NULL
);