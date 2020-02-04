package fr.jarvis.server.model;

import javax.persistence.*;

/**
 * Class of the Device type
 */
@Entity
@Table(name = "DEVICE_TYPE")
public class DeviceType {

    @Id
    @Column(name = "ID_DEVICE_TYPE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TYPE", nullable = false, unique = true)
    private String type;

    /**
     * Default constructor
     */
    protected DeviceType() {
        // This constructor is intentionally empty. Nothing special is needed here.
    }

    /**
     * Constructor of Device type
     * @param type String of type
     */
    public DeviceType(final String type) {
        this.type = type;
    }

    /**
     * Getter of type
     * @return String of type
     */
    public String getType() {
        return type;
    }

    /**
     * Setter of type
     * @param type String of type
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * Override of toString method
     * @return String representation of the model
     */
    @Override
    public String toString() {
        return "DeviceType{" +
                "id=" + this.id +
                ", model='" + this.type + '\'' +
                '}';
    }
}
