drop table videogames;
--drop sequence pid_seq restrict;
create table videogames(
    id  INT NOT NULL PRIMARY KEY
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
    titulo VARCHAR (40) NOT NULL,
    genero VARCHAR (40) NOT NULL,
    valoracion NUMERIC (10,2),
    jugado BOOLEAN);
-- create sequence pid_seq as int start with 1 increment by 1 no cycle;
insert into videogames values ('Zelda', 'RPG', 8.50, true);
insert into videogames values ('Mario Bros','PLATAFORMAS', 9.50, true);
insert into videogames values ('Call of duty','SHOOTER', 9.99, true);
insert into videogames values ('Mario 3D World','PLATAFORMAS', 0.0, false);
