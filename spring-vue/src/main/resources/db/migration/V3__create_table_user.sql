DROP TABLE IF EXISTS m_user;

-- user
CREATE TABLE `m_user` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) NOT NULL,
  `password` VARCHAR(64) NOT NULL,
  `user_kbn` VARCHAR(2) NOT NULL DEFAULT "02",
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_user_id` bigint unsigned NOT NULL DEFAULT 0,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_user_id` bigint unsigned NOT NULL DEFAULT 0,
  `deleted_at` DATETIME,
  `deleted_user_id` bigint unsigned DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO m_user (id,name,password,user_kbn) VALUES (1,'admin', 'admin', '01');
INSERT INTO m_user (name,password,user_kbn) VALUES ('soma', 'soma', '01');
INSERT INTO m_user (name,password,user_kbn) VALUES ('test', 'test', '01');