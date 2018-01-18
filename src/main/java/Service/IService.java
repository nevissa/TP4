package Service;

import java.util.List;

import domain.*;

public interface IService {
	
 public List<Home>getHomes();
 public List<Person>getPerson();
 public List<Heater>getHeater();
 public List<ElectronicDevices>getElectronic();
 public List<User>getUsers();
 public User findUserById(int id);
 public Person findPersonById(int id);
 public Home findHomeById(int id);
 public Heater findHeaterById(int id);
 public Home findElectronic(int id);
 public List<Home>getHomeParPersonne(int id);



}
