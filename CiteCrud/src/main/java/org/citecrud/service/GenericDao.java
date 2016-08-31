package org.citecrud.service;

import java.util.List;


public interface GenericDao<E, K, T> {

	void add(E entity);

	void update(E entity);

	void remove(E entity);

	E find(K key);

	List<E> list();
	
	List<E> findByName(T name);
	
	E findbyId(K key);


}
