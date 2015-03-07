import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class ControladorPartidaDB {

	public Partida getPartida(Integer idPartida){
		
		SessionFactory sessionFactory;
		 
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		  
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Partida partida = new Partida();
		
		partida = (Partida) session.get(Partida.class, idPartida);	
		
		return null;
	}
	
public void insertPartida (Partida partida) {
		
		SessionFactory sessionFactory;
		 
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		   
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(partida);
		session.getTransaction().commit();
		session.close();
		
		
	} 
	
	
}
