package fr.jarvis.server.repositories;

import fr.jarvis.server.model.Device;
import fr.jarvis.server.model.DeviceType;
import org.springframework.data.repository.CrudRepository;

public interface DeviceTypeRepository extends CrudRepository<DeviceType, Long> {

    DeviceType findByType(String type);
    Device findById(long id);
}