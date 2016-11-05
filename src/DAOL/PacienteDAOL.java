package DAOL;

import java.util.List;

import model.Paciente;

public interface PacienteDAOL {
	 public abstract Paciente insertar(Paciente obj) throws Exception;
	 public abstract List<Paciente> buscar (Paciente obj) throws Exception;
	 public abstract void eliminar(Paciente obj) throws Exception;
	 public abstract void actualizar (Paciente obj) throws Exception;
	 public abstract Paciente obtener (Paciente obj) throws Exception;
}
