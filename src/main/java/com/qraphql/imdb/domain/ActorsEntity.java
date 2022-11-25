package com.qraphql.imdb.domain;


import jakarta.persistence.*;
import java.util.Collection;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.<br/>
 *
 * @author : mohammad<br/>
 * <p>
 * Date : 10/6/2021:10:27 AM<br/>
 * project : graphql-imdb <br/>
 */
@Entity
@Table(name = "ACTORS")
public class ActorsEntity
{
    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "GENDER")
    @Convert(converter = GenderConverter.class)
    private Gender gender;
    @OneToMany(mappedBy = "actor")
    private Collection<RolesEntity> roles;


    public long getId()
    {
        return id;
    }

    public ActorsEntity setId(long id)
    {
        this.id = id;
        return this;
    }


    public String getFirstName()
    {
        return firstName;
    }

    public ActorsEntity setFirstName(String firstName)
    {
        this.firstName = firstName;
        return this;
    }


    public String getLastName()
    {
        return lastName;
    }

    public ActorsEntity setLastName(String lastName)
    {
        this.lastName = lastName;
        return this;
    }


    public Gender getGender()
    {
        return gender;
    }

    public ActorsEntity setGender(Gender gender)
    {
        this.gender = gender;
        return this;
    }


    public Collection<RolesEntity> getRoles()
    {
        return roles;
    }

    public ActorsEntity setRoles(Collection<RolesEntity> rolesById)
    {
        this.roles = rolesById;
        return this;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorsEntity that = (ActorsEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, firstName, lastName, gender);
    }



    public enum Gender
    {
        MALE("M"), FEMALE("F");
        private final String value;

        Gender(String value)
        {
            this.value = value;
        }

        public String getValue()
        {
            return value;
        }
    }

}
