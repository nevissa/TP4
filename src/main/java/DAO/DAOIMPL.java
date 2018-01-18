package DAO;

import java.io.PrintWriter;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.ElectronicDevices;
import domain.Heater;
import domain.Home;
import domain.Person;
import domain.User;

public class DAOIMPL implements IGENERIC {
	
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");

	EntityManager manager = factory.createEntityManager();

	EntityTransaction tx = manager.getTransaction();
   	
    
	  public void creerObject(Object o) {
		tx.begin();
		  manager.persist(o);
	         tx.commit();		
	        }

   
	  public List<User>getUsers()

       {
     	List<User>users= manager.createQuery("Select u From User u",User.class).getResultList();
         return users;
        
        }

    public List<Home> getHome() {
        List<Home> listHOME = manager.createQuery("Select a From Home a", Home.class).getResultList();	
        return listHOME;
    }


	public List<Person> getPerson() {
        List<Person> listPerson = manager.createQuery("Select a From Person a", Person.class).getResultList();	
        return listPerson;
	}


	public List<Heater> getHeater() {
		List<Heater> listHeater = manager.createQuery("Select h From Heater h", Heater.class).getResultList();	
        return listHeater ;
	}


	public List<ElectronicDevices> getElectronic() {
		List<ElectronicDevices> listDevices = manager.createQuery("Select h From ElectronicDevices h", ElectronicDevices.class).getResultList();	
        return listDevices ;
	}



	public Home findHomeById(int id) {
		 Home home=  manager.find(Home.class, id);
          return home;	}

	public User findUserById(int id) {
		   User user=  manager.find(User.class, id);
		    return user;
	}


	public Person findPersonById(int id) {
		 Person person=  manager.find(Person.class, id);
		    return person;
	}


	public Heater findHeaterById(int id) {
		// TODO Auto-generated method stub
		return null;
	}




	public List<Home> getHomeParPersonne(int  OWNER_ID) {
		List<Home> listHomeParPers =manager.createQuery("select home from Home home where OWNER_ID=OWNER_ID",Home.class).getResultList();
			return listHomeParPers;

		
	}

	
     }


	


	
	
	
	
	
	
	
	
	

	


