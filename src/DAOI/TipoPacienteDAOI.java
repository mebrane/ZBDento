package DAOI;

import java.util.List;

import javax.persistence.Query;

import DAOL.TipoPacienteDAOL;
import model.TipoPaciente;
import model.TipoPaciente;
import util.Conexion;

public class TipoPacienteDAOI implements TipoPacienteDAOL {

Conexion cn = new Conexion();
	
	@Override
	public List<TipoPaciente> listar() throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		List<TipoPaciente> lista = null;
		try {
			Query q = cn.em.createQuery("select tp from TipoPaciente tp");
			lista= q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.cerrar();
		}
		return lista;
	}

}
