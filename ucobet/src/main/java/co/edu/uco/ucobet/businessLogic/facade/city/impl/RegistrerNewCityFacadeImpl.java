package co.edu.uco.ucobet.businessLogic.facade.city.impl;

import co.edu.uco.ucobet.businessLogic.adapter.dto.CityDTOAdapter;
import co.edu.uco.ucobet.businessLogic.facade.city.RegisterNewCityFacade;
import co.edu.uco.ucobet.businessLogic.usecase.City.impl.RegisterNewCityImpl;
import co.edu.uco.ucobet.crosscutting.exceptions.DataUcoBetException;
import co.edu.uco.ucobet.crosscutting.exceptions.UcoBetException;
import co.edu.uco.ucobet.data.dao.DAOFactory;
import co.edu.uco.ucobet.data.dao.enums.DAOSource;
import co.edu.uco.ucobet.dto.CityDTO;

public class RegistrerNewCityFacadeImpl implements RegisterNewCityFacade {

	@Override
	public void execute(CityDTO data) {
		
		var factory = DAOFactory.getFactory(DAOSource.SQLSERVER);
		
		try {
			factory.initTransaction();
			
			var registerNewCityUseCase = new RegisterNewCityImpl(factory);
			var cityDomain = CityDTOAdapter.getCityDTOAdapter().adaptSource(data);
				
		
			
			registerNewCityUseCase.execute(cityDomain);
			
			factory.commitTransaction();
			
		}catch(final UcoBetException exception) {
			
			factory.rollbackTransaction();
			
			throw exception;
		}catch(final Exception exception) {
			
			factory.rollbackTransaction();
			
			var userMessage = "se ha presentado un problema inesperado  tratando de registrar la informacion de la neva ciudad.";
			var technicalMessage = " se ha presentado n problema inesperado registrando la informacion de la cuidad.porfavor revisar";
			throw DataUcoBetException.crear(userMessage, technicalMessage, exception);
		}finally {
			factory.closeConnection();
		}
	}

	@Override
	public void excute(CityDTO data) {
		// TODO Auto-generated method stub
		
	}

}
