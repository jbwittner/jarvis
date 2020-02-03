package fr.jarvis.server.repositories;

import fr.jarvis.server.model.Device;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface DeviceRepository extends CrudRepository<Device, Long> {

    List<Device> findBySerial(String serial);
    Device findById(long id);
}