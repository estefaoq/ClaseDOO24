package co.edu.uco.ucobet.businessLogic.adapter.dto;

import co.edu.uco.ucobet.businessLogic.adapter.Adapter;
import co.edu.uco.ucobet.domain.StateDomain;
import co.edu.uco.ucobet.dto.StateDTO;

public final class StateDTOAdapter implements Adapter<StateDomain, StateDTO>{
	
	private static final Adapter<StateDomain, StateDTO> instance = new StateDTOAdapter();
	
	private StateDTOAdapter() {
		
		
	}
	
	public static Adapter<StateDomain, StateDTO> getStateDTOAdapter(){
		return instance;
		
	}
	
	public StateDomain adaptSource(StateDTO data) {
		return null;
		
	}
	public StateDTO adaptTarget(StateDomain data) {
		return null;
	}
	

}
