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
	 * Description of the property id_etud.
	 */
	private int id_etud=-1;

	/**
	 * Description of the property id_groupe.
	 */
	private int id_groupe=-1;

	/**
	 * Description of the property grouped.
	 */
	private Boolean grouped = Boolean.FALSE;

	// Start of user code (user defined attributes for Etudiant)

	// End of user code

	/**
	 * The constructor.
	 * @param groupId 
	 */
	public Etudiant(String log, String nom, String prenom, String mdp, int last_id, int groupId) {
		// Start of user code constructor for Etudiant)
		super(log, nom, prenom, mdp);
		this.id_etud=last_id;
		this.id_groupe=groupId;
		// End of user code
	}

	// Start of user code (user defined methods for Etudiant)

	// End of user code
	/**
	 * Returns id_etud.
	 * @return id_etud 
	 */

	public int getId_etud() {
		return this.id_etud;
	}

	/**
	 * Returns id_groupe.
	 * @return id_groupe 
	 */

	public int getId_groupe() {
		return this.id_groupe;
	}

	/**
	 * Returns grouped.
	 * @return grouped 
	 */
	public Boolean getGrouped() {
		return this.grouped;
	}

	/**
	 * Sets a value to attribute grouped. 
	 * @param newGrouped 
	 */
	public void setGrouped(Boolean newGrouped) {
		this.grouped = newGrouped;
	}

}
