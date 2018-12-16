# Company-Purchase-Sale-Stock-Management-System
This project is training project that I completed in programing school.
The project is management system of trading company to purchase, sale and stock products.
It provides management of products, clients and suppliers information, 
and also provides the services of purchasing, sale, stock products.
****
    
|Author|Bing Yan|
|---|---
|E-mail|187233718@qq.com


****
## Table of Contents
* [Functions Introduction](#Functions-Introduction)
    * [User Management](#User-Management)
    * [Client Management](#Client-Management)
    * [Supplier Management](#Supplier-Management)
    * [Purchase Management](#Purchase-Management)
    * [Sale Management](#Sale-Management)
    * [Stock Management](#Stock-Management)
* [How to run](#How-to-run)
    * [Environment Dependence](#Environment-Dependence)
    * [Deployment Configuration](#Deployment-Configuration)
    * [Test Information](#Test-Information)
    
### Functions-Introduction
#### User-Management
```
User Management module provides operations including add user, update password of users.
User Management use Role-based Access Control in database.
User information includes user name, real name,password and role.
```
#### Client-Management
```
Client Management module provides add, delete, list clients information.
Client information includes id, name, address, phone num, contact, bank, accountNumber and so on.
```
#### Supplier-Management
```
Supplier Management module provides add, delete, list clients information.
Supplier information includes id, name, address, phone num, contact, bank, accountNumber and so on.
```
#### Purchase-Management
```
Purchase Management module provides add, modify, and list purchasing record according to purchasing products from supplier.
Purchase record includs id, supplier id, purchase time, operator,brokerage, payment method, product id, product price, product number and payment price.
Purchase record will increase products number in stock.
```
#### Sale-Management
```
Sale Management module provides add, modify, and list sale record according to saling products to clients.
Sale record includes id, client id, sale time, product name, sale price, product number, payment method, real income, operator, brokerage.
Sale record will reduce products number in stock.
```
#### Stock-Management
```
Stock Management provides conditional query of stock record.
Stock record includes id, product name, product source, standard, packing, unit, price, stock number information.
Stock record is generated according to purchasing and saling products operation.
```

### How-to-run
#### Environment-Dependence 
```
JDK 1.8
Tomcat
MySQL 5.0
```
#### Deployment-Configuration
```
1. modify proxool configuration in src\proxool.properties.
2. Run 2 sql files in src\sql to generate tables and initial test data in MySQL database.
3. Deploy project and access root directory of project.
4. Login with provided test user name and password.
```
#### Test-Information
```
role:admin
user:zhangsan
passwd:123

role:saleman
user:lisi
passwd:123

role:stockman
user:wangwu
passwd:123

role:buyer
user:zhaoliu
passwd:123
```


