DROP TABLE IF EXISTS m_budget_category;

CREATE TABLE `m_budget_category` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` INT UNSIGNED NOT NULL,
  `name` VARCHAR(64) NULL,
  `fixed_flg` TINYINT UNSIGNED NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted_at` DATETIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `id_idx` (`user_id` ASC) VISIBLE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS a_budget;

CREATE TABLE `a_budget` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `appropriate_month` DATE NULL,
  `budget_category_id` INT UNSIGNED NOT NULL,
  `amount` INT NOT NULL DEFAULT 0,
  `name` VARCHAR(64) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_user_id` INT UNSIGNED NOT NULL DEFAULT 0,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_user_id` INT UNSIGNED NOT NULL DEFAULT 0,
  `deleted_at` DATETIME NULL,
  `deleted_user_id` INT UNSIGNED NULL DEFAULT 0,
  PRIMARY KEY (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `hm`.`m_budget_category` (`id`, `user_id`, `name`, `fixed_flg`, `created_at`, `updated_at`, `deleted_at`) VALUES (1, 1, '水道', 1, DEFAULT, DEFAULT, NULL);
INSERT INTO `hm`.`m_budget_category` (`id`, `user_id`, `name`, `fixed_flg`, `created_at`, `updated_at`, `deleted_at`) VALUES (2, 1, 'LINE MOBILE', 1, DEFAULT, DEFAULT, NULL);
INSERT INTO `hm`.`m_budget_category` (`id`, `user_id`, `name`, `fixed_flg`, `created_at`, `updated_at`, `deleted_at`) VALUES (3, 1, '？？？', 0, DEFAULT, DEFAULT, NULL);