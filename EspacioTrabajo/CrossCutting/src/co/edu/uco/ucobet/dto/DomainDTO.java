package co.edu.uco.ucobet.dto;

import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;

public class DomainDTO {
	private String id;
	
	protected DomainDTO(final String id) {
		setId(id);
		
	}

	protected String getId() {
		return id;
	}

	protected void setId(final String id) {
		this.id = TextHelper.getDefault(id, UUIDHelper.getDefaultAsString());
	}
	

}
