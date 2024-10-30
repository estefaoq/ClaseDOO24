package co.edu.uco.ucobet.businessLogic.adapter.dto;

import co.edu.uco.ucobet.businessLogic.adapter.Adapter;
import co.edu.uco.ucobet.domain.CityDomain;
import co.edu.uco.ucobet.domain.CountryDomain;
import co.edu.uco.ucobet.dto.CityDTO;
import co.edu.uco.ucobet.dto.CountryDTO;

public class CityDTOAdapter implements Adapter<CityDomain, CityDTO> {
	
private static final Adapter<CityDomain, CityDTO> instance = new CityDTOAdapter();
	
	private CityDTOAdapter() {
		
		
	}
	
	public static Adapter<CityDomain, CityDTO> getCityDTOAdapter(){
		return instance;
		
		
	}
	
	public CityDomain adaptSource(CityDTO data) {
		return null;
	}
	
	public CityDTO adaptTarget(CityDomain data) {
		return null;
	}

}
