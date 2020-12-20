-- 予算カテゴリ
INSERT INTO m_budget_category (id, user_id, name, budget_category_type, created_at, updated_at, deleted_at) VALUES ('1', '2', '食費', '01', '2020/1/1 00:00:00', '2020/1/1 00:00:00', '2020/1/1 00:00:00');
INSERT INTO m_budget_category (id, user_id, name, budget_category_type, created_at, updated_at, deleted_at) VALUES ('2', '2', '洋服', '02', '2020/1/1 00:00:00', '2020/1/1 00:00:00', '2020/1/1 00:00:00');
INSERT INTO m_budget_category (id, user_id, name, budget_category_type, created_at, updated_at, deleted_at) VALUES ('3', '2', '光熱費', '01', '2020/1/1 00:00:00', '2020/1/1 00:00:00', '2020/1/1 00:00:00');
INSERT INTO m_budget_category (id, user_id, name, budget_category_type, created_at, updated_at, deleted_at) VALUES ('4', '2', '趣味', '02', '2020/1/1 00:00:00', '2020/1/1 00:00:00', '2020/1/1 00:00:00');
INSERT INTO m_budget_category (id, user_id, name, budget_category_type, created_at, updated_at, deleted_at) VALUES ('5', '1', '家賃', '01', '2020/1/1 00:00:00', '2020/1/1 00:00:00', '2020/1/1 00:00:00');
INSERT INTO m_budget_category (id, user_id, name, budget_category_type, created_at, updated_at, deleted_at) VALUES ('6', '2', '家賃', '01', '2020/1/1 00:00:00', '2020/1/1 00:00:00', '2020/1/1 00:00:00');


-- 予算
INSERT INTO a_budget (id, appropriate_month, budget_category_id, amount, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('1', null, '1', '20000', '昼食', '2020/1/1 00:00:00', '2', '2020/1/1 00:00:00', '2', null, null);
INSERT INTO a_budget (id, appropriate_month, budget_category_id, amount, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('2', null, '1', '20000', '夕食', '2020/1/1 00:00:00', '2', '2020/1/1 00:00:00', '2', null, null);
INSERT INTO a_budget (id, appropriate_month, budget_category_id, amount, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('3', null, '3', '3000', '電気', '2020/1/1 00:00:00', '2', '2020/1/1 00:00:00', '2', null, null);
INSERT INTO a_budget (id, appropriate_month, budget_category_id, amount, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('4', null, '3', '1500', 'ガス', '2020/1/1 00:00:00', '2', '2020/1/1 00:00:00', '2', null, null);
INSERT INTO a_budget (id, appropriate_month, budget_category_id, amount, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('5', null, '3', '1000', '水道', '2020/1/1 00:00:00', '2', '2020/1/1 00:00:00', '2', null, null);
INSERT INTO a_budget (id, appropriate_month, budget_category_id, amount, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('6', null, '3', '6000', 'インターネット', '2020/1/1 00:00:00', '2', '2020/1/1 00:00:00', '2', null, null);
INSERT INTO a_budget (id, appropriate_month, budget_category_id, amount, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('7', null, '6', '75000', '家賃', '2020/1/1 00:00:00', '2', '2020/1/1 00:00:00', '2', null, null);
INSERT INTO a_budget (id, appropriate_month, budget_category_id, amount, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('8', '2020/10/1', '1', '20000', '昼食', '2020/1/1 00:00:00', '2', '2020/1/1 00:00:00', '2', null, null);
INSERT INTO a_budget (id, appropriate_month, budget_category_id, amount, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('9', '2020/10/1', '1', '20000', '夕食', '2020/1/1 00:00:00', '2', '2020/1/1 00:00:00', '2', null, null);
INSERT INTO a_budget (id, appropriate_month, budget_category_id, amount, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('10', '2020/10/1', '3', '3000', '電気', '2020/1/1 00:00:00', '2', '2020/1/1 00:00:00', '2', null, null);
INSERT INTO a_budget (id, appropriate_month, budget_category_id, amount, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('11', '2020/10/1', '3', '1500', 'ガス', '2020/1/1 00:00:00', '2', '2020/1/1 00:00:00', '2', null, null);
INSERT INTO a_budget (id, appropriate_month, budget_category_id, amount, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('12', '2020/10/1', '3', '1000', '水道', '2020/1/1 00:00:00', '2', '2020/1/1 00:00:00', '2', null, null);
INSERT INTO a_budget (id, appropriate_month, budget_category_id, amount, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('13', '2020/11/1', '1', '20000', '昼食', '2020/1/1 00:00:00', '2', '2020/1/1 00:00:00', '2', null, null);
INSERT INTO a_budget (id, appropriate_month, budget_category_id, amount, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('14', '2020/11/1', '1', '20000', '夕食', '2020/1/1 00:00:00', '2', '2020/1/1 00:00:00', '2', null, null);
INSERT INTO a_budget (id, appropriate_month, budget_category_id, amount, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('15', '2020/11/1', '3', '3000', '電気', '2020/1/1 00:00:00', '2', '2020/1/1 00:00:00', '2', null, null);
INSERT INTO a_budget (id, appropriate_month, budget_category_id, amount, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('16', '2020/11/1', '3', '1500', 'ガス', '2020/1/1 00:00:00', '2', '2020/1/1 00:00:00', '2', null, null);
INSERT INTO a_budget (id, appropriate_month, budget_category_id, amount, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('17', '2020/11/1', '3', '1000', '水道', '2020/1/1 00:00:00', '2', '2020/1/1 00:00:00', '2', null, null);


-- 実績
INSERT INTO a_actual (id, appropriate_month, settled_at, budget_id, account_id, price, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('1', null, '2020-02-01 12:00:00', '13', '1', '800', 'ラーメン', '2020-01-01 00:00:00', '1', '2020-01-01 00:00:00', '1', null, null);
INSERT INTO a_actual (id, appropriate_month, settled_at, budget_id, account_id, price, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('2', null, '2020-02-02 12:00:00', '13', '1', '600', '弁当', '2020-01-01 00:00:00', '1', '2020-01-01 00:00:00', '1', null, null);
INSERT INTO a_actual (id, appropriate_month, settled_at, budget_id, account_id, price, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('3', null, '2020-02-02 12:00:00', '13', '2', '900', '油そば', '2020-01-01 00:00:00', '1', '2020-01-01 00:00:00', '1', null, null);
INSERT INTO a_actual (id, appropriate_month, settled_at, budget_id, account_id, price, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('4', null, '2020-11-02 12:00:00', '14', '2', '6000', '鍋', '2020-01-01 00:00:00', '1', '2020-01-01 00:00:00', '1', null, null);
INSERT INTO a_actual (id, appropriate_month, settled_at, budget_id, account_id, price, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('5', null, '2020-11-03 12:00:00', '14', '2', '8000', '居酒屋', '2020-01-01 00:00:00', '1', '2020-01-01 00:00:00', '1', null, null);


-- 口座残高
INSERT INTO a_account_balance (id, account_id, recorded_at, balance, currency_id, created_at, updated_at, deleted_at) VALUES ('1', '1', '2020/10/01 00:00:00', '5000', '1', '2020/10/01 00:00:00', '2020/10/01 00:00:00', null);
INSERT INTO a_account_balance (id, account_id, recorded_at, balance, currency_id, created_at, updated_at, deleted_at) VALUES ('2', '1', '2020/10/03 00:00:00', '10000', '1', '2020/10/01 00:00:00', '2020/10/01 00:00:00', null);
INSERT INTO a_account_balance (id, account_id, recorded_at, balance, currency_id, created_at, updated_at, deleted_at) VALUES ('3', '2', '2020/10/01 00:00:00', '3000', '2', '2020/10/01 00:00:00', '2020/10/01 00:00:00', null);


