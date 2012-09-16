package database;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class MovieOfferring {
	private int id;
	private Movie movie;
	private Cinema cinema;
	private int remaining;
	private Date date;
	private double price;
	private List<Purchase> purchase = new ArrayList<Purchase>();
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(targetEntity=Movie.class)
	@JoinColumn(name="movie_id")
	public Movie getMovie() {
		return movie;
	}
	
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@ManyToOne(targetEntity=Cinema.class)
	@JoinColumn(name="cinema_id")
	public Cinema getCinema() {
		return cinema;
	}
	
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	
	public int getRemaining() {
		return remaining;
	}
	
	public void setRemaining(int remaining) {
		this.remaining = remaining;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the purchase
	 */
	@OneToMany(targetEntity=Purchase.class, mappedBy="mov", cascade=CascadeType.ALL)	
	public List<Purchase> getPurchase() {
		return purchase;
	}

	/**
	 * @param purchase the purchase to set
	 */
	public void setPurchase(List<Purchase> purchase) {
		this.purchase = purchase;
	}
}
