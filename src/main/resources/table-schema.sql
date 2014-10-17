CREATE TABLE `article` (
	`seq` INT(11) NOT NULL AUTO_INCREMENT COMMENT '글번호',
	`title` VARCHAR(50) NOT NULL COMMENT '글제목',
	`content` VARCHAR(1000) NOT NULL COMMENT '글내용',
	`read_count` INT(11) NULL DEFAULT '0' COMMENT '조회수',
	`status` CHAR(50) NULL DEFAULT '' COMMENT '상태(D:삭제, S:비밀글)',
	`writer_id` VARCHAR(50) NOT NULL COMMENT '작성자ID',
	`created_date` DATETIME NOT NULL COMMENT '생성날짜',
	`modified_date` DATETIME NULL DEFAULT NULL COMMENT '변경날짜',
	PRIMARY KEY (`seq`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=2;
