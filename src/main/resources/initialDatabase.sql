create schema if not exists advisor collate utf8_unicode_ci;

  expiry_date datetime null,
  token varchar(255) null,
  user_id bigint not null
)
  engine=MyISAM charset=utf8;

on password_reset_token (user_id);

  create table if not exists persistent_logins
  (
    username varchar(64) not null,
    series varchar(64) not null
    primary key,
    token varchar(64) not null,
    last_used timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP
  )
  charset=utf8;

  create table if not exists question
  (
    id bigint not null
    primary key,
    date datetime null,
    status int not null,
    title varchar(255) null,
    category_id bigint null,
    user_id bigint not null,
    content_id bigint null,
    views int not null
  )
  engine=MyISAM charset=utf8;

  create index FK26g6m8juy3wj5tqa83vg0eawj
  on question (content_id);

  create index FK4ekrlbqiybwk8abhgclfjwnmc
create table if not exists answer
(
  id bigint not null
  primary key,
  date datetime null,
  content_id bigint null,
  question_id bigint null,
  user_id bigint null,
  like_id bigint null,
  answer_id bigint null
)
  engine=MyISAM charset=utf8;

create index FK68tbcw6bunvfjaoscaj851xpb
on answer (user_id);

create index FK8frr4bcabmmeyyu60qt7iiblo
on answer (question_id);

create index FKf7pp1ibo1k77xplroccbcnc2l
on answer (answer_id);

create index FKoapqsg4oexamm9pwn8dnc1vsl
on answer (content_id);

create table if not exists answer_model
(
  id bigint not null
  primary key,
  content varchar(255) null,
  dis_likes int not null,
  likes int not null,
  user varchar(255) null,
  dislikes int not null
  )
  engine=MyISAM charset=utf8;

create table if not exists category
(
  id bigint not null
  primary key,
  name varchar(255) null
  )
  engine=MyISAM charset=utf8;

create table if not exists comment
(
  id bigint not null
  primary key,
  comment_to varchar(20) default 'QUESTION' null,
  date datetime null,
  content_id bigint null,
  lawyer_id bigint null,
  question_id bigint null,
  user_id bigint not null
  )
  engine=MyISAM charset=utf8;

create index FK7e8oxffbryj1h60f1mqggxqut
on comment (question_id);

create index FK8kcum44fvpupyw6f5baccx25c
on comment (user_id);

create index FKayjc4dm2fhakqm3xufvstqnjs
on comment (lawyer_id);

create index FKr9jchxqv43o7l4tv7qkoqr4di
on comment (content_id);

create table if not exists content
(
  id bigint not null
  primary key,
  text text null
)
  engine=MyISAM charset=utf8;

create table if not exists grade
(
  id bigint not null
  primary key,
  type int null,
  question_id bigint null,
  user_id bigint not null,
  answer_id bigint null
)
  engine=MyISAM charset=utf8;

create index FKa0uq8i0nyphcdueagk939qn8q
on grade (question_id);

create index FKasgj3xfoi6sd5ghc8psbueb64
on grade (user_id);

create index FKm91mqjh4w4ejmoy7vkf5nggec
on grade (answer_id);

create table if not exists hibernate_sequence
(
  next_val bigint null
)
  engine=MyISAM charset=utf8;

create table if not exists lawyer_rate_model
(
  user_id bigint not null
  primary key,
  num_answers int null,
  name varchar(255) null,
  surname varchar(255) null
  )
  engine=MyISAM charset=utf8;

create table if not exists message_resource
(
  id bigint auto_increment
  primary key,
  eng varchar(255) null,
  kgz varchar(255) null,
  message_key varchar(255) not null,
  rus varchar(255) null
  )
  engine=MyISAM charset=utf8;

create table if not exists password_reset_token
(
  id bigint not null
  primary key,
  create index FK5lwtbncug84d4ero33v3cfxvl
  on question (user_id);

create index FK7jaqbm9p4prg7n91dd1uabrvj
on question (category_id);

create table if not exists question_model
(
  id bigint not null
  primary key,
  answers int not null,
  category varchar(255) null,
  content varchar(255) null,
  date datetime null,
  dislikes int not null,
  likes int not null,
  title varchar(255) null,
  user bigint null
  )
  engine=MyISAM charset=utf8;

create table if not exists role
(
  id bigint not null
  primary key,
  name varchar(255) null,
  constraint role_unique
  unique (name)
  )
  engine=MyISAM charset=utf8;

create table if not exists user
(
  id bigint auto_increment
  primary key,
  avatar varchar(255) null,
  email varchar(255) null,
  enabled bit not null,
  encryted_password varchar(255) null,
  name varchar(255) null,
  phone_number varchar(255) null,
  surname varchar(255) null,
  username varchar(255) null,
  lawyer_degree_id bigint null,
  matching_password varchar(255) null,
  reset_token varchar(255) null,
  token varchar(255) null,
  user_type varchar(20) default 'USER' null,
  gender int not null,
  user_id bigint null
  )
  engine=MyISAM charset=utf8;

create index FK9p2iig0hjktf5xiibajtquhe2
on user (user_id);

create index FKsbupftu9j5ne8v8xfpw62uwwm
on user (lawyer_degree_id);

create table if not exists user_role
(
  id bigint not null
  primary key,
  role_id bigint not null,
  user_id bigint not null
)
  engine=MyISAM charset=utf8;

create index FK859n2jvi8ivhui0rl0esws6o
on user_role (user_id);

create index FKa68196081fvovjhkek5m97n3y
on user_role (role_id);

create table if not exists verification_token
(
  id bigint not null
  primary key,
  expiry_date datetime null,
  token varchar(255) null,
  user_id bigint not null
  )
  engine=MyISAM charset=utf8;

create index FKrdn0mss276m9jdobfhhn2qogw
on verification_token (user_id);

