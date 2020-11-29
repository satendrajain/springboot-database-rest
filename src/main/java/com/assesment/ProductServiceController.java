package com.assesment;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceController {
	private static Map<Integer, Servicecurrent> productRepo = new HashMap<>();
	Serviceaudit service = new Serviceaudit();
	@Autowired
	private ModuleRepository moduleRepository;
	@Autowired
	private ServiceRepository serviceRepository;
	@Autowired
	private ServiceAuditRepository serviceAuditRepository;

	@RequestMapping(value = "/servicecurrent", method = RequestMethod.POST)
	public ResponseEntity<Object> createService(@RequestParam String serviceName, @RequestParam String branchName,
			@RequestParam String envName) {
		serviceRepository.save(new Servicecurrent(serviceName, branchName, envName, new Date().toString()));
		serviceAuditRepository.save(new Serviceaudit(serviceName, branchName, envName, new Date().toString()));

		return new ResponseEntity<>(
				"Service " + serviceName + " for " + branchName + " in " + envName + "Started successfully",
				HttpStatus.CREATED);
	}

	// Get call
	@RequestMapping(value = "/serviceaudit")
	public ResponseEntity<Object> getserviceAudit(@RequestParam String serviceName, @RequestParam String moduleName,
			@RequestParam String envName) {
		List servicecurrentList = new ArrayList<Servicecurrent>();
		if ((serviceName == null || serviceName.equalsIgnoreCase("null"))
				&& (moduleName == null || moduleName.equalsIgnoreCase("null"))) {
			serviceRepository.findAll().forEach(x -> {
				System.out.println(x);
				servicecurrentList.add(x);
			});
			return new ResponseEntity<>(servicecurrentList.toString(), HttpStatus.OK);

		} else if (moduleName != null || !moduleName.equalsIgnoreCase("null")) {
			String moduleServiceName = moduleRepository.findByModule(moduleName).getServicename();
			serviceRepository.findByServicename(moduleServiceName).forEach(x -> {
				System.out.println(x);
				servicecurrentList.add(x);
			});
			return new ResponseEntity<>(servicecurrentList.toString(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Please provide Service or Module Name", HttpStatus.OK);
		}

	}

	// Get call
	@RequestMapping(value = "/serviceaudit/history")
	public ResponseEntity<Object> getserviceHistory(@RequestParam String serviceName, @RequestParam String moduleName,
			@RequestParam String envName) {
		List servicecurrentList = new ArrayList<Servicecurrent>();
		if ((serviceName == null || serviceName.equalsIgnoreCase("null"))
				&& (moduleName == null || moduleName.equalsIgnoreCase("null"))) {
			serviceAuditRepository.findAll().forEach(x -> {
				System.out.println(x);
				servicecurrentList.add(x);
			});
			return new ResponseEntity<>(servicecurrentList.toString(), HttpStatus.OK);

		} else if ((moduleName == null || moduleName.equalsIgnoreCase("null")) && (envName != null)
				|| !envName.equalsIgnoreCase("null")) {
			String moduleServiceName = moduleRepository.findByModule(moduleName).getServicename();
			serviceAuditRepository.findByServicename(moduleServiceName).forEach(x -> {
				System.out.println(x);
				if (x.getEnvironment().equalsIgnoreCase(envName))
					servicecurrentList.add(x);
			});
			return new ResponseEntity<>(servicecurrentList.toString(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Please provide Service or Module Name", HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/loadmasterdata")
	public void loadMasterData() {
		System.out.println("StartApplication...");

		moduleRepository.save(new Servicemaster("Search", "Find"));
		moduleRepository.save(new Servicemaster("Upload", "Store"));
		moduleRepository.save(new Servicemaster("Download", "Store"));
		moduleRepository.save(new Servicemaster("Compose", "Create"));

		System.out.println("\nfindAll()");
		moduleRepository.findAll().forEach(x -> System.out.println(x));

		serviceRepository.save(new Servicecurrent("Search", "LON", "QA", new Date().toString()));
		serviceRepository.save(new Servicecurrent("Search", "FRA", "DEV", new Date().toString()));
		serviceRepository.save(new Servicecurrent("Search", "MIL", "SIT", new Date().toString()));
		serviceRepository.save(new Servicecurrent("Upload", "LON", "SIT", new Date().toString()));
		serviceRepository.save(new Servicecurrent("Upload", "FRA", "DEV", new Date().toString()));
		serviceRepository.save(new Servicecurrent("Upload", "MIL", "QA", new Date().toString()));
		serviceRepository.save(new Servicecurrent("Download", "LON", "UAT", new Date().toString()));
		serviceRepository.save(new Servicecurrent("Download", "FRA", "DEV", new Date().toString()));
		serviceRepository.save(new Servicecurrent("Download", "MIL", "SIT", new Date().toString()));
		serviceRepository.save(new Servicecurrent("Compose", "LON", "UAT", new Date().toString()));
		serviceRepository.save(new Servicecurrent("Compose", "FRA", "DEV", new Date().toString()));
		serviceRepository.save(new Servicecurrent("Compose", "MIL", "SIT", new Date().toString()));

		System.out.println("\nfindAll()");
		serviceRepository.findAll().forEach(x -> System.out.println(x));

		serviceAuditRepository.save(new Serviceaudit("Search", "LON", "QA", new Date().toString()));
		serviceAuditRepository.save(new Serviceaudit("Search", "FRA", "DEV", new Date().toString()));
		serviceAuditRepository.save(new Serviceaudit("Search", "MIL", "SIT", new Date().toString()));
		serviceAuditRepository.save(new Serviceaudit("Upload", "LON", "SIT", new Date().toString()));
		serviceAuditRepository.save(new Serviceaudit("Upload", "FRA", "DEV", new Date().toString()));
		serviceAuditRepository.save(new Serviceaudit("Upload", "MIL", "QA", new Date().toString()));
		serviceAuditRepository.save(new Serviceaudit("Download", "LON", "UAT", new Date().toString()));
		serviceAuditRepository.save(new Serviceaudit("Download", "FRA", "DEV", new Date().toString()));
		serviceAuditRepository.save(new Serviceaudit("Download", "MIL", "SIT", new Date().toString()));
		serviceAuditRepository.save(new Serviceaudit("Compose", "LON", "UAT", new Date().toString()));
		serviceAuditRepository.save(new Serviceaudit("Compose", "FRA", "DEV", new Date().toString()));
		serviceAuditRepository.save(new Serviceaudit("Compose", "MIL", "SIT", new Date().toString()));

		System.out.println("\nfindAll()");
		serviceAuditRepository.findAll().forEach(x -> System.out.println(x));

	}
}