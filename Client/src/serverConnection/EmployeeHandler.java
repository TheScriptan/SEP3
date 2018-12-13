package serverConnection;


import models.Employee;
import serverConnection.interfaces.IEmployeeHandler;
import utils.Response;
import utils.Utils;

public class EmployeeHandler implements IEmployeeHandler{

	@Override
	public Response addEmployee(Connection c, Employee employee) {
		Utils.SendRequest(c.getOutput(), Utils.Requests.ADD_EMPLOYEE, Utils.serializeObject(employee));
		return Utils.AcceptResponse(c.getInput());
	}

	@Override
	public Response editEmployee(Connection c, Employee employee) {
		Utils.SendRequest(c.getOutput(), Utils.Requests.EDIT_EMPLOYEE, Utils.serializeObject(employee));
		return Utils.AcceptResponse(c.getInput());
	}

	@Override
	public Response removeEmployee(Connection c, String employeeId) {
		Utils.SendRequest(c.getOutput(), Utils.Requests.EDIT_EMPLOYEE, employeeId.toString());	
		return Utils.AcceptResponse(c.getInput());
	}

	@Override
	public Response getAllEmployees(Connection c) {
		Utils.SendRequest(c.getOutput(), Utils.Requests.FIND_ALL_EMPLOYEES, "");
		return Utils.AcceptResponse(c.getInput());
	}

}
