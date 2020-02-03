package fr.jarvis.server.model.device;

import fr.jarvis.server.TestObjectFactory;
import fr.jarvis.server.model.Device;
import fr.jarvis.server.model.DeviceType;
import fr.jarvis.server.model.ModelTest;
import fr.jarvis.server.repositories.DeviceRepository;
import fr.jarvis.server.repositories.DeviceTypeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CreationDeviceModelTest extends ModelTest {

    @Autowired
    private DeviceTypeRepository deviceTypeRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    private DeviceType deviceType;

    public static final String DUPLICATE_DEVICE_TYPE = "RASPBERRY";

    @BeforeEach
    public void initCreation(){
        this.deviceType = factory.createRandomDeviceType();
        this.deviceTypeRepository.save(deviceType);
    }

    @Test
    public void createDeviceOk(){
        final Device device = new Device(this.factory.getRandomAsciiString(TestObjectFactory.LENGTH_DEVICE_SERIAL), this.deviceType);
        deviceRepository.save(device);
    }

    @Test
    public void createDuplicateDeviceTypeNOk(){
        final Device deviceOne = new Device(this.factory.getRandomAsciiString(TestObjectFactory.LENGTH_DEVICE_SERIAL), this.deviceType);
        final Device deviceTwo = new Device(deviceOne.getSerial(), this.deviceType);

        deviceRepository.save(deviceOne);

        Assertions.assertThrows(org.springframework.dao.DataIntegrityViolationException.class, () -> {
            deviceRepository.save(deviceTwo);
        });
    }

}