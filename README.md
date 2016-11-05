drop table zb_usuario; drop table zb_movimiento; drop table zb_transaccion; drop table zb_empleado; drop table zb_paciente; drop table zb_radiografia; drop table zb_tipopaciente; drop table zb_doctor; commit; create table zb_doctor ( doct_id NUMBER not null , doct_dni CHAR (8) not null , doct_nomb VARCHAR2 (50) not null , doct_apel VARCHAR2 (50) not null , doct_dire VARCHAR2 (50) , doct_emai VARCHAR2 (30) , doct_telf VARCHAR2 (20) , doct_freg DATE , doct_esta CHAR (1) not null ) ; alter table zb_doctor add constraint zb_doctor_pk primary key ( doct_id ) ; create table zb_empleado ( empl_id NUMBER not null , empl_nomb VARCHAR2 (50) not null , empl_apel VARCHAR2 (50) not null , empl_fnac DATE , empl_emai VARCHAR2 (50) , empl_telf VARCHAR2 (20) , empl_freg DATE , empl_esta CHAR (1) not null ) ; alter table zb_empleado add constraint zb_empleado_pk primary key ( empl_id ) ; create table zb_paciente ( paci_id NUMBER not null , tpac_id NUMBER not null , paci_dni CHAR (8) not null , paci_nomb VARCHAR2 (50) not null , paci_apel VARCHAR2 (50) not null , paci_dire VARCHAR2 (50) , paci_fnac DATE , paci_telf VARCHAR2 (20) , paci_emai VARCHAR2 (30) , paci_freg DATE not null , paci_esta CHAR (1) not null ) ; alter table zb_paciente add constraint zb_paciente_pk primary key ( paci_id ) ; create table zb_radiografia ( radi_id NUMBER not null , radi_nomb VARCHAR2 (30) not null , radi_prec NUMBER (10,2) not null , radi_esta CHAR (1) not null ) ; alter table zb_radiografia add constraint zb_radiografia_pk primary key ( radi_id ) ; create table zb_tipopaciente ( tpac_id NUMBER not null , tpac_nomb VARCHAR2 (30) not null ) ; alter table zb_tipopaciente add constraint zb_tipopaciente_pk primary key ( tpac_id ) ; create table zb_transaccion ( tran_id NUMBER not null , empl_id NUMBER not null , doct_id NUMBER not null , radi_id NUMBER not null , paci_id NUMBER not null , tran_cant NUMBER not null , tran_subt NUMBER (10,2) not null , tran_igv NUMBER (10,2) not null , tran_tota NUMBER (10,2) ) ; alter table zb_transaccion add constraint zb_transaccion_pk primary key ( tran_id ) ; create table zb_usuario ( user_id NUMBER not null , user_user VARCHAR2 (30) not null , user_pass VARCHAR2 (30) not null , user_freg DATE , user_esta CHAR (1) not null , empl_id NUMBER not null ) ; alter table zb_usuario add constraint zb_usuario_pk primary key ( user_id ) ; create table zb_movimiento ( movi_id NUMBER not null , movi_ingr NUMBER (10,2) not null , movi_egre NUMBER (10,2) not null , movi_tota NUMBER (10,2) not null , tran_id NUMBER not null ) ; alter table zb_movimiento add constraint zb_movimiento_pk primary key ( movi_id ) ; alter table zb_paciente add constraint zb_paciente_zb_tipopaciente_fk foreign key ( tpac_id ) references zb_tipopaciente ( tpac_id ) not deferrable ; alter table zb_transaccion add constraint zb_transaccion_zb_doctor_fk foreign key ( doct_id ) references zb_doctor ( doct_id ) not deferrable ; alter table zb_transaccion add constraint zb_transaccion_zb_empleado_fk foreign key ( empl_id ) references zb_empleado ( empl_id ) not deferrable ; alter table zb_transaccion add constraint zb_transaccion_zb_paciente_fk foreign key ( paci_id ) references zb_paciente ( paci_id ) not deferrable ; alter table zb_transaccion add constraint zb_trans_zb_radi_fk foreign key ( radi_id ) references zb_radiografia ( radi_id ) not deferrable ; alter table zb_usuario add constraint zb_usuario_zb_empleado_fk foreign key ( empl_id ) references zb_empleado ( empl_id ) not deferrable ; alter table zb_movimiento add constraint zb_movi_zb_trans_fk foreign key ( tran_id ) references zb_transaccion ( tran_id ) not deferrable ; commit; insert into zb_tipopaciente (tpac_id, tpac_nomb ) values (1, 'Tipo Paciente 1' ); insert into zb_tipopaciente (tpac_id, tpac_nomb ) values (2, 'Tipo Paciente 2' ); insert into zb_tipopaciente (tpac_id, tpac_nomb ) values (3, 'Tipo Paciente 3' ); commit; insert into zb_paciente ( paci_id, paci_fnac, paci_freg, paci_telf, paci_nomb, paci_emai, paci_apel, paci_dni, paci_esta, tpac_id, paci_dire ) values ( 1, null, sysdate, '1234567', 'Nombre 1', 'paciente1@hotmail.com', 'Apellido 1', '11111111', 'A', 1, 'Direccion 1' ); insert into zb_paciente ( paci_id, paci_fnac, paci_freg, paci_telf, paci_nomb, paci_emai, paci_apel, paci_dni, paci_esta, tpac_id, paci_dire ) values ( 2, null, sysdate, '7654321', 'Nombre 2', 'paciente2@hotmail.com', 'Apellido 2', '22222222', 'A', 2, 'Direccion 2' ); insert into zb_paciente ( paci_id, paci_fnac, paci_freg, paci_telf, paci_nomb, paci_emai, paci_apel, paci_dni, paci_esta, tpac_id, paci_dire ) values ( 3, null, sysdate, '7827292', 'Nombre 3', 'paciente3@hotmail.com', 'Apellido 3', '33333333', 'A', 3, 'Direccion 3' ); commit; insert into zb_empleado ( empl_id, empl_apel, empl_fnac, empl_nomb, empl_freg, empl_emai, empl_esta, empl_telf ) values ( 1, 'Perez', null, 'Juan', sysdate, 'juanperez@hotmail.com', 'A', '7328932' ); commit; insert into zb_usuario ( user_id, user_user, empl_id, user_esta, user_freg, user_pass ) values ( 1, 'admin', 1, 'A', sysdate, 'admin' ); commit; drop sequence zb_paciente_seq; create sequence zb_paciente_seq minvalue 4 maxvalue 999999999999999999999999999 start with 4 increment by 1 cache 20; commit; drop sequence zb_tipopaciente_seq; create sequence zb_tipopaciente_seq minvalue 4 maxvalue 999999999999999999999999999 start with 4 increment by 1 cache 20; commit; drop sequence zb_usuario_seq; create sequence zb_usuario_seq minvalue 2 maxvalue 999999999999999999999999999 start with 2 increment by 1 cache 20; commit;
