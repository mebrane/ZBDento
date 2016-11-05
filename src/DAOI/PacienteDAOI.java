package DAOI;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import DAOL.PacienteDAOL;
import model.Paciente;
import util.Conexion;

public class PacienteDAOI implements PacienteDAOL {

	Conexion cn = new Conexion();
	@Override
	public Paciente insertar(Paciente obj) throws Exception {
		
		cn.abrir();
		try {
			cn.em.getTransaction().begin();
			cn.em.persist(obj);
			cn.em.flush();
			cn.em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			cn.em.getTransaction().rollback();
		}
		return obj;
	}

	@Override
	public List<Paciente> buscar(Paciente obj) throws Exception {
		cn.abrir();
		
		String busqueda=obj.getPaci_nomb();
		busqueda='%'+busqueda.toLowerCase() +'%';
		
		String sentencia= "select p, "
				+"p.tipoPaciente.tpac_id "
				+"from Paciente p "
				+"where "
				+ "(lower(p.paci_nomb) like :busqueda "
				+"or lower(p.paci_apel) like :busqueda ) "
				+ "and p.paci_esta='A'";
		
	
		Query q= cn.em.createQuery(sentencia);
		
		q.setParameter("busqueda", busqueda);
		
		List<Object[]> lista_objetos =q.getResultList();

		
		List<Paciente> lista = new ArrayList<Paciente>();
		
		for(Object objs[]: lista_objetos){
			Paciente Paciente=(Paciente) objs[0];
			lista.add(Paciente);
		}

		return lista;
	}

	@Override
	public void eliminar(Paciente obj) throws Exception {
		cn.abrir();
		try {
			
			cn.em.getTransaction().begin();
			Paciente oPaciente=cn.em.find(Paciente.class, obj.getPaci_id());
			oPaciente.setPaci_esta('D');
			cn.em.merge(oPaciente);
			cn.em.getTransaction().commit();
			
		} catch (Exception e) {
			cn.em.getTransaction().rollback();
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		
	}

	@Override
	public void actualizar(Paciente obj) throws Exception {
		cn.abrir();
		try {
			cn.em.getTransaction().begin();
			cn.em.merge(obj);
			cn.em.getTransaction().commit();
			
		} catch (Exception e) {
			cn.em.getTransaction().rollback();
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		
	}

	@Override
	public Paciente obtener(Paciente obj) throws Exception {
		// TODO Auto-generated method stub
		Paciente e=null;
		cn.abrir();
		try {
			
			cn.em.getTransaction().begin();
			e=cn.em.find(Paciente.class, obj.getPaci_id());
			
			cn.em.getTransaction().commit();
			
		} catch (Exception ex) {
			cn.em.getTransaction().rollback();
			System.out.println(ex.getMessage());
			// TODO: handle exception
		}
		return e;
	
	}

}
