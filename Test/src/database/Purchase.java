package database;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Purchase {
	private int id;
	private StandardUser user;
	private MovieOfferring mov;
	private double cost;
	
	@Id
	@Generated(value="id")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="StandardUser_id")
	public StandardUser getUser() {
		return user;
	}
	
	public void setUser(StandardUser user) {
		this.user = user;
	}
	
	@ManyToOne
	@JoinColumn(name="Offerring_id")
	public MovieOfferring getMov() {
		return mov;
	}
	
	public void setMov(MovieOfferring mov) {
		this.mov = mov;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
}