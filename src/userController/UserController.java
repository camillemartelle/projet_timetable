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
 * Cette classe est le contrÃ´leur d'utilisateurs que vous devez implÃ©menter. 
 * Elle contient un attribut correspondant Ã  la base de donnÃ©es utilisateurs que vous allez crÃ©er.
 * Elle contient toutes les fonctions de l'interface IUserController que vous devez implÃ©menter.
 * 
 * @author Jose Mennesson (Mettre Ã  jour)
 * @version 04/2016 (Mettre Ã  jour)
 * 
 */

//TODO Classe Ã  modifier

public class UserController implements IUserController
{
	
	/**
	 * Contient une instance de base de donnÃ©es d'utilisateurs
	 * 
	 */
	private UserDB userDB=null;


	
	/**
	 * Constructeur de controleur d'utilisateurs crÃ©ant la base de donnÃ©es d'utilisateurs
	 * 
	 * @param userfile
	 * 		Fichier XML contenant la base de donnÃ©es d'utilisateurs
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
		
		//On evite de parcourir toute la liste d'étudiants pour trouver un prof ou un admin
		
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
		
		//On evite de parcourir toute la liste d'étudiants pour trouver un prof ou un admin
		
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
	
	
	/**
	 * 
	 * 
	 * @param userLogin
	 * @return boolean
	 * 		Permet de savoir si un utilisateur est un admin 
	 */
	//fonction permettant de savoir si un utilisateur est un admin à partir de son login
	private boolean isAdmin(String userLogin){
		ArrayList<Admin> listAdmin = userDB.getAdmins();
		int i = 0;
		while(i < listAdmin.size()){
			if(listAdmin.get(i++).getLogin().equals(userLogin))
				return true;
		}
		return false;
	}
	/**
	 * 
	 * 
	 * @param userLogin
	 * @return boolean
	 * 		Permet de savoir si un utilisateur est un pofesseur 
	 */
	private boolean isTeacher(String userLogin){
		ArrayList<Professeur> listTeacher = userDB.getTeachers();
		int i = 0;
		while(i < listTeacher.size()){
			if(listTeacher.get(i++).getLogin().equals(userLogin))
				return true;
		}
		return false;
	}
	/**
	 * 
	 * 
	 * @param userLogin
	 * @return boolean
	 * 		Permet de savoir si un utilisateur est un etudiant 
	 */
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
		if(!isAdmin(adminLogin) || isAdmin(newAdminlogin) || isTeacher(newAdminlogin) || isStudent(newAdminlogin))
			return false;
		
		userDB.addAdmin(new Admin(newAdminlogin, surname, firstname, pwd, adminID));
						
		
		return true;
	}

	@Override
	public boolean addTeacher(String adminLogin, String newteacherLogin, int teacherID, String firstname,
			String surname, String pwd) {
		
		
		if(!isAdmin(adminLogin) || isAdmin(newteacherLogin) || isTeacher(newteacherLogin) || isStudent(newteacherLogin))
			return false;
		
		userDB.addTeacher(new Professeur(newteacherLogin, surname, firstname, pwd, teacherID));
						
		
		return true;
		
	}

	@Override
	public boolean addStudent(String adminLogin, String newStudentLogin, int studentID, String firstname,
			String surname, String pwd) {
		
		if(!isAdmin(adminLogin) || isAdmin(newStudentLogin) || isTeacher(newStudentLogin) || isStudent(newStudentLogin))
			return false;
		
		userDB.addStudent(new Etudiant(newStudentLogin, surname, firstname, pwd, studentID, -1));
						
		
		return true;
		
		
	}

	@Override
	public boolean removeUser(String adminLogin, String userLogin) {
		
		if(!isAdmin(adminLogin))
			return false;
		
		ArrayList<Etudiant> listStudent = userDB.getStudents();
		ArrayList<Professeur> listTeacher = userDB.getTeachers();
		ArrayList<Admin> listAdmin = userDB.getAdmins();
		
		if(isAdmin(userLogin)){
			int i = 0;
			while(i<listAdmin.size()){
				if(userLogin.equals(listAdmin.get(i).getLogin())){
					userDB.removeAdmin(i);
					return true;
				}
				i++;
			}
			
		}
		
		if(isTeacher(userLogin)){
			int i = 0;
			while(i<listTeacher.size()){
				if(userLogin.equals(listTeacher.get(i).getLogin())){
					userDB.removeTeacher(i);
					return true;
				}
				i++;
			}
			
		}
		
		if(isStudent(userLogin)){
			int i = 0;
			while(i<listStudent.size()){
				
				if(userLogin.equals(listStudent.get(i).getLogin())){
					
					ArrayList<Groupe> listGroup = userDB.getGroupes();
					int j =0;
					//le numero de groupe ne correspond pas à son index dans la liste
					while(j<listGroup.size()){
						if(listGroup.get(j).getId_groupe() == listStudent.get(i).getId_groupe())
							listGroup.get(j).removeEtudiant(listStudent.get(i));			
						j++;
					}
					userDB.removeStudent(i);
					
					return true;
				}
				i++;
			}
			
		}
		
		
		
		
		return false;
	}

	@Override
	public boolean addGroup(String adminLogin, int groupId) {
		
		if(!isAdmin(adminLogin))
			return false;
		
		ArrayList<Groupe> listGroupe = userDB.getGroupes();
		int i =0;
		while(i<listGroupe.size()){
			if(listGroupe.get(i).getId_groupe()==groupId)
				return false;
			i++;
		}
		
		userDB.addGroupe(new Groupe(groupId));
		
		return true;
	}

	@Override
	public boolean removeGroup(String adminLogin, int groupId) {
		if(!isAdmin(adminLogin))
			return false;
		
		ArrayList<Groupe> listGroupe = userDB.getGroupes();
		ArrayList<Etudiant> listStudent = userDB.getStudents();
		ArrayList<Etudiant> groupStudent=new ArrayList<Etudiant>();
		
		
		
		int i =0, j=0;
		
		while(i<listGroupe.size()){
			if(listGroupe.get(i).getId_groupe()==groupId)
				groupStudent = listGroupe.get(i).getEtudiants();
			i++;
		}
		
		i=0;
		while(i<groupStudent.size()){
			
			while(j<listStudent.size()){
				if(listStudent.get(j).equals(groupStudent.get(i)))
					listStudent.get(j).setGroupe(-1);	
				j++;
			}
			
			i++;
			j=0;
		}
		i=0;
		while(i<listGroupe.size()){
			if(listGroupe.get(i).getId_groupe()==groupId){
				listGroupe.remove(i);
				return true;
			}
			i++;
		}
		
		
		return false;
	}

	@Override
	public boolean associateStudToGroup(String adminLogin, String studentLogin, int groupId) {
		
		if(!isAdmin(adminLogin))
			return false;
		
		ArrayList<Etudiant> listStudent = userDB.getStudents();
		ArrayList<Groupe> listGroupe = userDB.getGroupes();
		Etudiant student = null;
		Groupe groupe=null;
		int i = 0;
		while(i<listStudent.size()){
			if(listStudent.get(i).getLogin().equals(studentLogin))
				student = listStudent.get(i);
			i++;
		}
		if(student==null)
			return false;
		
		i=0;
		while(i<listGroupe.size()){
			if(listGroupe.get(i).getId_groupe()==groupId)
				groupe=listGroupe.get(i);
			i++;
		}
		if (groupe==null)
			return false;
		
		
		student.setGroupe(groupId);
		groupe.addEtudiant(student);
		
		
		return true;
		
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
		
		//on recupère les logins des étudiants
		userLogins = this.studentsLoginToString();
		
		//On charge les listes administrateurs et professeurs
		ArrayList<Professeur> listTeacher = userDB.getTeachers();
		ArrayList<Admin> listAdmin = userDB.getAdmins();
		
		//On recupère le nombre d'éléments du tableau pour avoir l'index à utiliser
		int j=0, k = 0;
		for(Object o : userLogins)
			if(o != null) j++;
		
		
		//On récupère les logins des profs et admins qu'on rajoute à ceux presents dans le tableau
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
		
		    
			ArrayList<Admin> listAdmin = userDB.getAdmins();
			ArrayList<Etudiant> listStudent = userDB.getStudents();
			ArrayList<Professeur> listTeacher = userDB.getTeachers();
			ArrayList<Groupe> listGroup = userDB.getGroupes();
			
			
            Element racine = new Element("UsersDB");
	        	        
	        
	        int i = 0;
	        Element groups = new Element("Groups");
	        while(i<listGroup.size()){
	        	Groupe currentGroup = listGroup.get(i);
	        	Element group = new Element("Group");
	        	
	        	Element groupId = new Element("groupId");
	        	groupId.setText(Integer.toString(currentGroup.getId_groupe()));
	        	group.addContent(groupId);
	        	
	        	groups.addContent(group);
	        	
	        	i++;
	        }
	                
	        
	        racine.addContent(groups);
	        
	        i=0;
	        Element students = new Element("Students");
	        
	        while(i<listStudent.size()){
	        	Etudiant currentStudent = listStudent.get(i);
	        	
	        	Element student = new Element("Student");
	        	
	        	Element login = new Element("login");
	        	login.setText(currentStudent.getLogin());
	        	student.addContent(login);
	        	
	        	Element firstname = new Element("firstname");
	        	firstname.setText(currentStudent.getPrenom());
	        	student.addContent(firstname);
	        	
	        	Element surname = new Element("surname");
	        	surname.setText(currentStudent.getNom());
	        	student.addContent(surname);
	        	
	        	Element pwd = new Element("pwd");
	        	pwd.setText(currentStudent.getMdp());
	        	student.addContent(pwd);
	        	
	        	Element studentId = new Element("studentId");
	        	studentId.setText(Integer.toString(currentStudent.getId_etud()));
	        	student.addContent(studentId);
	        	
	        	Element groupId = new Element("groupId");
	        	groupId.setText(Integer.toString(currentStudent.getId_groupe()));
	        	student.addContent(groupId);
	        	
	        	students.addContent(student);
	        	
	        	i++;	        	
	        	
	        	
	        	 
	        }
	        
	        racine.addContent(students);
	        i=0;
	        Element teachers = new Element("Teachers");
	        
	        while(i<listTeacher.size()){
	        	Professeur currentTeacher = listTeacher.get(i);
	        	
	        	Element teacher = new Element("Teacher");
	        	
	        	Element login = new Element("login");
	        	login.setText(currentTeacher.getLogin());
	        	teacher.addContent(login);
	        	
	        	Element firstname = new Element("firstname");
	        	firstname.setText(currentTeacher.getPrenom());
	        	teacher.addContent(firstname);
	        	
	        	Element surname = new Element("surname");
	        	surname.setText(currentTeacher.getNom());
	        	teacher.addContent(surname);
	        	
	        	Element pwd = new Element("pwd");
	        	pwd.setText(currentTeacher.getMdp());
	        	teacher.addContent(pwd);
	        	
	        	Element studentId = new Element("teacherId");
	        	studentId.setText(Integer.toString(currentTeacher.getId_prof()));
	        	teacher.addContent(studentId);
	        	
	        	teachers.addContent(teacher);
	        	
	        	i++;
	        }
	        	        
	        racine.addContent(teachers);
	        
	        i=0;
	        Element admins = new Element("Administrators");
	        
	        while(i<listAdmin.size()){
	        	Admin currentAdmin = listAdmin.get(i);
	        	
	        	Element admin = new Element("Administrator");
	        	
	        	Element login = new Element("login");
	        	login.setText(currentAdmin.getLogin());
	        	admin.addContent(login);
	        	
	        	Element firstname = new Element("firstname");
	        	firstname.setText(currentAdmin.getPrenom());
	        	admin.addContent(firstname);
	        	
	        	Element surname = new Element("surname");
	        	surname.setText(currentAdmin.getNom());
	        	admin.addContent(surname);
	        	
	        	Element pwd = new Element("pwd");
	        	pwd.setText(currentAdmin.getMdp());
	        	admin.addContent(pwd);
	        	
	        	Element adminId = new Element("adminId");
	        	adminId.setText(Integer.toString(currentAdmin.getId_admin()));
	        	admin.addContent(adminId);
	        	
	        	admins.addContent(admin);
	        	
	        	i++;
	        }
	        
	        racine.addContent(admins);
	        
	        try
	        {
	        	

	           Document database = new Document(racine);
	           
	           XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
	           
	           sortie.output(database, new FileOutputStream(userDB.getFile()));
	        }
	        catch (java.io.IOException e){}
		return false;
	}

	public UserDB getUserDB() {
		return userDB;
	}

	public void setUserDB(UserDB userDB) {
		this.userDB = userDB;
	}
	
	

}

