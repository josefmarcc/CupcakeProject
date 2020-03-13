USE `cupcakes`;

-- Inserts Bottoms --
INSERT INTO `bottom`(`bname`, `bPrice`) VALUES('Chokolade', 5.00);
INSERT INTO `bottom`(`bname`, `bPrice`) VALUES('Vanilje', 5.00);
INSERT INTO `bottom`(`bname`, `bPrice`) VALUES('Muskatnød', 5.00);
INSERT INTO `bottom`(`bname`, `bPrice`) VALUES('Pistacie', 6.00);
INSERT INTO `bottom`(`bname`, `bPrice`) VALUES('Mandel', 7.00);

-- Inserts Toppings -- 
INSERT INTO `topping`(`tname`, `tPrice`) VALUES('Chokolade', 5.00);
INSERT INTO `topping`(`tname`, `tPrice`) VALUES('Blåbær', 5.00);
INSERT INTO `topping`(`tname`, `tPrice`) VALUES('Hindbær', 5.00);
INSERT INTO `topping`(`tname`, `tPrice`) VALUES('Crispy', 6.00);
INSERT INTO `topping`(`tname`, `tPrice`) VALUES('Jordbær', 6.00);
INSERT INTO `topping`(`tname`, `tPrice`) VALUES('Rom/Rosin', 7.00);
INSERT INTO `topping`(`tname`, `tPrice`) VALUES('Appelsin', 8.00);
INSERT INTO `topping`(`tname`, `tPrice`) VALUES('Citron', 8.00);
INSERT INTO `topping`(`tname`, `tPrice`) VALUES('Blue cheese', 9.00);

-- Inserts users -- 
INSERT INTO `users`(`name`, `email`, `password`, `balance`) VALUES('Lone Lort', 'lonelort@somewhere.com', 'hejhedderlone', 500.00);
INSERT INTO `users`(`name`, `email`, `password`, `balance`) VALUES('Batman', 'batman@somewhere.com', 'robin', 500.00);
INSERT INTO `users`(`name`, `email`, `password`, `balance`) VALUES('Robin', 'robin@somewhere.com', 'batman', 500.00);

-- Inserts ordertails --
INSERT INTO `ordertails`(`email`, `tname`, `bname`, `qty`, `total`) VALUES('batman@somewhere.com', 'Crispy', 'Chokolade', 5, 100.00);
INSERT INTO `ordertails`(`email`, `tname`, `bname`, `qty`, `total`) VALUES('lonelort@somewhere.com', 'Jordbær', 'Muskatnød', 8, 150.00);
INSERT INTO `ordertails`(`email`, `tname`, `bname`, `qty`, `total`) VALUES('robin@somewhere.com', 'Blue cheese', 'Vanilje', 9, 200.00);