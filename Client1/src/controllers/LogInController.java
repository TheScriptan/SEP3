package controllers;

import serverConnection.Connection;
import utils.Utils;

public class LogInController {

	public LogInController() {
		
	}
	
	public boolean validateLogin(Connection c, String cpr, String password, String role) {	
		Utils.SendRequest(c.getOutput(),
							Utils.Requests.LOGIN,
							cpr,
							password,
							role);
	
		return Utils.AcceptResponse(c.getInput()).getResponseCode().equals(Utils.Responses.LOGIN_VALID.toString());
		
	}
}
