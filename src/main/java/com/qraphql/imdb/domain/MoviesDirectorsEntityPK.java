package com.qraphql.imdb.domain;

import javax.persistence.Column;
import javax.persistence.Id;
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
public class MoviesDirectorsEntityPK implements Serializable
{
    @Column(name = "DIRECTOR_ID")
    @Id
    private long directorId;
    @Column(name = "MOVIE_ID")
    @Id
    private long movieId;


    public long getDirectorId()
    {
        return directorId;
    }

    public MoviesDirectorsEntityPK setDirectorId(long directorId)
    {
        this.directorId = directorId;
        return this;
    }


    public long getMovieId()
    {
        return movieId;
    }

    public MoviesDirectorsEntityPK setMovieId(long movieId)
    {
        this.movieId = movieId;
        return this;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviesDirectorsEntityPK that = (MoviesDirectorsEntityPK) o;
        return Objects.equals(directorId, that.directorId) &&
                Objects.equals(movieId, that.movieId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(directorId, movieId);
    }
}
