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

/**
 * Test class for creation of device
 */
public class CreationDeviceModelTest extends ModelTest {

    @Autowired
    private DeviceTypeRepository deviceTypeRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    private DeviceType deviceType;

    public static final String DUPLICATE_DEVICE_TYPE = "RASPBERRY";

    /**
     * Method to prepare tests
     */
    @BeforeEach
    public void initCreation(){
        this.deviceType = factory.createRandomDeviceType();
        this.deviceTypeRepository.save(deviceType);
    }

    /**
     * Test to check the good creation of device
     */
    @Test
    public void createDeviceOk(){
        final Device device = new Device(this.factory.getRandomAsciiString(TestObjectFactory.LENGTH_DEVICE_SERIAL), this.deviceType);
        deviceRepository.save(device);
    }

    /**
     * Test to check if the repository throw an exception when we try to create a device with the same serial
     */
    @Test
    public void createDuplicateDeviceNOk(){
        final Device deviceOne = new Device(this.factory.getRandomAsciiString(TestObjectFactory.LENGTH_DEVICE_SERIAL), this.deviceType);
        final Device deviceTwo = new Device(deviceOne.getSerial(), this.deviceType);

        deviceRepository.save(deviceOne);

        Assertions.assertThrows(org.springframework.dao.DataIntegrityViolationException.class, () -> {
            deviceRepository.save(deviceTwo);
        });
    }

    /**
     * Test to check if the repository throw an exception when we try to create a device with a null serial
     */
    @Test
    public void createDeviceNullSerialNOk(){
        final Device device = new Device(null, this.deviceType);

        Assertions.assertThrows(org.springframework.dao.DataIntegrityViolationException.class, () -> {
            deviceRepository.save(device);
        });
    }

    /**
     * Test to check if the repository throw an exception when we try to create a device with a null type
     */
    @Test
    public void createDeviceNullTypeNOk(){
        final Device device = new Device(this.factory.getRandomAsciiString(TestObjectFactory.LENGTH_DEVICE_SERIAL), null);

        Assertions.assertThrows(org.springframework.dao.DataIntegrityViolationException.class, () -> {
            deviceRepository.save(device);
        });
    }

}