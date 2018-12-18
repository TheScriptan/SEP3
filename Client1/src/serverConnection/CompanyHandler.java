package serverConnection;


import models.Company;
import serverConnection.interfaces.ICompanyHandler;
import utils.Response;
import utils.Utils;

public class CompanyHandler implements ICompanyHandler{

	@Override
	public Response addCompany(Connection c, Company company) {
		Utils.SendRequest(c.getOutput(), Utils.Requests.ADD_COMPANY, Utils.serializeObject(company));
		return Utils.AcceptResponse(c.getInput());
	}

	@Override
	public Response editCompany(Connection c, Company company) {
		Utils.SendRequest(c.getOutput(), Utils.Requests.EDIT_COMPANY, Utils.serializeObject(company));
		return Utils.AcceptResponse(c.getInput());
	}

	@Override
	public Response removeCompany(Connection c, long companyId) {
		Utils.SendRequest(c.getOutput(), Utils.Requests.EDIT_COMPANY, companyId +" ");	
		return Utils.AcceptResponse(c.getInput());
	}

	@Override
	public Response getAllCompanies(Connection c) {
		Utils.SendRequest(c.getOutput(), Utils.Requests.FIND_ALL_COMPANIES, "");
		return Utils.AcceptResponse(c.getInput());
	}
	
	public Response getCompanyById(Connection c, Long id) {
		Utils.SendRequest(c.getOutput(), Utils.Requests.FIND_COMPANY, id+"");
		return Utils.AcceptResponse(c.getInput());
	}

}
