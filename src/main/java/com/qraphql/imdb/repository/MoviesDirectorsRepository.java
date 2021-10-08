package com.qraphql.imdb.repository;

import com.qraphql.imdb.domain.MoviesDirectorsEntity;
import com.qraphql.imdb.domain.MoviesDirectorsEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.graphql.data.GraphQlRepository;

/**
 * @author : mohammad
 * @since : 10/6/2021 5:10 PM , Wed
 * imdb
 **/
@GraphQlRepository
public interface MoviesDirectorsRepository extends JpaRepository<MoviesDirectorsEntity, MoviesDirectorsEntityPK>
        , QuerydslPredicateExecutor<MoviesDirectorsEntity>
{
}
