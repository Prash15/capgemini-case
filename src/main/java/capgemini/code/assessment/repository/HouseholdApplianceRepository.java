package capgemini.code.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import capgemini.code.assessment.model.Appliance;

@Repository
public interface HouseholdApplianceRepository extends JpaRepository<Appliance, Long>{
	List<Appliance> findBySerialNumberAndBrandAndModel(String serialNumber, String brand, String model);
}
