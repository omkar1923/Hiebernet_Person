package hibernet_person.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernet_student.dto.Person;

public class PersonDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("omkar").createEntityManager();
		
	}
	public void savePerson(Person person) {
		EntityManager manager=getEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(person);
		transaction.commit();
	}
	public Person getPerson(String email) {
		EntityManager manager=getEntityManager();
		Query query=manager.createQuery("select p from Person p where p.email=?1");
	query.setParameter(1, email);
	try {
		Person person= (Person)query.getSingleResult();
		
		return person;
	}
	catch (Exception e) {
		return null;
		// TODO: handle exception
	}
	}
	public Person findById(int id) {
		EntityManager manager=getEntityManager();
		
		try {
	Person person=	manager.find(Person.class,id);
	return person;
	}
		catch(Exception e){
			return null;
		
		}
	}
	public Person findByPhone(long phone) {
		EntityManager manager=getEntityManager();
		Query query=manager.createQuery("select p from Person p where p.phone=?1");
				query.setParameter(1, phone);
				try {
		Person person=(Person) query.getSingleResult();
		return person;
	}
				catch (Exception e) {
					return null;
				}
	}
	public Person findByName(String name) {
		EntityManager manager=getEntityManager();
		Query query=manager.createQuery("select p from Person p where p.name=?1");
		query.setParameter(1,name);
		try {
		Person person=(Person) query.getSingleResult();
		return person;
		}
		catch(Exception e){
			return null;
		}
		
	}
	public void deleteById(int id) {
		EntityManager manager=getEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		Person person=manager.find(Person.class,id);
		transaction.begin();
		if(person!=null) {
			manager.remove(person);
			System.out.println("data deleted successfully");
		}
		else {
			System.err.println("invalid id provided");
		}
		transaction.commit();
		
		
	}
	public void deleteByPhone(long phone) {
		EntityManager manager=getEntityManager();
		EntityTransaction transaction =manager.getTransaction();
		
		Person person= findByPhone(phone);
		if(person!=null) {
		
			transaction.begin();
			Query query=manager.createQuery("delete from Person e where e.phone=?1");
			query.setParameter(1,phone);
			int deletedCount = query.executeUpdate();
            System.out.println(deletedCount + " record(s) deleted");
			
			transaction.commit();
		}
		else {
			System.err.println("invalid phone provided");
		}
		
	}
	public void deleteByEmail(String email) {
		EntityManager manager=getEntityManager();
		EntityTransaction transaction =manager.getTransaction();
			transaction.begin();
			Query query=manager.createQuery("delete from Person e where e.email=?1");
			query.setParameter(1,email);
			int deletedCount = query.executeUpdate();
            System.out.println(deletedCount + " record(s) deleted");
			
			transaction.commit();
		}
	public List<Person> displayAll() {
		EntityManager manager=getEntityManager();
		Query query=manager.createQuery("select p from Person p");
		List<Person > list=query.getResultList();
		return list;
		
	}
	public Person updateName(int id, String name) {
	    EntityManager manager = getEntityManager();
	    EntityTransaction transaction = manager.getTransaction();
	    transaction.begin();
	    try {
	        Person person = manager.find(Person.class, id);
	        person.setName(name);
	        transaction.commit();
	        return person;
	    }
	    catch(Exception e) {
	    	return null;
	    }
		
	}
	public Person updateEmail(int id, String email) {
		// TODO Auto-generated method stub
		 EntityManager manager = getEntityManager();
		    EntityTransaction transaction = manager.getTransaction();
		    transaction.begin();
		    try {
		        Person person = manager.find(Person.class, id);
		        person.setEmail(email);
		        transaction.commit();
		        return person;
		    }
		    catch(Exception e) {
		    	return null;
		    }
		
	}
	public Person updatePhone(int id, Long phone) {
		 EntityManager manager = getEntityManager();
		    EntityTransaction transaction = manager.getTransaction();
		    transaction.begin();
		    try {
		        Person person = manager.find(Person.class, id);
		        person.setPhone(phone);
		        transaction.commit();
		        return person;
		    }
		    catch(Exception e) {
		    	return null;
		    }
		
	}
	public Person updatePassword(int id, String password) {
		 EntityManager manager = getEntityManager();
		    EntityTransaction transaction = manager.getTransaction();
		    transaction.begin();
		    try {
		        Person person = manager.find(Person.class, id);
		        person.setPassword(password);
		        transaction.commit();
		        return person;
		    }
		    catch(Exception e) {
		    	return null;
		    }
		
	}
	public Person updateAddress(int id, String email) {
		// TODO Auto-generated method stub
		 EntityManager manager = getEntityManager();
		    EntityTransaction transaction = manager.getTransaction();
		    transaction.begin();
		    try {
		        Person person = manager.find(Person.class, id);
		        person.setAddress(email);
		        transaction.commit();
		        return person;
		    }
		    catch(Exception e) {
		    	return null;
		    }
		
	
	
	}
}
				

				
