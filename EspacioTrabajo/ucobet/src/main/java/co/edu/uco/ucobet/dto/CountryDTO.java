package co.edu.uco.ucobet.dto;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;

public class CountryDTO extends DomainDTO{
	
	private String name;
	
	public CountryDTO() {
		super(UUIDHelper.getDefaultAsString());
		setName(name);
	}

	public static final CountryDTO create() {
		return new CountryDTO();
		
	}
	public String getName() {
		return name;
	}
	
	public CountryDTO setName(final String name) {
		this.name = TextHelper.applyTrim (name);
		return this;
		
	}
	
	@Override
	public String getId() {
		return super.getId();
	}

}