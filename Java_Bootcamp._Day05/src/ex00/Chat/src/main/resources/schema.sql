drop table users, message, room;

create table  if not exists users
(
  id serial primary key ,
  login text not null ,
  password text
);

create table  if not exists room
(
  id         serial primary key,
  chat_name  text   not null,
  chat_owner bigint not null references users(id)
);

create table if not exists message
(
  id      serial primary key,
  sender  int       not null references users(id),
  room_id int    not null references room(id),
  text    text      not null,
  time    timestamp not null
);




