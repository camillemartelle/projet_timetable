/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;


import userModel.User;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Professeur.
 * 
 * @author Camille
 */
public class Professeur extends User {
	/**
	 * Description of the property id_prof.
	 */
	private int id_prof;
	
	// Start of user code (user defined attributes for Professeur)
	
	// End of user code
	
	/**
	 * The constructor.
	 */
	public Professeur(String log, String nom, String prenom, String mdp, int last_id) {
		// Start of user code constructor for Professeur)
		super(log, nom, prenom, mdp);
		this.id_prof=last_id;
		// End of user code
	}

	// Start of user code (user defined methods for Professeur)

	// End of user code
	/**
	 * Returns id_prof.
	 * @return id_prof 
	 */

	public int getId_prof() {
		return this.id_prof;
	}

}
