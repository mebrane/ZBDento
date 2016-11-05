  drop sequence zb_paciente_seq;
  CREATE SEQUENCE zb_paciente_seq
  MINVALUE 4
  MAXVALUE 999999999999999999999999999
  START WITH 4
  INCREMENT BY 1
  CACHE 20;
  commit;
  
    drop sequence zb_tipopaciente_seq;
  CREATE SEQUENCE zb_tipopaciente_seq
  MINVALUE 4
  MAXVALUE 999999999999999999999999999
  START WITH 4
  INCREMENT BY 1
  CACHE 20;
  commit;
  
    
   drop sequence zb_usuario_seq;
  CREATE SEQUENCE zb_usuario_seq
  MINVALUE 2
  MAXVALUE 999999999999999999999999999
  START WITH 2
  INCREMENT BY 1
  CACHE 20;
  commit;
  
