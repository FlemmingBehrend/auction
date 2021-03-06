package dk.topdanmark.administrate.entity;

import dk.topdanmark.domain.types.DDDValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@DDDValueObject
public class Address implements Serializable {

    private String streetName;

    private int streetNumber;

    private String city;

    private String zip;

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
