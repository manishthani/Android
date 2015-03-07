import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class ControladorUsuariRegistratDB {

	public UsuariRegistrat getUsuariRegistrat(String username){
		
		SessionFactoryObject fact = SessionFactoryObject.getInstance();
		
		Session session = fact.getSessionFactory().openSession();
		session.beginTransaction();
		
		UsuariRegistrat usu = new UsuariRegistrat();
		usu = (UsuariRegistrat) session.get(UsuariRegistrat.class, username);	
		
		return usu;
	}
}
