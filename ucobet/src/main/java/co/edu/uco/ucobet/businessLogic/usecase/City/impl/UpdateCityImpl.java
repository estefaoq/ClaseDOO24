package co.edu.uco.ucobet.businessLogic.usecase.City.impl;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.businessLogic.adapter.entity.CityEntityAdapter;
import co.edu.uco.ucobet.businessLogic.usecase.City.UpdateCity;
import co.edu.uco.ucobet.crosscutting.exceptions.BusinessLogicUcoBetException;
import co.edu.uco.ucobet.data.dao.DAOFactory;
import co.edu.uco.ucobet.domain.CityDomain;

public final class UpdateCityImpl implements UpdateCity {

	@Override
	public void execute(final CityDomain data) {
		
		//politicas
		
		var cityEntity = CityEntityAdapter.getCityEntityAdapter().adaptSource(data);
		daoFactory.getCityDao().update(cityEntity);
		
	}
	
	private void setDaoFactory(final DAOFactory daoFactory) {
		if (ObjectHelper.isNull(daoFactory)) {
			var userMessage = "se ha presentado un probelma inesperado tratando de llevar a cabo la modificacion de la informas de la cuidad deseada";
			var technicalMessage = "el dao factory requerido para crearf la calse que actualiza la ciudad lleo null";
			throw BusinessLogicUcoBetException.create(userMessage, technicalMessage);
		}
		this.daoFactory = daoFactory;
	}
	
	

}
