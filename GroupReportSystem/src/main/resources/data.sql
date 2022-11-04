INSERT INTO employee(employee_code, employee_name, password, role)
VALUES('A001', '吉田太郎', '$2a$10$tD13H/oSqJMnqk1U9mhk7OmxqO0O3sH7HDr4u8Z9MuTeZGLmj.Jyq', 'ROLE_ADMIN'),
('A002', '坂上次郎', '$2a$10$tD13H/oSqJMnqk1U9mhk7OmxqO0O3sH7HDr4u8Z9MuTeZGLmj.Jyq', 'ROLE_ADMIN'),
('A003', '田中三郎', '$2a$10$tD13H/oSqJMnqk1U9mhk7OmxqO0O3sH7HDr4u8Z9MuTeZGLmj.Jyq', 'ROLE_GENERAL');

/** 顧客 */
INSERT INTO customer(customer_code, customer_name,
phone, address, move_date, pay_state)
VALUES('B001', '山田好子', '090-4433-8877', '東京都葛飾区2-3-15', '2022-04-04', 1),
('B002', '浜田健太', '090-2433-3877', '東京都三鷹市1-23-15', '2022-07-03', 1),
('B003', '佐々木リン', '080-4234-9077', '東京都練馬区1-13-15', '2022-10-02', 2);

/** 案件 */
INSERT INTO mission(
mission_title,
visit_date,
move_date,
pay_due,
note
)
VALUES(
'東京都葛飾区→北海道札幌市(山田)',
'2022-03-28',
'2022-04-04',
'2022-4-30',
'段ボール1セット必要'),
(
'東京都三鷹市→沖縄県那覇市(浜田)',
'2022-06-28',
'2022-07-03',
'2022-08-30',
'小さなお子さん2名'),
(
'東京都練馬区→神奈川県横浜市(佐々木)',
'2022-09-08',
'2022-10-02',
'2022-11-30',
'午前中に引っ越し完了予定');


/** 日報 */
INSERT INTO report(
report_code,
report_title,
employee_name,
content
)
VALUES(
'R001',
'田中さん訪問',
'萩原里菜',
'契約完了'
)

