package fr.jarvis.server.model;

import javax.persistence.*;

@Entity
@Table(name = "DEVICE_TYPE")
public class DeviceType {

    @Id
    @Column(name = "ID_DEVICE_TYPE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TYPE", nullable = false, unique = true)
    private String type;

    protected DeviceType() {}

    public DeviceType(final String type) {
        this.type = type;
    }

    public String getModel() {
        return type;
    }

    public void setModel(final String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DeviceType{" +
                "id=" + this.id +
                ", model='" + this.type + '\'' +
                '}';
    }
}
