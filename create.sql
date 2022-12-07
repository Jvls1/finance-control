create table expense (id uuid not null, amount numeric(8, 2) not null, description varchar(100) not null, buy_method int4 not null, register_date date not null, primary key (id));
create table income (id uuid not null, amount numeric(8, 2) not null, description varchar(100) not null, register_date date not null, primary key (id));
create table usr (id uuid not null, email varchar(255) not null, password varchar(255) not null, username varchar(255) not null, primary key (id));
create table wallet (id uuid not null, month date not null, primary key (id));
alter table if exists usr add constraint UK_g9l96r670qkidthshajdtxrqf unique (email);
