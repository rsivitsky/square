# use offersdb;
CREATE TABLE `user` (
  `id`        BIGINT PRIMARY KEY AUTO_INCREMENT,
  `login`     VARCHAR(255) NOT NULL,
  `password`  VARCHAR(255),
  `firstname` VARCHAR(255),
  `lastname`  VARCHAR(255),
  `role`      VARCHAR(32)
)
  ENGINE = InnoDB