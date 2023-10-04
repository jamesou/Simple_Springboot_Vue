-- ----------------------------
-- Postgresql
-- ----------------------------

DROP TABLE IF EXISTS m_blog;
CREATE TABLE m_blog  (
  id SERIAL PRIMARY KEY,
  user_id int8  NOT NULL,
  title varchar(255) NOT NULL,
  description varchar(255)  NOT NULL,
  content text,
  created timestamp NOT NULL ,
  status int4 DEFAULT NULL
);


-- ----------------------------
-- Table structure for m_user
-- ----------------------------
DROP TABLE IF EXISTS m_user;
CREATE TABLE m_user (
  id SERIAL PRIMARY KEY,
  username varchar(64),
  avatar varchar(500),
  email varchar(64),
  password varchar(64),
  status int4 NOT NULL,
  created timestamp DEFAULT NULL,
  last_login timestamp DEFAULT NULL
);
CREATE INDEX UK_USERNAME ON m_user USING btree (username);
INSERT INTO m_user VALUES (1, 'jamesou', 'https://i.stack.imgur.com/gPKrg.jpg', 'jamesou168@gmail.com', '629e5ccf5b78bef79d8d39d5d6f26ada', 1, '2020-04-20 10:44:01', NULL);

