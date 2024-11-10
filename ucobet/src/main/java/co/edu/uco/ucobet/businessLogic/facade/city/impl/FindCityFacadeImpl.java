package co.edu.uco.ucobet.businessLogic.facade.city.impl;

import java.util.List;

import co.edu.uco.ucobet.businessLogic.adapter.dto.CityDTOAdapter;
import co.edu.uco.ucobet.businessLogic.facade.city.FindCityFacade;
import co.edu.uco.ucobet.businessLogic.usecase.City.impl.FindCityImpl;
import co.edu.uco.ucobet.businessLogic.usecase.City.impl.RegisterNewCityImpl;
import co.edu.uco.ucobet.crosscutting.exceptions.DataUcoBetException;
import co.edu.uco.ucobet.crosscutting.exceptions.UcoBetException;
import co.edu.uco.ucobet.data.dao.DAOFactory;
import co.edu.uco.ucobet.data.dao.enums.DAOSource;
import co.edu.uco.ucobet.dto.CityDTO;

public class FindCityFacadeImpl implements FindCityFacade{
	
	

	@Override
	public List<CityDTO> excute(CityDTO data) {
		var factory = DAOFactory.getFactory(DAOSource.SQLSERVER);
		
		try {
			
			var findyCityUseCase = new FindCityImpl(factory);
			
			var cityDomain = CityDTOAdapter.getCityDTOAdapter().adaptSource(data);
			
			var resultsAsDto = CityDTOAdapter.getCityDTOAdapter().adaptTarget(findCityUseCase.execute(cityDomain));
			
			return resultsAsDto.getCityDTOAdapter().adaptTarget(findCityUseCase.excute(cityDomain));
			
			

				
		}catch(final UcoBetException exception) {
			
			
			throw exception;
		}catch(final Exception exception) {
			
			
			var userMessage = "se ha presentado un problema  tratando de consultar la informacion de la nueva ciudades.";
			var technicalMessage = " se ha presentado n problema inesperado registrando la informacion de la cuidad.porfavor revisar";
			throw DataUcoBetException.crear(userMessage, technicalMessage, exception);
		}finally {
			factory.closeConnection();
		}
	}
		return null;
	}

}
