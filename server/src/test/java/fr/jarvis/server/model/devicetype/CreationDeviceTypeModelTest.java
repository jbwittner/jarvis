package fr.jarvis.server.model.devicetype;

import fr.jarvis.server.model.DeviceType;
import fr.jarvis.server.model.ModelTest;
import fr.jarvis.server.repositories.DeviceTypeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Test class for creation of device type
 */
public class CreationDeviceTypeModelTest extends ModelTest {

    @Autowired
    DeviceTypeRepository deviceTypeRepository;

    public static final String DUPLICATE_DEVICE_TYPE = "RASPBERRY";

    /**
     * Test to check the good creation of device type
     */
    @Test
    public void createDeviceTypeOk(){
        final DeviceType deviceType = factory.createRandomDeviceType();

        deviceTypeRepository.save(deviceType);
    }

    /**
     * Test to check if the repository throw an exception when we try
     * to create a device type with a duplicate device type
     */
    @Test
    public void createDuplicateDeviceTypeNOk(){
        final DeviceType deviceType = new DeviceType(DUPLICATE_DEVICE_TYPE);
        final DeviceType duplicateDeviceType = new DeviceType(DUPLICATE_DEVICE_TYPE);

        deviceTypeRepository.save(deviceType);

        Assertions.assertThrows(org.springframework.dao.DataIntegrityViolationException.class, () -> {
            deviceTypeRepository.save(duplicateDeviceType);
        });
    }

    /**
     * Test to check if the repository throw an exception when we try
     * to create a device type a null type
     */
    @Test
    public void createDeviceTypeWithNullTypeNOk(){
        final DeviceType deviceType = new DeviceType(null);

        Assertions.assertThrows(org.springframework.dao.DataIntegrityViolationException.class, () -> {
            deviceTypeRepository.save(deviceType);
        });
    }

}
