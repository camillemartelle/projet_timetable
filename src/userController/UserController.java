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
 * Cette classe est le contrôleur d'utilisateurs que vous devez implémenter. 
 * Elle contient un attribut correspondant à la base de données utilisateurs que vous allez créer.
 * Elle contient toutes les fonctions de l'interface IUserController que vous devez implémenter.
 * 
 * @author Jose Mennesson (Mettre à jour)
 * @version 04/2016 (Mettre à jour)
 * 
 */

//TODO Classe à modifier

public class UserController implements IUserController
{
	
	/**
	 * Contient une instance de base de données d'utilisateurs
	 * 
	 */
	private UserDB userDB=null;


	
	/**
	 * Constructeur de controleur d'utilisateurs créant la base de données d'utilisateurs
	 * 
	 * @param userfile
	 * 		Fichier XML contenant la base de données d'utilisateurs
	 */
	public UserController(String userfile){
		UserDB userDB=new UserDB(userfile);
		this.setUserDB(userDB);
	}

	@Override
	public String getUserName(String userLogin) {
		// TODO Auto-generated method stub
		
		/*Element currentUsers = racine.getChild("Students");
		
		List listCurrent = currentUsers.getChildren("Student");
		
		Iterator i = listCurrent.iterator();
		int j=0;
		while(i.hasNext()){
			Element courant = (Element)i.next();
			if(courant.getChildText("login").equals(userLogin))
				return courant.getChildText("firstname") + " " + courant.getChildText("surname");
		}
		
		currentUsers = racine.getChild("Teachers");
		listCurrent = currentUsers.getChildren("Teacher");
		
		i = listCurrent.iterator();
		
		while(i.hasNext()){
			Element courant = (Element)i.next();
			if(courant.getChildText("login").equals(userLogin))
			return courant.getChildText("firstname") + " " + courant.getChildText("surname");
		}
		
		currentUsers = racine.getChild("Administrators");
		listCurrent = currentUsers.getChildren("Administrator");
		
		i = listCurrent.iterator();
		
		while(i.hasNext()){
			Element courant = (Element)i.next();
			if(courant.getChildText("login").equals(userLogin))
			return courant.getChildText("firstname") + " " + courant.getChildText("surname");
		}*/
		
		return null;
	}

	@Override
	public String getUserClass(String userLogin, String userPwd) {
		// TODO Auto-generated method stub
		/*Element currentUsers = racine.getChild("Students");
		
		List listCurrent = currentUsers.getChildren("Student");
		
		Iterator i = listCurrent.iterator();
		int j=0;
		while(i.hasNext()){
			Element courant = (Element)i.next();
			if(courant.getChildText("login").equals(userLogin) && courant.getChildText("pwd").equals(userPwd))
				return "Student";
		}
		
		currentUsers = racine.getChild("Teachers");
		listCurrent = currentUsers.getChildren("Teacher");
		
		i = listCurrent.iterator();
		
		while(i.hasNext()){
			Element courant = (Element)i.next();
			if(courant.getChildText("login").equals(userLogin) && courant.getChildText("pwd").equals(userPwd))
			return "Teacher";
		}
		
		currentUsers = racine.getChild("Administrators");
		listCurrent = currentUsers.getChildren("Administrator");
		
		i = listCurrent.iterator();
		
		while(i.hasNext()){
			Element courant = (Element)i.next();
			if(courant.getChildText("login").equals(userLogin) && courant.getChildText("pwd").equals(userPwd))
			return "Administrator";
		}*/
		
		return "";
	}

	@Override
	public int getStudentGroup(String studentLogin) {
		// TODO Auto-generated method stub
										
				/*Element students = racine.getChild("Students");
				
				List listStudent = students.getChildren("Student");
				
				Iterator i = listStudent.iterator();
				
				while(i.hasNext()){
					Element courant = (Element)i.next();
					if(courant.getChildText("login").equals(studentLogin))		
						return Integer.parseInt(courant.getChildText("groupId"));			
					
				}*/
																
				return -1;
	}
	

	@Override
	public boolean addAdmin(String adminLogin, String newAdminlogin, int adminID, String firstname, String surname,
			String pwd) {
		
		
		
		
		
		
		
		return false;
	}

	@Override
	public boolean addTeacher(String adminLogin, String newteacherLogin, int teacherID, String firstname,
			String surname, String pwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addStudent(String adminLogin, String newStudentLogin, int studentID, String firstname,
			String surname, String pwd) {
		// TODO Auto-generated method stub
		return false;
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
		
		/*String[] usersData = new String[2000];
		
		Element currentUsers = racine.getChild("Students");
		
		List listCurrent = currentUsers.getChildren("Student");
		
		Iterator i = listCurrent.iterator();
		int j=0;
		while(i.hasNext()){
			Element courant = (Element)i.next();
			usersData[j++] = courant.getChildText("login") + " " + courant.getChildText("firstname") + " " + courant.getChildText("surname") + " " + courant.getChildText("pwd") + " " + courant.getChildText("studentId") + " " + courant.getChildText("groupId");
		}
		
		currentUsers = racine.getChild("Teachers");
		listCurrent = currentUsers.getChildren("Teacher");
		
		i = listCurrent.iterator();
		
		while(i.hasNext()){
			Element courant = (Element)i.next();
			usersData[j++] = courant.getChildText("login") + " " + courant.getChildText("firstname") + " " + courant.getChildText("surname") + " " + courant.getChildText("pwd") + " " + courant.getChildText("teacherId");
		}
		
		currentUsers = racine.getChild("Administrators");
		listCurrent = currentUsers.getChildren("Administrator");
		
		i = listCurrent.iterator();
		
		while(i.hasNext()){
			Element courant = (Element)i.next();
			usersData[j++] = courant.getChildText("login") + " " + courant.getChildText("firstname") + " " + courant.getChildText("surname") + " " + courant.getChildText("pwd") + " " + courant.getChildText("adminId");
		}
		
		return usersData;*/
		return null;
	}

	@Override
	public String[] usersLoginToString() {
		//ajouter conditions pour taille tableau
		/*String[] usersLogin = this.studentsLoginToString();
		
		
		Element usersTeacher = racine.getChild("Teachers");
		Element usersAdmin = racine.getChild("Administrators");
		
		List listUserTeacher = usersTeacher.getChildren("Teacher");
		List listUserAdmin = usersAdmin.getChildren("Administrator");
		
		Iterator i = listUserTeacher.iterator();
		
		int j=0;
		for (String o : usersLogin)
			if (o!=null) j++;
		
		while(i.hasNext()){
			Element courant = (Element)i.next();
			usersLogin[j++] = courant.getChildText("login"); 
		}
		
		i = listUserAdmin.iterator();
		
		while(i.hasNext()){
			Element courant = (Element)i.next();
			usersLogin[j++] = courant.getChildText("login");
		}
		
		
		return usersLogin;*/
		return null;
	}

	@Override
	public String[] studentsLoginToString() {
		//ajouter conditions pour taille tableau
		/*String[] studentsLogin = new String[2000];
		
		Element students = racine.getChild("Students");
		
		List listStudent = students.getChildren("Student");
		
		Iterator i = listStudent.iterator();
		int j=0;
		while(i.hasNext()){
			Element courant = (Element)i.next();
			studentsLogin[j++]= courant.getChildText("login");
		}
		
		
		//System.out.print(listGroupId.toString());
		
		return studentsLogin;*/
		return null;
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
			//System.out.println(listeGroupe.get(2).getEtudiants().size());
			while(j<nbEtudiant)
			{
				
				infoGroupes[i] = infoGroupes[i] + " " + listeEtudiant.get(j).getNom() + " " + listeEtudiant.get(j).getPrenom();
				j++;
			}
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
	 			
	 			userDB.addStudent(new Etudiant(courant.getChildText("login"), courant.getChildText("surname"), courant.getChildText("firstname"), courant.getChildText("pwd"), Integer.parseInt(courant.getChildText("studentId"))));

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
	 		ArrayList<Etudiant> listeEtud = new ArrayList<Etudiant>();
	 		ArrayList<Groupe> listeGroupe = new ArrayList<Groupe>();
	 		int nombreEtud = listeEtud.size();
	 		int nombreGroupe= listeGroupe.size();
	 		while(j<nombreEtud)
	 		{
	 			System.out.println("b1");
	 			int current_idgroupe = listeEtud.get(j).getId_groupe();
	 			if(current_idgroupe!=-1)
	 			{
	 				while (k<nombreGroupe)
	 				{
	 					System.out.println("b2");
		 				if(listeGroupe.get(k).getId_groupe()==current_idgroupe) 
		 				{
		 				listeGroupe.get(k).addEtudiant(listeEtud.get(j));	
		 				}
	 				
	 				}
	 			}
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

