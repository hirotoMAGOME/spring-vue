SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS a_account_balance;
DROP TABLE IF EXISTS a_actual;
DROP TABLE IF EXISTS a_asset_history;
DROP TABLE IF EXISTS a_budget;
DROP TABLE IF EXISTS m_account;
DROP TABLE IF EXISTS m_account_category;
DROP TABLE IF EXISTS m_budget_category;
DROP TABLE IF EXISTS m_cls_type;
DROP TABLE IF EXISTS m_currency;
DROP TABLE IF EXISTS m_domain;
DROP TABLE IF EXISTS m_user;




/* Create Tables */

-- �����c��
CREATE TABLE a_account_balance
(
	id bigint unsigned NOT NULL,
	account_id bigint unsigned NOT NULL,
	-- ���ۂ̌����c�����m�F������
	recorded_at datetime DEFAULT NOW() NOT NULL,
	balance int NOT NULL,
	currency_id bigint unsigned NOT NULL,
	created_at datetime DEFAULT NOW() NOT NULL,
	updated_at datetime DEFAULT NOW() NOT NULL,
	deleted_at datetime,
	PRIMARY KEY (id)
);


-- ����
CREATE TABLE a_actual
(
	id bigint unsigned NOT NULL AUTO_INCREMENT,
	-- �v�コ�ꂽ��v�コ�ꂽ�����uYYYY-MM-01�v�̌`���ŃZ�b�g
	appropriate_month date,
	settled_at datetime NOT NULL,
	budget_id bigint unsigned NOT NULL,
	account_id bigint unsigned NOT NULL,
	-- �x���������z
	price int DEFAULT 0 NOT NULL,
	name varchar(64) NOT NULL,
	created_at datetime DEFAULT NOW() NOT NULL,
	created_user_id bigint unsigned NOT NULL,
	updated_at datetime DEFAULT NOW() NOT NULL,
	updated_user_id bigint unsigned NOT NULL,
	deleted_at datetime,
	deleted_user_id bigint unsigned,
	PRIMARY KEY (id)
);


-- ���Y����
CREATE TABLE a_asset_history
(
	id bigint unsigned NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (id)
);


-- �\�Z
CREATE TABLE a_budget
(
	id bigint unsigned NOT NULL AUTO_INCREMENT,
	-- �v�コ�ꂽ��v�コ�ꂽ�����uYYYY-MM-01�v�̌`���ŃZ�b�g
	appropriate_month date,
	budget_category_id bigint unsigned NOT NULL,
	-- ���Y����������\�肪�v���X
	amount int DEFAULT 0,
	name varchar(64) NOT NULL,
	created_at datetime DEFAULT NOW() NOT NULL,
	created_user_id bigint unsigned NOT NULL,
	updated_at datetime DEFAULT NOW() NOT NULL,
	updated_user_id bigint unsigned NOT NULL,
	deleted_at datetime,
	deleted_user_id bigint unsigned,
	PRIMARY KEY (id)
);


-- ����
CREATE TABLE m_account
(
	id bigint unsigned NOT NULL AUTO_INCREMENT,
	account_type_id bigint unsigned NOT NULL,
	name varchar(64) NOT NULL,
	created_at datetime DEFAULT NOW() NOT NULL,
	updated_at datetime DEFAULT NOW() NOT NULL,
	deleted_at datetime,
	PRIMARY KEY (id)
);


-- �����J�e�S���[
CREATE TABLE m_account_category
(
	id bigint unsigned NOT NULL AUTO_INCREMENT,
	user_id bigint unsigned NOT NULL,
	name varchar(64) NOT NULL,
	created_at datetime DEFAULT NOW() NOT NULL,
	updated_at datetime DEFAULT NOW() NOT NULL,
	deleted_at datetime,
	PRIMARY KEY (id)
);


-- �\�Z�J�e�S��
CREATE TABLE m_budget_category
(
	id bigint unsigned NOT NULL AUTO_INCREMENT,
	user_id bigint unsigned NOT NULL,
	name varchar(64) NOT NULL,
	fixed_flg boolean DEFAULT '0' NOT NULL,
	created_at datetime DEFAULT NOW() NOT NULL,
	updated_at datetime DEFAULT NOW() NOT NULL,
	deleted_at datetime,
	PRIMARY KEY (id),
	UNIQUE (id),
	UNIQUE (name)
);


-- �敪���
CREATE TABLE m_cls_type
(
	domain_cd varchar(64) NOT NULL,
	cls_type_key char(2),
	cls_type_name varchar(64),
	sort int(100) unsigned DEFAULT 999 NOT NULL,
	created_at datetime DEFAULT NOW() NOT NULL,
	updated_at datetime DEFAULT NOW() NOT NULL,
	deleted_at datetime,
	UNIQUE (domain_cd, cls_type_key, cls_type_name)
);


-- �ʉ�
CREATE TABLE m_currency
(
	id bigint unsigned NOT NULL AUTO_INCREMENT,
	name varchar(64) NOT NULL,
	mark varchar(64) NOT NULL,
	created_at datetime DEFAULT NOW() NOT NULL,
	updated_at datetime DEFAULT NOW() NOT NULL,
	deleted_at datetime,
	PRIMARY KEY (id)
);


-- �h���C��
CREATE TABLE m_domain
(
	domain_cd varchar(64) NOT NULL,
	name varchar(64),
	created_at datetime DEFAULT NOW() NOT NULL,
	updated_at datetime DEFAULT NOW() NOT NULL,
	deleted_at datetime,
	PRIMARY KEY (domain_cd)
);


-- ���[�U�[
CREATE TABLE m_user
(
	id bigint unsigned NOT NULL AUTO_INCREMENT,
	name varchar(64) NOT NULL,
	mail varchar(64) NOT NULL,
	password varchar(64) NOT NULL,
	user_type varchar(2) DEFAULT '02' NOT NULL,
	created_at datetime DEFAULT NOW() NOT NULL,
	updated_at datetime DEFAULT NOW() NOT NULL,
	deleted_at datetime,
	PRIMARY KEY (id),
	UNIQUE (mail)
);



/* Create Foreign Keys */

ALTER TABLE a_actual
	ADD FOREIGN KEY (budget_id)
	REFERENCES a_budget (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE a_account_balance
	ADD FOREIGN KEY (account_id)
	REFERENCES m_account (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE a_actual
	ADD FOREIGN KEY (account_id)
	REFERENCES m_account (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE m_account
	ADD FOREIGN KEY (account_type_id)
	REFERENCES m_account_category (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE a_budget
	ADD FOREIGN KEY (budget_category_id)
	REFERENCES m_budget_category (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE a_account_balance
	ADD FOREIGN KEY (currency_id)
	REFERENCES m_currency (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE m_cls_type
	ADD FOREIGN KEY (domain_cd)
	REFERENCES m_domain (domain_cd)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE m_account_category
	ADD FOREIGN KEY (user_id)
	REFERENCES m_user (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE m_budget_category
	ADD FOREIGN KEY (user_id)
	REFERENCES m_user (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



