CREATE TABLE produse (
    id UUID NOT NULL PRIMARY KEY,
    nume VARCHAR(100) NOT NULL,
    pret FLOAT NOT NULL,
    tva INT NOT NULL,
    cantitate INT NOT NULL,
    unitateMasura VARCHAR(100) NOT NULL,
    descriere VARCHAR(300) NOT NULL
);