CREATE TABLE PRODUCT (
	id BIGINT identity primary key,
	PRODUCT_TYPE varchar(255) not null,
	VAT_RATE number not null,
	price number not null,
	description varchar(255) not null
);

CREATE TABLE PRODUCT_TO_PROMOTION (
    PRODUCT_ID BIGINT NOT NULL,
    PARENT_PRODUCT_ID BIGINT NOT NULL
);

insert into PRODUCT (PRODUCT_TYPE,VAT_RATE,price, description) values ('MYPHONE_X',14,500,'Pear MyPhone X');
insert into PRODUCT (PRODUCT_TYPE,VAT_RATE,price, description) values ('MYPHONE_7',14,300,'Pear MyPhone 7');
insert into PRODUCT (PRODUCT_TYPE,VAT_RATE,price, description) values ('SIM_CARD',14,20,'SIM Card');
insert into PRODUCT (PRODUCT_TYPE,VAT_RATE,price, description) values ('INSURANCE',14,120,'Phone Insurance');
insert into PRODUCT (PRODUCT_TYPE,VAT_RATE,price, description) values ('PHONE_CASE',14,10,'Phone Case');