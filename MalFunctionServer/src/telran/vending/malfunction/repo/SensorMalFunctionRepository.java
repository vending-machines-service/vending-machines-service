package telran.vending.malfunction.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import telran.vending.malfunction.dto.SensorMongoDB;

@Repository
public interface SensorMalFunctionRepository extends MongoRepository<SensorMongoDB, String>{

}
