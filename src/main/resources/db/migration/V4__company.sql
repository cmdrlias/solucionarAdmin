create table company (
    cmp_code             INT NOT NULL AUTO_INCREMENT,
	cmp_name             VARCHAR(100) NOT NULL,
	cmp_social_name      VARCHAR(100) NOT NULL,
	cmp_insc_estadual    VARCHAR(16),
	cmp_insc_municipal   VARCHAR(16),
	PRIMARY KEY(cmp_code)
);

create table company_representative (
    cpr_code             INT NOT NULL AUTO_INCREMENT,
    cpr_name             VARCHAR(100) NOT NULL,
    cpr_email            VARCHAR(100) NOT NULL,
    PRIMARY KEY (cpr_code)
);

create table set_company_representative (
    cpr_code             INT NOT NULL,
    cmp_code             INT NOT NULL,
    PRIMARY KEY (cpr_code, cmp_code)
);

create table company_phone (
    cmp_code             INT NOT NULL,
    pho_code             INT NOT NULL,
    PRIMARY KEY (cmp_code, pho_code)
);

create table company_address (
    cmp_code             INT NOT NULL,
    add_code             INT NOT NULL,
    PRIMARY KEY (cmp_code, add_code)
);

INSERT INTO company_representative (cpr_name, cpr_email) VALUES ("Oziel Fernando", "oziel@solucionarmanutencoes.com.br");
INSERT INTO company (cmp_name, cmp_social_name, cmp_insc_estadual, cmp_insc_municipal)
            VALUES  ("Solucionar Manutenções", "Solucionar Manutenções", "214.010.439/4717", "0.000.000-0");
INSERT INTO set_company_representative VALUES (1, 1);
INSERT INTO phone (pho_number, pho_area_code) VALUES (44444444, 31);
INSERT INTO company_phone (cmp_code, pho_code) VALUES (1, 3);
INSERT INTO company_address (cmp_code, add_code) VALUES (1, 1);