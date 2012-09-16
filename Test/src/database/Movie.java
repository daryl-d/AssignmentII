package database;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

// break this up into two entities ?
@Entity
public class Movie {
	private int movie_id;
	private boolean showing;
	private String title;
	private String synposis;
	private String poster;
	private String actors; // calculated based on user ratings
	private Date release;
	private int released;
	private List<MovieOfferring> movOffer = new ArrayList<MovieOfferring>();
	private List<Comment> comment = new ArrayList<Comment>();
	private List<Rating> rating = new ArrayList<Rating>();
	/**
	 * @return the movie_id
	 */
	@Id
	@GeneratedValue
	public int getId() {
		return movie_id;
	}
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
//,fetch=FetchType.EAGER
	@OneToMany(targetEntity=Comment.class, mappedBy="movie", cascade=CascadeType.ALL)	
	public List<Comment> getComment() {
		return comment;
	}
	
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}	

	/**
	 * @param movie_id the movie_id to set
	 */
	public void setId(int movie_id) {
		this.movie_id = movie_id;
	}
	/**
	 * @return the showing
	 */
	public boolean isShowing() {
		return showing;
	}
	/**
	 * @param showing the showing to set
	 */
	public void setShowing(boolean showing) {
		this.showing = showing;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the synposis
	 */
	public String getSynposis() {
		return synposis;
	}
	/**
	 * @param synposis the synposis to set
	 */
	public void setSynposis(String synposis) {
		this.synposis = synposis;
	}
	/**
	 * @return the poster
	 */
	public String getPoster() {
		return poster;
	}
	/**
	 * @param poster the poster to set
	 */
	public void setPoster(String poster) {
		this.poster = poster;
	}
	/**
	 * @return the actors
	 */
	public String getActors() {
		return actors;
	}
	/**
	 * @param actors the actors to set
	 */
	public void setActors(String actors) {
		this.actors = actors;
	}
	/**
	 * @return the rating
	 */

	/**
	 * @return the release
	 */
	public Date getRelease() {
		return release;
	}
	/**
	 * @param release the release to set
	 */
	public void setRelease(Date release) {
		this.release = release;
	}
	/**
	 * @return the movOffer
	 */
	//,fetch=FetchType.EAGER
	@OneToMany(targetEntity=MovieOfferring.class, mappedBy="movie", cascade=CascadeType.ALL)
	public List<MovieOfferring> getMovOffer() {
		return movOffer;
	}
	/**
	 * @param movOffer the movOffer to set
	 */
	public void setMovOffer(List<MovieOfferring> movOffer) {
		this.movOffer = movOffer;
	}
	/**
	 * @return the released
	 */
	public int getReleased() {
		return released;
	}
	/**
	 * @param released the released to set
	 */
	public void setReleased(int released) {
		this.released = released;
	}
	/**
	 * @return the rating
	 */
	//, fetch=FetchType.EAGER
	@OneToMany(targetEntity=Rating.class, mappedBy="movie", cascade=CascadeType.ALL)
	public List<Rating> getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}

}
