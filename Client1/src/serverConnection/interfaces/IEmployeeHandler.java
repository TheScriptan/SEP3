package serverConnection.interfaces;

import models.Employee;
import serverConnection.Connection;
import utils.Response;

public interface IEmployeeHandler {

	public Response addEmployee(Connection c, Employee employee);
	public Response editEmployee(Connection c, Employee employee);
	public Response removeEmployee(Connection c, String employeeId);
	public Response getAllEmployees(Connection c);
}