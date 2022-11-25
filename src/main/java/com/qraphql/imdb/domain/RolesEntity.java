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
@Table(name = "ROLES")
@IdClass(RolesEntityPK.class)
public class RolesEntity
{
    @Id
    @Column(name = "ACTOR_ID")
    private long actorId;
    @Id
    @Column(name = "MOVIE_ID")
    private long movieId;
    @Column(name = "ROLE")
    private String role;
    @ManyToOne
    @JoinColumn(name = "ACTOR_ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    private ActorsEntity actor;
    @ManyToOne
    @JoinColumn(name = "MOVIE_ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    private MoviesEntity movie;


    public long getActorId()
    {
        return actorId;
    }

    public RolesEntity setActorId(long actorId)
    {
        this.actorId = actorId;
        return this;
    }


    public long getMovieId()
    {
        return movieId;
    }

    public RolesEntity setMovieId(long movieId)
    {
        this.movieId = movieId;
        return this;
    }


    public String getRole()
    {
        return role;
    }

    public RolesEntity setRole(String role)
    {
        this.role = role;
        return this;
    }


    public ActorsEntity getActor()
    {
        return actor;
    }

    public RolesEntity setActor(ActorsEntity actorsByActorId)
    {
        this.actor = actorsByActorId;
        return this;
    }


    public MoviesEntity getMovie()
    {
        return movie;
    }

    public RolesEntity setMovie(MoviesEntity moviesByMovieId)
    {
        this.movie = moviesByMovieId;
        return this;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolesEntity that = (RolesEntity) o;
        return Objects.equals(actorId, that.actorId) &&
                Objects.equals(movieId, that.movieId) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(actorId, movieId, role);
    }

}
