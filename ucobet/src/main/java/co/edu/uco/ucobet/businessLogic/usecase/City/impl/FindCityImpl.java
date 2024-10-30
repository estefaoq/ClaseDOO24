package co.edu.uco.ucobet.businessLogic.usecase.City.impl;

import java.util.List;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.businessLogic.usecase.City.FindCity;
import co.edu.uco.ucobet.data.dao.DAOFactory;
import co.edu.uco.ucobet.domain.CityDomain;

public final class FindCityImpl implements FindCity{
	
	private DAOFactory daoFactory;
	
	public UpdateCityImpl(DAOFactory daoFactory) {
		setDaoFactory(daoFactory);
		
	}
	
	@Override
	public List<CityDomain> execute(final CityDomain data) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void setDaoFactory(final DAOFactory daoFactory) {
		
		if (ObjectHelper.isNull(daoFactory)) {
			
		}
		
		this.daoFactory = daoFactory;
	}
	

}
