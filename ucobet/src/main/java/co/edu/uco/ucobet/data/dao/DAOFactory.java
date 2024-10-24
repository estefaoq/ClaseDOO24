package co.edu.uco.ucobet.data.dao;

public abstract class DAOFactory {
	protected abstract void openConnection();
	protected abstract void initTransaction();
	protected abstract void commitTransaction();
	protected abstract void rollbackTransaction();
	protected abstract void closeConnection();
	
	public abstract CityDAO getCityDAO();
	public abstract CountryDAO get();
	

}
