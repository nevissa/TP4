package DAO;

import java.util.List;

import domain.*;

public interface IGENERIC {
	
	
   public void creerObject(Object o) ;
   public List<Home>getHome();
   public List<Person>getPerson();
   public List<Heater>getHeater();
   public List<ElectronicDevices>getElectronics();
   public List<User>getUsers();
   public List<Home>getHomeParPersonne(int id);
   public List<SmartDevices>getSmart();
   public User findUserById(int id);
   public Person findPersonById(int id);
   public Home findHomeById(int id);
   public Heater findHeaterById(int id);


}
