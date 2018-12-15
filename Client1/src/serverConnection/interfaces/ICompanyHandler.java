package serverConnection.interfaces;

import models.Company;
import serverConnection.Connection;
import utils.Response;

public interface ICompanyHandler {

	public Response addCompany(Connection c, Company company);
	public Response editCompany(Connection c, Company company);
	public Response removeCompany(Connection c, long companyId);
	public Response getAllCompanies(Connection c);
}
