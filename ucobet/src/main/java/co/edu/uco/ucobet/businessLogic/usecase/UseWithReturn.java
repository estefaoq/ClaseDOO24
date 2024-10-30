package co.edu.uco.ucobet.businessLogic.usecase;

public interface UseWithReturn <D, R> {
	
	R execute(D data);

}
