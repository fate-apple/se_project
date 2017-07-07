package com.se.service.impl;

import com.se.dao.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class GenericServiceImpl<T, ID extends Serializable> {

	@Autowired
	private GenericRepository<T, ID> repository;

	// new record
	public void insert(T t) {
		repository.insert(t);
	}

	// update record
	public void save(T t) {
		repository.save(t);
	}

	public void delete(T t) {
		this.repository.delete(t);
	}

	public List<T> findAll() {
		return this.repository.findAll();
	}

	public T findById(ID id) {
		return repository.findOne(id);
	}
}
