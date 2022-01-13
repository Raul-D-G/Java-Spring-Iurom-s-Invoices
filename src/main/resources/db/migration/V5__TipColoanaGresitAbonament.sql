ALTER TABLE abonamente
DROP COLUMN limitaFacturi;

ALTER TABLE abonamente
ADD COLUMN limitaFacturi INT NOT NULL;