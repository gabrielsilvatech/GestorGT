CREATE TABLE produtos(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    cor varchar(30) not null,
    valor decimal(6, 2),
    primary key(id)
);