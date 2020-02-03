package fr.jarvis.server.model;

import javax.persistence.*;

@Entity
@Table(name = "DEVICE")
public class Device {

    @Id
    @Column(name = "DEVICE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SERIAL", unique = true, nullable = false)
    private String serial;

    @ManyToOne()
    @JoinColumn(name = "ID_TYPE", nullable = false, foreignKey = @ForeignKey(name = "FK_MODEL_DEVICE"))
    private DeviceType type;

    protected Device() {}

    public Device(final String serial, final DeviceType type) {
        this.serial = serial;
        this.type = type;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(final String serial) {
        this.serial = serial;
    }

    public DeviceType getModel() {
        return type;
    }

    public void setModel(final DeviceType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                ", model=" + type +
                '}';
    }
}
