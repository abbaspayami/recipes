--changeset nvoxland:5
create table recipe (
        id bigserial primary key,
        fk_food_type_id bigserial not null,
        title varchar(50) not null,
        serve int not null,
        instructions varchar(300) not null,
        constraint fk_recipe_food_type_id foreign key (fk_food_type_id) references food_type(id)
);

--changeset nvoxland:6
insert into recipe(title, serve, instructions, fk_food_type_id) values ('spageti', 2, 'First of all You should', 1);
insert into recipe(title, serve, instructions, fk_food_type_id) values ('oatmeal', 1, 'First of all You should',2);
insert into recipe(title, serve, instructions, fk_food_type_id) values ('meatball', 1, 'First of all You should',1);
insert into recipe(title, serve, instructions, fk_food_type_id) values ('crept', 2, 'First of all You should',2);
