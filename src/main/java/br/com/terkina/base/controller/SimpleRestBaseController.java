package br.com.terkina.base.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class SimpleRestBaseController<T, ID, Repository extends JpaRepository<T, ID>> {
	
	@Autowired
	protected Repository repository;
	
	@GetMapping
	public List<T> findAll() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public T findById(@PathVariable("id") ID id) {
		Optional<T> t = repository.findById(id);
		return t.orElse(null);
	}

	@PostMapping
	public T save(@RequestBody T entity) {
		return (T)repository.saveAndFlush(entity);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") ID id) {
		repository.deleteById(id);
	}

}