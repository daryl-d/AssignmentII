package database;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.*;

@Entity
public class StandardUser {
	private int id;
	private String userName;
	private String emailAddress;
	private String password;
	private UserData userData;
	private List<Comment> comment = new ArrayList<Comment>();
	private List<Rating> rating = new ArrayList<Rating>();
	private List<Purchase> purchase = new ArrayList<Purchase>();
	
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="UserData_Foreign_Key")
	public UserData getUserData() {
		return userData;
	}

	public void setUserData(UserData userData) {
		this.userData = userData;
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the comment
	 */
	//, fetch=FetchType.EAGER
	@OneToMany(targetEntity=Comment.class, mappedBy="person", cascade=CascadeType.ALL)
	public List<Comment> getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	/**
	 * @return the rating
	 */
//, fetch=FetchType.EAGER
	@OneToMany(targetEntity=Rating.class, mappedBy="person", cascade=CascadeType.ALL)
	public List<Rating> getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}

	/**
	 * @return the purchase
	 */
	@OneToMany(targetEntity=Purchase.class, mappedBy="user", cascade=CascadeType.ALL)
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
