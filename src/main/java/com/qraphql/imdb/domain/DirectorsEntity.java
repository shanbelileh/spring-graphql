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
@Table(name = "DIRECTORS")
public class DirectorsEntity
{
    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @OneToMany(mappedBy = "director")
    private Collection<DirectorsGenresEntity> genres;
    @OneToMany(mappedBy = "director")
    private Collection<MoviesDirectorsEntity> movies;


    public long getId()
    {
        return id;
    }

    public DirectorsEntity setId(long id)
    {
        this.id = id;
        return this;
    }


    public String getFirstName()
    {
        return firstName;
    }

    public DirectorsEntity setFirstName(String firstName)
    {
        this.firstName = firstName;
        return this;
    }


    public String getLastName()
    {
        return lastName;
    }

    public DirectorsEntity setLastName(String lastName)
    {
        this.lastName = lastName;
        return this;
    }


    public Collection<DirectorsGenresEntity> getGenres()
    {
        return genres;
    }

    public DirectorsEntity setGenres(Collection<DirectorsGenresEntity> directorsGenresById)
    {
        this.genres = directorsGenresById;
        return this;
    }

    public Collection<MoviesDirectorsEntity> getMovies()
    {
        return movies;
    }

    public DirectorsEntity setMovies(Collection<MoviesDirectorsEntity> moviesDirectorsById)
    {
        this.movies = moviesDirectorsById;
        return this;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectorsEntity that = (DirectorsEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, firstName, lastName);
    }
}
