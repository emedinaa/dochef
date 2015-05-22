package dochef.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name = "system_user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;
    
    @Column(name = "first_name", length = 100,nullable = false)
    private String firstName;
    
    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;
    
    @Column(name = "password", length = 255)
    private String password;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", length = 20, nullable = false)
    private Role role;

    public User(){}
    
    
    public User(String email, String firstName, String lastName,
			String password) {
		super();

		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
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




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public Role getRole() {
		return role;
	}




	public void setRole(Role role) {
		this.role = role;
	}





    
    
    
    
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
    

}