/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;

import java.util.ArrayList;

/**
 * Description of Groupe.
 * 
 * @author Camille
 */
public class Groupe {
	/**
	 * Liste contenant les étudiants du groupe
	 */
	private ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();

	/**
	 * Identifiant du groupe.
	 */
	private int id_groupe;
	
	/**
	 * Constructeur de Groupe.
	 * @param last_id
	 * 		identifiant du groupe à créer
	 */
	public Groupe(int last_id) {
		this.id_groupe=last_id;
	}

	/**
	 * Retourne la liste d'étudiants du groupe
	 * @return etudiants 
	 */
	public ArrayList<Etudiant> getEtudiants() { // type etudiant?
		return this.etudiants;
	}
	/**
	 * Ajoute un etudiant à la liste d'étudiants du groupe
	 * @param student
	 */
	public void addEtudiant(Etudiant student) {
		etudiants.add(student);			
		
	}
	/**
	 * Supprime un etudiant de la liste d'étudiants du groupe
	 * @param student
	 */
	public void removeEtudiant(Etudiant student){
		etudiants.remove(student);
	}
	/**
	 * Retourne l'identifiant du groupe
	 * @return id_groupe 
	 */

	public int getId_groupe() {
		return this.id_groupe;
	}

}
