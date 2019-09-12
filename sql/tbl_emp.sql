/*
 Navicat Premium Data Transfer

 Source Server         : mysql-localhost
 Source Server Type    : MySQL
 Source Server Version : 50644
 Source Host           : localhost:3306
 Source Schema         : erp

 Target Server Type    : MySQL
 Target Server Version : 50644
 File Encoding         : 65001

 Date: 12/09/2019 17:28:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_emp
-- ----------------------------
DROP TABLE IF EXISTS `tbl_emp`;
CREATE TABLE `tbl_emp`  (
  `uuid` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `realName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lastLoginTime` datetime(0) NULL DEFAULT NULL,
  `birthday` datetime(0) NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `deptId` int(11) NULL DEFAULT NULL,
  `lastLoginIp` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `loginTimes` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_emp
-- ----------------------------
INSERT INTO `tbl_emp` VALUES (1, 'admin', 'zhangsan', '21232f297a57a5a743894a0e4a801fc3', NULL, NULL, NULL, '2019-09-12 16:22:58', NULL, NULL, NULL, '0:0:0:0:0:0:0:1', 9);
INSERT INTO `tbl_emp` VALUES (9, 'test', '李四', '321654', '1368545564', '1', 'lisi@qq.com', NULL, '2019-09-09 00:00:00', '上兴街', 3, NULL, NULL);
INSERT INTO `tbl_emp` VALUES (10, 'Lancer', '王五', '852936', '1356642586', '1', 'wangwu@qq.com', NULL, '2019-09-02 00:00:00', '小什字', 4, NULL, NULL);
INSERT INTO `tbl_emp` VALUES (11, 'saber', '赵六', '123456', '1253465845', '0', 'zhaoliu@gmail.com', NULL, '2019-09-06 00:00:00', '回龙观', 5, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
