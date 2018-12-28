package telran.vending.malfunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.time.LocalDate;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import telran.vending.malfunction.dto.SensorData;
import telran.vending.malfunction.entity.SensorJpa;
import telran.vending.malfunction.repo.SensorMalFunctionRepository;
import telran.vending.malfunction.service.MalFunctionService;

@SpringBootApplication
public class MalFunctionServerTest {
	
	
	MalFunctionService service;
	ConfigurableApplicationContext ctx;
	ObjectMapper mapper = new ObjectMapper();
	
	
	SensorData sensor1 = new SensorData( 1, 1, 10);
	SensorData sensor2 = new SensorData(1, 2, 10);
	SensorData sensor3 = new SensorData(2, 1, 10);
	
	@BeforeEach
	void setUp() {
		ctx = SpringApplication.run(MalFunctionServerTest.class);
		service = ctx.getBean(MalFunctionService.class);
		
	}
	@AfterEach
	void tearDown() {
		ctx.close();
	}
	
	@Test
	void getSensorDataTest() throws IOException {
		String sensorJson1 = mapper.writeValueAsString(sensor1);
		service.getSensorData(sensorJson1);
		service.getSensorData(sensorJson1);
		assertEquals(1, service.getAllRecords().size());
		String sensorJson2 = mapper.writeValueAsString(sensor2);
		service.getSensorData(sensorJson2);
		assertEquals(2, service.getAllRecords().size());
		String sensorJson3 = mapper.writeValueAsString(sensor3);
		service.getSensorData(sensorJson3);
		assertEquals(3, service.getAllRecords().size());
		service.getAllRecords().forEach(System.out::println);
		
		
		
		
	}
	
	

}
