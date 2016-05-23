/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;

import java.util.ArrayList;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Groupe.
 * 
 * @author Camille
 */
public class Groupe {
	/**
	 * Description of the property etudiants.
	 */
	public ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();

	/**
	 * Description of the property id_groupe.
	 */
	private int id_groupe;
	
	// Start of user code (user defined attributes for Groupe)

	// End of user code
	
	/**
	 * The constructor.
	 */
	public Groupe(int last_id) {
		// Start of user code constructor for Groupe)
		//super();
		this.id_groupe=last_id;
		// End of user code
	}

	// Start of user code (user defined methods for Groupe)

	// End of user code
	/**
	 * Returns etudiants.
	 * @return etudiants 
	 */
	public ArrayList<Etudiant> getEtudiants() { // type etudiant?
		return this.etudiants;
	}

	/**
	 * Returns id_groupe.
	 * @return id_groupe 
	 */

	public int getId_groupe() {
		return this.id_groupe;
	}

}
