--客户表
insert into t_client (name,sname,address,zipcode,phone,fax,contact,contact_phone,email,bank,account_number)
values
('尚学堂科技有限公司','尚学堂','北京市海淀区西三旗','100016','18610001000','68686868','刘老师','13610001000','company@sxt.cn','建设银行','123456789'),
('北大青鸟科技有限公司','北大青鸟','北京市海淀区学府路','100020','18612221222','34343434','王老师','13612221222','company@bdqn.cn','招商银行','987654321'),
('黑马科技有限公司','黑马','北京市海淀区育新','100012','18613331333','89898989','张老师','13613331333','company@hm.cn','北京银行','111111111');

--商品表
insert into t_product (name,sname,place,unit,standard,packing,batchno,approval,remark)
values
('光盘','光盘','广东','个','1G','盒装','20180101GD','[2008]0285','DVD光盘'),
('液晶显示器','显示器','深圳','台','20寸','纸箱','20170101SZ','[2007]0285','液晶显示器'),
('机械键盘','键盘','台湾','个','红轴','礼盒装','20180101TW','[2006]0285','游戏用红轴机械键盘');

--供应商表
insert into t_supplier (name,sname,address,zipcode,phone,fax,contact,contact_phone,bank,account_number,email)
values 
('联想科技有限公司','联想','北京市朝阳区望京','100016','18612341234','67676767','张经理','13512341234','北京银行','22222222','company@lenovo.cn'),
('惠普科技有限公司','惠普','北京市朝阳区青年路','122222','18622222222','67676767','李经理','13512341234','建设银行','44444444','company@hp.cn'),
('罗技科技有限公司','联想','北京市大兴区','133333','18644444444','67676767','王经理','13512341234','华夏银行','66666666','company@logitech.cn');


--入库记录表
insert into t_instorage (supplier_id,idate,operator,brokerage,settlement,product_id,price,number,actual_pay)
values
(1,'2018-01-01','admin','赵科长','支票',1,5.0,100,500.0),
(2,'2018-02-01','admin','赵科长','汇票',2,1500.0,10,15000.0),
(3,'2018-03-01','admin','赵科长','现金',3,200.0,50,10000.0);



--销售记录表
insert into t_sale (client_id,sdate,operator,brokerage,settlement,product_id,price,number,actual_income)
values
(1,'2018-01-05','admin','李科长','现金',1,9.0,50,450.0),
(2,'2018-02-05','admin','李科长','支票',1,2000.0,5,10000.0),
(3,'2018-03-05','admin','李科长','现金',1,300.0,30,9000.0);


--库存数量
insert into t_stock (product_id,product_name,sname,place,unit,standard,packing,price,number)
values
(1,'光盘','光盘','广东','个','1G','盒装',9.0,50),
(2,'液晶显示器','显示器','深圳','台','20寸','纸箱',2000.0,5),
(3,'机械键盘','键盘','台湾','个','红轴','礼盒装',300.0,20);

--采购记录表
insert into t_purchase (product_id,pdate,number,price,total_amount,remark)
values
(1,'2018-01-01',100,5.0,500.0,'购买光盘100个'),
(2,'2018-01-01',10,1500.0,15000.0,'购买显示器10台'),
(3,'2018-01-01',50,200.0,10000.0,'购买键盘50个');

--菜单表
insert into t_menu (name,url,pid,remark)
values 
('基础信息',null,0,'一级菜单'),
('采购信息',null,0,'一级菜单'),
('库存信息',null,0,'一级菜单'),
('销售信息',null,0,'一级菜单'),
('系统设置',null,0,'一级菜单'),
('客户信息',null,1,'二级菜单'),
('商品信息',null,1,'二级菜单'),
('供应商信息',null,1,'二级菜单'),
('添加采购记录',null,2,'二级菜单'),
('查询采购记录',null,2,'二级菜单'),
('商品入库',null,3,'二级菜单'),
('入库记录查询',null,3,'二级菜单'),
('库存查询',null,3,'二级菜单'),
('商品销售',null,4,'二级菜单'),
('销售记录查询',null,4,'二级菜单'),
('添加操作员',null,5,'二级菜单'),
('修改密码',null,5,'二级菜单'),
('添加客户信息',null,6,'三级菜单'),
('查询客户信息',null,6,'三级菜单'),
('添加商品信息',null,7,'三级菜单'),
('查询商品信息',null,7,'三级菜单'),
('调整商品售价',null,7,'三级菜单'),
('添加供应商信息',null,8,'三级菜单'),
('查询供应商信息',null,8,'三级菜单');

--角色表

insert into t_role (name,remark)
values
('admin','管理员权限'),
('saleman','销售员权限'),
('stockman','仓库管理员权限'),
('buyer','采购人员');

--角色菜单关联表

insert into t_role_menu (role_id,menu_id)
values
(1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),(1,21),(1,22),(1,23),(1,24),
(2,1),(2,3),(2,4),(2,5),(2,6),(2,7),(2,13),(2,14),(2,15),(2,17),(2,18),(2,19),(2,21),
(3,3),(3,5),(3,11),(3,12),(3,13),(3,17),
(4,2),(4,3),(4,5),(4,7),(4,8),(4,9),(4,10),(4,13),(4,17),(4,20),(4,21),(4,23),(4,24);

--用户表
insert into t_user (name,rname,pwd,role_id)
values
('zhangsan','张三','123',1),
('lisi','李四','123',2),
('wangwu','王五','123',3),
('zhaoliu','赵六','123',4);









