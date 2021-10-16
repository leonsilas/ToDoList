package models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.ToDo;

public class ToDoModel {
	
	// querying the tasks in ToDo and listing them all
	@SuppressWarnings("unchecked")
	public List<ToDo> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<ToDo> todos = new ArrayList<>();
		Query query = session.createQuery("FROM ToDo");
		todos = query.list();
		return todos;		
	}
	// creates a new task and then saves it in the database
	public void create(ToDo task) {
		Session session = HibernateUtil.getSessionFactory().openSession();		
		Transaction tx = session.beginTransaction();
		session.save(task);
		tx.commit();
		session.close();
		
	}
	
	// updates a task if it needs a change, not implemented now, but might experiment with it later
	public void update(String task, int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		ToDo todotask = (ToDo) session.load(ToDo.class, task);
		todotask.setId(id);
		todotask.setTask(task);
		tx.commit();
		session.close();
	}
	
	// deletes a task from the database
	public void delete(ToDo task) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(task);
		tx.commit();
		session.close();
	}
	
	
}
