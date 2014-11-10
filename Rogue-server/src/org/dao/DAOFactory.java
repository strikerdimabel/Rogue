package dao;

public class DAOFactory {

	private static final DAO INSTANCE = new DAOImpl();

	public static DAO getDAO() {
		return INSTANCE;
	}
	
}
