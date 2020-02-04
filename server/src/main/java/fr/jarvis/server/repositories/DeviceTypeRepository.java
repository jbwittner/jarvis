package fr.jarvis.server.repositories;

import fr.jarvis.server.model.Device;
import fr.jarvis.server.model.DeviceType;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for device type
 */
public interface DeviceTypeRepository extends CrudRepository<DeviceType, Long> {

    /**
     * Method to find device type by serial
     * @param type Type to find
     * @return Type which the serial match
     */
    DeviceType findByType(String type);

    /**
     * Method to find type by id
     * @param id Id to find
     * @return Type which the id match
     */
    Device findById(long id);
}