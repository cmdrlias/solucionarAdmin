create table log (
  log_code             INT NOT NULL AUTO_INCREMENT,
  log_description      VARCHAR(100) NOT NULL,
  CREATED_AT           DATETIME,
  PRIMARY KEY (log_code)
);