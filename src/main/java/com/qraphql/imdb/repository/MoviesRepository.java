package com.qraphql.imdb.repository;

import com.qraphql.imdb.domain.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.graphql.data.GraphQlRepository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.<br/>
 *
 * @author : mohammad<br/>
 * <p>
 * Date : 10/6/2021:10:51 AM<br/>
 * project : graphql-imdb <br/>
 */

@GraphQlRepository
public interface MoviesRepository extends JpaRepository<MoviesEntity, Long>, QuerydslPredicateExecutor<MoviesEntity>
{
    List<MoviesEntity> findAllByNameContains(String name);
}
