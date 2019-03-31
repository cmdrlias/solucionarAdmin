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

create table phone_type(
   pht_code			      INT NOT NULL AUTO_INCREMENT,
   pht_description		VARCHAR(40) NOT NULL,
   PRIMARY KEY(pht_code)
);

create table phone(
  pho_code			      INT NOT NULL AUTO_INCREMENT,
  pht_code			      INT NOT NULL,
  pho_number			    INT NOT NULL,
  pho_area_code		    SMALLINT NOT NULL,
  PRIMARY KEY(pho_code),
  FOREIGN KEY(pht_code) REFERENCES phone_type(pht_code)

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

create table user (
  usr_code             INT NOT NULL AUTO_INCREMENT,
  usr_name             VARCHAR(100) NOT NULL,
  usr_email            VARCHAR(100) NOT NULL,
  usr_password         VARCHAR(264) NOT NULL,
  ust_code             INT NOT NULL,
  per_code				     INT NOT NULL,
  PRIMARY KEY (usr_code),
  FOREIGN KEY (ust_code) REFERENCES user_type(ust_code),
  FOREIGN KEY (per_code) REFERENCES person(per_code)
);

INSERT INTO user_type (ust_description) VALUES ("Administrador");
INSERT INTO address (add_street, add_number, add_neighborhood, add_city, add_state, add_country, add_zip_code)
            VALUES ("Boa Vista", "108", "Camelos", "Santa Luzia", "Minas Gerais", "Brasil", "33010-470");
INSERT INTO person (per_name, per_cpf) VALUES ("Larissa Silva", "131.529.596-21");
INSERT INTO person_address (per_code, add_code) VALUES (1, 1);
INSERT INTO user (usr_name, usr_email, usr_password, ust_code, per_code)  VALUES ("cmdrlias", "cmdrlias@gmail.com", "$2a$10$2XmoryKEpL8jrfy2anY4Wun.TseVwq8Dnxf/.xb5sUen5gFv0nJrO", 1, 1);