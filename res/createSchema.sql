-- ����
CREATE TABLE book (
	isbn        INT          NOT NULL, -- ���� ID
	pno         INT          NOT NULL, -- ���ǻ� ID
	title       VARCHAR(50)  NULL,     -- ����
	author      VARCHAR(30)  NULL,     -- ����
	description VARCHAR(100) NULL,     -- ����
	price       INT          NULL,     -- ����
	date        DATE         NULL      -- ������
);

-- ����
ALTER TABLE book
	ADD CONSTRAINT PK_book -- ���� �⺻Ű
		PRIMARY KEY (
			isbn, -- ���� ID
			pno   -- ���ǻ� ID
		);

-- ���ǻ�
CREATE TABLE publisher (
	pno       INT          NOT NULL, -- ���ǻ� ID
	publisher VARCHAR(50)  NULL,     -- ���ǻ� �̸�
	address   VARCHAR(100) NULL      -- �ּ�
);

-- ���ǻ�
ALTER TABLE publisher
	ADD CONSTRAINT PK_publisher -- ���ǻ� �⺻Ű
		PRIMARY KEY (
			pno -- ���ǻ� ID
		);

-- �����
CREATE TABLE user (
	id      VARCHAR(30)  NOT NULL, -- ����� ID
	pw      VARCHAR(30)  NULL,     -- ����� PW
	email   VARCHAR(30)  NULL,     -- �̸���
	address VARCHAR(100) NULL,     -- �ּ�
	tel     VARCHAR(20)  NULL      -- ��ȭ��ȣ
);

-- �����
ALTER TABLE user
	ADD CONSTRAINT PK_user -- ����� �⺻Ű
		PRIMARY KEY (
			id -- ����� ID
		);

-- ����
ALTER TABLE book
	ADD CONSTRAINT FK_publisher_TO_book -- ���ǻ� -> ����
		FOREIGN KEY (
			pno -- ���ǻ� ID
		)
		REFERENCES publisher ( -- ���ǻ�
			pno -- ���ǻ� ID
		);