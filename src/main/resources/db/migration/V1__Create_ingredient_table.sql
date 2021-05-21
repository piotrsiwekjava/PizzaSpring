create table ingredient (
    id_ingredient int unsigned primary key auto_increment,
    name varchar(100) not null,
    type varchar(20),
    price double
);

insert into ingredient (name, type, price) values ('Cienkie ciasto', 0, 10);
insert into ingredient (name, type, price) values ('GRUBE ciasto', 0, 15);

insert into ingredient (name, type, price) values ('GOUDA', 1, 0);
insert into ingredient (name, type, price) values ('MOZZARELLA', 1, 0);

insert into ingredient (name, type, price) values ('POMIDOROWY', 2, 0);
insert into ingredient (name, type, price) values ('CZOSNKOWY', 2, 0);

insert into ingredient (name, type, price) values ('SALAMI', 3, 5);
insert into ingredient (name, type, price) values ('PAPRYKA', 3, 5);
insert into ingredient (name, type, price) values ('Jalapeno', 3, 5);
insert into ingredient (name, type, price) values ('Pieczarki', 3, 5);

