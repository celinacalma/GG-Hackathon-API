package com.github.hackathon.entities;

// import static io.catalyte.training.constants.StringConstants.REQUIRED_FIELD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * Models a story object and maps it to a Postgres table via Hibernate
 */
@Entity
@Table(name = "stories")
public class Story implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name" + REQUIRED_FIELD)
    private String name;

//    @Email(message = "Please provide a valid email address")
//    @Pattern(regexp = ".+@.+\\..+", message = "Invalid email address format")
//    @NotBlank(message = "email" + REQUIRED_FIELD)
//    @Column(unique = true)
//    private String email;

//    @OneToOne(mappedBy = "story", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @Valid
//    private Address address;

//    @OneToMany(mappedBy = "story", cascade = CascadeType.ALL)
//    @JsonIgnore
//    private Set<GcOrder> gcOrders = new HashSet<>();

    public Story() {
    }

    public Story(
            @NotBlank String name,
            @NotBlank String email
    ) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<GcOrder> getGcOrders() {
        return gcOrders;
    }

    public void setGcOrder(Set<GcOrder> gcOrders) {
        this.gcOrders = gcOrders;
    }

    @Override
    public String toString() {
        return "Story{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", gcOrder=" + gcOrders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Story story = (Story) o;
        return Objects.equals(id, story.id) &&
                Objects.equals(name, story.name) &&
                Objects.equals(email, story.email) &&
                Objects.equals(address, story.address) &&
                Objects.equals(gcOrders, story.gcOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, address, gcOrders);
    }

    @JsonIgnore
    public boolean isEmpty() {
        return Objects.isNull(id) &&
                Objects.isNull(name) &&
                Objects.isNull(email) &&
                Objects.isNull(address) &&
                Objects.isNull(gcOrders);
    }

}
