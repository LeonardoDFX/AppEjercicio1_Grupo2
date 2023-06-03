package negocio;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UsuarioDao;
import entidad.Usuario;

public class UsuarioNegocio {

	private UsuarioDao usuarioDao;
	
	public boolean agregarUsuario(Usuario usuario,ApplicationContext appContext)
	{
		
		UsuarioDao usuarioDao = (UsuarioDao)appContext.getBean("usuarioDaoPepe");
		
		boolean existe = usuarioDao.Exist(usuario.getUsuario());
		if(existe ==false)
		{
			usuarioDao.Add(usuario);
			
			return true;
		}
		
		return false;
	}
	public void initUsuarioBean() {
		System.out.println("Se inicia el Bean.");
	}
	
	public void destroyUsuarioBean() {
		System.out.println("Se destruye el Bean.");
	}
}
