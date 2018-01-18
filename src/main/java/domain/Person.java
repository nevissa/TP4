package domain;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
 public class Person {
	private int id;
    private String nom;
	private String prenom;
	private String email;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
   private List<Home>homes=new ArrayList<Home>();
	
	@ManyToMany(targetEntity=Person.class)
	public List<Person> getFreinds() {
		return freinds;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFreinds(List<Person> freinds) {
		this.freinds = freinds;
	}
	private List<Person>freinds= new ArrayList<Person>();

	public void ajouterFriend(Person person)
	{
		
		this.freinds.add(person);
	}	
    public void ajouterHome(Home home) {
		
		
		this.homes.add(home);
		
	}
@OneToMany(targetEntity=Home.class)
@JoinColumn(name="OWNER_ID",referencedColumnName="id")
	public List<Home> getHomes() {
		return homes;
	}

    public List<ElectronicDevices>devices=new ArrayList<ElectronicDevices>();
    
    @OneToMany(targetEntity=ElectronicDevices.class)
    @JoinColumn(name="OWNER_ID",referencedColumnName="id")
   public List<ElectronicDevices> getDevices() {
		return devices;
	}
	public void setDevices(List<ElectronicDevices> devices) {
		this.devices = devices;
	}
public void setHomes(List<Home> homes) {
		this.homes = homes;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	

	
	public void addElectonic(ElectronicDevices elect) {
		
		this.devices.add(elect);
		
	}
}
