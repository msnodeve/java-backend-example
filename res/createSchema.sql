-- 도서
CREATE TABLE book (
	isbn        INT          NOT NULL, -- 도서 ID
	pno         INT          NOT NULL, -- 출판사 ID
	title       VARCHAR(50)  NULL,     -- 제목
	author      VARCHAR(30)  NULL,     -- 저자
	description VARCHAR(100) NULL,     -- 설명
	price       INT          NULL,     -- 가격
	date        DATE         NULL      -- 출판일
);

-- 도서
ALTER TABLE book
	ADD CONSTRAINT PK_book -- 도서 기본키
		PRIMARY KEY (
			isbn, -- 도서 ID
			pno   -- 출판사 ID
		);

-- 출판사
CREATE TABLE publisher (
	pno       INT          NOT NULL, -- 출판사 ID
	publisher VARCHAR(50)  NULL,     -- 출판사 이름
	address   VARCHAR(100) NULL      -- 주소
);

-- 출판사
ALTER TABLE publisher
	ADD CONSTRAINT PK_publisher -- 출판사 기본키
		PRIMARY KEY (
			pno -- 출판사 ID
		);

-- 사용자
CREATE TABLE user (
	uid     INT          NOT NULL, -- ID
	id      VARCHAR(30)  NULL,     -- 사용자 ID
	pw      VARCHAR(30)  NULL,     -- 사용자 PW
	email   VARCHAR(30)  NULL,     -- 이메일
	address VARCHAR(100) NULL,     -- 주소
	tel     VARCHAR(20)  NULL      -- 전화번호
);

-- 사용자
ALTER TABLE user
	ADD CONSTRAINT PK_user -- 사용자 기본키
		PRIMARY KEY (
			uid -- ID
		);

ALTER TABLE user
	MODIFY COLUMN uid INT NOT NULL AUTO_INCREMENT;

-- 도서
ALTER TABLE book
	ADD CONSTRAINT FK_publisher_TO_book -- 출판사 -> 도서
		FOREIGN KEY (
			pno -- 출판사 ID
		)
		REFERENCES publisher ( -- 출판사
			pno -- 출판사 ID
		);