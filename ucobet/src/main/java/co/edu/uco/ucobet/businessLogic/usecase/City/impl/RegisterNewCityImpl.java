package co.edu.uco.ucobet.businessLogic.usecase.City.impl;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.businessLogic.adapter.entity.CityEntityAdapter;
import co.edu.uco.ucobet.businessLogic.usecase.City.RegisterNewCity;
import co.edu.uco.ucobet.businessLogic.usecase.City.rules.impl.CityNameConsistencyIsValidImpl;
import co.edu.uco.ucobet.businessLogic.usecase.City.rules.impl.CityNameDoesNotExistsForStateImpl;
import co.edu.uco.ucobet.businessLogic.usecase.City.state.rules.impl.StateExistsImpl;
import co.edu.uco.ucobet.crosscutting.exceptions.BusinessLogicUcoBetException;
import co.edu.uco.ucobet.data.dao.DAOFactory;
import co.edu.uco.ucobet.domain.CityDomain;
import co.edu.uco.ucobet.businessLogic.usecase.City.rules.CityNameConsistencyIsValid;
import co.edu.uco.ucobet.businessLogic.usecase.City.rules.CityNameDoesNotExistsForState;

public final class RegisterNewCityImpl implements RegisterNewCity{
	
	private DAOFactory daoFactory;
	private CityNameDoesNotExistsForStateImpl cityNameDoesNotExistsForState= new CityNameDoesNotExistsForStateImpl();
	private StateExistsImpl stateExists = new StateExistsImpl();
	private CityNameConsistencyIsValidImpl cityNameConsistencyIsValid = new CityNameConsistencyIsValidImpl();
	
	public RegisterNewCityImpl (final DAOFactory daoFactory) {
		setDaoFactory(daoFactory);
	}

	@Override
	public void execute(final CityDomain data) {
		
		cityNameConsistencyIsValid.execute(data.getName());
		cityNameDoesNotExistsForState.execute(data, daoFactory);
		stateExists.execute(data.getState().getId(), daoFactory);
		
		var CityDomainToMap = CityDomain.create(generateId(), data.getName(), data.getState());
		var cityEntity = CityEntityAdapter.getCityEntityAdapter().adaptSorurce(data);
		daoFactory.getCityDAO().create(cityEntity);
		
		
		
	}
	
	private UUID generateId() {
		var id = UUIDHelper.generate();
		var cityEntity = daoFactory.getCityDAO().findByID(id);
		
		if (UUIDHelper.isEqual(cityEntity.getId(), id)) {
			id = generateId();
		}
		 return id;
		
		}
	
	private void setDaoFactory(final DAOFactory daoFactory) {
		if (ObjectHelper.isNull(daoFactory)) {
			var userMessage = "se ha presentado un problema inesperado inesperado, tratando de llevar a cabo la modificación de la información de la cuidad deseada.porfavor intenta de nuevo y si el problema persiste llame a luz mery rios Alzate..";
			var technicalMessage = "El dao factory requerido para crear la clase que se actualiza la cuidad llegó nula.";
			throw BusinessLogicUcoBetException.crear(userMessage, technicalMessage);
		}
		this.daoFactory = daoFactory;
	}

}