create table ingredients (
    id int unsigned primary key auto_increment,
    name varchar(100) not null,
    type varchar(20)
);

insert into ingredients (name, type) values ('Cienkie ciasto', 'BASE');
insert into ingredients (name, type) values ('GRUBE ciasto', 'BASE');
insert into ingredients (name, type) values ('GOUDA', 'CHESSE');
insert into ingredients (name, type) values ('MOZZARELLA', 'CHESSE');
insert into ingredients (name, type) values ('SALAMI', 'TOPPINGS');
insert into ingredients (name, type) values ('PAPRYKA', 'TOPPINGS');
insert into ingredients (name, type) values ('POMIDOROWY', 'SAUSE');
insert into ingredients (name, type) values ('CZOSNKOWY', 'SAUSE');
