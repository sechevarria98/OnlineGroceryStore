create table Customer
	(c_id numeric(5,0) primary key,
	 c_name varchar(25),
	 delivery_address varchar(100) not null,
	 balance numeric(5,2) Default '0.00'
	);
create table CustomerCC
	(c_id numeric(5,0),
	 credit_card numeric(16,0) not null,
	 payment_address varchar(100) not null,
	 foreign key(c_id) references Customer (c_id)
	);
create table StaffMember
	(s_id numeric(5,0) primary key,
	 staff_name varchar(25),
	 s_address varchar(100),
	 salary numeric(7,2) Default 25000,
	 job_title varchar(100) Default 'associate'
	);
create table Product
	(p_id numeric(5,0) primary key,
	 product_name varchar(25) not null,
	 packaging_size numeric(5,2) not null
	);
create table Alcohol
	(p_id numeric(5,0),
	 a_type varchar(10),
	 volume numeric(4,2),
	 foreign key(p_id) references Product(p_id)
	);
create table Nutrition
	(p_id numeric(5,0),
	 calorie numeric(4,0),
	 protein numeric(4,2),
	 sodium numeric(4,2),
	 fat_content numeric(4,2),
	 foreign key(p_id) references Product(p_id)
	);
create table Warehouse
	(w_number numeric(5,0) primary key,
	 w_address varchar(100) not null,
	 storage_capacity numeric(5,0) default 500
	);
create table Stock
	(p_id numeric(5,0),
	 w_number numeric(5,0),
	 amount numeric(10,0) Default 1,
	 foreign key(p_id) references Product(p_id),
	 foreign key(w_number) references Warehouse(w_number)
	);
create table Pricing
	(p_id numeric(5,0),
	 st char(2) not null,
	 price numeric(5,2) not null,
	 foreign key(p_id) references Product(p_id)
	);
create table Orders
	(c_id numeric(5,0),
	 p_id numeric(5,0),
	 num_items numeric(5,0) Default 1,
	 time_ordered timestamp,
	 status char(10) Default 'issued',
	 credit_card numeric(16,0) not null,
	 foreign key(c_id) references Customer(c_id),
	 foreign key(p_id) references Product(p_id)
	);
create table Suppliers
	(sup_name varchar(25) not null,
	 p_id numeric(5,0) not null,
	 s_price numeric(5,2) not null,
	 foreign key(p_id) references Product(p_id)
	 );
create table SupplierAddress
	(sup_name varchar(25) not null,
	 sup_address varchar(100) primary key
	);