package domain;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/*  cas heritage avec table par classe
 * @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

 * */
 
//@DiscriminatorColumn(name="TYPE_DEVICE")
//@DiscriminatorValue(value="smart")
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
 @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
 

@Entity

public class SmartDevices {
	private int id;
	@Id
/* cas pour heritage par table	@GeneratedValue(strategy=GenrationType.TABLE)
*/
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
