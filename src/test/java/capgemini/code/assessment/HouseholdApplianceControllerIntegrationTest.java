package capgemini.code.assessment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import capgemini.code.assessment.Application;
import capgemini.code.assessment.model.Appliance;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HouseholdApplianceControllerIntegrationTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetAllAppliances() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/appliances",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
	}

	@Test
	public void testGetApplianceById() {
		Appliance appliance = restTemplate.getForObject(getRootUrl() + "/appliances/1", Appliance.class);
		System.out.println(appliance.getSerialNumber());
		assertNotNull(appliance);
	}

	@Test
	public void testCreateAppliance() {
		Appliance appliance= new Appliance();
		appliance.setSerialNumber("Serial Number");
		appliance.setBrand("Brand");
		appliance.setModel("Model");
		appliance.setStatus(true);
		appliance.setDateBought(new Date());

		ResponseEntity<Appliance> postResponse = restTemplate.postForEntity(getRootUrl() + "/appliances", appliance, Appliance.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdateAppliance() {
		int id = 1;
		Appliance appliance= restTemplate.getForObject(getRootUrl() + "/appliances/" + id, Appliance.class);
		appliance.setSerialNumber("Serial Number1");
		appliance.setBrand("Brand2");

		restTemplate.put(getRootUrl() + "/appliances/" + id, appliance);

		Appliance updatedAppliance = restTemplate.getForObject(getRootUrl() + "/appliances/" + id, Appliance.class);
		assertNotNull(updatedAppliance);
	}

	@Test
	public void testDeleteAppliance() {
		int id = 2;
		Appliance appliance = restTemplate.getForObject(getRootUrl() + "/appliances/" + id, Appliance.class);
		assertNotNull(appliance);

		restTemplate.delete(getRootUrl() + "/appliances/" + id);

		try {
			appliance = restTemplate.getForObject(getRootUrl() + "/appliances/" + id, Appliance.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}
