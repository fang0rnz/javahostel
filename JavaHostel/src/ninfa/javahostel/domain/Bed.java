package ninfa.javahostel.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Bed {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Room room;
	
	private Integer number;
	private Double pricePerNight;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Double getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(Double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	@Override
	public int hashCode() {
		// Não é uma boa implementação. Só pra testar...
		return id.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// Não é uma boa implementação. Só pra testar...
		return id.equals(((Bed)obj).id); 
	}

	
}
