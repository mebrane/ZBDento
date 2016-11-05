INSERT INTO ZB_TIPOPACIENTE
  (TPAC_ID, TPAC_NOMB
  ) VALUES
  (1, 'Tipo Paciente 1'
  );
  
  INSERT INTO ZB_TIPOPACIENTE
  (TPAC_ID, TPAC_NOMB
  ) VALUES
  (2, 'Tipo Paciente 2'
  );
  
    
  INSERT INTO ZB_TIPOPACIENTE
  (TPAC_ID, TPAC_NOMB
  ) VALUES
  (3, 'Tipo Paciente 3'
  );
  
  commit;
  
  
  INSERT
INTO ZB_PACIENTE
  (
    PACI_ID,
    PACI_FNAC,
    PACI_FREG,
    PACI_TELF,
    PACI_NOMB,
    PACI_EMAI,
    PACI_APEL,
    PACI_DNI,
    PACI_ESTA,
    TPAC_ID,
    PACI_DIRE
  )
  VALUES
  (
    1,
    null, --fnac
    sysdate, --freg
    '1234567',--telf
    'Nombre 1',
    'paciente1@hotmail.com',
    'Apellido 1',
    '11111111', --dni
    'A', --esta
    1, --tpac
    'Direccion 1'
  );
  
  
    INSERT
INTO ZB_PACIENTE
  (
    PACI_ID,
    PACI_FNAC,
    PACI_FREG,
    PACI_TELF,
    PACI_NOMB,
    PACI_EMAI,
    PACI_APEL,
    PACI_DNI,
    PACI_ESTA,
    TPAC_ID,
    PACI_DIRE
  )
  VALUES
  (
    2,
    null, --fnac
    sysdate, --freg
    '7654321',--telf
    'Nombre 2',
    'paciente2@hotmail.com',
    'Apellido 2',
    '22222222', --dni
    'A', --esta
    2, --tpac
    'Direccion 2'
  );
  
    INSERT
INTO ZB_PACIENTE
  (
    PACI_ID,
    PACI_FNAC,
    PACI_FREG,
    PACI_TELF,
    PACI_NOMB,
    PACI_EMAI,
    PACI_APEL,
    PACI_DNI,
    PACI_ESTA,
    TPAC_ID,
    PACI_DIRE
  )
  VALUES
  (
    3,
    null, --fnac
    sysdate, --freg
    '7827292',--telf
    'Nombre 3',
    'paciente3@hotmail.com',
    'Apellido 3',
    '33333333', --dni
    'A', --esta
    3, --tpac
    'Direccion 3'
  );
  
  commit;
  
  INSERT
INTO ZB_EMPLEADO
  (
    EMPL_ID,
    EMPL_APEL,
    EMPL_FNAC,
    EMPL_NOMB,
    EMPL_FREG,
    EMPL_EMAI,
    EMPL_ESTA,
    EMPL_TELF
  )
  VALUES
  (
    1,
    'Perez',
    null,
    'Juan',
    sysdate,
    'juanperez@hotmail.com',
    'A',
    '7328932'
  );
  commit;
  
  INSERT
INTO ZB_USUARIO
  (
    USER_ID,
    USER_USER,
    EMPL_ID,
    USER_ESTA,
    USER_FREG,
    USER_PASS
  )
  VALUES
  (
    1,
    'admin',
    1,
    'A',
    sysdate,
    'admin'
  );
commit;