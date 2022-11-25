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
public class MoviesGenresEntityPK implements Serializable
{
    @Column(name = "MOVIE_ID")
    @Id
    private long movieId;
    @Column(name = "GENRE")
    @Id
    private String genre;


    public long getMovieId()
    {
        return movieId;
    }

    public MoviesGenresEntityPK setMovieId(long movieId)
    {
        this.movieId = movieId;
        return this;
    }


    public String getGenre()
    {
        return genre;
    }

    public MoviesGenresEntityPK setGenre(String genre)
    {
        this.genre = genre;
        return this;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviesGenresEntityPK that = (MoviesGenresEntityPK) o;
        return Objects.equals(movieId, that.movieId) &&
                Objects.equals(genre, that.genre);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(movieId, genre);
    }
}
