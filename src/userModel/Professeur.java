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
	 * 		Login du professeur � cr�er 
	 * @param nom
	 * 		Nom du professeur � cr�er 
	 * @param prenom
	 * 		Prenom du professeur � cr�er 
	 * @param mdp
	 * 		Mot de passe du professeur � cr�er 
	 * @param last_id
	 * 		Identifiant du professeur � cr�er
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
