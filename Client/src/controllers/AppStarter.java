package controllers;

public class AppStarter {

	public static void main(String[] args) {

		// Initialize view
		
		// Connect to server
		
		UserController rootApp = new UserController();
		rootApp.start();
	}

}
