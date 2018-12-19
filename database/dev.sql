DROP TABLE IF EXISTS `City`;
CREATE TABLE `City` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `provinceId` int(11) NOT NULL COMMENT '省份id',
  `cityName` VARCHAR(50) NOT NULL COMMENT '城市名字',
  `description` varchar(100) COMMENT '城市描述',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT = 1 COMMENT='城市表';