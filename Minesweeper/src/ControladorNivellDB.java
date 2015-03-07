

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ControladorNivellDB {

	
	public Nivell getNivell(String nom){
		
		SessionFactoryObject fact = SessionFactoryObject.getInstance();
		
		Session session = fact.getSessionFactory().openSession();
		session.beginTransaction();
		
		Nivell nivell = new Nivell();
		nivell = (Nivell) session.get(Nivell.class, nom);	
		
		session.close();
		return nivell;
		
	}
	
	
public void insertNivell(Nivell nivell) {
		
	SessionFactoryObject fact = SessionFactoryObject.getInstance();
	
	Session session = fact.getSessionFactory().openSession();
	session.beginTransaction();
		
	session.saveOrUpdate(nivell);
	session.getTransaction().commit();
	session.close();
		
	} 

public ArrayList<Nivell> getAll(){
	
	SessionFactoryObject fact = SessionFactoryObject.getInstance();
	
	Session session = fact.getSessionFactory().openSession();
	session.beginTransaction();
	
	Criteria crit = session.createCriteria(Nivell.class);
	crit.setMaxResults(3);
	List niveles = crit.list();
	session.close();
	
	return (ArrayList<Nivell>) niveles;
	
}
	
}
