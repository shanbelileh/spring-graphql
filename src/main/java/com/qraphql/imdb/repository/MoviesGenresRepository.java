package com.qraphql.imdb.repository;

import com.qraphql.imdb.domain.MoviesGenresEntity;
import com.qraphql.imdb.domain.MoviesGenresEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.graphql.data.GraphQlRepository;

/**
 * @author : mohammad
 * @since : 10/6/2021 5:11 PM , Wed
 * imdb
 **/

@GraphQlRepository
public interface MoviesGenresRepository extends JpaRepository<MoviesGenresEntity, MoviesGenresEntityPK>
        , QuerydslPredicateExecutor<MoviesGenresEntity>
{
}
