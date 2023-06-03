package principal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entidad.Usuario;
import negocio.UsuarioNegocio;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("resources/Beans.xml");
		Usuario usuario = (Usuario)appContext.getBean("usuarioPepe");
		
		UsuarioNegocio usuarioNegocio = (UsuarioNegocio)appContext.getBean("usuarioPepeNegocio");
		UsuarioNegocio.setAppContext(appContext);
	    boolean estado= usuarioNegocio.agregarUsuario(usuario);
	    
	    if(estado)
	    	{System.out.println("Se agrego correctamente");}
	    else
	    	{System.out.println("No se pudo agregar, el usuario ya existe en la BD");}
	    
	    ((ConfigurableApplicationContext)(appContext)).close();
	}	
}
