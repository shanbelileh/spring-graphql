package com.qraphql.imdb.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.<br/>
 *
 * @author : mohammad<br/>
 * <p>
 * Date : 10/6/2021:10:27 AM<br/>
 * project : graphql-imdb <br/>
 */
public class DirectorsGenresEntityPK implements Serializable
{
    @Column(name = "DIRECTOR_ID")
    @Id
    private long directorId;
    @Column(name = "GENRE")
    @Id
    private String genre;


    public long getDirectorId()
    {
        return directorId;
    }

    public DirectorsGenresEntityPK setDirectorId(long directorId)
    {
        this.directorId = directorId;
        return this;
    }


    public String getGenre()
    {
        return genre;
    }

    public DirectorsGenresEntityPK setGenre(String genre)
    {
        this.genre = genre;
        return this;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectorsGenresEntityPK that = (DirectorsGenresEntityPK) o;
        return Objects.equals(directorId, that.directorId) &&
                Objects.equals(genre, that.genre);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(directorId, genre);
    }
}
