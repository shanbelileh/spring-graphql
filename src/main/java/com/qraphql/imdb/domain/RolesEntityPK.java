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
public class RolesEntityPK implements Serializable
{
    @Column(name = "ACTOR_ID")
    @Id
    private long actorId;
    @Column(name = "MOVIE_ID")
    @Id
    private long movieId;


    public long getActorId()
    {
        return actorId;
    }

    public RolesEntityPK setActorId(long actorId)
    {
        this.actorId = actorId;
        return this;
    }


    public long getMovieId()
    {
        return movieId;
    }

    public RolesEntityPK setMovieId(long movieId)
    {
        this.movieId = movieId;
        return this;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolesEntityPK that = (RolesEntityPK) o;
        return actorId == that.actorId &&
                movieId == that.movieId;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(actorId, movieId);
    }
}
