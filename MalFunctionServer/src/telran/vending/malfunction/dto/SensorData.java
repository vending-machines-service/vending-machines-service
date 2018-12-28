package telran.vending.malfunction.dto;

public class SensorData {
	
	public int machineId;
	public int sensorId;
	public int value;
	
	public SensorData() {
		
	}
	

	public SensorData(int machineId, int sensorId, int value) {
		this.machineId = machineId;
		this.sensorId = sensorId;
		this.value = value;
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
		return "SensorData [machineId=" + machineId + ", sensorId=" + sensorId + ", value=" + value + "]";
	}
	
	
	

}
