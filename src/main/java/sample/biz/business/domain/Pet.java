package sample.biz.business.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Pet {

    @Id
    @Column(name = "PET_ID")
    private Integer petId;
    @Column(name = "PET_NAME")
    private String petName;
    @Column(name = "OWNER_ID")
    private String ownerId;
    @Column(name = "PRICE")
    private Integer price;
    @Column(name = "BIRTH_DATE")
    private java.sql.Date birthDate;

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }


    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }


    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }


    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    public java.sql.Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(java.sql.Date birthDate) {
        this.birthDate = birthDate;
    }


}
