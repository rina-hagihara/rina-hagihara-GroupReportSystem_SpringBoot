/* 従業員*/
CREATE TABLE IF NOT EXISTS employee (
employee_id INT PRIMARY KEY AUTO_INCREMENT,
employee_code VARCHAR(50),
employee_name VARCHAR(50),
password VARCHAR(100),
role VARCHAR(50)
);

/** 顧客 */
CREATE TABLE IF NOT EXISTS customer(
customer_id INT PRIMARY KEY AUTO_INCREMENT,
customer_code VARCHAR(50),
customer_name VARCHAR(50),
phone VARCHAR(50),
address VARCHAR(50),
move_date DATE,
pay_state INT
);


/** 案件 */
CREATE TABLE IF NOT EXISTS mission(
mission_id INT PRIMARY KEY AUTO_INCREMENT,
mission_title VARCHAR(50),
visit_date DATE,
move_date DATE,
pay_due DATE,
note VARCHAR(300)
);

/** 日報 */
CREATE TABLE IF NOT EXISTS report(
report_id INT PRIMARY KEY AUTO_INCREMENT,
report_code VARCHAR(50),
report_title VARCHAR(50),
employee_name VARCHAR(50) ,
content VARCHAR(300)
);


/** 案件従業員 */
CREATE TABLE IF NOT EXISTS mission_employee(
mission_employee_id INT PRIMARY KEY AUTO_INCREMENT,
employee_id INT,
mission_id INT
);

/** 案件日報 */
CREATE TABLE IF NOT EXISTS mission_report(
mission_report_id INT PRIMARY KEY AUTO_INCREMENT,
report_id INT,
mission_id INT
);

/** 案件顧客 */
CREATE TABLE IF NOT EXISTS mission_customer(
mission_customer_id INT PRIMARY KEY AUTO_INCREMENT,
customer_id INT,
mission_id INT
);
