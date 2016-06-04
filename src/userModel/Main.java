package userModel;

import userController.UserController;
/**
 * Cette classe permet de tester les fonctions du contrôleur d'utilisateurs.
 * Elle crée une base de données de 6 utilisateurs et les sauvegarde dans le fichier "usersDB.xml". 
 * 
 * @author Jose Mennesson (Mettre à jour)
 * @version 04/2016 (Mettre à jour)
 * 
 */

//TODO Classe pouvant être modifiée suivant vos besoins

public class Main {
	/**
	 * Fonction principale 
	 * 
	 * @param args
	 * 			Les arguments donnés en entrée du programme.
	 * 
	 */
	public static void main(String[] args) {
		final String file="userDB.xml";
		UserController UC=new UserController(file);
		UC.loadDB();
		System.out.println(UC.groupsToString()[1]);
		System.out.println(UC.removeGroup("su", 3));
		UC.addAdmin("su", "admintest", 15, "toast", "toasty", "ok");
		UC.addTeacher("su", "teachertest", 15, "toast", "toasty", "ok");
		UC.addStudent("su", "studenttest", 15, "toast", "toasty", "ok");
		UC.addGroup("su", 1);
		UC.addGroup("su", 2);
		UC.associateStudToGroup("su", "studenttest", 1);
		System.out.println(UC.associateStudToGroup("su", "dzad", 4));

		System.out.println(UC.groupsToString()[1]);

		UC.saveDB();
	}
}
