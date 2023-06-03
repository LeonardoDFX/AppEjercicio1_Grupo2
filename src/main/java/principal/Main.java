package principal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entidad.Usuario;
import negocio.UsuarioNegocio;

public class Main {

	public static void main(String[] args) {
		
		/*Usuario usuario = new Usuario();
	    usuario.setUsuario("Pepe");
	    usuario.setContrasenia("123");
	    
	    UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
	    boolean estado= usuarioNegocio.agregarUsuario(usuario);
	    if(estado)
	    	System.out.println("Se agrego correctamente");
	    else
	    	System.out.println("No se pudo agregar, el usuario ya existe en la BD");*/
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("resources/Beans.xml");
		Usuario usuario = (Usuario)appContext.getBean("usuarioPepe");
		
		
		UsuarioNegocio usuarioNegocio = (UsuarioNegocio)appContext.getBean("usuarioPepeNegocio");
		
		

	    boolean estado= usuarioNegocio.agregarUsuario(usuario,appContext);
	    if(estado)
	    	{System.out.println("Se agrego correctamente");}
	    else
	    	{System.out.println("No se pudo agregar, el usuario ya existe en la BD");}
	    
	    ((ConfigurableApplicationContext)(appContext)).close();
	}	
}
