ALTER TABLE usr
    ADD CONSTRAINT uc_usr_email UNIQUE (email);

ALTER TABLE expense
    ADD CONSTRAINT FK_EXPENSE_ON_ID_WALLET FOREIGN KEY (id_wallet) REFERENCES wallet (id);

ALTER TABLE income
    ADD CONSTRAINT FK_INCOME_ON_ID_USER FOREIGN KEY (id_user) REFERENCES usr (id);

ALTER TABLE income
    ADD CONSTRAINT FK_INCOME_ON_ID_WALLET FOREIGN KEY (id_wallet) REFERENCES wallet (id);

ALTER TABLE wallet
    ADD CONSTRAINT FK_WALLET_ON_ID_USER_COLLABORATOR FOREIGN KEY (id_user_collaborator) REFERENCES usr (id);

ALTER TABLE wallet
    ADD CONSTRAINT FK_WALLET_ON_ID_USER_OWNER FOREIGN KEY (id_user_owner) REFERENCES usr (id);