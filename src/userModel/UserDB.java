package userModel;

import java.util.ArrayList;

/**
 * 
 * Cette classe g√©re la base de donn√©es d'utilisateurs. Elle doit permettre de sauvegarder et charger les utilisateurs et les groupes √† partir d'un fichier XML. 
 * La structure du fichier XML devra √™tre la m√™me que celle du fichier userDB.xml.
 * @see <a href="../../userDB.xml">userDB.xml</a> 
 * 
 * @author Jose Mennesson (Mettre √† jour)
 * @version 04/2016 (Mettre √† jour)
 * 
 */

//TODO Classe √† modifier

public class UserDB {
	
	/**
	 * 
	 * Le fichier contenant la base de donn√©es.
	 * 
	 */
	private String file;
	private ArrayList<Etudiant> students = new ArrayList<Etudiant>();
	private ArrayList<Admin> admins = new ArrayList<Admin>();
	private ArrayList<Professeur> teachers = new ArrayList<Professeur>();
	private ArrayList<Groupe> groupes = new ArrayList<Groupe>();
	/**
	 * 
	 * Constructeur de UserDB. 
	 * 
	 * !!!!!!!!!!!! PENSEZ √Ä AJOUTER UN ADMINISTRATEUR (su par exemple) QUI VOUS PERMETTRA DE CHARGER LA BASE DE DONN√âES AU DEMARRAGE DE L'APPLICATION !!!!!!
	 * 
	 * @param file
	 * 		Le nom du fichier qui contient la base de donn√©es.
	 */
	public UserDB(String file){
		//TODO Fonction √† modifier
		//super();
		this.setFile(file);
		
	}
	
	/**
	 * Getter de file
	 * 
	 * @return 
	 * 		Le nom du fichier qui contient la base de donn√©es.
	 */
	
	public String getFile() {
		return file;
	}
	
	/**
	 * Setter de file
	 * 
	 * @param file
	 * 		Le nom du fichier qui contient la base de donn√©es.
	 */
	
	public void setFile(String file) {
		this.file = file;
	}
	/**
	 * 
	 * @return students
	 * 		Retourne la liste d'Ètudiants
	 */
	public ArrayList<Etudiant> getStudents() {
		return students;
	}
	/**
	 *
	 * @param student 
	 * 		Ajoute un Ètudiant ‡ la liste d'Ètudiants
	 */
	public void addStudent(Etudiant student) {
		students.add(student);
	}
	/**
	 * 
	 * @return teachers
	 * 		Retourne la liste de professeurs
	 */
	public ArrayList<Professeur> getTeachers() {
		return teachers;
	}
	/**
	 * 
	 * @param professeur
	 * 		Ajoute un professeur ‡ la liste de professeurs
	 */
	public void addTeacher(Professeur professeur) {
		teachers.add(professeur);

	}
	/**
	 * 
	 * @return admins
	 * 		Retourne la liste d'administrateurs
	 */
	public ArrayList<Admin> getAdmins() {
		return admins;
	}
	/**
	 * 
	 * @param admin
	 * 		Ajoute un administrateur ‡ la liste d'administrateurs
	 */
	public void addAdmin(Admin admin) {
		admins.add(admin);
		
	}
	/**
	 * 
	 * @param groupe
	 * 		Ajoute un groupe ‡ la liste de groupes
	 */
	public void addGroupe(Groupe groupe) {
		groupes.add(groupe);
		
	}
	/**
	 * 
	 * @return groupes
	 * 		Retourne la liste des groupes
	 */
	public ArrayList<Groupe> getGroupes(){
		return groupes;
	}
	/**
	 * 
	 * @param index
	 * 		Supprime un Ètudiant de la liste via son index
	 */
	public void removeStudent(int index){
		students.remove(index);
	}
	/**
	 * 
	 * @param index
	 * 		Supprime un administrateur de la liste via son index
	 */
	public void removeAdmin(int index){
		admins.remove(index);
	}
	/**
	 * 
	 * @param index
	 * 		Supprime un professeur de la liste via son index
	 */
	public void removeTeacher(int index){
		teachers.remove(index);
	}

}
