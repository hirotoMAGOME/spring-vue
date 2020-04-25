CREATE TABLE IF NOT EXISTS `hm`.`a_account_balance` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` INT UNSIGNED NOT NULL,
  `appropriate_month` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `account_id` INT UNSIGNED NOT NULL,
  `balance` INT NOT NULL DEFAULT 0,
  `currency_id` INT NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_user_id` INT UNSIGNED NOT NULL DEFAULT 0,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_user_id` INT UNSIGNED NOT NULL DEFAULT 0,
  `deleted_at` DATETIME NULL,
  `deleted_user_id` INT UNSIGNED NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `id_idx` (`created_user_id` ASC, `updated_user_id` ASC, `deleted_user_id` ASC, `user_id` ASC) INVISIBLE,
  INDEX `id_idx1` (`user_id` ASC) INVISIBLE
)
ENGINE = InnoDB
