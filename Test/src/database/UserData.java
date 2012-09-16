package database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserData {
	private int userDataId;
	private String nickName;
	private String firstName;
	private String lastName;
	private int birthYear;
	private String genre;
	private String favourites;

	@Id
	@GeneratedValue
	public int getUserDataId() {
		return userDataId;
	}
	
	public void setUserDataId(int userDataId) {
		this.userDataId = userDataId;
	}
	
	
	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getFavourites() {
		return favourites;
	}
	
	public void setFavourites(String favourites) {
		this.favourites = favourites;
	}
}
