/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/3/19 20:06:22                           */
/*==============================================================*/


drop table if exists t_client;

drop table if exists t_instorage;

drop table if exists t_menu;

drop table if exists t_product;

drop table if exists t_purchase;

drop table if exists t_role;

drop table if exists t_role_menu;

drop table if exists t_sale;

drop table if exists t_stock;

drop table if exists t_supplier;

drop table if exists t_user;

/*==============================================================*/
/* Table: t_client                                              */
/*==============================================================*/
create table t_client
(
   id                   Integer not null auto_increment,
   name                 varchar(50) not null,
   sname                varchar(50) not null,
   address              varchar(50) not null,
   zipcode              varchar(50) not null,
   phone                varchar(50) not null,
   fax                  varchar(50) not null,
   contact              varchar(50) not null,
   contact_phone        varchar(50) not null,
   email                varchar(50) not null,
   bank                 varchar(50) not null,
   account_number       varchar(50) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: t_instorage                                           */
/*==============================================================*/
create table t_instorage
(
   id                   Integer not null auto_increment,
   supplier_id          Integer not null,
   idate                date not null,
   operator             varchar(50) not null,
   brokerage            varchar(50) not null,
   settlement           varchar(50) not null,
   product_id           Integer not null,
   price                double not null,
   number               Integer not null,
   actual_pay           double not null,
   primary key (id)
);

/*==============================================================*/
/* Table: t_menu                                                */
/*==============================================================*/
create table t_menu
(
   id                   Integer not null auto_increment,
   name                 varchar(50) not null,
   url                  varchar(100),
   pid                  Integer not null,
   remark               text,
   primary key (id)
);

/*==============================================================*/
/* Table: t_product                                             */
/*==============================================================*/
create table t_product
(
   id                   Integer not null,
   name                 varchar(50) not null,
   sname                varchar(50) not null,
   place                varchar(50) not null,
   unit                 varchar(50) not null,
   standard             varchar(50) not null,
   package              varchar(50) not null,
   batchno              varchar(50) not null,
   approval             varchar(50) not null,
   remark               text not null,
   supplier_id          Integer not null,
   primary key (id)
);

/*==============================================================*/
/* Table: t_purchase                                            */
/*==============================================================*/
create table t_purchase
(
   id                   Integer not null,
   product_id           Integer not null,
   pdate                date not null,
   number               Integer not null,
   price                double not null,
   total_amount         double not null,
   remark               text,
   supplier_id          Integer,
   primary key (id)
);

/*==============================================================*/
/* Table: t_role                                                */
/*==============================================================*/
create table t_role
(
   id                   Integer not null auto_increment,
   name                 varchar(50) not null,
   remark               text,
   primary key (id)
);

/*==============================================================*/
/* Table: t_role_menu                                           */
/*==============================================================*/
create table t_role_menu
(
   role_id              Integer not null,
   menu_id              Integer not null,
   primary key (role_id, menu_id)
);

/*==============================================================*/
/* Table: t_sale                                                */
/*==============================================================*/
create table t_sale
(
   id                   Integer not null auto_increment,
   client_id            Integer not null,
   sdate                date not null,
   operator             varchar(50) not null,
   brokerage            varchar(50) not null,
   settlement           varchar(50) not null,
   product_id           Integer not null,
   price                double not null,
   number               Integer not null,
   actual_income        double not null,
   primary key (id)
);

/*==============================================================*/
/* Table: t_stock                                               */
/*==============================================================*/
create table t_stock
(
   id                   Integer not null auto_increment,
   product_id           Integer not null,
   product_name         varchar(50) not null,
   sname                varchar(50) not null,
   place                varchar(50) not null,
   standard             varchar(50) not null,
   package              varchar(50) not null,
   unit                 varchar(50) not null,
   price                double not null,
   number               Integer not null,
   primary key (id)
);

/*==============================================================*/
/* Table: t_supplier                                            */
/*==============================================================*/
create table t_supplier
(
   id                   Integer not null auto_increment,
   name                 varchar(50) not null,
   sname                varchar(50) not null,
   address              varchar(50) not null,
   zipcode              varchar(50) not null,
   phone                varchar(11) not null,
   fax                  varchar(50) not null,
   contact              varchar(50) not null,
   contact_phone        varchar(11) not null,
   bank                 varchar(50) not null,
   account_number       varchar(50) not null,
   email                varchar(50) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   Integer not null auto_increment,
   name                 varchar(50) not null,
   rname                varchar(50) not null,
   pwd                  varchar(50) not null,
   role_id              Integer not null,
   primary key (id)
);

alter table t_instorage add constraint FK_instorage_product_1 foreign key (product_id)
      references t_product (id) on delete restrict on update restrict;

alter table t_instorage add constraint FK_instorage_supplier_1 foreign key (supplier_id)
      references t_supplier (id) on delete restrict on update restrict;

alter table t_product add constraint FK_product_supplier_1 foreign key (supplier_id)
      references t_supplier (id) on delete restrict on update restrict;

alter table t_purchase add constraint FK_purchase_product_1 foreign key (product_id)
      references t_product (id) on delete restrict on update restrict;

alter table t_purchase add constraint FK_purchase_supplier_1 foreign key (supplier_id)
      references t_supplier (id) on delete restrict on update restrict;

alter table t_role_menu add constraint FK_role_menu_1 foreign key (role_id)
      references t_role (id) on delete restrict on update restrict;

alter table t_role_menu add constraint FK_role_menu_2 foreign key (menu_id)
      references t_menu (id) on delete restrict on update restrict;

alter table t_sale add constraint FK_sale_client_1 foreign key (client_id)
      references t_client (id) on delete restrict on update restrict;

alter table t_sale add constraint FK_sale_product_1 foreign key (product_id)
      references t_product (id) on delete restrict on update restrict;

alter table t_user add constraint FK_user_role_1 foreign key (role_id)
      references t_role (id) on delete restrict on update restrict;

