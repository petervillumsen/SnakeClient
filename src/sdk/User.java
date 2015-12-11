package sdk;

import java.sql.Date;

/**
 * This class contains the same as the User class on the server side
 * and represents an object of a user with all attributes
 */

public class User {

    //Declaring variables
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Date created;
    private String status;
    private String email;
    private int type;
    public User () {}

    //creating get and set method for all the variables, so they can be used by other classes

    /**
     * Getter for id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for id
     * @param id sets id for the user object
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for firstName
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for firstName
     * @param firstName sets the first name for user object
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for lastName
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for lastName
     * @param lastName sets the last name for user object
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter for username
     * @param username sets username for user object
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter for password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for password
     * @param password sets password for user object
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for created
     * @return created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Setter for created
     * @param created sets created for user object
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * Getter for status
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter for status
     * @param status sets status for user object
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Getter for email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for email
     * @param email sets email for user object
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for type
     * @return type
     */
    public int getType() {
        return type;
    }

    /**
     * Setter for type
     * @param type sets type for user object
     */
    public void setType(int type) {
        this.type = type;
    }
}//End of class