package DAOI;

import java.util.List;

import javax.persistence.Query;

import DAOL.UsuarioDAOL;
import model.Usuario;
import util.Conexion;

public class UsuarioDAOI  implements UsuarioDAOL{

	Conexion cn = new Conexion();
	@Override
	public Usuario validar(Usuario usu) throws Exception {
		cn.abrir();
		Usuario u = null;
		try {
			Query q = cn.em.createQuery("select u from Usuario u where u.user_user= :u and u.user_pass= :p");
			q.setParameter("u", usu.getUser_user());
			q.setParameter("p", usu.getUser_pass());
			List<Usuario> lista = q.getResultList();
			for (Usuario o : lista) {
				u = lista.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.cerrar();
		}
		return u;
	}

}
