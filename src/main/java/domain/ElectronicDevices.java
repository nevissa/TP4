package domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorValue(value="electronique")

public class ElectronicDevices extends SmartDevices{


private Double consomm;
	

	public Double getConsoom() {
		return consoom;
	}
	public void setConsoom(Double consoom) {
		this.consoom = consoom;
	}
	private Double consoom;

}
