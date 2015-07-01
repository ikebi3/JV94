DROP DATABASE IF EXISTS langtest;
CREATE DATABASE langtest;
use langtest;
CREATE TABLE t(
	id		int	PRIMARY KEY AUTO_INCREMENT,
	lang	VARCHAR(10)	CHARACTER SET latin1,
	chara	VARCHAR(10)	CHARACTER SET utf16,
	utf8	VARCHAR(3)	CHARACTER SET utf8,
	ucs2	VARCHAR(3)	CHARACTER SET ucs2,
	sjis	VARCHAR(3)	CHARACTER SET sjis,
	cp932	VARCHAR(3)	CHARACTER SET cp932,
	utf16	VARCHAR(3)	CHARACTER SET utf16,
	utf16le	VARCHAR(3)	CHARACTER SET binary,
   `binary`	VARCHAR(3)	CHARACTER SET binary
) DEFAULT CHARSET=utf8;

LOAD DATA INFILE '/work/sql/lang/data/utf8.txt'     INTO TABLE t CHARACTER SET utf8   ;              INSERT INTO t SET lang='---';
LOAD DATA INFILE '/work/sql/lang/data/ujis.txt'     INTO TABLE t CHARACTER SET ujis   ;              INSERT INTO t SET lang='---';
LOAD DATA INFILE '/work/sql/lang/data/sjis.txt'     INTO TABLE t CHARACTER SET sjis   ;              INSERT INTO t SET lang='---';
LOAD DATA INFILE '/work/sql/lang/data/utf880.txt'   INTO TABLE t CHARACTER SET utf8   ;              INSERT INTO t SET lang='---';
LOAD DATA INFILE '/work/sql/lang/data/utf16BE.txt'  INTO TABLE t CHARACTER SET utf16  ;SHOW WARNINGS;INSERT INTO t SET lang='---';
LOAD DATA INFILE '/work/sql/lang/data/utf16LE.txt'  INTO TABLE t CHARACTER SET binary ;SHOW WARNINGS;INSERT INTO t SET lang='---';

SELECT * FROM t;
