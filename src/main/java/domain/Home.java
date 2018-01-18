package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity

public class Home {
	private int id;
	private int taille;
	private int nbpeices;
	private String name;
	public String getName() {
		return name;
	}








	public void setName(String name) {
		this.name = name;
	}

	private List<Heater>heaters= new ArrayList<Heater>();

	@Id
	@GeneratedValue
public int getId() {
		return id;
	}
  @OneToMany(targetEntity=Heater.class)
	@JoinColumn(name="home_id",referencedColumnName="id")
	public List<Heater> getHeaters() {
		return heaters;
	}
	public void setHeaters(List<Heater> heaters) {
		this.heaters = heaters;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public int getNbpeices() {
		return nbpeices;
	}
	public void setNbpeices(int nbpeices) {
		this.nbpeices = nbpeices;
	}
	
	public void ajouterHeater(Heater heater) {
	
		this.heaters.add(heater);
	}


}
