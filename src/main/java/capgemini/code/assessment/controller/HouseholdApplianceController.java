package capgemini.code.assessment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import capgemini.code.assessment.exception.ResourceNotFoundException;
import capgemini.code.assessment.model.Appliance;
import capgemini.code.assessment.repository.HouseholdApplianceRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class HouseholdApplianceController {
	@Autowired
	private HouseholdApplianceRepository householdApplianceRepository;

	@GetMapping("/appliances")
	public List<Appliance> getAllAppliances() {
		return householdApplianceRepository.findAll();
	}

	@GetMapping("/appliances/{id}")
	public ResponseEntity<Appliance> getApplianceById(@PathVariable(value = "id") Long applianceId)
			throws ResourceNotFoundException {
		Appliance appliance= householdApplianceRepository.findById(applianceId)
				.orElseThrow(() -> new ResourceNotFoundException("Appliance not found for this id :: " + applianceId));
		return ResponseEntity.ok().body(appliance);
	}

	@PostMapping("/appliances")
	public Appliance createAppliance(@Valid @RequestBody Appliance appliance) {
		List<Appliance> applianceObj= 
				householdApplianceRepository.findBySerialNumberAndBrandAndModel
				(appliance.getSerialNumber(), appliance.getBrand(), appliance.getModel());
		if (applianceObj.size()>0) {
		  return null;
		} else {
		  return householdApplianceRepository.save(appliance);
		}		
	}

	@PutMapping("/appliances/{id}")
	public ResponseEntity<Appliance> updateAppliance(@PathVariable(value = "id") Long applianceId,
			@Valid @RequestBody Appliance applianceDetails) throws ResourceNotFoundException {
		Appliance appliance = householdApplianceRepository.findById(applianceId)
				.orElseThrow(() -> new ResourceNotFoundException("Appliance not found for this id :: " + applianceId));
		appliance.setSerialNumber(applianceDetails.getSerialNumber());
		appliance.setBrand(applianceDetails.getBrand());
		appliance.setModel(applianceDetails.getModel());
		appliance.setStatus(applianceDetails.getStatus());
		final Appliance updatedAppliance = householdApplianceRepository.save(appliance);
		return ResponseEntity.ok(updatedAppliance);
	}

	@DeleteMapping("/appliances/{id}")
	public Map<String, Boolean> deleteAppliance(@PathVariable(value = "id") Long applianceId)
			throws ResourceNotFoundException {
		Appliance appliance = householdApplianceRepository.findById(applianceId)
				.orElseThrow(() -> new ResourceNotFoundException("Appliance not found for this id :: " + applianceId));
		householdApplianceRepository.delete(appliance);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
