import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class ControladorAdministradorDB {

	
	public Administrador getAdministrador(String username){
		
		SessionFactoryObject fact = SessionFactoryObject.getInstance();
		
		Session session = fact.getSessionFactory().openSession();
		session.beginTransaction();
		
		Administrador administrador = new Administrador();
		
		administrador = (Administrador) session.get(Administrador.class, username);
		session.close();
		return administrador;
		
	}
	
	public void insertAdministrador (Administrador administrador) {
		
		SessionFactoryObject fact = SessionFactoryObject.getInstance();
		
		Session session = fact.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(administrador);
		session.getTransaction().commit();
		session.close();
		
		
	} 
	
	
	
}
