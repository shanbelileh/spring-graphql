package com.qraphql.imdb.domain;

import javax.persistence.*;
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
@Table(name = "MOVIES_GENRES")
@IdClass(MoviesGenresEntityPK.class)
public class MoviesGenresEntity
{
    @Id
    @Column(name = "MOVIE_ID")
    private long movieId;
    @Id
    @Column(name = "GENRE")
    private String genre;
    @ManyToOne
    @JoinColumn(name = "MOVIE_ID", referencedColumnName = "ID", nullable = false,insertable = false,updatable = false)
    private MoviesEntity movie;


    public long getMovieId()
    {
        return movieId;
    }

    public MoviesGenresEntity setMovieId(long movieId)
    {
        this.movieId = movieId;
        return this;
    }


    public String getGenre()
    {
        return genre;
    }

    public MoviesGenresEntity setGenre(String genre)
    {
        this.genre = genre;
        return this;
    }




    public MoviesEntity getMovie()
    {
        return movie;
    }

    public MoviesGenresEntity setMovie(MoviesEntity moviesByMovieId)
    {
        this.movie = moviesByMovieId;
        return this;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviesGenresEntity that = (MoviesGenresEntity) o;
        return Objects.equals(movieId, that.movieId) &&
                Objects.equals(genre, that.genre);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(movieId, genre);
    }
}
