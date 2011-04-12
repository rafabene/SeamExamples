package br.com.example.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

import br.com.example.domain.vo.ContactType;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class ContactInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @NotNull
    @ManyToOne
    @XmlTransient
    private Person contact;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "contact_type")
    private ContactType contactType;

    @NotNull
    @Length(min = 5, max = 20)
    @Column(name = "contact_value")
    private String value;

    public Long getId() {
        return id;
    }

    public Person getContact() {
        return contact;
    }

    public void setContact(Person contact) {
        this.contact = contact;
    }

     public ContactType getType() {
     return contactType;
     }
    
     public void setType(ContactType type) {
     this.contactType = type;
     }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
