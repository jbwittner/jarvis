package fr.jarvis.server.model;

import javax.persistence.*;

/**
 * Class of the Device
 */
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

    /**
     * Default constructor
     */
    protected Device() {
        // This constructor is intentionally empty. Nothing special is needed here.
    }

    /**
     * Constructor of Device model
     * @param serial Device serial
     * @param type Device type
     */
    public Device(final String serial, final DeviceType type) {
        this.serial = serial;
        this.type = type;
    }

    /**
     * Getter of Serial
     * @return Device serial
     */
    public String getSerial() {
        return serial;
    }

    /**
     * Setter of Serial
     * @param serial Device serial
     */
    public void setSerial(final String serial) {
        this.serial = serial;
    }

    /**
     * Getter of Type
     * @return Device type
     */
    public DeviceType getType() {
        return type;
    }

    /**
     * Setter of type
     * @param type Device type
     */
    public void setType(final DeviceType type) {
        this.type = type;
    }

    /**
     * Override of toString method
     * @return String representation of the model
     */
    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                ", model=" + type +
                '}';
    }
}
