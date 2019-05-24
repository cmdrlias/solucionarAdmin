# company_address

alter table company_representative add constraint fk_r_10 foreign key (cmp_code)
  references company (cmp_code) on delete restrict on update restrict;

alter table company_representative add constraint fk_r_11 foreign key (rep_code)
  references representative (rep_code) on delete restrict on update restrict;

alter table company_phone add constraint fk_r_12 foreign key (cmp_code)
  references company (cmp_code) on delete restrict on update restrict;

alter table company_phone add constraint fk_r_13 foreign key (pho_code)
  references phone (pho_code) on delete restrict on update restrict;

alter table company_address add constraint fk_r_14 foreign key (cmp_code)
  references company (cmp_code) on delete restrict on update restrict;

alter table company_address add constraint fk_r_15 foreign key (add_code)
  references address (add_code) on delete restrict on update restrict;