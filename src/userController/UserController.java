package userController;

import userModel.Admin;
import userModel.Etudiant;
import userModel.Groupe;
import userModel.Professeur;
import userModel.UserDB;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * Cette classe est le contr√¥leur d'utilisateurs que vous devez impl√©menter. 
 * Elle contient un attribut correspondant √† la base de donn√©es utilisateurs que vous allez cr√©er.
 * Elle contient toutes les fonctions de l'interface IUserController que vous devez impl√©menter.
 * 
 * @author Jose Mennesson (Mettre √† jour)
 * @version 04/2016 (Mettre √† jour)
 * 
 */

//TODO Classe √† modifier

public class UserController implements IUserController
{
	
	/**
	 * Contient une instance de base de donn√©es d'utilisateurs
	 * 
	 */
	private UserDB userDB=null;


	
	/**
	 * Constructeur de controleur d'utilisateurs cr√©ant la base de donn√©es d'utilisateurs
	 * 
	 * @param userfile
	 * 		Fichier XML contenant la base de donn√©es d'utilisateurs
	 */
	public UserController(String userfile){
		UserDB userDB=new UserDB(userfile);
		this.setUserDB(userDB);
	}

	@Override
	public String getUserName(String userLogin) {
		
		
		
		ArrayList<Etudiant> listStudent = userDB.getStudents();
		ArrayList<Professeur> listTeacher = userDB.getTeachers();
		ArrayList<Admin> listAdmin = userDB.getAdmins();
		
		//On evite de parcourir toute la liste d'Ètudiants pour trouver un prof ou un admin
		
		int i = 0;
		while(i<listAdmin.size()){
			if(listAdmin.get(i).getLogin().equals(userLogin))
				return listAdmin.get(i).getNom() + " " + listAdmin.get(i).getPrenom();				
		i++;
		}
		
		i=0;
		while(i<listTeacher.size()){
			if(listTeacher.get(i).getLogin().equals(userLogin))
				return listTeacher.get(i).getNom() + " " + listTeacher.get(i).getPrenom();				
		i++;
		}
		
		i=0;
		while(i<listStudent.size()){
			if(listStudent.get(i).getLogin().equals(userLogin))
				return listStudent.get(i).getNom() + " " + listStudent.get(i).getPrenom();				
		i++;
		}
		
				
		return null;
		
		}

	@Override
	public String getUserClass(String userLogin, String userPwd) {
		
		ArrayList<Etudiant> listStudent = userDB.getStudents();
		ArrayList<Professeur> listTeacher = userDB.getTeachers();
		ArrayList<Admin> listAdmin = userDB.getAdmins();
		
		//On evite de parcourir toute la liste d'Ètudiants pour trouver un prof ou un admin
		
		int i = 0;
		while(i<listAdmin.size()){
			if(listAdmin.get(i).getLogin().equals(userLogin) && listAdmin.get(i).getMdp().equals(userPwd))
				return "Administrator";				
		i++;
		}
		
		i=0;
		while(i<listTeacher.size()){
			if(listTeacher.get(i).getLogin().equals(userLogin) && listTeacher.get(i).getMdp().equals(userPwd))
				return "Teacher";				
		i++;
		}
		
		i=0;
		while(i<listStudent.size()){
			if(listStudent.get(i).getLogin().equals(userLogin) && listStudent.get(i).getMdp().equals(userPwd))
				return "Student";				
		i++;
		}
		
				
		return "";
		
	}
	
	//fonction permettant de savoir si un utilisateur est un admin ‡ partir de son login
	private boolean isAdmin(String userLogin){
		ArrayList<Admin> listAdmin = userDB.getAdmins();
		int i = 0;
		while(i < listAdmin.size()){
			if(listAdmin.get(i++).getLogin().equals(userLogin))
				return true;
		}
		return false;
	}

	private boolean isTeacher(String userLogin){
		ArrayList<Professeur> listTeacher = userDB.getTeachers();
		int i = 0;
		while(i < listTeacher.size()){
			if(listTeacher.get(i++).getLogin().equals(userLogin))
				return true;
		}
		return false;
	}
	
	private boolean isStudent(String userLogin){
		ArrayList<Etudiant> listStudent = userDB.getStudents();
		int i = 0;
		while(i < listStudent.size()){
			if(listStudent.get(i++).getLogin().equals(userLogin))
				return true;
		}
		return false;
	}
	
	@Override
	public int getStudentGroup(String studentLogin) {
		
		ArrayList<Etudiant> listStudent = userDB.getStudents();
		
		int i = 0;
		
		while(i < listStudent.size()){
			if(listStudent.get(i).getLogin().equals(studentLogin))
				return listStudent.get(i).getId_groupe();
			i++;
		}
		
		
				return -1;
				
	}
	

	@Override
	public boolean addAdmin(String adminLogin, String newAdminlogin, int adminID, String firstname, String surname,
			String pwd) {
		
		//si adminLogin n'est pas un admin ou si newAdminlogin existe deja
		if(!isAdmin(adminLogin) || isAdmin(newAdminlogin))
			return false;
		
		userDB.getAdmins().add(new Admin(newAdminlogin, surname, firstname, pwd, adminID));
						
		
		return true;
	}

	@Override
	public boolean addTeacher(String adminLogin, String newteacherLogin, int teacherID, String firstname,
			String surname, String pwd) {
		
		
		if(!isAdmin(adminLogin) || isTeacher(newteacherLogin))
			return false;
		
		userDB.getTeachers().add(new Professeur(newteacherLogin, surname, firstname, pwd, teacherID));
						
		
		return true;
		
	}

	@Override
	public boolean addStudent(String adminLogin, String newStudentLogin, int studentID, String firstname,
			String surname, String pwd) {
		
		if(!isAdmin(adminLogin) || isAdmin(newStudentLogin))
			return false;
		
		userDB.getStudents().add(new Etudiant(newStudentLogin, surname, firstname, pwd, studentID, -1));
						
		
		return true;
		
		
	}

	@Override
	public boolean removeUser(String adminLogin, String userLogin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addGroup(String adminLogin, int groupId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeGroup(String adminLogin, int groupId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean associateStudToGroup(String adminLogin, String studentLogin, int groupId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String[] usersToString() {
		
		String[] usersData = new String[2000];
		ArrayList<Etudiant> listStudent = userDB.getStudents();
		ArrayList<Professeur> listTeacher = userDB.getTeachers();
		ArrayList<Admin> listAdmin = userDB.getAdmins();
		
		//i pour parcourir tableau et j pour parcourir listes
		int i = 0, j = 0;
		
		while(j < listStudent.size())
		{
			usersData[i] = listStudent.get(j).getLogin() + " " + listStudent.get(j).getNom() + " " + listStudent.get(j).getPrenom() + " Id etudiant : " + listStudent.get(j).getId_etud() +" Groupe : " + listStudent.get(j).getId_groupe();
			i++;
			j++;
		}
		
		j=0;
		
		while(j < listTeacher.size()){
			usersData[i] = listTeacher.get(j).getLogin() + " " + listTeacher.get(j).getNom() + " " + listTeacher.get(j).getPrenom() + " Id prof : " + listTeacher.get(j).getId_prof();
			i++;
			j++;			
		}
		
		j=0;
 		
		while(j < listAdmin.size()){
			usersData[i] = listAdmin.get(j).getLogin() + " " + listAdmin.get(j).getNom() + " " + listAdmin.get(j).getPrenom() + " Id admin : " + listAdmin.get(j).getId_admin();
			i++;
			j++;			
		}
		
				
		
		
		
		return usersData;
	}

	@Override
	public String[] usersLoginToString() {
		
		String[] userLogins = new String[2000];
		
		//on recupËre les logins des Ètudiants
		userLogins = this.studentsLoginToString();
		
		//On charge les listes administrateurs et professeurs
		ArrayList<Professeur> listTeacher = userDB.getTeachers();
		ArrayList<Admin> listAdmin = userDB.getAdmins();
		
		//On recupËre le nombre d'ÈlÈments du tableau pour avoir l'index ‡ utiliser
		int j=0, k = 0;
		for(Object o : userLogins)
			if(o != null) j++;
		
		
		//On rÈcupËre les logins des profs et admins qu'on rajoute ‡ ceux presents dans le tableau
		while(listTeacher.size() > k ){
			userLogins[j] = listTeacher.get(k++).getLogin();
			j++;
		}
		
		k = 0;
		
		while(listAdmin.size() > k ){
			userLogins[j] = listAdmin.get(k++).getLogin();
			j++;
		}
		
		
		return userLogins;
		
	}

	@Override
	public String[] studentsLoginToString() {
		
		String[] logins = new String[2000];
		int j = 0;
		ArrayList<Etudiant> listStudent = userDB.getStudents();
				
		while(listStudent.size() > j ){
			logins[j] = listStudent.get(j).getLogin();
			j++;
		}
			
		return logins;
		
	}

	@Override
	public String[] groupsIdToString() {
		
		String[] groupes = new String[200];
		int j = 0;
		ArrayList<Groupe> listGroupe = userDB.getGroupes();
				
		while(listGroupe.size() > j ){
			groupes[j] =  Integer.toString(listGroupe.get(j).getId_groupe());
			j++;
		}
			
		return groupes;
	}

	@Override
	public String[] groupsToString() {
		String[] infoGroupes= new String[200];
		ArrayList<Groupe> listeGroupe = userDB.getGroupes();
		
		int nbGroupe = listeGroupe.size();		
		int i = 0, j=0;
		while(i<nbGroupe)
		{
			ArrayList<Etudiant> listeEtudiant = listeGroupe.get(i).getEtudiants();
			int nbEtudiant = listeEtudiant.size();
			infoGroupes[i]=Integer.toString(listeGroupe.get(i).getId_groupe());
			while(j<nbEtudiant)
			{
				
				infoGroupes[i] = infoGroupes[i] + " " + listeEtudiant.get(j).getNom() + " " + listeEtudiant.get(j).getPrenom();
				j++;
			}
			j=0;
			i++;		
		}
		
		
		
		
		return infoGroupes;
	}

	@Override
	public boolean loadDB() {
		// TODO Auto-generated method stub
		
				
	      try
	      {
	    	 SAXBuilder sxb = new SAXBuilder();
	         Document database = sxb.build(new File(userDB.getFile()));
	         Element racine = database.getRootElement();
	         
	         Element currentUsers = racine.getChild("Students");
	 		
	 		List listCurrent = currentUsers.getChildren("Student");
	 		
	 		Iterator i = listCurrent.iterator();
	 		
	 		while(i.hasNext()){
	 			Element courant = (Element)i.next();
	 			
	 			userDB.addStudent(new Etudiant(courant.getChildText("login"), courant.getChildText("surname"), courant.getChildText("firstname"), courant.getChildText("pwd"), Integer.parseInt(courant.getChildText("studentId")), Integer.parseInt(courant.getChildText("groupId"))));

	 		}
	 		
	 		currentUsers = racine.getChild("Teachers");
	 		listCurrent = currentUsers.getChildren("Teacher");
	 		
	 		i = listCurrent.iterator();
	 		
	 		while(i.hasNext()){
	 			Element courant = (Element)i.next();
	 			
	 			userDB.addTeacher(new Professeur(courant.getChildText("login"), courant.getChildText("surname"), courant.getChildText("firstname"), courant.getChildText("pwd"), Integer.parseInt(courant.getChildText("teacherId"))));
	 			
	 		}
	 		
	 		currentUsers = racine.getChild("Administrators");
	 		listCurrent = currentUsers.getChildren("Administrator");
	 		
	 		i = listCurrent.iterator();
	 		
	 		while(i.hasNext()){
	 			Element courant = (Element)i.next();
	 			userDB.addAdmin(new Admin(courant.getChildText("login"), courant.getChildText("surname"), courant.getChildText("firstname"), courant.getChildText("pwd"), Integer.parseInt(courant.getChildText("adminId"))));
	 			
	 		}
	 		
	 		currentUsers = racine.getChild("Groups");
	 		listCurrent = currentUsers.getChildren("Group");
	 		
	 		i = listCurrent.iterator();
	 		
	 		while(i.hasNext()){
	 			Element courant = (Element)i.next();
	 			userDB.addGroupe(new Groupe(Integer.parseInt(courant.getChildText("groupId"))));
	 		}
	 		
	 		int j = 0, k = 0;
	 		ArrayList<Etudiant> listeEtud = userDB.getStudents();
	 		ArrayList<Groupe> listeGroupe = userDB.getGroupes();
	 		int nombreEtud = listeEtud.size();
	 		int nombreGroupe= listeGroupe.size();
	 		while(j<nombreGroupe)
	 		{

	 			int current_idgroupe = listeGroupe.get(j).getId_groupe();
	 			Etudiant currentStudent = listeEtud.get(j);
	 			
	 			if(current_idgroupe!=-1)
	 			{
	 				while (k<nombreEtud)
	 				{

		 				if(listeEtud.get(k).getId_groupe() == current_idgroupe) 
		 				{
		 					listeGroupe.get(j).addEtudiant(listeEtud.get(k));	
		 				}
	 				k++;
	 				}
	 			}
	 			k=0;
	 			j++;
	 		}
	 		
	 			 		
	         return true;
	      }
	      catch(Exception e){}
	      
	       
		

		return false;
	}

	@Override
	public boolean saveDB() {
		// TODO Auto-generated method stub
		/*try
		   {
		      
		      XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
		      
		      sortie.output(database, new FileOutputStream(userDB.getFile()));
		      return true;
		   }
		   catch (java.io.IOException e){}*/
		return false;
	}

	public UserDB getUserDB() {
		return userDB;
	}

	public void setUserDB(UserDB userDB) {
		this.userDB = userDB;
	}
	
	

}

