package telran.vending.malfunction.repo;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import telran.vending.malfunction.entity.SensorJpa;

public interface SensorMalFunctionRepository extends JpaRepository<SensorJpa, Integer>{

	boolean existsByMachineIdAndSensorId(int machineId, int sensorId);
}
