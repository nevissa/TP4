package Service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import DAO.*;
import domain.*;

@Path("/hello")
public class RestService implements IService {

	private IGENERIC dao = new DAOIMPL();

	@POST
	@Path("/createUser")
	// @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	// par contre il faut cocher sur x-www-form-urlencoded
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User ajouterUser(JSONObject JSonUser) throws JSONException {
		User user = new User();
		user.setFirstName(JSonUser.getString("nom"));
		user.setLastName(JSonUser.getString("prenom"));
		System.out.println(user.getFirstName());

		dao.creerObject(user);
		return user;
	}

	@POST
	@Path("/createHeater")
	// @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	// par contre il faut cocher sur x-www-form-urlencoded
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public Heater ajouterHeater(@FormParam("power") String power,@FormParam("id_home") int id_home) {
		Heater heater = new Heater();
		heater.setPower(power);
		Home home=dao.findHomeById(id_home);
		home.ajouterHeater(heater);
		dao.creerObject(heater);
		
		return heater;
	}

	@POST
	@Path("/createPerson")
	// @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	// par contre il faut cocher sur x-www-form-urlencoded
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public Person ajouterPerson(@FormParam("nom") String nom, @FormParam("prenom") String prenom,
			@FormParam("email") String email) {
		Person person = new Person();
		person.setNom(nom);
		person.setPrenom(prenom);
		person.setEmail(email);
		dao.creerObject(person);
		return person;
	}

	@POST
	@Path("/createHome")
	// @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	// par contre il faut cocher sur x-www-form-urlencoded
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public Home ajouterHome(@FormParam("taille") int taille, @FormParam("nbpieces") int nbpiece,
			@FormParam("name") String name, @FormParam("id_person") int id_person) {
		Home home = new Home();
		home.setNbpeices(nbpiece);
		home.setTaille(taille);
		home.setName(name);
		Person person =dao.findPersonById(id_person);
		person.ajouterHome(home);
		dao.creerObject(home);
		return home;
	}

	@GET
	@Path("/homes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Home> getHomes() {
		return dao.getHome();
	}

	@GET
	@Path("/persons")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getPerson() {
		return dao.getPerson();
	}

	@GET
	@Path("/heaters")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Heater> getHeater() {
		return dao.getHeater();
	}

	@GET
	@Path("/Electronics")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ElectronicDevices> getElectronic() {
		return dao.getElectronics();
	}

	@GET
	@Path("/Users")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		return dao.getUsers();

	}

	@GET
	@Path("/Persons/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person findPersonById(@PathParam(value = "id") int id) {
		return dao.findPersonById(id);

	}

	@GET
	@Path("/Users/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User findUserById(@PathParam(value = "id") int id) {
		return dao.findUserById(id);

	}

	public Home findHomeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Heater findHeaterById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Home findElectronic(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@GET
	@Path("/persons/{id}/HomesPerson")
	@Produces(MediaType.APPLICATION_JSON)

	public List<Home> getHomeParPersonne(@PathParam(value = "id") int id) {
		return dao.getHomeParPersonne(id);
	}
	@GET
	@Path("/persons/{id}")
	@Produces(MediaType.APPLICATION_JSON)

	public Person getInfoPerson(@PathParam(value = "id") int id) {
		return dao.findPersonById(id);
	}

}
