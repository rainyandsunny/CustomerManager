create table customer (
  id                            bigint auto_increment not null,
  name                          varchar(20),
  sex                           varchar(10),
  age                           integer(5),
  address                       varchar(100),
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_modified                 datetime(6) not null,
  constraint pk_customer primary key (id)
);

