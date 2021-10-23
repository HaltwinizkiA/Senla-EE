DROP TABLE IF EXISTS history;
CREATE TABLE history
(
 id     	  serial PRIMARY KEY ,
 sellingPrice int NOT NULL ,
 sellenigDate date NOT NULL ,
 productId    int NOT NULL ,
 customerId   int NOT NULL ,
CONSTRAINT fk_products
      FOREIGN KEY(productId)
	  REFERENCES products(id),
CONSTRAINT fk_users
      FOREIGN KEY(customerId)
	  REFERENCES users(id)
);
