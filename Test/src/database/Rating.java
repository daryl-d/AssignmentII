package database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*************
 * 
 * 
 * @author daryl
 *Have to add in the relationships later
 */

@Entity
public class Rating {
	private int id;
	private Movie movie;
	private StandardUser person;
	private int rating;
	/**
	 * @return the id
	 */
	@Id	
	@GeneratedValue
	@Column(name="id")
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the movie
	 */
	@ManyToOne
	@JoinColumn(name="movie_id")
	public Movie getMovie() {
		return movie;
	}
	/**
	 * @param movie the movie to set
	 */

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	@ManyToOne
	@JoinColumn(name="StandardUser_id")
	public StandardUser getPerson() {
		return person;
	}
	
	public void setPerson(StandardUser person) {
		this.person = person;
	}
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}


}
