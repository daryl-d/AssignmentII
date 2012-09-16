package database;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Cinema {
	private int cinema_id;
	private String name;
	private String address;
	private int capacity;
	private List<MovieOfferring> movOff = new ArrayList<MovieOfferring>();
	
	@Id
	@GeneratedValue
	public int getId() {
		return cinema_id;
	}
	
	public void setId(int cinema_id) {
		this.cinema_id = cinema_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return the movOff
	 */
	@OneToMany(targetEntity=MovieOfferring.class, mappedBy="cinema", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public List<MovieOfferring> getMovOff() {
		return movOff;
	}

	/**
	 * @param movOff the movOff to set
	 */
	public void setMovOff(List<MovieOfferring> movOff) {
		this.movOff = movOff;
	}
}
