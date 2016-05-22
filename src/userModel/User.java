/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;


// Start of user code (user defined imports)

// End of user code

/**
 * Description of User.
 * 
 * @author Camille
 */
public class User {
	/**
	 * Description of the property login.
	 */
	private String login = new String();

	/**
	 * Description of the property prenom.
	 */
	private String prenom = new String();

	/**
	 * Description of the property nom.
	 */
	private String nom = new String();

	/**
	 * Description of the property mdp.
	 */
	private String mdp = new String();

	// Start of user code (user defined attributes for User)

	// End of user code

	/**
	 * The constructor.
	 */
	public User(String log, String nom, String prenom, String mdp) {
		// Start of user code constructor for User)
		this.login=log;
		this.nom=nom;
		this.prenom=prenom;
		this.mdp=mdp;
		
		//super();
		// End of user code
	}

	// Start of user code (user defined methods for User)

	// End of user code
	/**
	 * Returns login.
	 * @return login 
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 * Returns prenom.
	 * @return prenom 
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Returns nom.
	 * @return nom 
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Returns mdp.
	 * @return mdp 
	 */
	public String getMdp() {
		return this.mdp;
	}

}
