package userModel;

import java.util.ArrayList;

/**
 * 
 * Cette classe gére la base de données d'utilisateurs. Elle doit permettre de sauvegarder et charger les utilisateurs et les groupes à partir d'un fichier XML. 
 * La structure du fichier XML devra être la même que celle du fichier userDB.xml.
 * @see <a href="../../userDB.xml">userDB.xml</a> 
 * 
 * @author Jose Mennesson (Mettre à jour)
 * @version 04/2016 (Mettre à jour)
 * 
 */

//TODO Classe à modifier

public class UserDB {
	
	/**
	 * 
	 * Le fichier contenant la base de données.
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
	 * !!!!!!!!!!!! PENSEZ À AJOUTER UN ADMINISTRATEUR (su par exemple) QUI VOUS PERMETTRA DE CHARGER LA BASE DE DONNÉES AU DEMARRAGE DE L'APPLICATION !!!!!!
	 * 
	 * @param file
	 * 		Le nom du fichier qui contient la base de données.
	 */
	public UserDB(String file){
		//TODO Fonction à modifier
		//super();
		this.setFile(file);
		
	}
	
	/**
	 * Getter de file
	 * 
	 * @return 
	 * 		Le nom du fichier qui contient la base de données.
	 */
	
	public String getFile() {
		return file;
	}
	
	/**
	 * Setter de file
	 * 
	 * @param file
	 * 		Le nom du fichier qui contient la base de données.
	 */
	
	public void setFile(String file) {
		this.file = file;
	}

	public ArrayList<Etudiant> getStudents() {
		return students;
	}

	public void addStudent(Etudiant student) {
		students.add(student);
	}

	public ArrayList<Professeur> getTeachers() {
		return teachers;
	}
	
	public void addTeacher(Professeur professeur) {
		teachers.add(professeur);
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Admin> getAdmins() {
		return admins;
	}
	
	public void addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		admins.add(admin);
		
	}

	public void addGroupe(Groupe groupe) {
		groupes.add(groupe);
		
	}
	
	public ArrayList<Groupe> getGroupes(){
		return groupes;
	}

}
