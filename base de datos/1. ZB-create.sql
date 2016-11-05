drop table zb_usuario;
drop table zb_movimiento;
drop table zb_transaccion;
drop table zb_empleado;
drop table zb_paciente;
drop table zb_radiografia;
drop table zb_tipopaciente;
drop table zb_doctor;
commit;

CREATE TABLE ZB_DOCTOR
  (
    doct_id   NUMBER NOT NULL ,
    doct_dni  CHAR (8) NOT NULL ,
    doct_nomb VARCHAR2 (50) NOT NULL ,
    doct_apel VARCHAR2 (50) NOT NULL ,
    doct_dire VARCHAR2 (50) ,
    doct_emai VARCHAR2 (30) ,
    doct_telf VARCHAR2 (20) ,
    doct_freg DATE ,
    doct_Esta CHAR (1) NOT NULL
  )
;
ALTER TABLE ZB_DOCTOR ADD CONSTRAINT ZB_DOCTOR_PK PRIMARY KEY ( doct_id ) ;
CREATE TABLE ZB_EMPLEADO
  (
    empl_id   NUMBER NOT NULL ,
    empl_nomb VARCHAR2 (50) NOT NULL ,
    empl_apel VARCHAR2 (50) NOT NULL ,
    empl_fnac DATE ,
    empl_emai VARCHAR2 (50) ,
    empl_telf VARCHAR2 (20) ,
    empl_freg DATE ,
    empl_esta CHAR (1) NOT NULL
  )
;
ALTER TABLE ZB_EMPLEADO ADD CONSTRAINT ZB_EMPLEADO_PK PRIMARY KEY ( empl_id ) ;
CREATE TABLE ZB_PACIENTE
  (
    paci_id   NUMBER NOT NULL ,
    tpac_id   NUMBER NOT NULL ,
    paci_dni  CHAR (8) NOT NULL ,
    paci_nomb VARCHAR2 (50) NOT NULL ,
    paci_apel VARCHAR2 (50) NOT NULL ,
    paci_dire VARCHAR2 (50) ,
    paci_fnac DATE ,
    paci_telf VARCHAR2 (20) ,
    paci_emai VARCHAR2 (30) ,
    paci_freg DATE NOT NULL ,
    paci_Esta CHAR (1) NOT NULL
  )
;
ALTER TABLE ZB_PACIENTE ADD CONSTRAINT ZB_PACIENTE_PK PRIMARY KEY ( paci_id ) ;
CREATE TABLE ZB_RADIOGRAFIA
  (
    radi_id   NUMBER NOT NULL ,
    radi_nomb VARCHAR2 (30) NOT NULL ,
    radi_prec NUMBER (10,2) NOT NULL ,
    radi_esta CHAR (1) NOT NULL
  )
;
ALTER TABLE ZB_RADIOGRAFIA ADD CONSTRAINT ZB_RADIOGRAFIA_PK PRIMARY KEY ( radi_id ) ;
CREATE TABLE ZB_TIPOPACIENTE
  (
    tpac_id   NUMBER NOT NULL ,
    tpac_nomb VARCHAR2 (30) NOT NULL
  )
;
ALTER TABLE ZB_TIPOPACIENTE ADD CONSTRAINT ZB_TIPOPACIENTE_PK PRIMARY KEY ( tpac_id ) ;
CREATE TABLE ZB_TRANSACCION
  (
    tran_id   NUMBER NOT NULL ,
    empl_id   NUMBER NOT NULL ,
    doct_id   NUMBER NOT NULL ,
    radi_id   NUMBER NOT NULL ,
    paci_id   NUMBER NOT NULL ,
    tran_cant NUMBER NOT NULL ,
    tran_subt NUMBER (10,2) NOT NULL ,
    tran_igv  NUMBER (10,2) NOT NULL ,
    tran_tota NUMBER (10,2)
  )
;
ALTER TABLE ZB_TRANSACCION ADD CONSTRAINT ZB_TRANSACCION_PK PRIMARY KEY ( tran_id ) ;
CREATE TABLE ZB_USUARIO
  (
    user_id   NUMBER NOT NULL ,
    user_user VARCHAR2 (30) NOT NULL ,
    user_pass VARCHAR2 (30) NOT NULL ,
    user_freg DATE ,
    user_esta CHAR (1) NOT NULL ,
    empl_id   NUMBER NOT NULL
  )
;
ALTER TABLE ZB_USUARIO ADD CONSTRAINT ZB_USUARIO_PK PRIMARY KEY ( user_id ) ;
CREATE TABLE zb_MOVIMIENTO
  (
    movi_id   NUMBER NOT NULL ,
    movi_ingr NUMBER (10,2) NOT NULL ,
    movi_egre NUMBER (10,2) NOT NULL ,
    movi_tota NUMBER (10,2) NOT NULL ,
    tran_id   NUMBER NOT NULL
  )
;
ALTER TABLE zb_MOVIMIENTO ADD CONSTRAINT zb_MOVIMIENTO_PK PRIMARY KEY ( movi_id ) ;
ALTER TABLE ZB_PACIENTE ADD CONSTRAINT ZB_PACIENTE_ZB_TIPOPACIENTE_FK FOREIGN KEY ( tpac_id ) REFERENCES ZB_TIPOPACIENTE ( tpac_id ) NOT DEFERRABLE ;
ALTER TABLE ZB_TRANSACCION ADD CONSTRAINT ZB_TRANSACCION_ZB_DOCTOR_FK FOREIGN KEY ( doct_id ) REFERENCES ZB_DOCTOR ( doct_id ) NOT DEFERRABLE ;
ALTER TABLE ZB_TRANSACCION ADD CONSTRAINT ZB_TRANSACCION_ZB_EMPLEADO_FK FOREIGN KEY ( empl_id ) REFERENCES ZB_EMPLEADO ( empl_id ) NOT DEFERRABLE ;
ALTER TABLE ZB_TRANSACCION ADD CONSTRAINT ZB_TRANSACCION_ZB_PACIENTE_FK FOREIGN KEY ( paci_id ) REFERENCES ZB_PACIENTE ( paci_id ) NOT DEFERRABLE ;
--  ERROR: FK name length exceeds maximum allowed length(30)
ALTER TABLE ZB_TRANSACCION ADD CONSTRAINT ZB_TRANS_ZB_RADI_FK FOREIGN KEY ( radi_id ) REFERENCES ZB_RADIOGRAFIA ( radi_id ) NOT DEFERRABLE ;
ALTER TABLE ZB_USUARIO ADD CONSTRAINT ZB_USUARIO_ZB_EMPLEADO_FK FOREIGN KEY ( empl_id ) REFERENCES ZB_EMPLEADO ( empl_id ) NOT DEFERRABLE ;
--  ERROR: FK name length exceeds maximum allowed length(30)
ALTER TABLE zb_MOVIMIENTO ADD CONSTRAINT zb_MOVI_ZB_TRANS_FK FOREIGN KEY ( tran_id ) REFERENCES ZB_TRANSACCION ( tran_id ) NOT DEFERRABLE ;
commit;