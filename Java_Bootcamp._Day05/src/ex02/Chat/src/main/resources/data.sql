insert into users(login, password) values ('sdfsdf', 'sfsadfa');
insert into users(login, password) values ('Ivan', 'fsfadas');
insert into users(login, password) values ('Sergey', 'fsdgwet4252');
insert into users(login, password) values ('Aynur', '124325');

insert into room(chat_owner, chat_name) values (1, 'chat1');
insert into room(chat_owner, chat_name) values (2, 'chat2');
insert into room(chat_owner, chat_name) values (3, 'chat3');
insert into room(chat_owner, chat_name) values (4, 'chat4');

insert into message(sender, room_id, text, time) values (1, 1, 'hello', to_timestamp('2022 Mart', 'YYYY MON'));
insert into message(sender, room_id, text, time) values (2, 1, 'hello', to_timestamp('2022 Mart', 'YYYY MON'));
insert into message(sender, room_id, text, time) values (3, 1, 'hello world', to_timestamp('2022 Mart', 'YYYY MON'));
insert into message(sender, room_id, text, time) values (4, 2, 'hello dfs', to_timestamp('2022 Mart', 'YYYY MON'));
insert into message(sender, room_id, text, time) values (3, 4, 'hello fsdf', to_timestamp('2022 Mart', 'YYYY MON'));
insert into message(sender, room_id, text, time) values (4, 3, 'hellofsdf', to_timestamp('2022 Mart', 'YYYY MON'));



