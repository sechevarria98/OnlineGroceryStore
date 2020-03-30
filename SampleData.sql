delete from Customer;
delete from CustomerCC;
delete from StaffMember;
delete from Product;
delete from Alcohol;
delete from Warehouse;
delete from Stock;
delete from Pricing;
delete from Orders;
delete from Suppliers;

-- Data for Customer;
insert into Customer values ( 1, 'Kevin', '123 Street Street', 100.00);
insert into Customer values ( 2, 'Jason', '456 Avenue Street', 324.00);
insert into Customer values ( 3, 'Sam', '789 Main Street', 250.00);

--Data for CustomerCC:
insert into CustomerCC values ( 1, 1232348912345678, '123 Street Street');
insert into CustomerCC values ( 2, 1234567565664562, '789 Main Street');
insert into CustomerCC values ( 3, 2123423491234567, '123 Street Street');

--Data for StaffMember;
insert into StaffMember values ( 1, 'KevinPrime', '123 Street Street', 40000.00, 'Manager');
insert into StaffMember values ( 2, 'JasonPrime', '456 Avenue Street', 25000.00, 'Associate');
insert into StaffMember values ( 3, 'SamPrime', '789 Main Street', 25000.00, 'Associate');

--Data for Product;
insert into Product values ( 10456, 'Aquafina', 20.00);
insert into Product values ( 10436, 'Moutain Dew', 20.00);
insert into Product values ( 10458, 'Coke Cola', 20.00);

insert into Product values ( 11145, 'Bud Light: 12 Pack', 144.00);
insert into Product values ( 11142, 'Jack Daniels', 30.00);
insert into Product values ( 11147, 'Rolling Rock', 12.00);

--Data for Alcohol;
insert into Alcohol values ( 11145, 'Beer', 12.00);
insert into Alcohol values ( 11142, 'Whiskey', 30.00);
insert into Alcohol values ( 11147, 'Beer', 30.00);

--Data for Nutrition;
insert into Nutrition values( 10456, 0, 0.00, 0.00, 0.00);
insert into Nutrition values( 10436, 290, 0.00, 1.05, 0.00);
insert into Nutrition values( 10458, 240, 0.00, 0.75, 0.00);

insert into Nutrition values( 11145, 110, 1.00, 0.90, 0.00);
insert into Nutrition values( 11142, 1950, 0.00, 0.00, 0.00);
insert into Nutrition values( 11147, 130, 1.00, 0.00, 0.00);

--Data for Warehouse;
insert into Warehouse values ( 1, '395 Well Street', 1000);
insert into Warehouse values ( 2, '582 Wolf Street', 1000);
insert into Warehouse values ( 3, '222 Wall Street', 500);

--Data for Stock;
insert into Stock values ( 10456, 1, 100);
insert into Stock values ( 10436, 1, 70);
insert into Stock values ( 10458, 2, 80);

insert into Stock values ( 11145, 3, 45);
insert into Stock values ( 11142, 3, 50);
insert into Stock values ( 11147, 3, 30);

--Data for Pricing
insert into Pricing values ( 10456, 'IL', 2.00);
insert into Pricing values ( 10436, 'IL', 2.00);
insert into Pricing values ( 10458, 'IL', 2.00);

insert into Pricing values ( 11145, 'IL', 5.00);
insert into Pricing values ( 11142, 'IL', 9.00);
insert into Pricing values ( 11147, 'IL', 3.00);

insert into Pricing values ( 10456, 'WI', 2.25);
insert into Pricing values ( 10436, 'WI', 2.25);
insert into Pricing values ( 10458, 'WI', 2.25);

insert into Pricing values ( 11145, 'WI', 5.50);
insert into Pricing values ( 11142, 'WI', 9.50);
insert into Pricing values ( 11147, 'WI', 3.50);

--Data for Orders;
--Not necessary, we'll add orders as the customer adds items to their cart

--Data for Suppliers;
insert into Suppliers values('Supplier_A', 10456, 1.75);
insert into Suppliers values('Supplier_A', 10436, 1.75);
insert into Suppliers values('Supplier_A', 10458, 1.75);

insert into Suppliers values('Supplier_B', 11145, 4.50);
insert into Suppliers values('Supplier_B', 11142, 8.00);
insert into Suppliers values('Supplier_B', 11147, 2.50);