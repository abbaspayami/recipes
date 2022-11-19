--changeset nvoxland:1
create table food_type (
     id bigserial primary key,
     type varchar(50) not null
);

create unique index food_type_type on food_type (type);

--changeset nvoxland:2
insert into food_type(type) values ('vegetarian');
insert into food_type(type) values ('vegan');
insert into food_type(type) values ('test1');
insert into food_type(type) values ('test2');