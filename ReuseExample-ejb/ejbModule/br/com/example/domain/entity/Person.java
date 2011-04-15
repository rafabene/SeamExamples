package br.com.example.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;

import org.hibernate.annotations.NotFound;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

import br.com.example.infrastructure.dao.PersonDao;

@Entity
@NamedQuery(name=PersonDao.FIND_ALL_QNAME, query=PersonDao.FIND_ALL_QUERY)
@XmlRootElement(name="person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private Long id;
    
    @NotFound
    @Length(min=3, max=100)
    private String name;
    
    @Temporal(TemporalType.DATE)
    @NotNull
    @XmlSchemaType(name="date")
    private Date birthday;

    @OneToMany(mappedBy="contact", cascade=CascadeType.ALL)
    @XmlElement(name="contactInfo")
    private List<ContactInfo> contactInfos = new ArrayList<ContactInfo>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public List<ContactInfo> getContactInfos() {
        return contactInfos;
    }
    
    
}
