package database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/********************
 * 
 * 
 * @author daryl
 * Have to add in the relationships later !
 *
 */
@Entity
public class Comment {
	private int id;
	private String comment;
	private Movie movie;
	private StandardUser person;
	
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
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	
	@ManyToOne(targetEntity=Movie.class)
	@JoinColumn(name="movie_id")	
	public Movie getMovie() {
		return movie;
	}
	
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@ManyToOne(targetEntity=StandardUser.class)
	@JoinColumn(name="StandardUser_id")	
	public StandardUser getPerson() {
		return person;
	}
	

	public void setPerson(StandardUser person) {
		this.person = person;
	}

}
