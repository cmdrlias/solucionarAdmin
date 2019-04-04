alter table person_phone add constraint fk_r_01 foreign key (per_code)
  references person (per_code) on delete restrict on update restrict;

alter table person_phone add constraint fk_r_02 foreign key (pho_code)
  references phone (pho_code) on delete restrict on update restrict;

alter table person_address add constraint fk_r_03 foreign key (per_code)
  references person (per_code) on delete restrict on update restrict;

alter table person_address add constraint fk_r_04 foreign key (add_code)
  references address (add_code) on delete restrict on update restrict;

alter table person_user add constraint fk_r_05 foreign key (usr_code)
  references user (usr_code) on delete restrict on update restrict;

alter table person_user add constraint fk_r_06 foreign key (per_code)
  references person (per_code) on delete restrict on update restrict;

alter table set_user_type add constraint fk_r_07 foreign key (usr_code)
  references user (usr_code) on delete restrict on update restrict;

alter table set_user_type add constraint fk_r_08 foreign key (ust_code)
  references user_type (ust_code) on delete restrict on update restrict;

alter table person_address add constraint fk_r_09 foreign key (per_code)
  references person (per_code) on delete restrict on update restrict;