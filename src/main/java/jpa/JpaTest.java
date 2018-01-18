package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.ElectronicDevices;
import domain.Heater;
import domain.Home;
import domain.Person;
import domain.SmartDevices;
import domain.User;


public class JpaTest {
	private EntityManager manager;
	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory =   
 			 Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createPerson();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		//test.listEmployees();
			
   	 manager.close();
   	 factory.close();
		System.out.println(".. done");
	}
	
	
	
	 public void ajouterUser(User user) {
      manager.persist(user);	    	
	    }


private void createPerson() {

	Person p = new Person();
    manager.persist(p);
	p.setEmail("nafi@gmail.com");
	p.setNom("nafi");
	Person p1 = new Person();
	p1.setEmail("med@gmail.com");
	p1.setNom("med");
	p1.setEmail("khbz");
	p.setPrenom("khabaz");
	Home home= new Home();
	manager.persist(home);
	manager.persist(p1);
	Home home1= new Home();
	manager.persist(home1);
    p.ajouterFriend(p1);
    Heater heater= new Heater();
    manager.persist(heater);
    home1.ajouterHeater(heater);
    p.ajouterHome(home1);
   
    SmartDevices smart= new SmartDevices();
  manager.persist(smart);
    ElectronicDevices device= 	new ElectronicDevices();
    heater.setPower("600W");
    manager.persist(device);
    p.addElectonic(device);
   manager.refresh(p);

	
}


}
