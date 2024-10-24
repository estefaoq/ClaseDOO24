package co.edu.uco.ucobet.businessLogic.adapter.dto;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.domain.CountryDomain;
import co.edu.uco.ucobet.dto.CountryDTO;

public final class CountryDTOAdapter implements Adapter<CountryDomain, CountrDTO>{
	
	public CountryDomain adaptSource(final CountryDTO data) {
		var dtoToAdapt = ObjectHelper.getDefault(data, CountryDTO.create());
		return CountryDomain.create(UUIDHelper.convertToUUID(dtoToAdapt.getId()), data.getName());
		
	}
	
	public CountryDTO adaptTarget(final CountryDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, CountryDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY));
		return CountryDTO.create().setId("").setName(domainToAdapt.getName());
		
	}

}
