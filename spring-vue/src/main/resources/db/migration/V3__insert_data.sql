-- 予算カテゴリ
INSERT INTO m_budget_category (id, user_id, name, fixed_flg, created_at, updated_at, deleted_at) VALUES ('1', '2', '食費', '1', '2020/1/1 00:00:00', '2020/1/1 00:00:00', '2020/1/1 00:00:00');
INSERT INTO m_budget_category (id, user_id, name, fixed_flg, created_at, updated_at, deleted_at) VALUES ('2', '2', '洋服', '0', '2020/1/1 00:00:00', '2020/1/1 00:00:00', '2020/1/1 00:00:00');
INSERT INTO m_budget_category (id, user_id, name, fixed_flg, created_at, updated_at, deleted_at) VALUES ('3', '2', '光熱費', '1', '2020/1/1 00:00:00', '2020/1/1 00:00:00', '2020/1/1 00:00:00');
INSERT INTO m_budget_category (id, user_id, name, fixed_flg, created_at, updated_at, deleted_at) VALUES ('4', '2', '趣味', '0', '2020/1/1 00:00:00', '2020/1/1 00:00:00', '2020/1/1 00:00:00');
INSERT INTO m_budget_category (id, user_id, name, fixed_flg, created_at, updated_at, deleted_at) VALUES ('5', '1', '家賃', '1', '2020/1/1 00:00:00', '2020/1/1 00:00:00', '2020/1/1 00:00:00');
INSERT INTO m_budget_category (id, user_id, name, fixed_flg, created_at, updated_at, deleted_at) VALUES ('6', '2', '家賃', '1', '2020/1/1 00:00:00', '2020/1/1 00:00:00', '2020/1/1 00:00:00');


-- 予算
INSERT INTO a_budget (id, appropriate_month, budget_category_id, amount, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('1', null, '1', '20000', '昼食', '2020/1/1 00:00:00', '2', '2020/1/1 00:00:00', '2', null, null);
INSERT INTO a_budget (id, appropriate_month, budget_category_id, amount, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('2', null, '1', '20000', '夕食', '2020/1/1 00:00:00', '2', '2020/1/1 00:00:00', '2', null, null);
INSERT INTO a_budget (id, appropriate_month, budget_category_id, amount, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('3', null, '3', '3000', '電気', '2020/1/1 00:00:00', '2', '2020/1/1 00:00:00', '2', null, null);
INSERT INTO a_budget (id, appropriate_month, budget_category_id, amount, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('4', null, '3', '1500', 'ガス', '2020/1/1 00:00:00', '2', '2020/1/1 00:00:00', '2', null, null);
INSERT INTO a_budget (id, appropriate_month, budget_category_id, amount, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('5', null, '3', '1000', '水道', '2020/1/1 00:00:00', '2', '2020/1/1 00:00:00', '2', null, null);
INSERT INTO a_budget (id, appropriate_month, budget_category_id, amount, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('6', null, '3', '6000', 'インターネット', '2020/1/1 00:00:00', '2', '2020/1/1 00:00:00', '2', null, null);
INSERT INTO a_budget (id, appropriate_month, budget_category_id, amount, name, created_at, created_user_id, updated_at, updated_user_id, deleted_at, deleted_user_id) VALUES ('7', null, '6', '75000', '家賃', '2020/1/1 00:00:00', '2', '2020/1/1 00:00:00', '2', null, null);


