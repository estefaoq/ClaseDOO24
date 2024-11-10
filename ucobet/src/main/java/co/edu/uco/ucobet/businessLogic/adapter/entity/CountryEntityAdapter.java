package co.edu.uco.ucobet.businessLogic.adapter.entity;

import java.util.List;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.businessLogic.adapter.Adapter;
import co.edu.uco.ucobet.domain.CountryDomain;
import co.edu.uco.ucobet.domain.StateDomain;
import co.edu.uco.ucobet.entity.CountryEntity;
import co.edu.uco.ucobet.entity.StateEntity;

public class CountryEntityAdapter implements Adapter<CountryDomain, CountryEntity> {
	
private static final Adapter<StateDomain, StateEntity> instance = new StateEntityAdapter();
	
	private CountryEntityAdapter() {
		
	}
	
	public static Adapter<StateDomain, StateEntity> getCityEntityAdapter(){
		return instance;
	}
	
	
	public CountryDomain adaptSource(final CountryEntity data) {
		var entityToAdapt = ObjectHelper.getDefault(data,new CountryEntity());
		return CountryDomain.create(entityToAdapt.getId(),entityToAdapt.getName());
		
	}
	
	public CountryEntity adaptTarget(final CountryDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, CountryDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY));
		var entityAdapted = new CountryEntity();
		entityAdapted.setId(domainToAdapt.getId());
		entityAdapted.setName(domainToAdapt.getName());
		
		
		return  entityAdapted;
	}

	@Override
	public CountryDomain adaptSorurce(CountryEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CountryEntity> adaptTarget(List<CountryDomain> data) {
		// TODO Auto-generated method stub
		return null;
	}

}
