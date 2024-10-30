package co.edu.uco.ucobet.businessLogic.adapter.dto;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.businessLogic.adapter.Adapter;
import co.edu.uco.ucobet.domain.CountryDomain;
import co.edu.uco.ucobet.domain.StateDomain;
import co.edu.uco.ucobet.dto.CountryDTO;
import co.edu.uco.ucobet.dto.StateDTO;

public final class CountryDTOAdapter implements Adapter<CountryDomain, CountryDTO>{
	
	
	private static final Adapter<CountryDomain, CountryDTO> instance = new CountryDTOAdapter();
	
	private CountryDTOAdapter() {
		
		
	}
	
	public static Adapter<CountryDomain, CountryDTO> getCityDTOAdapter(){
		return instance;
	 
		
	}
	
	
	public CountryDomain adaptSource(final CountryDTO data) {
		var dtoToAdapt = ObjectHelper.getDefault(data, CountryDTO.create());
		return CountryDomain.create(UUIDHelper.convertToUUID(dtoToAdapt.getId()), data.getName());
		
	}
	
	public CountryDTO adaptTarget(final CountryDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, CountryDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY));
		return CountryDTO.create().setId("").setName(domainToAdapt.getName());
		
	}

}