# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table estimate (
  id                        bigint auto_increment not null,
  estimate_number           bigint,
  customer_name             varchar(255),
  subject                   varchar(255),
  create_date               datetime not null,
  update_date               datetime not null,
  constraint pk_estimate primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table estimate;

SET FOREIGN_KEY_CHECKS=1;

