CREATE TABLE expense
(
    id            UUID          NOT NULL,
    time_creation TIMESTAMP WITHOUT TIME ZONE,
    time_update   TIMESTAMP WITHOUT TIME ZONE,
    time_removed  TIMESTAMP WITHOUT TIME ZONE,
    description   VARCHAR(100),
    amount        DECIMAL(8, 2) NOT NULL,
    date_register date          NOT NULL,
    id_wallet     UUID,
    buy_method    VARCHAR(255)  NOT NULL,
    CONSTRAINT pk_expense PRIMARY KEY (id)
);

CREATE TABLE income
(
    id            UUID          NOT NULL,
    time_creation TIMESTAMP WITHOUT TIME ZONE,
    time_update   TIMESTAMP WITHOUT TIME ZONE,
    time_removed  TIMESTAMP WITHOUT TIME ZONE,
    description   VARCHAR(100),
    amount        DECIMAL(8, 2) NOT NULL,
    date_register date          NOT NULL,
    id_user       UUID          NOT NULL,
    id_wallet     UUID          NOT NULL,
    CONSTRAINT pk_income PRIMARY KEY (id)
);


CREATE TABLE usr
(
    id            UUID         NOT NULL,
    time_creation TIMESTAMP WITHOUT TIME ZONE,
    time_update   TIMESTAMP WITHOUT TIME ZONE,
    time_removed  TIMESTAMP WITHOUT TIME ZONE,
    name          VARCHAR(255) NOT NULL,
    password      VARCHAR(255) NOT NULL,
    email         VARCHAR(255) NOT NULL,
    CONSTRAINT pk_usr PRIMARY KEY (id)
);

CREATE TABLE wallet
(
    id                   UUID     NOT NULL,
    time_creation        TIMESTAMP WITHOUT TIME ZONE,
    time_update          TIMESTAMP WITHOUT TIME ZONE,
    time_removed         TIMESTAMP WITHOUT TIME ZONE,
    month                INTEGER  NOT NULL,
    year                 SMALLINT NOT NULL,
    id_user_owner        UUID     NOT NULL,
    id_user_collaborator UUID,
    CONSTRAINT pk_wallet PRIMARY KEY (id)
);
