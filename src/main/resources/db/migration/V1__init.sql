create table user_type(
  ust_code			      INT NOT NULL AUTO_INCREMENT,
  ust_description		  VARCHAR(40) NOT NULL,
  PRIMARY KEY (ust_code)
);

create table address(
    add_code			      INT NOT NULL AUTO_INCREMENT,
    add_street          VARCHAR(100) not null,
    add_number          VARCHAR(10),
    add_complement      VARCHAR(50),
    add_neighborhood    VARCHAR(50) not null,
    add_city            VARCHAR(50) not null,
    add_state           VARCHAR(50) not null,
    add_country         VARCHAR(50) not null,
    add_zip_code        VARCHAR(20) not null,
    PRIMARY KEY (add_code)
);

create table phone(
  pho_code			      INT NOT NULL AUTO_INCREMENT,
  pho_number			  INT,
  pho_area_code		      SMALLINT,
  PRIMARY KEY(pho_code)
);

create table person(
   per_code 			    INT NOT NULL AUTO_INCREMENT,
   per_name			      VARCHAR(100) NOT NULL,
   per_cpf				    VARCHAR(14) NOT NULL,
   PRIMARY KEY (per_code)

);
create table person_phone(
   per_code			      INT NOT NULL,
   pho_code			      INT NOT NULL,
   FOREIGN KEY (per_code) REFERENCES person(per_code),
   FOREIGN KEY (pho_code) REFERENCES phone(pho_code)
);

create table person_address(
    per_code          INT NOT NULL,
    add_code          INT NOT NULL,
    FOREIGN KEY (per_code) REFERENCES person(per_code),
    FOREIGN KEY (add_code) REFERENCES address(add_code)
);

# TODO
# fix user type and person by creating a connecting table (not using foreign keys)
# use person_address and person_phone as examples

create table user (
  usr_code             INT NOT NULL AUTO_INCREMENT,
  usr_name             VARCHAR(100) NOT NULL,
  usr_email            VARCHAR(100) NOT NULL,
  usr_password         VARCHAR(264) NOT NULL,
  ust_code             INT NOT NULL,
  per_code				     INT NOT NULL,
  PRIMARY KEY (usr_code),
  FOREIGN KEY (per_code) REFERENCES person(per_code)
);

create table set_user_type (
    usr_code          INT NOT NULL,
    ust_code          INT NOT NULL,
    FOREIGN KEY (usr_code) REFERENCES user(usr_code),
    FOREIGN KEY (ust_code) REFERENCES user_type(ust_code)
);

create table person_user(
    usr_code         INT NOT NULL,
    per_code         INT NOT NULL,
    FOREIGN KEY (usr_code) REFERENCES user(usr_code),
    FOREIGN KEY (per_code) REFERENCES person(per_code)
);

INSERT INTO user_type (ust_description) VALUES ("Administrador");
INSERT INTO address (add_street, add_number, add_neighborhood, add_city, add_state, add_country, add_zip_code)
            VALUES ("Boa Vista", "108", "Camelos", "Santa Luzia", "Minas Gerais", "Brasil", "33010-470");
INSERT INTO person (per_name, per_cpf) VALUES ("Larissa Silva", "131.529.596-21");
INSERT INTO person (per_name, per_cpf) VALUES ("Vanessa Aparecida Abreu e Silva Melo", "111.111.111-11");
INSERT INTO person_address (per_code, add_code) VALUES (1, 1);
INSERT INTO person_address (per_code, add_code) VALUES (2, 1);
INSERT INTO user (usr_name, usr_email, usr_password, ust_code, per_code)
          VALUES ("cmdrlias", "cmdrlias@gmail.com", "$2a$10$2XmoryKEpL8jrfy2anY4Wun.TseVwq8Dnxf/.xb5sUen5gFv0nJrO", 1, 1);
INSERT INTO user (usr_name, usr_email, usr_password, ust_code, per_code)
          VALUES ("vanessa", "vanessasilvamelo@hotmail.com", "$2a$10$ih/YGdjBNtlEkGcivO4y8ewg72mhk1SH6zWu9K4cERSSBAgAamOLi", 1, 2);
INSERT INTO phone (pho_number, pho_area_code) VALUES (992498172, 31);
INSERT INTO phone (pho_number, pho_area_code) VALUES (33333333, 31);
INSERT INTO person_phone (per_code, pho_code) VALUES (1, 1);
INSERT INTO person_phone (per_code, pho_code) VALUES (2, 2);
INSERT INTO person_user (usr_code, per_code) VALUES (1, 1);
INSERT INTO person_user (usr_code, per_code) VALUES (2, 2);
INSERT INTO set_user_type (usr_code, ust_code) VALUES (1, 1);
INSERT INTO set_user_type (usr_code, ust_code) VALUES (2, 1);