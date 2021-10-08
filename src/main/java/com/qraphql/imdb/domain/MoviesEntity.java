package com.qraphql.imdb.domain;

import javax.persistence.*;
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
@Table(name = "MOVIES")
public class MoviesEntity
{
    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "YEAR")
    private long year;
    @Column(name = "RANK")
    private Double rank;
    @OneToMany(mappedBy = "movie")
    private Collection<MoviesDirectorsEntity> directors;
    @OneToMany(mappedBy = "movie")
    private Collection<MoviesGenresEntity> genres;
    @OneToMany(mappedBy = "movie")
    private Collection<RolesEntity> roles;


    public long getId()
    {
        return id;
    }

    public MoviesEntity setId(long id)
    {
        this.id = id;
        return this;
    }


    public String getName()
    {
        return name;
    }

    public MoviesEntity setName(String name)
    {
        this.name = name;
        return this;
    }


    public long getYear()
    {
        return year;
    }

    public MoviesEntity setYear(long year)
    {
        this.year = year;
        return this;
    }


    public Double getRank()
    {
        return rank;
    }

    public MoviesEntity setRank(Double rank)
    {
        this.rank = rank;
        return this;
    }


    public Collection<MoviesDirectorsEntity> getDirectors()
    {
        return directors;
    }

    public MoviesEntity setDirectors(Collection<MoviesDirectorsEntity> moviesDirectorsById)
    {
        this.directors = moviesDirectorsById;
        return this;
    }

    public Collection<MoviesGenresEntity> getGenres()
    {
        return genres;
    }

    public MoviesEntity setGenres(Collection<MoviesGenresEntity> moviesGenresById)
    {
        this.genres = moviesGenresById;
        return this;
    }

    public Collection<RolesEntity> getRoles()
    {
        return roles;
    }

    public MoviesEntity setRoles(Collection<RolesEntity> rolesById)
    {
        this.roles = rolesById;
        return this;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviesEntity that = (MoviesEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(year, that.year) &&
                Objects.equals(rank, that.rank);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, name, year, rank);
    }

}
