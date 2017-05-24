package ninfa.javahostel.control;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Init;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

import ninfa.javahostel.application.AuthenticationService;
import ninfa.javahostel.application.BedRegistrationService;
import ninfa.javahostel.application.RegistrationService;
import ninfa.javahostel.application.RoomRegistrationService;
import ninfa.javahostel.application.UnderAgeGuestException;
import ninfa.javahostel.domain.Bed;
import ninfa.javahostel.domain.Guest;
import ninfa.javahostel.domain.Room;

@Named
@SessionScoped
public class RegistrationController implements Serializable {
	@EJB
	private RegistrationService registrationService;
	private Guest guest = new Guest();
	private int age;
	
	
	@EJB
	private RoomRegistrationService roomRegistrationService;
	
	Room room = new Room();

	public Room getRoom() {
		return room;
	}
	
	public String roomRegister() {
		try {
			roomRegistrationService.register(room);
		}
		catch (ConverterException e) {
			FacesMessage msg = e.getFacesMessage();
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.addMessage("roomRegForm", msg);
		}
		room = new Room();
		return "/roomcreate/sucess.xhtml";


	}
	
	
	@EJB
	private BedRegistrationService bedRegistrationService;
	
	Bed bed = new Bed();
	
	private Set<Bed> beds = new HashSet<Bed>();
	
	boolean i=false;
	public void getAllBeds() {
		
		if (!i){
		beds.addAll(bedRegistrationService.findAll());
		} //usar boolean
		i = true;
		
	}
	
	
	public Set<Bed> getBeds(){
		this.getAllBeds();
		return beds;
	}
	
	
	public Bed getBed() {
		return bed;
	}
	

	
	public String bedRegister() {
		try {
			bedRegistrationService.register(bed);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		bed = new Bed();
		return "/bedcreation/sucess.xhtml";


	}
	
	
	public Guest getGuest() {
		return guest;
	}

	public int getAge() {
		return age;
	}

	public String register() {
		try {
			registrationService.register(guest);
		}
		catch (UnderAgeGuestException e) {
			age = e.getAge();
			return "/registration/underage.xhtml";
		}
		finally{
			guest = new Guest();
			
		}
		return "/registration/sucess.xhtml";
	}
	
	@EJB
	private AuthenticationService authenticationService;
	
	
	public boolean isUserAuthenticated(){
		return (guest.getId() != null);
	}
	
	public void login(){
		try {
			guest = authenticationService.login(guest.getEmail(), guest.getPassword());
		}
		catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Incorreto", "Não foi possível identificá-lo a partir dos dados informados. Por favor, tente novamente.");
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.addMessage("formLogin", msg);
		}
	}
	
	public void logout(){
		guest = new Guest();
	}
	
}