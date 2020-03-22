DROP TABLE IF EXISTS m_budget_category;

CREATE TABLE `m_budget_category` (
  `id` BIGINT UNSIGNED unsigned NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT UNSIGNED NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted_at` DATETIME,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `m_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS a_budget;

CREATE TABLE `a_budget` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `appropriate_month` DATE,
  `budget_category_id` BIGINT UNSIGNED NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  `amount` INT NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_user_id` BIGINT UNSIGNED NOT NULL DEFAULT 1,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_user_id` BIGINT UNSIGNED NOT NULL DEFAULT 1,
  `deleted_at` DATETIME,
  `deleted_user_id` BIGINT UNSIGNED DEFAULT 1,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`budget_category_id`) REFERENCES `m_account_type` (`id`),
  FOREIGN KEY (`created_user_id`) REFERENCES `m_user` (`id`),
  FOREIGN KEY (`updated_user_id`) REFERENCES `m_user` (`id`),
  FOREIGN KEY (`deleted_user_id`) REFERENCES `m_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO m_budget_category (id,user_id,name) VALUES (1,2,"カテゴリ1");
INSERT INTO m_budget_category (id,user_id,name) VALUES (2,2,"カテゴリ2");
INSERT INTO m_budget_category (id,user_id,name) VALUES (3,2,"カテゴリ3");
INSERT INTO m_budget_category (id,user_id,name) VALUES (4,2,"カテゴリ4");
INSERT INTO m_budget_category (id,user_id,name) VALUES (5,2,"カテゴリ5");
INSERT INTO a_budget (id,appropriate_month,budget_category_id,name,price) VALUES (1,NULL,1,"サンプル予算",100);
INSERT INTO a_budget (id,appropriate_month,budget_category_id,name,price) VALUES (2,NULL,2,"サンプル予算2",200);