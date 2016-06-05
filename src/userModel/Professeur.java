/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;


import userModel.User;


/**
 * 
 * @author Camille
 */
public class Professeur extends User {
	/**
	 * Identifiant du professeur.
	 */
	private int id_prof;
	
	
	/**
	 * Constructeur de Professeur.
	 * @param log
	 * 		Login du professeur à créer 
	 * @param nom
	 * 		Nom du professeur à créer 
	 * @param prenom
	 * 		Prenom du professeur à créer 
	 * @param mdp
	 * 		Mot de passe du professeur à créer 
	 * @param last_id
	 * 		Identifiant du professeur à créer
	 */
	public Professeur(String log, String nom, String prenom, String mdp, int last_id) {
		super(log, nom, prenom, mdp);
		this.id_prof=last_id;
	}

	/**
	 * Retourne l'identifiant du professeur.
	 * @return id_prof 
	 */

	public int getId_prof() {
		return this.id_prof;
	}

}
