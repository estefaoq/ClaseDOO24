package co.edu.uco.ucobet.businessLogic.adapter.entity;

import co.edu.uco.ucobet.businessLogic.adapter.Adapter;
import co.edu.uco.ucobet.domain.CityDomain;
import co.edu.uco.ucobet.entity.CityEntity;

public final class CityEntityAdapter implements Adapter<CityEntity, CityDomain>{
	
	private static final Adapter<CityEntity, CityDomain> instance = new CityEntityAdapter();
	
	private CityEntityAdapter() {
		
	}
	
	public static Adapter<CityEntity, CityDomain> getCityEntityAdapter(){
		return instance;
		
	}

	@Override
	public CityEntity adaptSorurce(CityDomain data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CityDomain adaptTarget(CityEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

}
