/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;


import userModel.User;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Etudiant.
 * 
 * @author Camille
 */
public class Etudiant extends User {
	/**
	 * Identifiant de l'�tudiant.
	 */
	private int id_etud=-1;

	/**
	 * Identifiant du groupe de l'�tudiant. -1 si l'�tudiant n'a pas de groupe
	 */
	private int id_groupe=-1;

	/**
	 * Constructeur
	 * @param groupId 
	 * 		Identifiant du groupe � cr�er
	 * @param log
	 * 		Login de l'�tudiant � cr�er 
	 * @param nom
	 * 		Nom de l'�tudiant � cr�er 
	 * @param prenom
	 * 		Prenom de l'�tudiant � cr�er 
	 * @param mdp
	 * 		Mot de passe de l'�tudiant � cr�er 
	 * @param groupId 
	 * 		Identifiant du groupe de l'�tudiant. -1 s'il n'en a pas
	 */
	public Etudiant(String log, String nom, String prenom, String mdp, int last_id, int groupId) {
		super(log, nom, prenom, mdp);
		this.id_etud=last_id;
		this.id_groupe=groupId;
	}


	/**
	 * Retourne l'identifiant de l'�tudiant
	 * @return id_etud 
	 */

	public int getId_etud() {
		return this.id_etud;
	}

	/**
	 * Retourne l'identifiant du groupe de l'�tudiant
	 * @return id_groupe 
	 */

	public int getId_groupe() {
		return this.id_groupe;
	}


	/**
	 * Associe l'�tudiant � un groupe 
	 * @param groupId 
	 * 		Identifiant du groupe auquel l'�tudiant doit �tre associ�
	 */
	public void setGroupe(int groupId) {
		this.id_groupe=groupId;	
	}

}
