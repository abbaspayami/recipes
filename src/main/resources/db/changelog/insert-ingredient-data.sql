--changeset nvoxland:3
create table ingredient (
        id bigserial primary key,
        ingredient varchar(50) not null
);

create unique index ingredient_ingredient ON ingredient (ingredient);

--changeset nvoxland:4
insert into ingredient(ingredient) values ('potatoes');
insert into ingredient(ingredient) values ('salmon');
insert into ingredient(ingredient) values ('tomato');
insert into ingredient(ingredient) values ('oil');
insert into ingredient(ingredient) values ('olive');