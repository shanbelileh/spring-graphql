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
@Table(name = "DIRECTORS_GENRES")
@IdClass(DirectorsGenresEntityPK.class)
public class DirectorsGenresEntity
{
    @Id
    @Column(name = "DIRECTOR_ID")
    private long directorId;
    @Id
    @Column(name = "GENRE")
    private String genre;
    @Column(name = "PROB")
    private Double prob;
    @ManyToOne
    @JoinColumn(name = "DIRECTOR_ID", referencedColumnName = "ID", nullable = false,insertable = false,updatable = false)
    private DirectorsEntity director;


    public long getDirectorId()
    {
        return directorId;
    }

    public DirectorsGenresEntity setDirectorId(long directorId)
    {
        this.directorId = directorId;
        return this;
    }


    public String getGenre()
    {
        return genre;
    }

    public DirectorsGenresEntity setGenre(String genre)
    {
        this.genre = genre;
        return this;
    }


    public Double getProb()
    {
        return prob;
    }

    public DirectorsGenresEntity setProb(Double prob)
    {
        this.prob = prob;
        return this;
    }



    public DirectorsEntity getDirector()
    {
        return director;
    }

    public DirectorsGenresEntity setDirector(DirectorsEntity directorsByDirectorId)
    {
        this.director = directorsByDirectorId;
        return this;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectorsGenresEntity that = (DirectorsGenresEntity) o;
        return Objects.equals(directorId, that.directorId) &&
                Objects.equals(genre, that.genre) &&
                Objects.equals(prob, that.prob);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(directorId, genre, prob);
    }

}
