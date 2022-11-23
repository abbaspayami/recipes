--changeset nvoxland:3
create table ingredient (
        id bigserial primary key,
        ingredient varchar(50) not null
);

create unique index ingredient_ingredient ON ingredient (ingredient);

--changeset nvoxland:4
ALTER TABLE ingredient ADD unit VARCHAR(50);

--changeset nvoxland:9
insert into ingredient(ingredient, unit) values ('potatoes', 'kg');
insert into ingredient(ingredient, unit) values ('salmon', 'kg');
insert into ingredient(ingredient, unit) values ('tomato', 'kg');
insert into ingredient(ingredient, unit) values ('oil', 'gram');
insert into ingredient(ingredient, unit) values ('olive', 'gram');