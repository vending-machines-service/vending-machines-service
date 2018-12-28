package telran.vending.malfunction.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import telran.vending.malfunction.dto.SensorData;
import telran.vending.malfunction.entity.SensorJpa;
import telran.vending.malfunction.repo.SensorMalFunctionRepository;

@Service
@EnableBinding(Sink.class)
public class MalFunctionService {
	
	@Autowired
	SensorMalFunctionRepository malFunctionRepo;
	
	ObjectMapper mapper = new ObjectMapper();
	
	@StreamListener(Sink.INPUT)
	public void getSensorData(String json) throws JsonParseException, JsonMappingException, IOException {
			SensorData sensor = mapper.readValue(json, SensorData.class);
			
			if(!malFunctionRepo.existsByMachineIdAndSensorId(sensor.machineId, sensor.sensorId)) {
				saveInDataBase(sensor);
			}
				
	}
	
	@Transactional
	private void saveInDataBase(SensorData sensor) {
		SensorJpa sensorJpa = new SensorJpa(LocalDate.now(), 
				sensor.machineId, sensor.sensorId, sensor.value);
		malFunctionRepo.save(sensorJpa);
		
	}
	
	public List<SensorJpa> getAllRecords(){
		return malFunctionRepo.findAll();
	}
			

}
