CREATE
    ALGORITHM = UNDEFINED
    DEFINER = `root`@`localhost`
    SQL SECURITY DEFINER
VIEW `cupcake`.`customer_view` AS
    SELECT
        `c`.`customer_id` AS `customer_id`,
        `c`.`email` AS `email`,
        `c`.`password` AS `password`,
        `o`.`order_id` AS `order_id`,
        `o`.`order_date` AS `order_date`,
        `ol`.`orderline_id` AS `orderline_id`,
        `ol`.`qty` AS `qty`,
        `ol`.`sum` AS `sum`,
        `t`.`topping_id` AS `topping_id`,
        `t`.`name` AS `topping_name`,
        `t`.`price` AS `topping_price`,
        `b`.`bottom_id` AS `bottom_id`,
        `b`.`name` AS `bottom_name`,
        `b`.`price` AS `bottom_price`
    FROM
        ((((`cupcake`.`customer` `c`
        JOIN `cupcake`.`order` `o` ON ((`c`.`customer_id` = `o`.`customer_id`)))
        JOIN `cupcake`.`orderline` `ol` ON ((`o`.`order_id` = `ol`.`order_id`)))
        JOIN `cupcake`.`topping` `t` ON ((`ol`.`topping_id` = `t`.`topping_id`)))
        JOIN `cupcake`.`bottom` `b` ON ((`ol`.`bottom_id` = `b`.`bottom_id`)))