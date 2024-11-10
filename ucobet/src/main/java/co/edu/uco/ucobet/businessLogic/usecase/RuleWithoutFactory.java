package co.edu.uco.ucobet.businessLogic.usecase;

import co.edu.uco.ucobet.data.dao.DAOFactory;

public interface RuleWithoutFactory <T> {
	void execute(T data, DAOFactory factory);

}
