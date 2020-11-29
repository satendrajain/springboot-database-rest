package com.assesment;

import org.springframework.data.repository.CrudRepository;

public interface ModuleRepository extends CrudRepository<Servicemaster, String> {

	Servicemaster findByModule(String moduleName);

}
