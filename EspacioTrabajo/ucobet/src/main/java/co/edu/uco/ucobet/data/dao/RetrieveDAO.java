package co.edu.uco.ucobet.data.dao;

import java.util.List;

 interface RetrieveDAO <T, I>{
	T findByID(I id);
	
	List<T> findALL();
	List<T> findByFilter(T filter);

}