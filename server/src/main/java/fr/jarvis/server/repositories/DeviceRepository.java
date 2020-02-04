package fr.jarvis.server.repositories;

import fr.jarvis.server.model.Device;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for device
 */
public interface DeviceRepository extends CrudRepository<Device, Long> {

    /**
     * Method to find device by serial
     * @param serial Serial to find
     * @return Device which the serial match
     */
    Device findBySerial(String serial);

    /**
     * Method to find device by id
     * @param id Id to find
     * @return Device which the id match
     */
    Device findById(long id);
}