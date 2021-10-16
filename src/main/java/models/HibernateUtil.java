package models;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import entities.ToDo;

public class HibernateUtil {
private static SessionFactory sessionFactory;

// for easier access when calling sessionfactory
// @return sessionfactory
public static SessionFactory getSessionFactory() {
	if (sessionFactory == null) {
		try {
			Configuration configuration = new Configuration();
			
			//Hibernate settings
			Properties settings = new Properties();
			settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			settings.put(Environment.URL, "jdbc:mysql://localhost:3306/todo_database");
			settings.put(Environment.USER, "root");
			settings.put(Environment.PASS, "root");
			settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
			
			settings.put(Environment.SHOW_SQL, "true");
			settings.put(Environment.HBM2DDL_AUTO, "create");
			
			configuration.setProperties(settings);
			configuration.addAnnotatedClass(ToDo.class);
			
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			System.out.println("Hibernate Configurations Successfully Created.");
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			return sessionFactory;
		
		} catch (Exception e) {
			System.out.println("cannot open session factory");
			e.printStackTrace();
		}
	}
	return sessionFactory;
}
	
	
}

