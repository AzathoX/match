/*
 Navicat Premium Data Transfer

 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Schema         : match

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 23/03/2021 18:41:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_appoint
-- ----------------------------
DROP TABLE IF EXISTS `t_appoint`;
CREATE TABLE `t_appoint`  (
  `id` int(30) NOT NULL COMMENT '预约信息主键id',
  `cateName` varchar(50) CHARACTER SET gbk COLLATE gbk_bin NOT NULL COMMENT '预约项目名称',
  `dateId` varchar(20) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL COMMENT '预约天 yyyyMMdd',
  `time` varchar(20) CHARACTER SET gbk COLLATE gbk_bin NOT NULL COMMENT '预约时间 17:00-19:00',
  `week` varchar(2) CHARACTER SET gbk COLLATE gbk_bin NOT NULL COMMENT '预约时间 星期几',
  `deptName` varchar(50) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL COMMENT '预约部门的名字',
  `mobile` varchar(20) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL COMMENT '预约人电话',
  `name` varchar(20) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL COMMENT '预约人姓名',
  `placeName` varchar(50) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL COMMENT '预约地方',
  `siteName` varchar(50) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL COMMENT '预约的地方场地',
  `status` int(2) NOT NULL COMMENT '预约状态',
  `statusStr` varchar(20) CHARACTER SET gbk COLLATE gbk_bin NOT NULL COMMENT '预约状态文件描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_cam
-- ----------------------------
DROP TABLE IF EXISTS `t_cam`;
CREATE TABLE `t_cam`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `mac` varchar(30) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `status` tinyint(4) NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `connect_name` varchar(20) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `ipaddress` varchar(16) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `live` int(11) UNSIGNED NULL DEFAULT NULL,
  `ivenue` varchar(20) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `channel` int(11) NULL DEFAULT NULL,
  `url` varchar(200) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL COMMENT '直播地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_code
-- ----------------------------
DROP TABLE IF EXISTS `t_code`;
CREATE TABLE `t_code`  (
  `match_id` int(11) NULL DEFAULT NULL,
  `code_a` int(11) NULL DEFAULT NULL,
  `code_b` int(11) NULL DEFAULT NULL,
  `type` int(4) NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  UNIQUE INDEX `codeA`(`code_a`) USING BTREE,
  UNIQUE INDEX `codeB`(`code_b`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_competition_rule
-- ----------------------------
DROP TABLE IF EXISTS `t_competition_rule`;
CREATE TABLE `t_competition_rule`  (
  `id` int(11) NOT NULL,
  `name` varchar(30) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_court
-- ----------------------------
DROP TABLE IF EXISTS `t_court`;
CREATE TABLE `t_court`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `venue_id` int(11) NOT NULL,
  `name` varchar(30) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `location` varchar(80) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `court_number` int(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_detail_score
-- ----------------------------
DROP TABLE IF EXISTS `t_detail_score`;
CREATE TABLE `t_detail_score`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `match_id` int(11) NOT NULL,
  `a_detail_score` int(11) NOT NULL,
  `b_detail_score` int(11) NULL DEFAULT NULL,
  `inning_no` int(11) NULL DEFAULT NULL,
  `score_id` int(11) NULL DEFAULT NULL,
  `server_position` int(11) NULL DEFAULT NULL COMMENT '发球者位置（从裁判视角由近到远，左为12右为34）',
  `score_type` int(4) NULL DEFAULT NULL COMMENT '篮球分数：罚球1分，进球2-3分',
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 87273 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_event
-- ----------------------------
DROP TABLE IF EXISTS `t_event`;
CREATE TABLE `t_event`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `description` varchar(1024) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `type` tinyint(4) NULL DEFAULT NULL COMMENT '1:单项赛,2:团体赛',
  `match_types` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `sub_match_count` tinyint(4) NULL DEFAULT NULL,
  `rule_type` tinyint(4) NULL DEFAULT NULL,
  `team_count` int(5) NULL DEFAULT NULL,
  `point_system_id` int(4) NULL DEFAULT NULL,
  `point_system_id2` int(11) NULL DEFAULT NULL,
  `point_system_id3` int(11) NULL DEFAULT NULL,
  `venue_id` int(11) NULL DEFAULT NULL,
  `court_count` int(11) NULL DEFAULT NULL,
  `start_date` datetime(0) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `simple_name` varchar(10) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `sub_match_names` varchar(60) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `challenge_id` int(11) NULL DEFAULT NULL,
  `be_challenged_id` int(11) NULL DEFAULT NULL,
  `species` int(4) NULL DEFAULT NULL COMMENT '1羽毛球2乒乓球3篮球4足球',
  `match_time` int(11) NULL DEFAULT NULL COMMENT '一场比赛时间（篮球、足球）',
  `half_time` int(11) NULL DEFAULT NULL,
  `section_time` int(11) NULL DEFAULT NULL,
  `program_id` int(11) NULL DEFAULT NULL,
  `group_count` int(11) NULL DEFAULT NULL COMMENT '团队循环赛多少组',
  `point_base` int(11) NULL DEFAULT NULL COMMENT '每隔几分换人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 264 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_event_court_rel
-- ----------------------------
DROP TABLE IF EXISTS `t_event_court_rel`;
CREATE TABLE `t_event_court_rel`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) NULL DEFAULT NULL,
  `court_id` int(11) NULL DEFAULT NULL,
  `court_alias` varchar(30) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_game
-- ----------------------------
DROP TABLE IF EXISTS `t_game`;
CREATE TABLE `t_game`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `team_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `score_one` int(11) NULL DEFAULT NULL,
  `score_two` int(11) NULL DEFAULT NULL,
  `score_three` int(11) NULL DEFAULT NULL,
  `score_four` int(11) NULL DEFAULT NULL,
  `score_five` int(11) NULL DEFAULT NULL,
  `score_six` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_group
-- ----------------------------
DROP TABLE IF EXISTS `t_group`;
CREATE TABLE `t_group`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uniname` char(64) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `event_id` int(11) NULL DEFAULT NULL,
  `name` varchar(10) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `stage_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `event_id`(`event_id`, `name`, `stage_id`) USING BTREE,
  UNIQUE INDEX `uniname`(`uniname`) USING BTREE,
  UNIQUE INDEX `uniname_2`(`uniname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1073 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_group_team_rel
-- ----------------------------
DROP TABLE IF EXISTS `t_group_team_rel`;
CREATE TABLE `t_group_team_rel`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NULL DEFAULT NULL,
  `team_id` int(11) NULL DEFAULT NULL,
  `group_id_for_stage2` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3795 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_ko_target
-- ----------------------------
DROP TABLE IF EXISTS `t_ko_target`;
CREATE TABLE `t_ko_target`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `high_place` tinyint(4) NULL DEFAULT NULL COMMENT '最高名次',
  `low_place` tinyint(4) NULL DEFAULT NULL COMMENT '最低名次',
  `match_count` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_live_file_list
-- ----------------------------
DROP TABLE IF EXISTS `t_live_file_list`;
CREATE TABLE `t_live_file_list`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `filePath` varchar(150) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `startTime` bigint(20) NULL DEFAULT NULL,
  `endTime` bigint(20) NULL DEFAULT NULL,
  `live` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_match
-- ----------------------------
DROP TABLE IF EXISTS `t_match`;
CREATE TABLE `t_match`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stage_id` int(11) NOT NULL,
  `group_id` int(11) NULL DEFAULT NULL,
  `ko_target_id` int(11) NULL DEFAULT NULL,
  `round` tinyint(4) NULL DEFAULT NULL,
  `name` varchar(30) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `description` varchar(1024) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `team_a_id` int(11) NULL DEFAULT NULL,
  `team_a_player_id` varchar(18) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `team_b_id` int(11) NULL DEFAULT NULL,
  `team_b_player_id` varchar(18) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `court_id` int(11) NULL DEFAULT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `score_1a` tinyint(4) NULL DEFAULT NULL,
  `score_1b` tinyint(4) NULL DEFAULT NULL,
  `score_2a` tinyint(4) NULL DEFAULT NULL,
  `score_2b` tinyint(4) NULL DEFAULT NULL,
  `score_3a` tinyint(4) NULL DEFAULT NULL,
  `score_3b` tinyint(4) NULL DEFAULT NULL,
  `score_a` tinyint(4) NULL DEFAULT NULL,
  `score_b` tinyint(4) NULL DEFAULT NULL,
  `src_match_a_id` int(11) NULL DEFAULT NULL,
  `src_match_b_id` int(11) NULL DEFAULT NULL,
  `src_match_result` tinyint(4) NULL DEFAULT NULL COMMENT '1:胜者,2:败者',
  `parent_id` int(11) NULL DEFAULT NULL,
  `sub_match_no` tinyint(4) NULL DEFAULT NULL,
  `is_play` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT 1,
  `rownum` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `stage_id`(`stage_id`, `group_id`, `ko_target_id`, `name`, `team_a_id`, `team_b_id`, `start_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17928 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_match_copy
-- ----------------------------
DROP TABLE IF EXISTS `t_match_copy`;
CREATE TABLE `t_match_copy`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stage_id` int(11) NOT NULL,
  `group_id` int(11) NULL DEFAULT NULL,
  `ko_target_id` int(11) NULL DEFAULT NULL,
  `round` tinyint(4) NULL DEFAULT NULL,
  `name` varchar(30) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `description` varchar(1024) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `team_a_id` int(11) NULL DEFAULT NULL,
  `team_a_player_id` varchar(18) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `team_b_id` int(11) NULL DEFAULT NULL,
  `team_b_player_id` varchar(18) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `court_id` int(11) NULL DEFAULT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `score_1a` tinyint(4) NULL DEFAULT NULL,
  `score_1b` tinyint(4) NULL DEFAULT NULL,
  `score_2a` tinyint(4) NULL DEFAULT NULL,
  `score_2b` tinyint(4) NULL DEFAULT NULL,
  `score_3a` tinyint(4) NULL DEFAULT NULL,
  `score_3b` tinyint(4) NULL DEFAULT NULL,
  `score_a` tinyint(4) NULL DEFAULT NULL,
  `score_b` tinyint(4) NULL DEFAULT NULL,
  `src_match_a_id` int(11) NULL DEFAULT NULL,
  `src_match_b_id` int(11) NULL DEFAULT NULL,
  `src_match_result` tinyint(4) NULL DEFAULT NULL COMMENT '1:胜者,2:败者',
  `parent_id` int(11) NULL DEFAULT NULL,
  `sub_match_no` tinyint(4) NULL DEFAULT NULL,
  `is_play` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT 1,
  `rownum` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `stage_id`(`stage_id`, `group_id`, `ko_target_id`, `name`, `team_a_id`, `team_b_id`, `start_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6839 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_match_copy1
-- ----------------------------
DROP TABLE IF EXISTS `t_match_copy1`;
CREATE TABLE `t_match_copy1`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stage_id` int(11) NOT NULL,
  `group_id` int(11) NULL DEFAULT NULL,
  `ko_target_id` int(11) NULL DEFAULT NULL,
  `round` tinyint(4) NULL DEFAULT NULL,
  `name` varchar(30) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `description` varchar(1024) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `team_a_id` int(11) NULL DEFAULT NULL,
  `team_a_player_id` varchar(18) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `team_b_id` int(11) NULL DEFAULT NULL,
  `team_b_player_id` varchar(18) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `court_id` int(11) NULL DEFAULT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `score_1a` tinyint(4) NULL DEFAULT NULL,
  `score_1b` tinyint(4) NULL DEFAULT NULL,
  `score_2a` tinyint(4) NULL DEFAULT NULL,
  `score_2b` tinyint(4) NULL DEFAULT NULL,
  `score_3a` tinyint(4) NULL DEFAULT NULL,
  `score_3b` tinyint(4) NULL DEFAULT NULL,
  `score_a` tinyint(4) NULL DEFAULT NULL,
  `score_b` tinyint(4) NULL DEFAULT NULL,
  `src_match_a_id` int(11) NULL DEFAULT NULL,
  `src_match_b_id` int(11) NULL DEFAULT NULL,
  `src_match_result` tinyint(4) NULL DEFAULT NULL COMMENT '1:胜者,2:败者',
  `parent_id` int(11) NULL DEFAULT NULL,
  `sub_match_no` tinyint(4) NULL DEFAULT NULL,
  `is_play` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT 1,
  `rownum` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `stage_id`(`stage_id`, `group_id`, `ko_target_id`, `name`, `team_a_id`, `team_b_id`, `start_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8859 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_match_copy2
-- ----------------------------
DROP TABLE IF EXISTS `t_match_copy2`;
CREATE TABLE `t_match_copy2`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stage_id` int(11) NOT NULL,
  `group_id` int(11) NULL DEFAULT NULL,
  `ko_target_id` int(11) NULL DEFAULT NULL,
  `round` tinyint(4) NULL DEFAULT NULL,
  `name` varchar(30) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `description` varchar(1024) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `team_a_id` int(11) NULL DEFAULT NULL,
  `team_a_player_id` varchar(18) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `team_b_id` int(11) NULL DEFAULT NULL,
  `team_b_player_id` varchar(18) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `court_id` int(11) NULL DEFAULT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `score_1a` tinyint(4) NULL DEFAULT NULL,
  `score_1b` tinyint(4) NULL DEFAULT NULL,
  `score_2a` tinyint(4) NULL DEFAULT NULL,
  `score_2b` tinyint(4) NULL DEFAULT NULL,
  `score_3a` tinyint(4) NULL DEFAULT NULL,
  `score_3b` tinyint(4) NULL DEFAULT NULL,
  `score_a` tinyint(4) NULL DEFAULT NULL,
  `score_b` tinyint(4) NULL DEFAULT NULL,
  `src_match_a_id` int(11) NULL DEFAULT NULL,
  `src_match_b_id` int(11) NULL DEFAULT NULL,
  `src_match_result` tinyint(4) NULL DEFAULT NULL COMMENT '1:胜者,2:败者',
  `parent_id` int(11) NULL DEFAULT NULL,
  `sub_match_no` tinyint(4) NULL DEFAULT NULL,
  `is_play` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT 1,
  `rownum` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `stage_id`(`stage_id`, `group_id`, `ko_target_id`, `name`, `team_a_id`, `team_b_id`, `start_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8859 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_match_member
-- ----------------------------
DROP TABLE IF EXISTS `t_match_member`;
CREATE TABLE `t_match_member`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `match_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL,
  `checked` int(11) UNSIGNED ZEROFILL NOT NULL,
  `round_num` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6483 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_match_member_copy
-- ----------------------------
DROP TABLE IF EXISTS `t_match_member_copy`;
CREATE TABLE `t_match_member_copy`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `match_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL,
  `checked` int(11) UNSIGNED ZEROFILL NOT NULL,
  `round_num` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3775 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `team_name_a` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `team_name_b` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `spaces` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL,
  `project_name` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stage` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `match_id` int(11) NULL DEFAULT NULL,
  `stage_id` int(11) NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `event_id` int(11) NULL DEFAULT NULL,
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_news
-- ----------------------------
DROP TABLE IF EXISTS `t_news`;
CREATE TABLE `t_news`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `news_title` varchar(255) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `news_content` mediumtext CHARACTER SET gbk COLLATE gbk_bin NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `reference_count` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_phontom
-- ----------------------------
DROP TABLE IF EXISTS `t_phontom`;
CREATE TABLE `t_phontom`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `p_uniname` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '唯一名字',
  `p_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作品名称',
  `p_tel` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `p_start_tel` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '脱敏数据手机号',
  `p_event_id` int(11) NULL DEFAULT NULL COMMENT '秩序册id',
  `p_account_id` char(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号id',
  `pet_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称为空时匿名 项目初期',
  `p_check` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否过审 1 过审, 0 未审核 ,-1 不过审',
  `is_del` tinyint(1) NULL DEFAULT 0,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '上传时间',
  `remark_1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark_2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark_3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark_4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `p_uniname`(`p_uniname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 72 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_phontom_file
-- ----------------------------
DROP TABLE IF EXISTS `t_phontom_file`;
CREATE TABLE `t_phontom_file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `p_uniname` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '唯一名字,一对一',
  `f_short_name` char(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件脱敏数据',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `p_uniname`(`p_uniname`, `f_short_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_phontom_text
-- ----------------------------
DROP TABLE IF EXISTS `t_phontom_text`;
CREATE TABLE `t_phontom_text`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `p_uniname` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '唯一名字,一对一',
  `p_text` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `remark_1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark_2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark_3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark_4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `p_uniname`(`p_uniname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 73 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_play_item
-- ----------------------------
DROP TABLE IF EXISTS `t_play_item`;
CREATE TABLE `t_play_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_id` int(11) NULL DEFAULT NULL,
  `item_type` tinyint(4) NULL DEFAULT NULL,
  `item_id` int(11) NULL DEFAULT NULL,
  `time_type` tinyint(4) NULL DEFAULT NULL,
  `start_time` smallint(6) NULL DEFAULT NULL,
  `duration` smallint(6) NULL DEFAULT NULL,
  `event_id` int(11) NULL DEFAULT NULL,
  `event_info_types` varchar(30) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `event_info_duration` smallint(6) NULL DEFAULT NULL,
  `cam_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_play_playlist
-- ----------------------------
DROP TABLE IF EXISTS `t_play_playlist`;
CREATE TABLE `t_play_playlist`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tv_id` int(11) NULL DEFAULT NULL,
  `content` int(11) NULL DEFAULT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL,
  `duration` mediumtext CHARACTER SET gbk COLLATE gbk_bin NULL,
  `seq` int(11) NULL DEFAULT NULL,
  `play_type` tinyint(4) NULL DEFAULT NULL COMMENT '1.视频 2.预约 3.赛事对阵信息 4.赛事实时比分 5.赛事结果',
  `event_id` int(11) NULL DEFAULT NULL,
  `stage_id` int(11) NULL DEFAULT NULL,
  `stage` tinyint(4) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `task_id` int(11) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `priority` tinyint(4) NULL DEFAULT NULL,
  `match_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1690 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_play_task
-- ----------------------------
DROP TABLE IF EXISTS `t_play_task`;
CREATE TABLE `t_play_task`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `has_video` tinyint(4) NULL DEFAULT NULL,
  `has_venue` tinyint(4) NULL DEFAULT NULL,
  `has_event` tinyint(4) NULL DEFAULT NULL,
  `has_cam` tinyint(4) NULL DEFAULT NULL,
  `priority` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_player
-- ----------------------------
DROP TABLE IF EXISTS `t_player`;
CREATE TABLE `t_player`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `event_id` int(11) NULL DEFAULT NULL,
  `team_id` int(11) NULL DEFAULT NULL,
  `type` tinyint(4) NULL DEFAULT NULL,
  `phone` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` tinyint(4) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(3) NULL DEFAULT NULL,
  `number` int(11) NULL DEFAULT NULL COMMENT '号码',
  `id_card` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12734 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_player_match
-- ----------------------------
DROP TABLE IF EXISTS `t_player_match`;
CREATE TABLE `t_player_match`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `player_id` int(11) NULL DEFAULT NULL,
  `match_id` int(11) NOT NULL,
  `status` int(2) NULL DEFAULT NULL COMMENT '是否上场',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_point_system
-- ----------------------------
DROP TABLE IF EXISTS `t_point_system`;
CREATE TABLE `t_point_system`  (
  `id` int(11) NOT NULL,
  `name` varchar(30) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `inning_minutes` tinyint(4) NULL DEFAULT NULL,
  `inning_count` tinyint(4) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_program
-- ----------------------------
DROP TABLE IF EXISTS `t_program`;
CREATE TABLE `t_program`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL COMMENT '名称',
  `time` varchar(100) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `place` varchar(100) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '报名开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '报名结束时间',
  `context` mediumtext CHARACTER SET gbk COLLATE gbk_bin NULL COMMENT '正文',
  `is_available` int(4) NULL DEFAULT NULL COMMENT '是否显示',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_score
-- ----------------------------
DROP TABLE IF EXISTS `t_score`;
CREATE TABLE `t_score`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `match_id` int(11) NOT NULL,
  `sub_match_no` tinyint(4) NULL DEFAULT NULL COMMENT '团体赛第几场(总分为0)',
  `inning_no` tinyint(4) NULL DEFAULT NULL COMMENT '第几局(总比分为0)',
  `score_a` int(6) NULL DEFAULT NULL,
  `score_b` int(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17723 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_score_backups
-- ----------------------------
DROP TABLE IF EXISTS `t_score_backups`;
CREATE TABLE `t_score_backups`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `match_id` int(11) NOT NULL,
  `sub_match_no` tinyint(4) NULL DEFAULT NULL COMMENT '团体赛第几场(总分为0)',
  `inning_no` tinyint(4) NULL DEFAULT NULL COMMENT '第几局(总比分为0)',
  `score_a` tinyint(4) NULL DEFAULT NULL,
  `score_b` tinyint(4) NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_stage
-- ----------------------------
DROP TABLE IF EXISTS `t_stage`;
CREATE TABLE `t_stage`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) NOT NULL,
  `prev_stage_id` int(11) NULL DEFAULT NULL,
  `no` int(11) NULL DEFAULT NULL,
  `competition_rule_id` int(11) NULL DEFAULT NULL,
  `court_count` tinyint(4) NULL DEFAULT NULL,
  `start_date` datetime(0) NULL DEFAULT NULL,
  `am_start_time` int(11) NULL DEFAULT NULL,
  `pm_start_time` int(11) NULL DEFAULT NULL,
  `group_count` tinyint(4) NULL DEFAULT NULL,
  `team_count` int(5) NULL DEFAULT NULL,
  `match_count` int(11) NULL DEFAULT NULL,
  `req_court_count` int(11) NULL DEFAULT NULL,
  `req_court_hours` varchar(255) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `special_match_type` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `event_id`(`event_id`, `prev_stage_id`, `no`, `competition_rule_id`, `court_count`, `start_date`, `am_start_time`, `pm_start_time`, `group_count`, `team_count`, `match_count`, `req_court_count`, `req_court_hours`, `special_match_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 641 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_stage_copy
-- ----------------------------
DROP TABLE IF EXISTS `t_stage_copy`;
CREATE TABLE `t_stage_copy`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) NOT NULL,
  `prev_stage_id` int(11) NULL DEFAULT NULL,
  `no` int(11) NULL DEFAULT NULL,
  `competition_rule_id` int(11) NULL DEFAULT NULL,
  `court_count` tinyint(4) NULL DEFAULT NULL,
  `start_date` datetime(0) NULL DEFAULT NULL,
  `am_start_time` int(11) NULL DEFAULT NULL,
  `pm_start_time` int(11) NULL DEFAULT NULL,
  `group_count` tinyint(4) NULL DEFAULT NULL,
  `team_count` tinyint(4) NULL DEFAULT NULL,
  `match_count` int(11) NULL DEFAULT NULL,
  `req_court_count` int(11) NULL DEFAULT NULL,
  `req_court_hours` varchar(255) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `special_match_type` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `event_id`(`event_id`, `prev_stage_id`, `no`, `competition_rule_id`, `court_count`, `start_date`, `am_start_time`, `pm_start_time`, `group_count`, `team_count`, `match_count`, `req_court_count`, `req_court_hours`, `special_match_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 390 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_stage_court
-- ----------------------------
DROP TABLE IF EXISTS `t_stage_court`;
CREATE TABLE `t_stage_court`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stage_id` int(11) NOT NULL,
  `court_id` int(11) NULL DEFAULT NULL,
  `name` varchar(30) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1823 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_stage_team_rel
-- ----------------------------
DROP TABLE IF EXISTS `t_stage_team_rel`;
CREATE TABLE `t_stage_team_rel`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stage_id` int(11) NOT NULL,
  `team_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7251 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dict`;
CREATE TABLE `t_sys_dict`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cat` varchar(60) CHARACTER SET gbk COLLATE gbk_bin NOT NULL,
  `code` tinyint(4) NOT NULL,
  `name` varchar(30) CHARACTER SET gbk COLLATE gbk_bin NOT NULL,
  `seq` int(4) NULL DEFAULT NULL,
  `description` varchar(80) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `man_count` int(4) NULL DEFAULT NULL,
  `age_limit` int(11) NULL DEFAULT NULL COMMENT '年龄限制',
  `double_age_limit` int(11) NULL DEFAULT NULL COMMENT '年龄和限制',
  `type` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `ux_cat_code`(`cat`, `code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_sys_file
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_file`;
CREATE TABLE `t_sys_file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rel_table` varchar(30) CHARACTER SET gbk COLLATE gbk_bin NOT NULL,
  `rel_id` int(11) NOT NULL,
  `type` tinyint(4) NOT NULL DEFAULT 0,
  `seq` smallint(6) UNSIGNED NOT NULL DEFAULT 0,
  `size` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET gbk COLLATE gbk_bin NOT NULL,
  `content_type` varchar(30) CHARACTER SET gbk COLLATE gbk_bin NOT NULL,
  `content` mediumblob NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `md5` char(32) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ix_md5`(`md5`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_sys_var
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_var`;
CREATE TABLE `t_sys_var`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET gbk COLLATE gbk_bin NOT NULL,
  `value` varchar(255) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `date_value` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `expire_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_t1
-- ----------------------------
DROP TABLE IF EXISTS `t_t1`;
CREATE TABLE `t_t1`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `desc` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_team
-- ----------------------------
DROP TABLE IF EXISTS `t_team`;
CREATE TABLE `t_team`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) NOT NULL,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `description` varchar(1024) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `seed_no` varchar(10) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `unit` varchar(30) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `unit_id` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3051 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_team_member
-- ----------------------------
DROP TABLE IF EXISTS `t_team_member`;
CREATE TABLE `t_team_member`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `team_id` int(11) NOT NULL,
  `type` tinyint(4) NULL DEFAULT NULL COMMENT '1:领队,2:教练,3:队长,4:队员',
  `name` varchar(30) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `sex` tinyint(4) NULL DEFAULT NULL,
  `age` tinyint(4) NULL DEFAULT NULL,
  `dept` varchar(30) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `mobile` varchar(16) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `remark` varchar(1024) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_technical_record
-- ----------------------------
DROP TABLE IF EXISTS `t_technical_record`;
CREATE TABLE `t_technical_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `match_id` int(11) NULL DEFAULT NULL,
  `player_id` int(11) NULL DEFAULT NULL,
  `type` int(4) NULL DEFAULT NULL COMMENT '0犯规 1暂停',
  `section` int(4) NULL DEFAULT NULL,
  `team` int(4) NULL DEFAULT NULL COMMENT '0为A队，1为B队',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_temp_account
-- ----------------------------
DROP TABLE IF EXISTS `t_temp_account`;
CREATE TABLE `t_temp_account`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `tel` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `short_account` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pet_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_del` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `tel`(`tel`) USING BTREE,
  UNIQUE INDEX `short_account`(`short_account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_tv
-- ----------------------------
DROP TABLE IF EXISTS `t_tv`;
CREATE TABLE `t_tv`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `mac` varchar(30) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `status` tinyint(4) NULL DEFAULT NULL,
  `ipaddress` varchar(18) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `play_type` tinyint(4) NULL DEFAULT NULL,
  `load_status` tinyint(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0,
  `cam_id` int(11) NULL DEFAULT NULL,
  `ivenue` varchar(20) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_tv_task
-- ----------------------------
DROP TABLE IF EXISTS `t_tv_task`;
CREATE TABLE `t_tv_task`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tv_id` int(11) NULL DEFAULT NULL,
  `task_id` int(11) NULL DEFAULT NULL,
  `seq` int(11) NULL DEFAULT NULL,
  `priority` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_unit
-- ----------------------------
DROP TABLE IF EXISTS `t_unit`;
CREATE TABLE `t_unit`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) NULL DEFAULT NULL,
  `name` varchar(30) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_venue
-- ----------------------------
DROP TABLE IF EXISTS `t_venue`;
CREATE TABLE `t_venue`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `address` varchar(120) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `description` varchar(1024) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_video_file
-- ----------------------------
DROP TABLE IF EXISTS `t_video_file`;
CREATE TABLE `t_video_file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `folder_id` int(11) NULL DEFAULT NULL,
  `name` varchar(80) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `file_name` varchar(255) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `file_size` int(11) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `reference_count` int(11) UNSIGNED ZEROFILL NULL DEFAULT 00000000000,
  `original_id` int(11) UNSIGNED ZEROFILL NULL DEFAULT 00000000000,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 378 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_video_folder
-- ----------------------------
DROP TABLE IF EXISTS `t_video_folder`;
CREATE TABLE `t_video_folder`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NULL DEFAULT NULL,
  `name` varchar(80) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `reference_count` int(11) UNSIGNED ZEROFILL NULL DEFAULT 00000000000,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_video_lib_file
-- ----------------------------
DROP TABLE IF EXISTS `t_video_lib_file`;
CREATE TABLE `t_video_lib_file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `file_name` varchar(255) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `file_size` int(11) NULL DEFAULT NULL,
  `src_id` int(11) NULL DEFAULT NULL,
  `src_url` varchar(255) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '0:等待中,1:下载中,2:暂停,3:已下载',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 186 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_video_play_item
-- ----------------------------
DROP TABLE IF EXISTS `t_video_play_item`;
CREATE TABLE `t_video_play_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `list_id` int(11) NULL DEFAULT NULL,
  `type` tinyint(4) NULL DEFAULT NULL COMMENT '1:视频,2:预约信息,3:赛事信息,4:直播',
  `file_id` int(11) NULL DEFAULT NULL,
  `lib_file_id` int(11) NULL DEFAULT NULL,
  `event_id` int(11) NULL DEFAULT NULL,
  `seq` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_video_play_list
-- ----------------------------
DROP TABLE IF EXISTS `t_video_play_list`;
CREATE TABLE `t_video_play_list`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_video_task
-- ----------------------------
DROP TABLE IF EXISTS `t_video_task`;
CREATE TABLE `t_video_task`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `taskName` varchar(30) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `videostatus` int(11) NULL DEFAULT NULL,
  `fileName` varchar(200) CHARACTER SET gbk COLLATE gbk_bin NULL DEFAULT NULL,
  `startTime` int(11) NULL DEFAULT NULL,
  `endTime` int(11) NULL DEFAULT NULL,
  `cid` int(11) NULL DEFAULT NULL,
  `dir_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_ID`(`cid`) USING BTREE,
  INDEX `FK_SPECIALTY_ID`(`dir_id`) USING BTREE,
  CONSTRAINT `t_video_task_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `t_cam` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_video_task_ibfk_2` FOREIGN KEY (`dir_id`) REFERENCES `t_video_folder` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = gbk COLLATE = gbk_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_count_addr
-- ----------------------------
DROP TABLE IF EXISTS `tb_count_addr`;
CREATE TABLE `tb_count_addr`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addr_name` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址名称',
  `addr_count` tinyint(4) NOT NULL DEFAULT 4 COMMENT '可用场地',
  `addr` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详细地址',
  `is_del` int(11) NULL DEFAULT 0,
  `remark_1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark_2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark_3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `addr_name`(`addr_name`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_file
-- ----------------------------
DROP TABLE IF EXISTS `tb_file`;
CREATE TABLE `tb_file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_file_name` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件名',
  `f_short_name` char(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '脱敏数据',
  `f_web_src` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网络连接',
  `f_original_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原文件名',
  `f_filetree_id` int(11) NULL DEFAULT NULL COMMENT '在虚拟文件树所在的位置',
  `f_filetree_virtual` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '在虚拟文件树所在的目录',
  `f_absolute_src` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '绝对路径 到/',
  `f_position_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '相对路径 到 /',
  `f_subfix` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '后缀',
  `f_size` int(11) NOT NULL COMMENT '大小',
  `is_temp` tinyint(1) NULL DEFAULT 1 COMMENT '是否为临时文件默认是true',
  `is_del` tinyint(1) NULL DEFAULT 0,
  `remark_1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark_2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark_3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark_4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark_5` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark_6` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark_7` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark_8` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `f_file_name`(`f_file_name`) USING BTREE,
  UNIQUE INDEX `f_short_name`(`f_short_name`) USING BTREE,
  UNIQUE INDEX `f_web_src`(`f_web_src`) USING BTREE,
  UNIQUE INDEX `f_absolute_src`(`f_absolute_src`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 143 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_file_tree
-- ----------------------------
DROP TABLE IF EXISTS `tb_file_tree`;
CREATE TABLE `tb_file_tree`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `virtual_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `maxsize` int(11) NOT NULL,
  `is_del` int(11) NULL DEFAULT 0,
  `remark_1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark_2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark_3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_vmatch_temp
-- ----------------------------
DROP TABLE IF EXISTS `tb_vmatch_temp`;
CREATE TABLE `tb_vmatch_temp`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `temp_uniname` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模板名称',
  `event_id` int(11) NOT NULL,
  `temp_config` json NOT NULL COMMENT '模板基本配置',
  `temp_count` int(11) NULL DEFAULT 0,
  `outline_rule` int(11) NULL DEFAULT 0,
  `start_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `is_del` int(11) NULL DEFAULT 0,
  `remark_1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark_2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark_3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `temp_uniname`(`temp_uniname`) USING BTREE,
  UNIQUE INDEX `event_id`(`event_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- View structure for v_today_match
-- ----------------------------
DROP VIEW IF EXISTS `v_today_match`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_today_match` AS select `m`.`start_time` AS `start_time`,(select `p`.`name` from `t_group` `p` where (`p`.`id` = `m`.`group_id`)) AS `group_name`,`m`.`name` AS `NAME`,(select `c`.`name` from `t_court` `c` where (`c`.`id` = `m`.`court_id`)) AS `court_name`,(select `t`.`name` from `t_team` `t` where (`t`.`id` = `m`.`team_a_id`)) AS `A_team`,(select `t`.`name` from `t_team` `t` where (`t`.`id` = `m`.`team_b_id`)) AS `B_team`,`m`.`stage_id` AS `stage_id`,floor(((rand() * 500000) + 400000)) AS `code6`,`m`.`id` AS `id`,(case 1 when isnull(`m`.`parent_id`) then 0 else 1 end) AS `type` from `t_match` `m` where ((`m`.`start_time` is not null) and (`m`.`start_time` > curdate()) and (`m`.`start_time` < (curdate() + interval 1 day))) order by `m`.`start_time`,(select `c`.`name` from `t_court` `c` where (`c`.`id` = `m`.`court_id`));

-- ----------------------------
-- View structure for v_today_match_v2
-- ----------------------------
DROP VIEW IF EXISTS `v_today_match_v2`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_today_match_v2` AS select `m`.`id` AS `id`,`m`.`name` AS `name`,`m`.`start_time` AS `start_time`,`m`.`parent_id` AS `parent_id`,`b`.`id` AS `pid`,`b`.`name` AS `pname` from (`t_match` `m` join `t_match` `b`) where ((`m`.`parent_id` = `b`.`id`) and (`m`.`start_time` is not null) and (`m`.`start_time` > curdate()) and (`m`.`start_time` < (curdate() + interval 1 day))) order by `m`.`start_time`;

-- ----------------------------
-- Procedure structure for C_MatchArrange
-- ----------------------------
DROP PROCEDURE IF EXISTS `C_MatchArrange`;
delimiter ;;
CREATE PROCEDURE `C_MatchArrange`()
BEGIN	
  DECLARE nTeam int;            -- 参赛队数
  DECLARE nWinGames int;        -- 胜场数   
  DECLARE nGames int;           -- 比赛场数  
  DECLARE i int default 1;      -- match序号
	DECLARE ti int;               -- 循环计数器
  
  -- 先假定6个场地
  DECLARE width int default 6;  -- 场地编号 
  DECLARE maxrow int default 1; -- 已经计算的当前最大行
  DECLARE nrow int default 1;   -- 当前行数
  DECLARE nrow_bak int;         -- 当前行数备份
  DECLARE ncol int default 1;   -- 当前列数
  DECLARE nGameNo int;          -- 比赛序号
  DECLARE matchID int;          
  DECLARE eventID int;  
  DECLARE KO_type int;          -- 比赛类型
  DECLARE tBeginTime datetime;  -- 比赛开始时间
  DECLARE am_time datetime;
  DECLARE pm_time datetime;

	-- 遍历数据结束标志
  DECLARE done INT DEFAULT FALSE;
	
	-- 游标
  DECLARE cur CURSOR FOR select (@i:=@i+1)as no, m.id, m.ko_target_id
													from t_match m, (select @i:=0) as b
                         where m.parent_id is null and m.stage_id=vstage_id
                           -- and m.ko_target_id not in (3,4,5)                            
                          order by name;
	-- 将结束标志绑定到游标
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;        
         
  -- 参数队数, event_id, 开始时间                 
  select s.team_count,s.event_id, 
         DATE_ADD(start_date,INTERVAL am_start_time/100 HOUR),     
         DATE_ADD(start_date,INTERVAL pm_start_time/100 HOUR)         
    into nTeam, eventID, am_time, pm_time                  
    from t_stage s where s.id=vstage_id;    
  
  select e.sub_match_count into nGames          -- 比赛场数
    from t_event e where e.id=eventID;

  set nWinGames = nGames div 2+1;
   
  set done = FALSE;
  OPEN cur;  

	-- 开始循环
  read_loop: LOOP
    -- 提取游标里的数据，这里只有一个，多个的话也一样；
    FETCH cur INTO nGameNo, matchID, KO_type;      
   
    -- 声明结束的时候
    IF done THEN
      LEAVE read_loop;
    END IF;

    -- 这里做你想做的循环的事件   
    
    if (nTeam = 4) then           -- 4队进入第二阶段
      
      set ti = nGameNo % 2; 
			if (ti = 1) then		
				#ininial
				set nrow = maxrow;
				set nrow_bak = nrow;			
			else
				set nrow = nrow_bak;			
			end if; 
     
      call i_arrange4(ti, nrow, matchID, nWinGames, am_time, pm_time); -- 4 队可以不用ko_type   

		ELSEIF (nTeam = 8) then       -- 8队进入第二阶段

      set ti = nGameNo % 4; 
			if (ti = 0) then
        set ti = 4;
      end if;

			if (ti = 1) then		
				#ininial
				set nrow = maxrow;
				set nrow_bak = nrow;			
			else
				set nrow = nrow_bak;			
			end if; 
      -- select 'b', ti, nrow;
      call i_arrange8(ti, nrow, matchID, nWinGames, am_time, pm_time);  
      -- select 'a', ti, nrow;                       
		end if;



    -- 记录最大行标
		if (nrow>maxrow) THEN
      set maxrow = nrow;
		end if ;     

    -- 循环结束的地方
  END LOOP;
  -- 关闭游标
  CLOSE cur; 
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for I_arrange8
-- ----------------------------
DROP PROCEDURE IF EXISTS `I_arrange8`;
delimiter ;;
CREATE PROCEDURE `I_arrange8`(IN `ti` int,INOUT `row` int, IN `matchID` int,IN `winnum` int,In am_time datetime,In pm_time datetime)
BEGIN
  DECLARE w int;
  DECLARE n int;
  DECLARE i int DEFAULT 0;
  DECLARE t int DEFAULT 0;
	DECLARE col int; -- 列
  DECLARE orignCol int;
  DECLARE tmpMax int; -- d1+d2
  DECLARE tBeginTime datetime;

  DECLARE a int;
  DECLARE b int;
  DECLARE c int;  -- max(a,b)
  DECLARE d1 int; -- a+b
	DECLARE d2 int; -- n-max(a,b)
	DECLARE d3 int; -- d1+d2

  set n = winnum;                -- 胜场数
  set w = 2*n-1;                 -- 比赛数 
   
  
  select count(score_a), ifnull(score_a,0), ifnull(score_b,0) into c, a, b from t_score
   where match_id = matchID and sub_match_no=0 and inning_no=0;
  set c = a;
  if (b > a) then 
    set c = b;
  end if;
 
  set d1 = a+b;  
  set d2 = n-c;
  set d3 = d1+d2;
  if (ti = 1) THEN
    set orignCol = 1;
  ELSEIF(ti = 2) then  
    set orignCol = 2 ;
  ELSEIF(ti = 3) then  
    set orignCol = 3 ;  
  ELSEIF(ti = 4) then  
    set orignCol = 4 ;  
  end if;
  set col = orignCol;
  set tBeginTime=am_time;
  

  --  编排的重点
	
  if (d2 = 0) then -- 比赛已经结束, 则关闭显示   
    update t_match m set m.is_play=0
     where m.parent_id=matchID and m.sub_match_no>d3 and (is_play=1 or is_play is null); 

    select count(m.rownum) into tmpMax from t_match m
     where m.parent_id=matchID and (is_play = 1 OR is_play is null) GROUP BY parent_id;
    set row = row+tmpMax;
  ELSE
    
    if (d1 = 0) then-- 完全没开始
      set i = 1;
      
      -- 上半区
      if (ti = 1 || ti = 2) then
        if(n =3 ) then         
          while (i <= w) DO
        
            update t_match m set m.court_id=col,m.rownum=row,is_play=null,
                                 m.start_time=DATE_ADD(tBeginTime, interval (row-1)*30 MINUTE)
             where m.parent_id=matchID and m.sub_match_no=i; 
     
            set i = i+1;        
            set col = col+2;
            if (col > 6) THEN
              set col = orignCol;
              set row = row+1;                
            end if;   
				    if (i = 5) THEN
              set col = orignCol;
              set row = row+1;                
            end if;       
          end while;
          
        elseif(n = 4) then
          while (i <= w) DO
        
            update t_match m set m.court_id=col,m.rownum=row,is_play=null,
                                 m.start_time=DATE_ADD(tBeginTime, interval (row-1)*30 MINUTE)
             where m.parent_id=matchID and m.sub_match_no=i; 
     
            set i = i+1;        
            set col = col+2;
            if (col > 6) THEN
              set col = orignCol;
              set row = row+1;                
            end if;   
				    if (i = 6 || i = 7) THEN
              set col = orignCol;
              set row = row+1;                
            end if;       
          end while;
        end if;
      -- 下半区
      else
        set row = row+1;
        if(n = 3 ) then         
          while (i <= w) DO
        
            update t_match m set m.court_id=col,m.rownum=row,is_play=null,
                                 m.start_time=DATE_ADD(tBeginTime, interval (row-1)*30 MINUTE)
             where m.parent_id=matchID and m.sub_match_no=i; 
     
            set i = i+1;        
            set col = col+2;
            if (col > 6) THEN
              set col = orignCol;
              set row = row+1;                
            end if;   				    
          end while;
          
        elseif(n = 4) then
          set row = row+1; -- 再往下一行
          while (i <= w) DO
        
            update t_match m set m.court_id=col,m.rownum=row,is_play=null,
                                 m.start_time=DATE_ADD(tBeginTime, interval (row-1)*30 MINUTE)
             where m.parent_id=matchID and m.sub_match_no=i; 
     
            set i = i+1;        
            set col = col+2;
            if (col > 6) THEN
              set col = orignCol;
              set row = row+1;                
            end if; 
          end while;
        end if;
        set row = row+1;  
      end if;
          
    ELSEIF (d1 = 3 && d2 = 1 && n= 4 && (ti=1 || ti=2)) then -- 7战上半区（考虑3:0)
	    set i = 5, row = row+2;      
      while (i <= w) DO
        update t_match m set m.court_id=orignCol,m.rownum=row
         where m.parent_id=matchID and m.sub_match_no=i; 
        set i = i+1;        
        set row = row+1;
      end while;  
    ELSEIF (d1 = 4 && d2 = 1 && n= 4 && (ti=3 || ti=4)) then -- 7战下半区（考虑3:1)
	    set i = 6, row = row+5;      
      while (i <= w) DO
        update t_match m set m.court_id=orignCol,m.rownum=row
         where m.parent_id=matchID and m.sub_match_no=i; 
        set i = i+1;        
        set row = row+1;
      end while;  
    ELSEIF ((d1=2 && d2=1) && n=3 && (ti=3 || ti=4)) then -- 5战（上半区不用管，下半区2:0就需要调整了)
	    set i = 4, row = row+3;      
      while (i <= w) DO
        update t_match m set m.court_id=orignCol,m.rownum=row
         where m.parent_id=matchID and m.sub_match_no=i; 
        set i = i+1;        
        set row = row+1;
      end while; 
		ELSE       
       select count(m.rownum) into tmpMax from t_match m
        where m.parent_id=matchID GROUP BY parent_id;
       set row = row+tmpMax;
		end if;
  end if;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for p_arrange
-- ----------------------------
DROP PROCEDURE IF EXISTS `p_arrange`;
delimiter ;;
CREATE PROCEDURE `p_arrange`(INOUT `row` int,IN `col` int,IN `width` int,IN `no` int, IN `matchID` int,IN `winnum` int)
  READS SQL DATA 
BEGIN
	DECLARE nGameNo int; -- d1+d2
  DECLARE w int;
  DECLARE n int;
  DECLARE i int DEFAULT 0;
  DECLARE t int DEFAULT 0;
	DECLARE orignCol int; -- 传入的列

  DECLARE a int;
  DECLARE b int;
  DECLARE c int;  -- max(a,b)
  DECLARE d1 int; -- a+b
	DECLARE d2 int; -- n-max(a,b)
	DECLARE d3 int; -- d1+d2

  DECLARE tBeginTime1 datetime default timestamp('2017-07-23 09:30:00');
	DECLARE tBeginTime2 datetime default timestamp('2017-07-23 15:30:00');
	DECLARE tBeginTime3 datetime default timestamp('2017-07-23 19:30:00');
	DECLARE tBeginTime datetime;

  set n = winnum;
  set w = 2*n-1;
	set nGameNo = no;
  set orignCol = col;  
  
  -- 时间的处理
	if (nGameNo=1 || nGameNo=2) THEN
		set tBeginTime = tBeginTime1;	
  ELSEIF (nGameNo=3 || nGameNo=4) THEN
    set tBeginTime = tBeginTime1;	
    if (row = 2) then
      set tBeginTime = DATE_ADD(tBeginTime, interval 30 MINUTE);
    elseif (row = 3) then
			set tBeginTime = DATE_ADD(tBeginTime, interval 60 MINUTE);      
		ELSE      
			set tBeginTime = DATE_ADD(tBeginTime, interval 90 MINUTE);      
    end if;
    -- select tBeginTime;
	ELSEIF (nGameNo=5 || nGameNo=6) THEN
		set tBeginTime = tBeginTime2;
  ELSEIF (nGameNo=7 || nGameNo=8) THEN
    set tBeginTime = tBeginTime2;	
    if (row = 2) then
      set tBeginTime = DATE_ADD(tBeginTime, interval 30 MINUTE);
    elseif (row = 3) then
			set tBeginTime = DATE_ADD(tBeginTime, interval 60 MINUTE);
		ELSE
      set tBeginTime = DATE_ADD(tBeginTime, interval 90 MINUTE);
    end if;
	ELSEIF (nGameNo=9) THEN
		set tBeginTime = tBeginTime3;
	end if;	
  
  select count(score_a), ifnull(score_a,0), ifnull(score_b,0) into c, a, b from t_score
   where match_id = matchID and sub_match_no=0 and inning_no=0;
  set c = a;
  if (b>a) then 
    set c = b;
  end if;
  set d1 = a+b;  
  set d2 = n-c;
  set d3 = d1+d2;
  -- select no, d1,d2,d3; -- debug;

  if (d2=0) then -- 比赛已经结束
    update t_match m set m.is_play=0
     where m.parent_id=matchID and m.sub_match_no>d3 and is_play=1; 
  ELSE
    if (d1=0) then-- 完全没开始
			set i=1;
      while (i<=w) DO
        update t_match m set m.start_time=tBeginTime,m.court_id=col
         where m.parent_id=matchID and m.sub_match_no=i; 
        set i=i+1;
        set col=col+1;
        if (col>orignCol + width -1) THEN
          set col=orignCol;
          set row=row+1;
          set tBeginTime= DATE_ADD(tBeginTime, interval 30 MINUTE);          
        end if; 
        -- select row, col;
      end while;  
    ELSEIF (d1<3) then
			set t=1;         -- 其实就是什么也不做
		ELSEIF (d1=3) then -- 一定是2:1  			
      set row=row+2;   
      set tBeginTime= DATE_ADD(tBeginTime, interval 60 MINUTE);
			update t_match m set m.start_time=tBeginTime,m.court_id=orignCol
       where m.parent_id=matchID and m.sub_match_no=5; 			
		end if;
  end if;

END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for p_match_plan_2
-- ----------------------------
DROP PROCEDURE IF EXISTS `p_match_plan_2`;
delimiter ;;
CREATE PROCEDURE `p_match_plan_2`(IN `stage_id` int,IN `team_count` int,IN `win_count` int)
  READS SQL DATA 
BEGIN	
  DECLARE nTeam int;
  DECLARE nWinGames int;
  DECLARE nStageId int; 
  DECLARE i int default 1;
	DECLARE ti int;  
  
  -- 先假定6个场地
  DECLARE width int default 6;
  DECLARE halfW int;
  DECLARE maxrow int default 0;
  DECLARE nrow int default 1;
  DECLARE nrow_bak int;
  DECLARE ncol int default 1;
  DECLARE nGameNo int;
  DECLARE matchID int;

	-- 遍历数据结束标志
  DECLARE done INT DEFAULT FALSE;
	
	-- 游标
  DECLARE cur CURSOR FOR select (@i:=@i+1)as no, m.id
													from t_match m, (select @i:=0) as b
                         where m.parent_id is null and m.stage_id=428  
                           and m.ko_target_id not in (3,4,5)                            
                          order by name;
	-- 将结束标志绑定到游标
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
      

  set nTeam = team_count;  
  set nWinGames = win_count; 
  set nStageId = stage_id;   
  set halfW = width/2; -- 一半的场地

 
  OPEN cur;

	-- 开始循环
  read_loop: LOOP
    -- 提取游标里的数据，这里只有一个，多个的话也一样；
    FETCH cur INTO nGameNo, matchID;
    -- 声明结束的时候
    IF done THEN
      LEAVE read_loop;
    END IF;

    -- 这里做你想做的循环的事件

    set ti = nGameNo % 2;
    if (nGameNo = 5 || nGameNo = 9 ) THEN  -- 第5,9场是一个轮回
      set maxrow = 0;
		end if;

    if (ti = 1) then		
			#ininial
      set nrow = maxrow + 1;
			set nrow_bak = nrow;
			set ncol = 1;
		else
      set nrow = nrow_bak;
			set ncol = 1 + halfW;
    end if; 

		-- 调用过程进行处理
		call p_arrange(nrow, ncol, halfW, nGameNo, matchID, nWinGames);
     
    -- 记录最大行标
		if (nrow>maxrow) THEN
      set maxrow = nrow;
		end if ; 		
  END LOOP;
  -- 关闭游标
  CLOSE cur; 
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for p_test
-- ----------------------------
DROP PROCEDURE IF EXISTS `p_test`;
delimiter ;;
CREATE PROCEDURE `p_test`()
BEGIN
	#Routine body goes here...
  DECLARE tBeginTime1 datetime default timestamp('2017-07-23 09:30:00');
  select tBeginTime1;
  set tBeginTime1 = DATE_ADD(tBeginTime1, interval 30 MINUTE);
select tBeginTime1;
 
END
;;
delimiter ;

-- ----------------------------
-- Event structure for e_ins_code
-- ----------------------------
DROP EVENT IF EXISTS `e_ins_code`;
delimiter ;;
CREATE EVENT `e_ins_code`
ON SCHEDULE
EVERY '10' MINUTE STARTS '2017-06-30 09:31:02'
ON COMPLETION PRESERVE
DO INSERT into t_code(MATCH_id, code_a, code_b, type)
  select id, floor(rand()*700000+200000) as code_a, floor(rand()*300000+600000) as code_b, 1 as type
    from v_today_match
   where id not in (select match_id from t_code)
  union
  select * from (
        select pid as id, floor(rand()*700000+200000) as code_a, floor(rand()*300000+600000) as code_b, 0 as type 
          from v_today_match_v2 group by pid ) d
   where id not in (select match_id from t_code)
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
