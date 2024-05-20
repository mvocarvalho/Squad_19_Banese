 create database if not exists squad19;

use squad19;

create table if not exists tipo(
  id int not null primary key,
  descricao varchar(200)
);

create table if not exists mensagem(
  id int primary key,
  descricao varchar(200),
  idtipo int not null,
  foreign key(idtipo) references tipo(id)
);

create table if not exists destino(
  id int not null primary key,
  endereco varchar(200),
  idtipo int not null,
  foreign key (idtipo) references tipo(id)
);

insert into tipo(id,descricao)
values ('1', 'mensagem1');

insert into mensagem(id,descricao,idtipo)
values ('1','mensagem1','1');

insert into destino(id,endereco,idtipo)
value ('1','mensagem1', '1');