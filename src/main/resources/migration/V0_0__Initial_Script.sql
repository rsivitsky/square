CREATE TABLE `user` (
  `id`        BIGINT PRIMARY KEY AUTO_INCREMENT,
  `login`     VARCHAR(255) NOT NULL,
  `password`  VARCHAR(255),
  `firstname` VARCHAR(255),
  `lastname`  VARCHAR(255),
  `role`      VARCHAR(32)
);

CREATE TABLE `vendor` (
  `id`   BIGINT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL
);

CREATE TABLE `vendor_account` (
  `id`        BIGINT PRIMARY KEY AUTO_INCREMENT,
  `vendor_fk` BIGINT       NOT NULL,
  `user_fk`   BIGINT       NOT NULL,
  `role`      VARCHAR(255) NOT NULL
);
ALTER TABLE vendor_account ADD INDEX vendor_account_vendor_fk_ind (vendor_fk), ADD CONSTRAINT vendor_account_vendor_fk FOREIGN KEY (vendor_fk) REFERENCES vendor (id);
ALTER TABLE vendor_account ADD INDEX vendor_account_user_fk_ind (user_fk), ADD CONSTRAINT vendor_account_user_fk FOREIGN KEY (user_fk) REFERENCES user (id);

CREATE TABLE `currency` (
  `id`     BIGINT PRIMARY KEY AUTO_INCREMENT,
  `name`   VARCHAR(255) NOT NULL,
  `symbol` VARCHAR(255)
);