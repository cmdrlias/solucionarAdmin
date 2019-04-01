create table news(
  nws_code             INT NOT NULL AUTO_INCREMENT,
  nws_description      VARCHAR(255) NOT NULL,
  usr_code             INT NOT NULL,
  CREATED_AT           DATETIME,
  PRIMARY KEY (nws_code),
  FOREIGN KEY (usr_code) REFERENCES user(usr_code)
);