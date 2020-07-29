-- ドメイン
INSERT INTO m_domain (domain_cd, name, created_at, updated_at, deleted_at) VALUES ('user_type', 'ユーザー種別', '2020/01/01 00:00:00', '2020/01/01 00:00:00', '2020/01/01 00:00:00');


-- 区分種別
INSERT INTO m_cls_type (domain_cd, cls_type_key, cls_type_name, sort, created_at, updated_at, deleted_at) VALUES ('user_type', '01', '管理者', '1', '2020/01/01 00:00:00', '2020/01/01 00:00:00', '2020/01/01 00:00:00');
INSERT INTO m_cls_type (domain_cd, cls_type_key, cls_type_name, sort, created_at, updated_at, deleted_at) VALUES ('user_type', '02', '一般', '2', '2020/01/01 00:00:00', '2020/01/01 00:00:00', '2020/01/01 00:00:00');


-- ユーザー
INSERT INTO m_user (id, name, mail, password, user_type, created_at, updated_at, deleted_at) VALUES ('1', 'admin', 'soma.dev.magome@gmail.com', 'admin', '01', '2020/01/01 00:00:00', '2020/01/01 00:00:00', '2020/01/01 00:00:00');
INSERT INTO m_user (id, name, mail, password, user_type, created_at, updated_at, deleted_at) VALUES ('2', 'user1', 'soma.dev.magome+1@gmail.com', 'user1', '02', '2020/01/01 00:00:00', '2020/01/01 00:00:00', '2020/01/01 00:00:00');
INSERT INTO m_user (id, name, mail, password, user_type, created_at, updated_at, deleted_at) VALUES ('3', 'user2', 'soma.dev.magome+2@gmail.com', 'user2', '02', '2020/01/01 00:00:00', '2020/01/01 00:00:00', '2020/01/01 00:00:00');


-- 資産API一覧
INSERT INTO m_asset_api_list (id, api_cd, name, path) VALUES ('1', 'AST_01', '予算カテゴリ', '/api/ast/budget-category');


