package co.edu.uco.ucobet.businessLogic.adapter;

import java.util.List;

public interface Adapter<D,T> {
	D adaptSorurce(T data);
	T adaptTarget(D data);
	
	List<T> adaptTarget(List<D>data);

}
