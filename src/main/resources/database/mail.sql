
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255)  NOT NULL unique COMMENT '用户名',
  `password` varchar(255)  NULL COMMENT '密码',
  `nickname` varchar(255)  NULL COMMENT '昵称',
  `email` varchar(255)  NOT NULL unique COMMENT '邮箱',
  `state` int(3) DEFAULT '0' COMMENT '激活状态',
  `code` varchar(255) NULL COMMENT '激活码',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
