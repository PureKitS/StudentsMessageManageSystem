/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MariaDB
 Source Server Version : 100508
 Source Host           : localhost:3306
 Source Schema         : students

 Target Server Type    : MariaDB
 Target Server Version : 100508
 File Encoding         : 65001

 Date: 25/11/2020 14:36:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int(4) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `admin_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '管理员姓名',
  `admin_email` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '管理员邮箱',
  `create_date` datetime(0) NOT NULL COMMENT '管理员创建时间',
  `admin_active` tinyint(1) NOT NULL COMMENT '管理员在籍状态',
  `username` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '管理员登录用户名',
  `password` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '管理员密码',
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '郝宏鑫', 'Purekit', '2020-11-21 11:21:01', 1, 'root', 'c1f46c805200d800a0c0185b33334b263d34c7ed');
INSERT INTO `admin` VALUES (2, 'purekit', 'Purekit.ahcme@outlook.com', '2020-11-21 11:21:09', 0, 'admin', 'c1f46c805200d800a0c0185b33334b263d34c7ed');

-- ----------------------------
-- Table structure for students_message
-- ----------------------------
DROP TABLE IF EXISTS `students_message`;
CREATE TABLE `students_message`  (
  `id` int(4) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '序号',
  `students_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生学号',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生姓名',
  `sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生性别',
  `department` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生班级部门',
  `room_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生宿舍号',
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生邮箱',
  `phone_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生手机号',
  `address` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生家庭住址',
  `start_school` datetime(0) NOT NULL DEFAULT '2019-09-16 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '入学时间',
  `stop-school` timestamp(0) NOT NULL DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP COMMENT '退学时间',
  `active` tinyint(1) NOT NULL COMMENT '学生在籍状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of students_message
-- ----------------------------
INSERT INTO `students_message` VALUES (1, '1101201190', '马保国', '男', '耗子尾汁', '太极门', 'PureKit.ahcme@gmail.com', '250520110', '混元形意', '2020-11-20 13:48:06', '2020-11-20 13:48:06', 1);
INSERT INTO `students_message` VALUES (2, '110120130', 'PureK1t', 'male', 'Software', 'P706', 'PureKit.ahcme@gmail.com', '8808888', 'AnhuiYinshang', '2020-11-19 22:02:04', '2020-11-19 22:02:04', 1);
INSERT INTO `students_message` VALUES (3, '1103193001', '刘**', '男', '软件***4', '培训楼703', 'PureKit.ahcme@gmail.com', '520111701', '安庆**县', '2020-11-19 22:02:18', '2020-11-19 22:02:18', 1);
INSERT INTO `students_message` VALUES (4, '1103193002', '尉**', '男', '软件***4', '4北102', 'PureKit.ahcme@gmail.com', '520111702', '宿州**县', '2020-11-19 22:02:19', '2020-11-19 22:02:19', 1);
INSERT INTO `students_message` VALUES (5, '1103193003', '顾**', '男', '软件***4', '4北102', 'PureKit.ahcme@gmail.com', '520111703', '淮南**', '2020-11-19 22:02:21', '2020-11-19 22:02:21', 1);
INSERT INTO `students_message` VALUES (6, '1103193004', '董**', '女', '软件***4', '4南226', 'PureKit.ahcme@gmail.com', '520111704', '淮南**县', '2020-11-19 22:02:22', '2020-11-19 22:02:22', 1);
INSERT INTO `students_message` VALUES (7, '1103193005', '吴**', '男', '软件***4', '4北102', 'PureKit.ahcme@gmail.com', '520111705', '合肥**县', '2020-11-19 22:02:23', '2020-11-19 22:02:23', 1);
INSERT INTO `students_message` VALUES (8, '1103193006', '朱**', '女', '软件***4', '4南226', 'PureKit.ahcme@gmail.com', '520111706', '宿州**', '2020-11-19 22:02:25', '2020-11-19 22:02:25', 1);
INSERT INTO `students_message` VALUES (9, '1103193007', '桂**', '男', '软件***4', '培训楼703', 'PureKit.ahcme@gmail.com', '520111707', '安庆**县', '2020-11-19 22:02:27', '2020-11-19 22:02:27', 1);
INSERT INTO `students_message` VALUES (10, '1103193008', '袁**', '男', '软件***4', '4北122', 'PureKit.ahcme@gmail.com', '520111708', '合肥**县', '2020-11-19 22:02:28', '2020-11-19 22:02:28', 0);
INSERT INTO `students_message` VALUES (11, '1103193009', '陈**', '男', '软件***4', '培训楼708', 'PureKit.ahcme@gmail.com', '520111709', '黄山**县', '2020-11-19 22:02:30', '2020-11-19 22:02:30', 1);
INSERT INTO `students_message` VALUES (12, '1103193010', '戴**', '男', '软件***4', '培训楼708', 'PureKit.ahcme@gmail.com', '520111710', '黄山**县', '2020-11-19 22:02:31', '2020-11-19 22:02:31', 1);
INSERT INTO `students_message` VALUES (13, '1103193011', '陈**', '男', '软件***4', '培训楼707', 'PureKit.ahcme@gmail.com', '520111711', '六安**区', '2020-11-19 22:02:33', '2020-11-19 22:02:33', 1);
INSERT INTO `students_message` VALUES (14, '1103193012', '金**', '男', '软件***4', '培训楼707', 'PureKit.ahcme@gmail.com', '520111712', '淮南**', '2020-11-20 00:53:44', '2020-11-20 00:53:44', 0);
INSERT INTO `students_message` VALUES (15, '1103193013', '王**', '男', '软件***4', '培训楼710', 'PureKit.ahcme@gmail.com', '520111713', '滁州**县', '2020-11-19 22:02:37', '2020-11-19 22:02:37', 1);
INSERT INTO `students_message` VALUES (16, '1103193014', '冯**', '男', '软件***4', '培训楼709', 'PureKit.ahcme@gmail.com', '520111714', '宿州**县', '2020-11-20 00:54:17', '2020-11-20 00:54:17', 0);
INSERT INTO `students_message` VALUES (17, '1103193015', '李**', '男', '软件***4', '培训楼707', 'PureKit.ahcme@gmail.com', '520111715', '阜阳**县', '2020-11-19 22:03:01', '2020-11-19 22:03:01', 1);
INSERT INTO `students_message` VALUES (18, '1103193016', '朱**', '男', '软件***4', '培训楼709', 'PureKit.ahcme@gmail.com', '520111717', '蚌埠**县', '2020-11-20 15:19:00', '2020-11-20 15:19:00', 0);
INSERT INTO `students_message` VALUES (19, '1103193017', '郭**', '男', '软件***4', '培训楼726', 'PureKit.ahcme@gmail.com', '520111717', '亳州**县', '2020-11-19 22:03:05', '2020-11-19 22:03:05', 1);
INSERT INTO `students_message` VALUES (20, '1103193018', '刘**', '男', '软件***4', '培训楼709', 'PureKit.ahcme@gmail.com', '520111756', '蚌埠**县', '2020-11-19 22:49:37', '2020-11-19 22:49:37', 0);
INSERT INTO `students_message` VALUES (21, '1103193019', '王**', '男', '软件***4', '培训楼706', 'PureKit.ahcme@gmail.com', '520111719', '铜陵**区', '2020-11-19 22:03:06', '2020-11-19 22:03:06', 1);
INSERT INTO `students_message` VALUES (22, '1103193020', '王**', '男', '软件***4', '培训楼707', 'PureKit.ahcme@gmail.com', '520111720', '宿州**县', '2020-11-19 22:03:08', '2020-11-19 22:03:08', 1);
INSERT INTO `students_message` VALUES (23, '1103193021', '张**', '男', '软件***4', '培训楼706', 'PureKit.ahcme@gmail.com', '520111721', '宿州**县', '2020-11-19 22:03:09', '2020-11-19 22:03:09', 1);
INSERT INTO `students_message` VALUES (24, '1103193022', '莫**', '男', '软件***4', '培训楼706', 'PureKit.ahcme@gmail.com', '520111722', '池州**县', '2020-11-19 22:03:10', '2020-11-19 22:03:10', 1);
INSERT INTO `students_message` VALUES (25, '1103193023', '杨**', '男', '软件***4', '培训楼708', 'PureKit.ahcme@gmail.com', '520111723', '安庆**县', '2020-11-19 22:03:12', '2020-11-19 22:03:12', 0);
INSERT INTO `students_message` VALUES (26, '1103193024', '郝**', '男', '软件***4', '培训楼706', 'PureKit.ahcme@gmail.com', '520111724', '阜阳**县', '2020-11-19 22:03:13', '2020-11-19 22:03:13', 1);
INSERT INTO `students_message` VALUES (27, '1103193025', '魏**', '男', '软件***4', '培训楼708', 'PureKit.ahcme@gmail.com', '520111725', '亳州**县', '2020-11-19 22:03:15', '2020-11-19 22:03:15', 1);
INSERT INTO `students_message` VALUES (28, '1103193026', '何**', '男', '软件***4', '培训楼709', 'PureKit.ahcme@gmail.com', '520111726', '宿州**', '2020-11-19 22:03:23', '2020-11-19 22:03:23', 1);
INSERT INTO `students_message` VALUES (29, '1103193027', '李**', '男', '软件***4', '3南322', 'PureKit.ahcme@gmail.com', '520111727', '阜阳**县', '2020-11-19 22:03:23', '2020-11-19 22:03:23', 1);
INSERT INTO `students_message` VALUES (30, '1103193028', '房**', '男', '软件***4', '3南322', 'PureKit.ahcme@gmail.com', '520111728', '蚌埠**县', '2020-11-19 22:03:24', '2020-11-19 22:03:24', 1);
INSERT INTO `students_message` VALUES (31, '1103193029', '杨**', '男', '软件***4', '3南414', 'PureKit.ahcme@gmail.com', '520111729', '六安**县', '2020-11-19 22:03:26', '2020-11-19 22:03:26', 1);
INSERT INTO `students_message` VALUES (32, '1103193030', '邓**', '男', '软件***4', '2南404', 'PureKit.ahcme@gmail.com', '520111730', '芜湖**县', '2020-11-19 22:03:29', '2020-11-19 22:03:29', 0);
INSERT INTO `students_message` VALUES (33, '1103193031', '王**', '男', '软件***4', '2南209', 'PureKit.ahcme@gmail.com', '520111731', '阜阳**区', '2020-11-20 00:56:07', '2020-11-20 00:56:07', 0);
INSERT INTO `students_message` VALUES (34, '1103193032', '转**', '男', '软件***4', '培训楼607', 'PureKit.ahcme@gmail.com', '520111732', '亳州**县', '2020-11-19 22:03:32', '2020-11-19 22:03:32', 1);
INSERT INTO `students_message` VALUES (35, '1103193033', '高**', '男', '软件***4', '培训楼313', 'PureKit.ahcme@gmail.com', '520111733', '蚌埠**县', '2020-11-19 22:03:35', '2020-11-19 22:03:35', 0);
INSERT INTO `students_message` VALUES (36, '1103193034', '孟**', '男', '软件***4', '培训楼615', 'PureKit.ahcme@gmail.com', '520111734', '宿州**县', '2020-11-19 22:03:40', '2020-11-19 22:03:40', 1);
INSERT INTO `students_message` VALUES (37, '1103193035', '高**', '男', '软件***4', '3南504', 'PureKit.ahcme@gmail.com', '520111735', '宿州**', '2020-11-19 22:03:42', '2020-11-19 22:03:42', 1);
INSERT INTO `students_message` VALUES (38, '1103193036', '王**', '男', '软件***4', '3南523', 'PureKit.ahcme@gmail.com', '520111736', '六安**县', '2020-11-19 22:03:44', '2020-11-19 22:03:44', 0);
INSERT INTO `students_message` VALUES (39, '1103193037', '朱**', '男', '软件***4', '3南605', 'PureKit.ahcme@gmail.com', '520111737', '滁州**县', '2020-11-19 22:03:46', '2020-11-19 22:03:46', 1);
INSERT INTO `students_message` VALUES (40, '1103193038', '袁**', '男', '软件***4', '3南216', 'PureKit.ahcme@gmail.com', '520111738', '芜湖**县', '2020-11-19 22:03:47', '2020-11-19 22:03:47', 1);
INSERT INTO `students_message` VALUES (41, '1103193039', '常**', '女', '软件***4', '4南610', 'PureKit.ahcme@gmail.com', '520111739', '蚌埠**县', '2020-11-19 22:03:48', '2020-11-19 22:03:48', 0);
INSERT INTO `students_message` VALUES (42, '1103193040', '朱**', '女', '软件***4', '4南602', 'PureKit.ahcme@gmail.com', '520111740', '马鞍**涂县', '2020-11-19 22:03:49', '2020-11-19 22:03:49', 1);
INSERT INTO `students_message` VALUES (43, '1103193041', '李**', '女', '软件***4', '4南610', 'PureKit.ahcme@gmail.com', '520111741', '宿州**县', '2020-11-19 22:03:50', '2020-11-19 22:03:50', 0);
INSERT INTO `students_message` VALUES (44, '1103193042', '王**', '男', '软件***4', '3南126', 'PureKit.ahcme@gmail.com', '520111742', '安庆**区', '2020-11-19 22:03:51', '2020-11-19 22:03:51', 1);
INSERT INTO `students_message` VALUES (45, '1103193043', '叶**', '男', '软件***4', '3南106', 'PureKit.ahcme@gmail.com', '520111743', '黄山**县', '2020-11-19 22:03:53', '2020-11-19 22:03:53', 1);
INSERT INTO `students_message` VALUES (46, '1103193044', '连**', '男', '软件***4', '3南303', 'PureKit.ahcme@gmail.com', '520111744', '淮北**区', '2020-11-19 22:03:55', '2020-11-19 22:03:55', 0);
INSERT INTO `students_message` VALUES (47, '1103193045', '王**', '男', '软件***4', '3南117', 'PureKit.ahcme@gmail.com', '520111745', '池州**县', '2020-11-19 22:03:57', '2020-11-19 22:03:57', 1);
INSERT INTO `students_message` VALUES (48, '3103193061', '郝宏鑫', '男', '软件3194', '培训楼706', 'PureKit.ahcme@outlook.com', '347095985', '安徽省颍上县', '2020-11-23 14:25:23', '2020-11-23 14:25:23', 0);
INSERT INTO `students_message` VALUES (49, '4444444', '555`', 'nan', 'sss', 'rrrrr', 'jjjjj', 'rrfrrr', 'rrrrrrr', '2019-09-16 00:00:00', '2020-11-19 22:41:50', 1);
INSERT INTO `students_message` VALUES (50, '928468418', 'PureK1t', 'male', 'Software', 'P706', 'PureKit.ahcme@gmail.com', '928468418', 'AnhuiYinshang', '2020-11-19 22:02:11', '2020-11-19 22:02:11', 0);
INSERT INTO `students_message` VALUES (51, 'dddddedddd', 'ddddddd', 'ddd', 'dddd', 'dddd', 'ddddd', 'dddddd', 'dddddddd', '2019-09-16 00:00:00', '2020-11-19 22:45:36', 1);
INSERT INTO `students_message` VALUES (52, 'yyyyyy', 'yyyyy', 'yyyy', 'yyyyyy', 'yyyyy', 'yyyyyyyy', 'yyyyyy', 'yyyyyy', '2019-09-16 00:00:00', '2020-11-19 22:54:41', 1);
INSERT INTO `students_message` VALUES (53, 'root', '郝宏鑫', '男', '软件', '706', 'uuuuuuu', 'uuuiuuiuiu', 'uuuuuuuu', '2019-09-16 00:00:00', '2020-11-23 14:25:03', 1);

SET FOREIGN_KEY_CHECKS = 1;
