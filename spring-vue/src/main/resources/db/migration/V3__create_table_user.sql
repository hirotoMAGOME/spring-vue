DROP TABLE IF EXISTS user;

-- user
CREATE TABLE `user` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) NOT NULL,
  `password` VARCHAR(64) NOT NULL,
  `admin_kbn` VARCHAR(10) NOT NULL,
  `del_flg` BOOLEAN NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO user VALUES (NULL,'Soma', 'Hiroto12', '1',0);
INSERT INTO user VALUES (NULL,'test', 'test', '0',0);