import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SessionFactoryObject {

	private static SessionFactoryObject instance = null;
	private SessionFactory sessionFactory = null;			 
	private Configuration configuration = null;	
	private ServiceRegistry serviceRegistry = null;
			
			
	private SessionFactoryObject() {
		configuration = new Configuration();	
		configuration.configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static SessionFactoryObject getInstance(){
		if (instance == null) instance = new SessionFactoryObject(); 		
		return instance;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

			
			
	
}
