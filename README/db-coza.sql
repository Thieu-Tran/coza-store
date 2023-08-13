CREATE DATABASE coza_store;
USE coza_store;

CREATE table user(
	id int AUTO_INCREMENT,
	username varchar(255),
	password varchar(255),
	email varchar(255) UNIQUE,

	primary key(id)
);

CREATE table country(
	id int AUTO_INCREMENT,
	name varchar(255),
	price_ship decimal(10,2),
	
	primary key(id)
);

CREATE table size(
	id int AUTO_INCREMENT,
	name varchar(10),
	
	primary key(id)
);

CREATE table color(
	id int AUTO_INCREMENT,
	name varchar(10),
	
	primary key(id)
);

CREATE table category(
	id int AUTO_INCREMENT,
	name varchar(50),
	
	primary key(id)
);

CREATE table tag(
	id int AUTO_INCREMENT,
	name varchar(50),
	
	primary key(id)
);

CREATE table category_tag(
	category_id int,
	tag_id int,
	
	primary key(category_id,tag_id)
);

CREATE table product(
	id int AUTO_INCREMENT,
	image text,
	name varchar(255),
	price decimal(10,2),
	description text,
	quantity int,
	image_detail text,
	
	color_id int,
	size_id int,
	category_id int,
	
	primary key(id)
);

CREATE table blog(
	id int AUTO_INCREMENT,
	image text,
	title varchar(255),
	description text,
	content text,
	create_date timestamp default current_timestamp,
	
	user_id int,
	
	primary key(id)
);

CREATE table comment(
	id int AUTO_INCREMENT,
	name varchar(255),
	email varchar(255),
	website varchar(255),
	comment text,
	create_date timestamp default current_timestamp,
	
	blog_id int,
	
	primary key(id)
);

CREATE table orders(
	id int AUTO_INCREMENT,
	create_date timestamp default current_timestamp,
	
	user_id int,
	country_id int,
	
	primary key(id)
);

CREATE table tag_blog(
	tag_id int,
	blog_id int,
	
	primary key(tag_id,blog_id)
);

CREATE table order_detail(
	product_id int,
	order_id int,
	price decimal(10,2),
	quantity int,
	
	primary key(product_id,order_id)
);

CREATE table banner(
	id int AUTO_INCREMENT,
	name varchar(50),
	content varchar(50),
	image text,
	
	primary key(id)
);


ALTER table blog add constraint fk_blog_user_id foreign key(user_id) references user(id);

ALTER table comment add constraint fk_comment_blog_id foreign key(blog_id) references blog(id);

ALTER table orders add constraint fk_country_id foreign key(country_id) references country(id);
ALTER table orders add constraint fk_user_id foreign key(user_id) references user(id);

ALTER table tag_blog add constraint fk_tag_blog_tag_id foreign key(tag_id) references tag(id);
ALTER table tag_blog add constraint fk_tag_blog_blog_id foreign key(blog_id) references blog(id);

ALTER table order_detail add constraint fk_order_detail_product_id foreign key(product_id) references product(id);
ALTER table order_detail add constraint fk_order_detail_order_id foreign key(order_id) references orders(id);

ALTER table category_tag add constraint fk_category_tag_category_id foreign key(category_id) references category(id);
ALTER table category_tag add constraint fk_category_tag_tag_id foreign key(tag_id) references tag(id);

ALTER table product add constraint fk_product_size_id foreign key(size_id) references size(id);
ALTER table product add constraint fk_product_color_id foreign key(color_id) references color(id);
ALTER table product add constraint fk_product_category_id foreign key(category_id) references category(id);

INSERT into color(name) values("Red");
INSERT into color(name) values("Blue");
INSERT into color(name) values("White");
INSERT into color(name) values("Black");
INSERT into color(name) values("Yellow");

INSERT into size(name) values("S");
INSERT into size(name) values("M");
INSERT into size(name) values("L");
INSERT into size(name) values("XL");
INSERT into size(name) values("XXL");

INSERT into category(name) values("Women");
INSERT into category(name) values("Man");
INSERT into category(name) values("Bag");
INSERT into category(name) values("Shoe");
INSERT into category(name) values("Watches");

INSERT INTO country(name,price_ship) values("Ha Noi",2.25);
INSERT INTO country(name,price_ship) values("Ho Chi Minh",0.5);
INSERT INTO country(name,price_ship) values("Da Nang",1.42);
INSERT INTO country(name,price_ship) values("Vinh",1.60);
INSERT INTO country(name,price_ship) values("Buon Ma Thuot",1.20);


INSERT into product(image,name,price,description,quantity,image_detail,color_id,size_id,category_id) 
values("product-shoe-01.jpg","Boys' Under Armour Big Kid Zone Basketball Shoes",60.00,"Nulla eget sem vitae eros pharetra viverra. Nam vitae luctus ligula.",60,"product-shoe-detail-1.1.jpg,product-shoe-detail-1.2.jpg,product-shoe-detail-1.3.jpg",3,2,4);

INSERT into product(image,name,price,description,quantity,image_detail,color_id,size_id,category_id) 
values("product-shoe-01.jpg","Boys' Under Armour Big Kid Zone Basketball Shoes",60.00,"Nulla eget sem vitae eros pharetra viverra. Nam vitae luctus ligula.",60,"product-shoe-detail-1.1.jpg,product-shoe-detail-1.2.jpg,product-shoe-detail-1.3.jpg",1,3,4);

INSERT into product(image,name,price,description,quantity,image_detail,color_id,size_id,category_id) 
values("product-shoe-01.jpg","Boys' Under Armour Big Kid Zone Basketball Shoes",60.00,"Nulla eget sem vitae eros pharetra viverra. Nam vitae luctus ligula.",60,"product-shoe-detail-1.1.jpg,product-shoe-detail-1.2.jpg,product-shoe-detail-1.3.jpg",2,1,4);


INSERT into product(image,name,price,description,quantity,image_detail,color_id,size_id,category_id) 
values("product-shoe-02.jpg","Boys' Skechers Little Kid & Big Kid Dino Lights Light-Up Sneakers",49.98,"Nulla eget sem vitae eros pharetra viverra. Nam vitae luctus ligula.",60,"product-shoe-detail-2.1.jpg,product-shoe-detail-2.2.jpg,product-shoe-detail-2.3.jpg",5,2,4);

INSERT into product(image,name,price,description,quantity,image_detail,color_id,size_id,category_id) 
values("product-shoe-03.jpg","Men's Fila Memory Superstride 6 Running Shoes",39.98,"Nulla eget sem vitae eros pharetra viverra. Nam vitae luctus ligula.",60,"product-shoe-detail-3.1.jpg,product-shoe-detail-3.2.jpg,product-shoe-detail-3.3.jpg",4,2,4);

INSERT into product(image,name,price,description,quantity,image_detail,color_id,size_id,category_id) 
values("product-shoe-04.jpg","Men's Vans Seldan Skate Shoes",49.98,"Nulla eget sem vitae eros pharetra viverra. Nam vitae luctus ligula.",60,"product-shoe-detail-4.1.jpg,product-shoe-detail-4.2.jpg,product-shoe-detail-4.3.jpg",5,2,4);

INSERT into product(image,name,price,description,quantity,image_detail,color_id,size_id,category_id) 
values("product-shoe-05.jpg","Women's VINTAGE HAVANA Brenda Sneakers",64.98,"Nulla eget sem vitae eros pharetra viverra. Nam vitae luctus ligula.",60,"product-shoe-detail-5.1.jpg,product-shoe-detail-5.2.jpg,product-shoe-detail-5.3.jpg",3,2,4);


INSERT into product(image,name,price,description,quantity,image_detail,color_id,size_id,category_id) 
values("product-watch-01.jpg","Luminox Pacific Diver",34.99,"Nulla eget sem vitae eros pharetra viverra. Nam vitae luctus ligula.",60,"product-watch-detail-1.1.jpg,product-watch-detail-1.2.jpg,product-watch-detail-1.3.jpg",3,2,5);

INSERT into product(image,name,price,description,quantity,image_detail,color_id,size_id,category_id) 
values("product-watch-01.jpg","Luminox Pacific Diver",34.99,"Nulla eget sem vitae eros pharetra viverra. Nam vitae luctus ligula.",60,"product-watch-detail-1.1.jpg,product-watch-detail-1.2.jpg,product-watch-detail-1.3.jpg",4,3,5);

INSERT into product(image,name,price,description,quantity,image_detail,color_id,size_id,category_id) 
values("product-watch-02.jpg","Tissot Men's Seastar",595,"Nulla eget sem vitae eros pharetra viverra. Nam vitae luctus ligula.",60,"product-watch-detail-2.1.jpg,product-watch-detail-2.2.jpg,product-watch-detail-2.3.jpg",4,2,5);

INSERT into product(image,name,price,description,quantity,image_detail,color_id,size_id,category_id) 
values("product-watch-02.jpg","Tissot Men's Seastar",595,"Nulla eget sem vitae eros pharetra viverra. Nam vitae luctus ligula.",60,"product-watch-detail-2.1.jpg,product-watch-detail-2.2.jpg,product-watch-detail-2.3.jpg",2,1,5);


INSERT into product(image,name,price,description,quantity,image_detail,color_id,size_id,category_id) 
values("product-women-01.jpg","Coolmax Skinny Fit Women's Jeans WJE 2021",29.62,"Nulla eget sem vitae eros pharetra viverra. Nam vitae luctus ligula.",60,"product-women-detail-1.1.jpg,product-women-detail-1.2.jpg,product-women-detail-1.3.jpg",3,1,1);

INSERT into product(image,name,price,description,quantity,image_detail,color_id,size_id,category_id) 
values("product-women-02.jpg","Women's Anti UV Regular Fit Emboss Jacket WOK 2037",27.79,"Nulla eget sem vitae eros pharetra viverra. Nam vitae luctus ligula.",60,"product-women-detail-2.1.jpg,product-women-detail-2.2.jpg,product-women-detail-2.3.jpg",2,2,1);

INSERT into product(image,name,price,description,quantity,image_detail,color_id,size_id,category_id) 
values("product-women-03.jpg","Women's Mini Split Dress WSK",15.21,"Nulla eget sem vitae eros pharetra viverra. Nam vitae luctus ligula.",60,"product-women-detail-3.1.jpg,product-women-detail-3.2.jpg,product-women-detail-3.3.jpg",2,2,1);

INSERT into product(image,name,price,description,quantity,image_detail,color_id,size_id,category_id) 
values("product-women-04.jpg","Women's Tanktop Rib T-shirt WTS 2254",8.43,"Nulla eget sem vitae eros pharetra viverra. Nam vitae luctus ligula.",60,"product-women-detail-4.1.jpg,product-women-detail-4.2.jpg,product-women-detail-4.3.jpg",5,1,1);

INSERT into product(image,name,price,description,quantity,image_detail,color_id,size_id,category_id) 
values("product-women-05.jpg","Women's Umbrella Jacket Raglan Color Coordinator WOP 2033",22.84,"Nulla eget sem vitae eros pharetra viverra. Nam vitae luctus ligula.",60,"product-women-detail-5.1.jpg,product-women-detail-5.2.jpg,product-women-detail-5.3.jpg",2,2,1);


INSERT into product(image,name,price,description,quantity,image_detail,color_id,size_id,category_id) 
values("product-bag-01.jpg","BIRDYBAG MIDDLE PILLOW BAG",11.86,"Nulla eget sem vitae eros pharetra viverra. Nam vitae luctus ligula.",20,"product-bag-detail-1.1.jpg,product-bag-detail-1.2.jpg,product-bag-detail-1.3.jpg",3,1,3);

INSERT into product(image,name,price,description,quantity,image_detail,color_id,size_id,category_id) 
values("product-bag-02.jpg","BIRDYBAG MIDDLE PILLOW Navy",14.86,"Nulla eget sem vitae eros pharetra viverra. Nam vitae luctus ligula.",20,"product-bag-detail-2.1.jpg,product-bag-detail-2.2.jpg,product-bag-detail-2.3.jpg",2,1,3);


INSERT into product(image,name,price,description,quantity,image_detail,color_id,size_id,category_id) 
values("product-men-01.jpg","Umbrella Jacket",33.89,"Nulla eget sem vitae eros pharetra viverra. Nam vitae luctus ligula.",60,"product-men-detail-1.1.jpg,product-men-detail-1.2.jpg,product-men-detail-1.3.jpg",5,2,2);

INSERT into product(image,name,price,description,quantity,image_detail,color_id,size_id,category_id) 
values("product-men-02.jpg","Men's Umbrella Jacket Mixed Color MOP 1039",28.94,"Nulla eget sem vitae eros pharetra viverra. Nam vitae luctus ligula.",60,"product-men-detail-2.1.jpg,product-men-detail-2.2.jpg,product-men-detail-2.3.jpg",5,2,2);

INSERT into product(image,name,price,description,quantity,image_detail,color_id,size_id,category_id) 
values("product-men-03.jpg","MOP 1045 . Single Layer Stand Collar Men's Jacket",22.84,"Nulla eget sem vitae eros pharetra viverra. Nam vitae luctus ligula.",60,"product-men-detail-3.1.jpg,product-men-detail-3.2.jpg,product-men-detail-3.3.jpg",5,2,2);

INSERT into product(image,name,price,description,quantity,image_detail,color_id,size_id,category_id) 
values("product-men-04.jpg","Iscra MPO Men's Polo Shirt 1036",19.03,"Nulla eget sem vitae eros pharetra viverra. Nam vitae luctus ligula.",60,"product-men-detail-4.1.jpg,product-men-detail-4.2.jpg,product-men-detail-4.3.jpg",5,2,2);


INSERT INTO banner(name,content,image) values("Women","Young - Dynamic","banner-08.jpg");
INSERT INTO banner(name,content,image) values("Men","Elegant","banner-07.jpg");
INSERT INTO banner(name,content,image) values("Accessories","Hot 2023","banner-09.jpg");

INSERT INTO user(username,password,email) values("Ares","$2y$10$MQzXOmH/OWoNADM3Il6o4ebKkCukRUD7csm6ydb6KenIa8xzaL6Li","ares@gmail.com");
INSERT INTO user(username,password,email) values("Endless","$2y$10$MQzXOmH/OWoNADM3Il6o4ebKkCukRUD7csm6ydb6KenIa8xzaL6Li","endless@gmail.com");
INSERT INTO user(username,password,email) values("July","$2y$10$MQzXOmH/OWoNADM3Il6o4ebKkCukRUD7csm6ydb6KenIa8xzaL6Li","july@gmail.com");


INSERT INTO blog(image,title,description,content,user_id) values("How_To_Start_A_Blog_-_article_image.jpg","How To Start A Blog And Make Money In 2023 – Forbes Advisor",
"In the early days of the internet, blogging was more akin to journaling. Some of the earliest blogs were used as a way to chronicle someone’s personal viewpoints and experiences.",
"Starting a blog can be both a rewarding and lucrative venture that opens exciting opportunities. Through blogging, you can establish yourself as a credible expert in your field, earn a part-time or full-time income and connect with like-minded people who share your interests and passions.",1);

INSERT INTO blog(image,title,description,content,user_id) values("blogs-on-business.jpg","The Power of Blogs on Business Websites",
"Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce eget dictum tortor. Donec dictum vitae sapien eu varius",
"Blogging platforms were earlier used by people to write their opinions on a variety of topics. In recent years, businesses have recognized the importance of blogs for digital success. Companies have realized that they must provide additional value to their customer base, to remain competitive in the digital landscape.",2);

INSERT INTO blog(image,title,description,content,user_id) values("blogging-stats.jpg","24 Blogging Stats You Need To Know - Constant Content (A Division of Moresby Media Inc.)",
"Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce eget dictum tortor. Donec dictum vitae sapien eu varius",
"Blogs remain one of the best ways to engage your audience, generate leads, and improve your online visibility. If you’re still wondering if blogging makes sense for your business, we hope the following blogging statistics that we’ve curated from over a dozen studies will convince you to make blogging a part of your content strategy.",3);



INSERT INTO tag(name) values("Fashion");
INSERT INTO tag(name) values("Trend");
INSERT INTO tag(name) values("Beauty");
INSERT INTO tag(name) values("Street Style");
INSERT INTO tag(name) values("Life Style");
INSERT INTO tag(name) values("DIY & Crafts");

INSERT INTO tag_blog(tag_id,blog_id) values(1,1);
INSERT INTO tag_blog(tag_id,blog_id) values(5,1);
INSERT INTO tag_blog(tag_id,blog_id) values(4,2);
INSERT INTO tag_blog(tag_id,blog_id) values(1,2);
INSERT INTO tag_blog(tag_id,blog_id) values(2,3);
INSERT INTO tag_blog(tag_id,blog_id) values(3,3);
INSERT INTO tag_blog(tag_id,blog_id) values(6,1);


INSERT INTO comment(name,email,website,comment,blog_id) values("Nguyen Van A","nguyenvana@gmail.com","hoathinh4k.net","Great article!",1);
INSERT INTO comment(name,email,website,comment,blog_id) values("Tran Van B","tranvanb@gmail.com","helloworld.com","Thanks the author",2);
INSERT INTO comment(name,email,website,comment,blog_id) values("Nguyen Thi C","nguyenthic@gmail.com","localhost8080.com","Very meaningful article",1);


-- ------------------------------------------------------------
SELECT * FROM user;
SELECT * FROM color;
SELECT * FROM size;
SELECT * FROM category;
SELECT * FROM product;
SELECT * FROM banner;
SELECT * FROM country;
SELECT * FROM blog;
SELECT * FROM tag;
SELECT * FROM tag_blog;
SELECT * FROM comment;
SELECT * FROM orders;
SELECT * FROM order_detail;
-- ------------------------------------------------------------

-- SELECT * FROM blog b2 WHERE YEAR(create_date)>2022;
-- SELECT * FROM tag t inner join tag_blog tb on t.id=tb.tag_id INNER JOIN blog b on b.id=1 and tb.blog_id=1;
-- SELECT c.id ,c.name FROM color c, product p WHERE p.name ="Tissot Men's Seastar 660/1000 Stainless Steel Casual Watch" AND p.color_id =c.id ;
-- SELECT s.id ,s.name FROM size s, product p WHERE p.name ="Men's Fila Memory Superstride 6 Running Shoes" AND p.size_id =s.id ;
-- SELECT * FROM orders o WHERE user_id =3 ORDER BY id DESC LIMIT 1;
-- SELECT * FROM product p2 inner join (SELECT DISTINCT name as filterName from product p) on p.filterName =p2.name;
-- SELECT DISTINCT name from product p ;
-- delete from user WHERE user.id=4;












