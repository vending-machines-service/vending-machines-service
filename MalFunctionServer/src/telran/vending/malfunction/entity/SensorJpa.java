package telran.vending.malfunction.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name ="current_malfunction")
@Entity
public class SensorJpa {
	@Id
	@GeneratedValue
	int id;
	@Column(name = "date")
	public LocalDate currentDate;
	@Column(name = "machine_id")
	public int machineId;
	@Column(name = "sensor_id")
	public int sensorId;
	public int value;
	
	public SensorJpa() {}

	public SensorJpa(LocalDate current, int machineId, int sensorId, int value) {
		super();
		this.currentDate = current;
		this.machineId = machineId;
		this.sensorId = sensorId;
		this.value = value;
	}

	public LocalDate getCurrent() {
		return currentDate;
	}

	public void setCurrent(LocalDate current) {
		this.currentDate = current;
	}

	public int getMachineId() {
		return machineId;
	}

	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}

	public int getSensorId() {
		return sensorId;
	}

	public void setSensorId(int sensorId) {
		this.sensorId = sensorId;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "SensorJpa [currentDate=" + currentDate + ", machineId=" + machineId + ", sensorId=" + sensorId + ", value="
				+ value + "]";
	}
	
	
	
	

}
