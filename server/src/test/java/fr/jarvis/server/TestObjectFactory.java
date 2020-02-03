package fr.jarvis.server;

import fr.jarvis.server.model.DeviceType;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class TestObjectFactory {

    public static final int LENGTH_DEVICE_TYPE_MODEL = 10;
    public static final int LENGTH_DEVICE_SERIAL = 10;

    private List<String> listRandomString = new ArrayList<>();

    public void resetListString(){
        this.listRandomString = new ArrayList<>();
    }

    public String getRandomAsciiString(final int length){
        boolean isNotUnique = true;
        String randomString = "";

        while (isNotUnique){
            randomString = RandomStringUtils.randomAscii(length);
            isNotUnique = listRandomString.contains(randomString);
        }

        listRandomString.add(randomString);

        return randomString;
    }

    public DeviceType createRandomDeviceType(){
        final String type = this.getRandomAsciiString(LENGTH_DEVICE_TYPE_MODEL);

        return this.createDeviceType(type);
    }

    public DeviceType createDeviceType(final String type){
        return new DeviceType(type);
    }

}
