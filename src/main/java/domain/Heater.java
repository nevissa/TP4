package domain;
import domain.SmartDevices;

import javax.persistence.*;
@Entity
//@DiscriminatorValue(value="chauffage")

public class Heater extends SmartDevices {

	 
private String power;

public String getPower() {
	return power;
}

public void setPower(String power) {
	this.power = power;
}

}
