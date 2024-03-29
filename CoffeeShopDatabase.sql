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
	username nvarchar(50),
	position int,
	email varchar(254),
	pass varchar(64),
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