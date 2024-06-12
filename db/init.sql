
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_code_dbinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_code_dbinfo`;
CREATE TABLE `t_code_dbinfo`  (
  `ID` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `ALIAS` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `DB_DRIVER` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '数据库驱动',
  `DB_URL` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '数据库地址',
  `DB_USER_NAME` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '数据库账户',
  `DB_PASSWORD` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '连接密码',
  `USER_ID` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `DB_TYPE` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '数据库类型',
  `CRT_USER_ID` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CRT_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `MDF_USER_ID` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `MDF_TIME` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '数据库链接信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_code_gen_params
-- ----------------------------
DROP TABLE IF EXISTS `t_code_gen_params`;
CREATE TABLE `t_code_gen_params`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `ALIAS` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '别名',
  `author` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '作者',
  `code_package` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT 'code 包',
  `xml_package` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT 'xml 路径',
  `js_package` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT 'js 目录',
  `html_package` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT 'html 目录',
  `local_path` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '本地路径',
  `encoded` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '编码',
  `copyright` varchar(2000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '版权信息',
  `user_id` int NOT NULL,
  `CRT_USER_ID` int NULL DEFAULT NULL COMMENT '创建人',
  `CRT_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `MDF_USER_ID` int NULL DEFAULT NULL COMMENT '修改人',
  `MDF_TIME` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '生成参数' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_code_table_base_field
-- ----------------------------
DROP TABLE IF EXISTS `t_code_table_base_field`;
CREATE TABLE `t_code_table_base_field`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int NULL DEFAULT NULL COMMENT '用户',
  `alias` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '别名',
  `field_name_check` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '字段名(检验用)',
  `field_id` int NOT NULL COMMENT '字段ID',
  `CRT_USER_ID` int NULL DEFAULT NULL COMMENT '创建人',
  `CRT_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `MDF_USER_ID` int NULL DEFAULT NULL COMMENT '修改人',
  `MDF_TIME` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id` ASC, `field_name_check` ASC) USING BTREE COMMENT '用户基础字段唯一值校验'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '基础字段' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_code_table_field
-- ----------------------------
DROP TABLE IF EXISTS `t_code_table_field`;
CREATE TABLE `t_code_table_field`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `table_id` int NULL DEFAULT NULL COMMENT '关联表ID',
  `field_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '列名',
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '名称',
  `content` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '功能',
  `type` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '类型',
  `is_key` varchar(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '是否主键',
  `is_null` varchar(5) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '是否可以为空',
  `is_show_add` int NULL DEFAULT 1 COMMENT '是否显示新增',
  `is_show_edit` int NULL DEFAULT 1 COMMENT '是否显示编辑',
  `is_show_detail` int NULL DEFAULT 1 COMMENT '是否显示详情',
  `is_show_list` int NULL DEFAULT 2 COMMENT '是否列表显示',
  `is_import` int NULL DEFAULT 1 COMMENT '是否Excel导入',
  `is_export` int NULL DEFAULT 1 COMMENT '是否导出Excel',
  `is_query` int NULL DEFAULT 2 COMMENT '是否查询',
  `query_mode` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '查询类型',
  `show_type` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '显示类型',
  `order_num` int NULL DEFAULT NULL COMMENT '排序',
  `dict_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '字段名称',
  `dict_type` int NULL DEFAULT NULL COMMENT '字段类型 1 枚举 2 字段 3 列表',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5141 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '字段对应关系' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_code_table_field_dbinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_code_table_field_dbinfo`;
CREATE TABLE `t_code_table_field_dbinfo`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `field_id` int NOT NULL COMMENT '字段ID',
  `field_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '列名',
  `field_default` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '字段默认值',
  `field_content` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT ' 字段注释',
  `field_length` int NULL DEFAULT NULL COMMENT '字段长度',
  `field_type` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '字段类型',
  `field_point_length` int NULL DEFAULT NULL COMMENT '小数点位数',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `un_field_id`(`field_id` ASC) USING BTREE COMMENT '字段 Id'
) ENGINE = InnoDB AUTO_INCREMENT = 4959 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '字段的数据库信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_code_table_field_verification
-- ----------------------------
DROP TABLE IF EXISTS `t_code_table_field_verification`;
CREATE TABLE `t_code_table_field_verification`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `field_id` int NOT NULL COMMENT '字段ID',
  `view_verification` int NULL DEFAULT NULL COMMENT '前端校验',
  `server_verification` int NULL DEFAULT NULL COMMENT '后台校验',
  `not_null` int NULL DEFAULT NULL COMMENT '允许空',
  `min_num` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '最小',
  `max_num` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '最大',
  `regex` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '正则',
  `regex_type` int NULL DEFAULT NULL COMMENT '正则类型',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `un_field_id`(`field_id` ASC) USING BTREE COMMENT '字段 Id'
) ENGINE = InnoDB AUTO_INCREMENT = 5030 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '字段校验规则' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_code_table_head
-- ----------------------------
DROP TABLE IF EXISTS `t_code_table_head`;
CREATE TABLE `t_code_table_head`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL COMMENT '所属用户',
  `table_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '表名',
  `class_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `content` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '表名称',
  `is_import` int NULL DEFAULT 1 COMMENT '是否导入Excel',
  `is_export` int NULL DEFAULT 1 COMMENT '是否导出Excel',
  `is_pagination` int NULL DEFAULT 1 COMMENT '是否分页',
  `is_log` int NULL DEFAULT 1 COMMENT '是否添加日志',
  `is_protocol` int NULL DEFAULT 1 COMMENT '是否添加协议',
  `CRT_USER_ID` int NULL DEFAULT NULL COMMENT '创建人',
  `CRT_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `MDF_USER_ID` int NULL DEFAULT NULL COMMENT '修改人',
  `MDF_TIME` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 257 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '表单管理' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_code_table_service_config
-- ----------------------------
DROP TABLE IF EXISTS `t_code_table_service_config`;
CREATE TABLE `t_code_table_service_config`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `table_id` int NOT NULL COMMENT '对应表',
  `type` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '功能 ',
  `is_enable` int NULL DEFAULT NULL COMMENT '是否启用改功能',
  `is_permission` int NULL DEFAULT NULL COMMENT '是否需要授权',
  `is_transactional` int NULL DEFAULT NULL COMMENT '是否开启事务',
  `transactional_type` varchar(2) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '事务类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1770 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '表功能配置' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_code_template
-- ----------------------------
DROP TABLE IF EXISTS `t_code_template`;
CREATE TABLE `t_code_template`  (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Template_NAME` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '模板名称',
  `Template_path` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '模板地址',
  `USER_ID` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `Template_DESC` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `FILE_NAME` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '文件名称',
  `GROUP_ID` int NOT NULL COMMENT '组ID',
  `local_path` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '本地路径',
  `TEMPLATE_TYPE` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '模板类型',
  `CRT_USER_ID` int NULL DEFAULT NULL COMMENT '创建人',
  `ORIGINAL_ID` int NULL DEFAULT NULL COMMENT '原ID',
  `VERSION` int NULL DEFAULT 1 COMMENT '版本 1 正常版本 2 历史版本',
  `CRT_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `MDF_USER_ID` int NULL DEFAULT NULL COMMENT '修改人',
  `MDF_TIME` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 383 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '模板' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_code_template_file
-- ----------------------------
DROP TABLE IF EXISTS `t_code_template_file`;
CREATE TABLE `t_code_template_file`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `template_id` int NOT NULL,
  `file` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '文件内容',
  `file_type` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '文件类型',
  `CRT_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `MDF_TIME` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 388 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '模板文件内容' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_code_template_group
-- ----------------------------
DROP TABLE IF EXISTS `t_code_template_group`;
CREATE TABLE `t_code_template_group`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL COMMENT '用户ID',
  `name` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '组名称',
  `desc` varchar(400) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '描述',
  `version` int NULL DEFAULT 1 COMMENT '版本 1 正常版本 2 历史版本',
  `share_status` int NOT NULL DEFAULT 1 COMMENT '分享状态',
  `CRT_USER_ID` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CRT_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `MDF_USER_ID` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `MDF_TIME` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '模板组' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_code_template_share
-- ----------------------------
DROP TABLE IF EXISTS `t_code_template_share`;
CREATE TABLE `t_code_template_share`  (
  `ID` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `Template_NAME` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '模板名称',
  `Template_path` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '模板地址',
  `Template_effect` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '模板效果',
  `Template_DESC` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '模板分享' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_element
-- ----------------------------
DROP TABLE IF EXISTS `t_element`;
CREATE TABLE `t_element`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `module_id` int NULL DEFAULT NULL,
  `page_id` int NULL DEFAULT NULL,
  `element_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `element_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `element_rules` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `check_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `dict_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `interactive_methods` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `trigger_event` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '元素管理' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_error_code
-- ----------------------------
DROP TABLE IF EXISTS `t_error_code`;
CREATE TABLE `t_error_code`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` int NULL DEFAULT NULL COMMENT '错误码',
  `code_type` int NULL DEFAULT NULL COMMENT '错误码类型',
  `cn_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '中文描述',
  `en_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '英文描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 128 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '错误码' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_module
-- ----------------------------
DROP TABLE IF EXISTS `t_module`;
CREATE TABLE `t_module`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `use_scope` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '适用范围',
  `model_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '模型名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '业务描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '模型表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_page
-- ----------------------------
DROP TABLE IF EXISTS `t_page`;
CREATE TABLE `t_page`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `page_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `page_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `module_id` int NULL DEFAULT NULL,
  `files` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '页面管理' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_system_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_system_dept`;
CREATE TABLE `t_system_dept`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int NULL DEFAULT NULL COMMENT '排序',
  `pid` int NULL DEFAULT NULL COMMENT '父部门id',
  `pids` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '父级ids',
  `simplename` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '简称',
  `fullname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '全称',
  `tips` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '提示',
  `version` int NULL DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '部门表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_system_dict
-- ----------------------------
DROP TABLE IF EXISTS `t_system_dict`;
CREATE TABLE `t_system_dict`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '子Key',
  `pid` int NULL DEFAULT NULL COMMENT '父级字典',
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '名称',
  `tips` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '提示',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 98 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '字典表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_system_login_log
-- ----------------------------
DROP TABLE IF EXISTS `t_system_login_log`;
CREATE TABLE `t_system_login_log`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `logname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '日志名称',
  `userid` int NULL DEFAULT NULL COMMENT '管理员id',
  `createtime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `succeed` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '是否执行成功',
  `message` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '具体消息',
  `ip` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '登录ip',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1422 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '登录记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_system_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_system_menu`;
CREATE TABLE `t_system_menu`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `code` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '菜单编号',
  `pcode` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '菜单父编号',
  `pcodes` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '当前菜单的所有父菜单编号',
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `url` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT 'url地址',
  `num` int NULL DEFAULT NULL COMMENT '菜单排序号',
  `levels` int NULL DEFAULT NULL COMMENT '菜单层级',
  `ismenu` int NULL DEFAULT NULL COMMENT '是否是菜单（1：是  0：不是）',
  `tips` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  `status` int NULL DEFAULT NULL COMMENT '菜单状态 :  1:启用   0:不启用',
  `isopen` int NULL DEFAULT NULL COMMENT '是否打开:    1:打开   0:不打开',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 212 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '菜单表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_system_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_system_notice`;
CREATE TABLE `t_system_notice`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '标题',
  `type` int NULL DEFAULT NULL COMMENT '类型',
  `content` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '内容',
  `createtime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `creater` int NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '通知表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_system_operation_log
-- ----------------------------
DROP TABLE IF EXISTS `t_system_operation_log`;
CREATE TABLE `t_system_operation_log`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `logtype` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '日志类型',
  `logname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '日志名称',
  `userid` int NULL DEFAULT NULL COMMENT '用户id',
  `classname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '类名称',
  `method` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '方法名称',
  `createtime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `succeed` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '是否成功',
  `message` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2315 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '操作日志' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_system_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_system_relation`;
CREATE TABLE `t_system_relation`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menuid` int NULL DEFAULT NULL COMMENT '菜单id',
  `roleid` int NULL DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5358 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '角色和菜单关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_system_role
-- ----------------------------
DROP TABLE IF EXISTS `t_system_role`;
CREATE TABLE `t_system_role`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int NULL DEFAULT NULL COMMENT '序号',
  `pid` int NULL DEFAULT NULL COMMENT '父角色id',
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `deptid` int NULL DEFAULT NULL COMMENT '部门名称',
  `tips` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '提示',
  `version` int NULL DEFAULT NULL COMMENT '保留字段(暂时没用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_system_user
-- ----------------------------
DROP TABLE IF EXISTS `t_system_user`;
CREATE TABLE `t_system_user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `avatar` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '头像',
  `account` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT 'md5密码盐',
  `name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '名字',
  `birthday` datetime NULL DEFAULT NULL COMMENT '生日',
  `sex` int NULL DEFAULT NULL COMMENT '性别（1：男 2：女）',
  `email` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '电子邮件',
  `phone` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '电话',
  `roleid` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '角色id',
  `deptid` int NULL DEFAULT NULL COMMENT '部门id',
  `status` int NULL DEFAULT NULL COMMENT '状态(1：启用  2：冻结  3：删除）',
  `createtime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `version` int NULL DEFAULT NULL COMMENT '保留字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 82 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '管理员表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for test_table
-- ----------------------------
DROP TABLE IF EXISTS `test_table`;
CREATE TABLE `test_table`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL COMMENT '用户ID',
  `name` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '组名称',
  `desc` varchar(400) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '描述',
  `CRT_USER_ID` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CRT_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `MDF_USER_ID` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `MDF_TIME` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '测试对象' ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
