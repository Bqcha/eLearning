package eLearning;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory= buildSessionFactory();
	private static ServiceRegistry serviceRegistry;
	private static Session session;
	
	private static SessionFactory buildSessionFactory() {
		
		try {
			Configuration configuration= new Configuration();
			configuration.configure("hibernate.cfg.xml");
			//serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServieRegistry();

			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			return configuration.buildSessionFactory(serviceRegistry);
			
		}catch(Throwable ex){
			System.err.println("Failed to create SessionFactory" +ex);
			throw new ExceptionInInitializerError(ex);
			
			
			
		}
		
		
	}
	
	

}
