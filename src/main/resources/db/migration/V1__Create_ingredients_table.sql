create table ingredient (
    id int unsigned primary key auto_increment,
    name varchar(100) not null,
    type varchar(20)
);

insert into ingredient (name, type) values ('Cienkie ciasto', 'BASE');
insert into ingredient (name, type) values ('GRUBE ciasto', 'BASE');

insert into ingredient (name, type) values ('GOUDA', 'CHEESE');
insert into ingredient (name, type) values ('MOZZARELLA', 'CHEESE');

insert into ingredient (name, type) values ('SALAMI', 'TOPPINGS');
insert into ingredient (name, type) values ('PAPRYKA', 'TOPPINGS');

insert into ingredient (name, type) values ('POMIDOROWY', 'SAUCE');
insert into ingredient (name, type) values ('CZOSNKOWY', 'SAUCE');
