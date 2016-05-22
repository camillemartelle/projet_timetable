/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;


import userModel.User;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Admin.
 * 
 * @author Camille
 */
public class Admin extends User {
	/**
	 * Description of the property id_admin.
	 */
	private int id_admin;
	
	// Start of user code (user defined attributes for Admin)
	
	// End of user code
	
	/**
	 * The constructor.
	 */
	public Admin(String log, String nom, String prenom, String mdp, int last_id) {
		// Start of user code constructor for Admin)
		super(log, nom, prenom, mdp);
		this.id_admin=last_id++;
		
		// End of user code
	}

	// Start of user code (user defined methods for Admin)

	// End of user code
	/**
	 * Returns id_admin.
	 * @return id_admin 
	 */

	public int getId_admin() {
		return this.id_admin;
	}

}
