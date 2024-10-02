package co.edu.uco.ucobet.entity;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;

public class StateEntity extends DomainDTO{
	
	private String name;
	private CountryDTO country;
	
	public StateEntity() {
		super(UUIDHelper.getDefaultAsString());
		setName(TextHelper.EMPTY);
		setcountry(CountryDTO.create());
		
	}
	
	public static final StateEntity create() {
		return new StateEntity();
	}
	
	public String getName() {
		return name;
	}


}
