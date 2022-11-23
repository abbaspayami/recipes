--changeset nvoxland:7
create table recipe_ingredient (
        id bigserial primary key,
        fk_ingredient_id bigserial,
        fk_recipe_id bigserial,
        constraint fk_ingredient_id foreign key (fk_ingredient_id) references ingredient(id),
        constraint fk_recipe_id foreign key (fk_recipe_id) references recipe(id)
);

--changeset nvoxland:8
ALTER TABLE recipe_ingredient ADD amount int;
ALTER TABLE recipe_ingredient ADD serving_number int;

--changeset nvoxland:10
insert into recipe_ingredient(fk_ingredient_id, fk_recipe_id, amount, serving_number) values (1,2,500, 1);
insert into recipe_ingredient(fk_ingredient_id, fk_recipe_id, amount, serving_number) values (1,3, 700, 2);
insert into recipe_ingredient(fk_ingredient_id, fk_recipe_id, amount, serving_number) values (2,1, 800, 3);
insert into recipe_ingredient(fk_ingredient_id, fk_recipe_id, amount, serving_number) values (2,3, 900, 4);