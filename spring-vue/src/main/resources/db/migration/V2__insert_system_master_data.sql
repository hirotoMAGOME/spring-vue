-- ドメイン
INSERT INTO m_domain (domain_cd, name, created_at, updated_at, deleted_at) VALUES ('user_type', 'ユーザー種別', '2020/01/01 00:00:00', '2020/01/01 00:00:00', '2020/01/01 00:00:00');
INSERT INTO m_domain (domain_cd, name, created_at, updated_at, deleted_at) VALUES ('budget_category_type', '予算カテゴリ種別', '2020/01/01 00:00:00', '2020/01/01 00:00:00', '2020/01/01 00:00:00');


-- 区分種別
INSERT INTO m_cls_type (domain_cd, cls_type_key, name, sort, created_at, updated_at, deleted_at) VALUES ('user_type', '01', '管理者', '1', '2020/01/01 00:00:00', '2020/01/01 00:00:00', null);
INSERT INTO m_cls_type (domain_cd, cls_type_key, name, sort, created_at, updated_at, deleted_at) VALUES ('user_type', '02', '一般', '2', '2020/01/01 00:00:00', '2020/01/01 00:00:00', null);
INSERT INTO m_cls_type (domain_cd, cls_type_key, name, sort, created_at, updated_at, deleted_at) VALUES ('budget_category_type', '01', '固定費', '1', '2020/01/01 00:00:00', '2020/01/01 00:00:00', null);
INSERT INTO m_cls_type (domain_cd, cls_type_key, name, sort, created_at, updated_at, deleted_at) VALUES ('budget_category_type', '02', '変動費', '2', '2020/01/01 00:00:00', '2020/01/01 00:00:00', null);


-- ユーザー
INSERT INTO m_user (id, name, mail, password, user_type, created_at, updated_at, deleted_at) VALUES ('1', 'admin', 'soma.dev.magome@gmail.com', 'admin', '01', '2020/01/01 00:00:00', '2020/01/01 00:00:00', '2020/01/01 00:00:00');
INSERT INTO m_user (id, name, mail, password, user_type, created_at, updated_at, deleted_at) VALUES ('2', 'user1', 'soma.dev.magome+1@gmail.com', 'user1', '02', '2020/01/01 00:00:00', '2020/01/01 00:00:00', '2020/01/01 00:00:00');
INSERT INTO m_user (id, name, mail, password, user_type, created_at, updated_at, deleted_at) VALUES ('3', 'user2', 'soma.dev.magome+2@gmail.com', 'user2', '02', '2020/01/01 00:00:00', '2020/01/01 00:00:00', '2020/01/01 00:00:00');


-- 資産API一覧
INSERT INTO m_asset_api_list (id, api_cd, name, path) VALUES ('1', 'AST_01', '予算カテゴリ', '/api/ast/budget-category');
INSERT INTO m_asset_api_list (id, api_cd, name, path) VALUES ('2', 'AST_02', '予算', '/api/ast/budget');
INSERT INTO m_asset_api_list (id, api_cd, name, path) VALUES ('3', 'AST_03', '口座カテゴリ', '/api/ast/account-category');
INSERT INTO m_asset_api_list (id, api_cd, name, path) VALUES ('4', 'AST_04', '口座', '/api/ast/account');
INSERT INTO m_asset_api_list (id, api_cd, name, path) VALUES ('5', 'AST_05', '通貨', '/api/ast/currency');


-- 口座カテゴリ
INSERT INTO m_account_category (id, user_id, name, created_at, updated_at, deleted_at) VALUES ('1', '2', '現金', '2020-01-01 00:00:00', '2020-01-01 00:00:00', null);
INSERT INTO m_account_category (id, user_id, name, created_at, updated_at, deleted_at) VALUES ('2', '2', '銀行口座', '2020-01-01 00:00:00', '2020-01-01 00:00:00', null);
INSERT INTO m_account_category (id, user_id, name, created_at, updated_at, deleted_at) VALUES ('3', '2', 'FX口座', '2020-01-01 00:00:00', '2020-01-01 00:00:00', null);
INSERT INTO m_account_category (id, user_id, name, created_at, updated_at, deleted_at) VALUES ('4', '2', '株式口座', '2020-01-01 00:00:00', '2020-01-01 00:00:00', null);
INSERT INTO m_account_category (id, user_id, name, created_at, updated_at, deleted_at) VALUES ('5', '2', '仮想通貨口座', '2020-01-01 00:00:00', '2020-01-01 00:00:00', null);
INSERT INTO m_account_category (id, user_id, name, created_at, updated_at, deleted_at) VALUES ('6', '2', 'クレジットカード', '2020-01-01 00:00:00', '2020-01-01 00:00:00', null);
INSERT INTO m_account_category (id, user_id, name, created_at, updated_at, deleted_at) VALUES ('7', '2', 'プリペイドカード', '2020-01-01 00:00:00', '2020-01-01 00:00:00', null);


-- 口座
INSERT INTO m_account (id, account_category_id, name, sort, created_at, updated_at, deleted_at) VALUES ('1', '1', '財布', '1', '2020-01-01 00:00:00', '2020-01-01 00:00:00', null);
INSERT INTO m_account (id, account_category_id, name, sort, created_at, updated_at, deleted_at) VALUES ('2', '2', '三菱UFJ', '2', '2020-01-01 00:00:00', '2020-01-01 00:00:00', null);
INSERT INTO m_account (id, account_category_id, name, sort, created_at, updated_at, deleted_at) VALUES ('3', '2', '三井住友', '3', '2020-01-01 00:00:00', '2020-01-01 00:00:00', null);
INSERT INTO m_account (id, account_category_id, name, sort, created_at, updated_at, deleted_at) VALUES ('4', '5', 'bitFlyer', '4', '2020-01-01 00:00:00', '2020-01-01 00:00:00', null);


-- 通貨
INSERT INTO m_currency (id, user_id, name, mark, created_at, updated_at, deleted_at) VALUES ('1', '1', '円', '￥', '2020/01/01 00:00:00', '2020/01/01 00:00:00', null);
INSERT INTO m_currency (id, user_id, name, mark, created_at, updated_at, deleted_at) VALUES ('2', '1', 'ドル', '＄', '2020/01/01 00:00:00', '2020/01/01 00:00:00', null);


