/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;


import userModel.User;

/**
 * 
 * @author Camille
 */
public class Admin extends User {
	/**
	 * Identifiant de l'administrateur
	 */
	private int id_admin;
	
	/**
	 * Constructeur de l'administrateur
	 * @param log
	 * 		Login de l'admin à créer 
	 * @param nom
	 * 		Nom de l'admin à créer 
	 * @param prenom
	 * 		Prenom de l'admin à créer 
	 * @param mdp
	 * 		Mot de passe de l'admin à créer 
	 * @param last_id
	 * 		Identifiant de l'admin à créer
	 */
	public Admin(String log, String nom, String prenom, String mdp, int last_id) {
		super(log, nom, prenom, mdp);
		this.id_admin=last_id;
	}
	/**
	 * Retourne l'identifiant de l'administrateur
	 * @return id_admin 
	 */

	public int getId_admin() {
		return this.id_admin;
	}

}
