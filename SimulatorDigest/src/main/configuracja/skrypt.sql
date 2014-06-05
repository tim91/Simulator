create table users (
  username varchar(15) not null,
  password varchar(15) not null,
  primary key (username)
);
  
create table user_roles (
  username varchar(15) not null,
  role     varchar(15) not null,
  primary key (username, role)
);
  
insert into users values ('tomcat', 'tomcat')
  
insert into user_roles values ('tomcat', 'tomcat')