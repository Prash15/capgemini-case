package capgemini.code.assessment.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "household_appliances")
public class Appliance {

	private long id;
	private String serialNumber;
	private String brand;
	private String model;
	private Boolean status;
	private Date dateBought;
	
	public Appliance() {
		
	}

	public Appliance(long id, String serialNumber, String brand, String model, Boolean status,
			Date dateBought) {
		this.id = id;
		this.serialNumber = serialNumber;
		this.brand = brand;
		this.model = model;
		this.status = status;
		this.dateBought = dateBought;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "serial_number", nullable = false)
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Column(name = "brand", nullable = false)
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Column(name = "model", nullable = false)
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "status", nullable = false)
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Column(name = "date_bought", nullable = false)
	public Date getDateBought() {
		return dateBought;
	}

	public void setDateBought(Date dateBought) {
		this.dateBought = dateBought;
	}

	@Override
	public String toString() {
		return "HouseholdAppliances [id=" + id + ", serialNumber=" + serialNumber + ", brand=" + brand + ", model="
				+ model + ", status=" + status + ", dateBought=" + dateBought + "]";
	}
	
}
