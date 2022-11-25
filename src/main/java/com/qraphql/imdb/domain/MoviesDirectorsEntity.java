package com.qraphql.imdb.domain;

import jakarta.persistence.*;
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
@Table(name = "MOVIES_DIRECTORS")
@IdClass(MoviesDirectorsEntityPK.class)
public class MoviesDirectorsEntity
{
    @Id
    @Column(name = "DIRECTOR_ID")
    private long directorId;
    @Id
    @Column(name = "MOVIE_ID")
    private long movieId;
    @ManyToOne
    @JoinColumn(name = "DIRECTOR_ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    private DirectorsEntity director;
    @ManyToOne
    @JoinColumn(name = "MOVIE_ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    private MoviesEntity movie;


    public long getDirectorId()
    {
        return directorId;
    }

    public MoviesDirectorsEntity setDirectorId(long directorId)
    {
        this.directorId = directorId;
        return this;
    }


    public long getMovieId()
    {
        return movieId;
    }

    public MoviesDirectorsEntity setMovieId(long movieId)
    {
        this.movieId = movieId;
        return this;
    }


    public DirectorsEntity getDirector()
    {
        return director;
    }

    public MoviesDirectorsEntity setDirector(DirectorsEntity directorsByDirectorId)
    {
        this.director = directorsByDirectorId;
        return this;
    }


    public MoviesEntity getMovie()
    {
        return movie;
    }

    public MoviesDirectorsEntity setMovie(MoviesEntity moviesByMovieId)
    {
        this.movie = moviesByMovieId;
        return this;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviesDirectorsEntity that = (MoviesDirectorsEntity) o;
        return Objects.equals(directorId, that.directorId) &&
                Objects.equals(movieId, that.movieId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(directorId, movieId);
    }
}
