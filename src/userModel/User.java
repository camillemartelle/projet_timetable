/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;


// Start of user code (user defined imports)

// End of user code

/**
 * 
 * @author Camille
 */
public class User {
	/**
	 * Login de l'utilisateur
	 */
	private String login = new String();

	/**
	 * Prenom de l'utilisateur
	 */
	private String prenom = new String();

	/**
	 * Nom de l'utilisateur
	 */
	private String nom = new String();

	/**
	 * Mot de passe de l'utilisateur
	 */
	private String mdp = new String();

	/**
	 * Constructeur de User.
	 * @param log
	 * 		Login de l'utilisateur à créer 
	 * @param nom
	 * 		Nom de l'utilisateur à créer 
	 * @param prenom
	 * 		Prenom de l'utilisateur à créer 
	 * @param mdp
	 * 		Mot de passe de l'utilisateur à créer 
	 */
	public User(String log, String nom, String prenom, String mdp) {
		this.login=log;
		this.nom=nom;
		this.prenom=prenom;
		this.mdp=mdp;
	}

	/**
	 * Retourne le login de l'utilisateur
	 * @return login 
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 * Retourne le prenom de l'utilisateur
	 * @return prenom 
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Retourne le nom de l'utilisateur
	 * @return nom 
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Retourne le mot de passe de l'utilisateur
	 * @return mdp 
	 */
	public String getMdp() {
		return this.mdp;
	}

}
