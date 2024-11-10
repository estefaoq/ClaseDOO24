package co.edu.uco.ucobet.businessLogic.usecase.City.rules.impl;

import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.businessLogic.usecase.City.rules.CityNameConsistencyIsValid;
import co.edu.uco.ucobet.crosscutting.exceptions.BusinessLogicUcoBetException;
import co.edu.uco.ucobet.data.dao.DAOFactory;



public final class CityNameConsistencyIsValidImpl implements CityNameConsistencyIsValid {
	
	@Override
	public void execute(final String data) {
		validateNotNull(data);
		validateLen(data);
		validateFormat(data);

	}
		
		
	
	private void validateLen(final String data) {
		if(!TextHelper.maxLenIsValid(data, 50)) {
			 var userMessage ="el nombre de la cuidad puede contener 50 caracteres";
			 throw BusinessLogicUcoBetException.crear(userMessage); 
		 }
		
	}
	

	private void validateFormat(final String data) {
		if(!TextHelper.containsOnlyLettersAndSpaces(data)) {
			 var userMessage ="el nombre de la cuidad solo puede contener letas y espacios";
			 throw BusinessLogicUcoBetException.crear(userMessage); 
		 }
	}
	

	private void validateNotNull(final String data) {
		if(TextHelper.isEmpty(data)) {
			 var userMessage ="no existe un departamento con el identificador " + data.toString();
			 throw BusinessLogicUcoBetException.crear(userMessage); 
		 }
			
    }



	@Override
	public void execute(String data, DAOFactory factory) {
		// TODO Auto-generated method stub
		
	}



	



	
}