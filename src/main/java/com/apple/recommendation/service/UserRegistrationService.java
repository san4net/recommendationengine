package com.apple.recommendation.service;

import java.util.Collection;
import java.util.List;

import com.apple.recommendation.model.UserDetail;

/**
 * 
 * @author santoshkumar
 *
 * @param <T>
 */
public interface UserRegistrationService<T,S> {

	/**
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public boolean add(T t) throws Exception;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public T get(S id);
	
	public Collection<T> getAll();
	

}
