-- begin CEUME_ENTITY_ATTRIBUTE_DESCRIPTION
create table CEUME_ENTITY_ATTRIBUTE_DESCRIPTION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    ENTITY varchar(255),
    ENTITY_ATTRIBUTE varchar(255),
    --
    API_DESCRIPTION varchar(255),
    DB_DESCRIPTION varchar(255),
    --
    primary key (ID)
)^
-- end CEUME_ENTITY_ATTRIBUTE_DESCRIPTION
-- begin CEUME_CUSTOMER
create table CEUME_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIRST_NAME varchar(255),
    NAME varchar(255),
    BIRTHDAY date,
    --
    primary key (ID)
)^
-- end CEUME_CUSTOMER
-- begin CEUME_PRODUCT
create table CEUME_PRODUCT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    TYPE_ varchar(50),
    --
    primary key (ID)
)^
-- end CEUME_PRODUCT
