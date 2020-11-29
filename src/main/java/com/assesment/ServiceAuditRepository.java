package com.assesment;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ServiceAuditRepository extends CrudRepository<Serviceaudit, Integer> {

	List<Serviceaudit> findByServicename(String moduleServiceName);
}
