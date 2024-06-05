create table guest(id serial primary key,
                   name varchar(100) not null,
                   email varchar(30) not null unique,
                   phone varchar(12));

create user manager with password '1234';
grant usage, select on sequence guest_id_seq TO manager;
grant all on guest to manager;

create or replace view guest_name as (
                                     select name
                                     from guest);
grant select on guest_name to manager;
create user guard with password '5555';
grant select on guest_name to guard;
