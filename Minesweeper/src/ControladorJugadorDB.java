import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class ControladorJugadorDB {

	public Jugador getJugador(String username){
		
		SessionFactoryObject fact = SessionFactoryObject.getInstance();
		
		Session session = fact.getSessionFactory().openSession();
		session.beginTransaction();
		Jugador jugador = new Jugador();
		
		jugador = (Jugador) session.get(Jugador.class, username);	
		session.close();
		return jugador;
		
	}
	
public void insertJugador(Jugador jugador) {
		
SessionFactoryObject fact = SessionFactoryObject.getInstance();
	
	Session session = fact.getSessionFactory().openSession();
	session.beginTransaction();
		
		session.saveOrUpdate(jugador);
		session.getTransaction().commit();
		session.close();
		
	} 
	
	
}
