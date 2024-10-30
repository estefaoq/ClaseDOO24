package co.edu.uco.ucobet.businessLogic.adapter;

public interface Adapter<D,T> {
	D adaptSorurce(T data);
	T adaptTarget(D data);

}
