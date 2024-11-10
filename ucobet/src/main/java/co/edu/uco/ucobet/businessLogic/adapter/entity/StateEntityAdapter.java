package co.edu.uco.ucobet.businessLogic.adapter.entity;

import java.util.List;

import co.edu.uco.ucobet.businessLogic.adapter.Adapter;
import co.edu.uco.ucobet.domain.StateDomain;
import co.edu.uco.ucobet.entity.StateEntity;

public class StateEntityAdapter implements Adapter<StateDomain, StateEntity> {
	
private static final Adapter<StateDomain, StateEntity> instance = new StateEntityAdapter();
	
	StateEntityAdapter() {
		
	}
	
	public static Adapter<StateDomain, StateEntity> getStateEntityAdapter(){
		return instance;
	}
	
	
	public StateDomain adaptSource(StateEntity data) {
		return null;
	}
	
	public StateEntity adaptTarget(StateDomain data) {
		return null;
	}

	@Override
	public StateDomain adaptSorurce(StateEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateEntity> adaptTarget(List<StateDomain> data) {
		// TODO Auto-generated method stub
		return null;
	}


}
