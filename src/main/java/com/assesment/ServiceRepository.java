package com.assesment;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServiceRepository extends CrudRepository<Servicecurrent, Long> {

	List<Servicecurrent> findByServicename(String moduleServiceName);
}
