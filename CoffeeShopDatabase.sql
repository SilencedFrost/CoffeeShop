create database CoffeeShop;
go

use CoffeeShop;
go

create table PaymentCard
(
	cardnum varchar(16),
	userID int,
	expdate date,
	cvv int,
	cardownername varchar(50)
	primary key (cardnum)
);
go

create table Customer
(
	userID int identity (1, 1),
	username varchar(50) UNIQUE not null,
	position int not null,
	email varchar(254),
	pass varchar(64) not null,
	gender bit,
	phone varchar(12),
	exactloc nvarchar(100),
	ward nvarchar(30),
	district nvarchar(30),
	city nvarchar(30),
	primary key(userID)
);
go

create table Comment
(
	commentID int identity(1, 1),
	userID int,
	productID char(10),
	adddate datetime,
	rating float,
	comm nvarchar(500),
	primary key (commentID)
);
go

create table Cart
(
	userID int,
	productID char(10),
	quantity int,
	primary key (userID, productID)
);
go

create table Ords
(
	orderID int identity(1, 1),
	creationdate datetime,
	finisheddate datetime,
	status nvarchar(20),
	userID int,
	primary key (orderID)
);
go

create table OrdItems
(
	orderID int,
	productID char(10),
	primary key (orderID, productID)
);
go

create table Product
(
	productID char(10),
	pdname nvarchar(20),
	pddesc nvarchar(500),
	visibility bit,
	adddate datetime,
	size char(1),
	price float,
	primary key (productID)
);
go

alter table PaymentCard
	add constraint PaymentCard_userID
		foreign key (userID) references Customer(userID);
go

alter table Comment
	add constraint Comment_userID
		foreign key (userID) references Customer(userID),
	constraint Comment_productID
		foreign key (productID) references Product(productID);
go

alter table Cart
	add constraint Cart_userID
		foreign key (userID) references Customer(userID),
	constraint Cart_productID
		foreign key (productID) references Product(productID);
go

alter table Ords
	add constraint Ords_userID
		foreign key (userID) references Customer(userID);
go

alter table OrdItems
	add constraint OrdItems_orderID
		foreign key (orderID) references Ords(orderID),
	constraint OrdItems_productID
		foreign key (productID) references Product(productID);
go

-- trigger

create or alter trigger Customer_password_hash on Customer
instead of insert
as
begin
	insert into Customer(username, position, email, pass, gender, phone, exactloc, ward, district, city) values (
	(select username from inserted), 
	(select position from inserted), 
	(select email from inserted), 
	HASHBYTES('SHA2_256', (select pass from inserted)), 
	(select gender from inserted), 
	(select phone from inserted), 
	(select exactloc from inserted), 
	(select ward from inserted), 
	(select district from inserted), 
	(select city from inserted))
end
go

-- Procs

create or alter proc Register
@Username varchar(50),
@Email varchar(100),
@Password varchar(32),
@Success int output
as
begin
	if not exists(select * from Customer where username like @Username or email like @Email)
		begin
		insert into Customer(username, email, pass, position) values (@Username, @Email, HASHBYTES('SHA2_256', @Password), 0)
		set @Success = 1;
		end
	else
		begin
		set @Success = 0;
		end
end;
go

-- Funcs

create or alter function UserLogin
(
@username varchar(50),
@password varchar(32)
)
returns table
as
	return 
	(select * from Customer
	where username = @username
	AND pass = HASHBYTES('SHA2_256', @password))
go

insert into Customer(username, pass, position) values ('NguyenQuocMinh' , '123456', 3);
go

select * from Customer
