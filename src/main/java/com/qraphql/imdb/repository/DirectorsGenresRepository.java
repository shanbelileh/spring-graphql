package com.qraphql.imdb.repository;

import com.qraphql.imdb.domain.DirectorsGenresEntity;
import com.qraphql.imdb.domain.DirectorsGenresEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.graphql.data.GraphQlRepository;

/**
 * @author : mohammad
 * @since : 10/6/2021 5:09 PM , Wed
 * imdb
 **/
@GraphQlRepository
public interface DirectorsGenresRepository extends JpaRepository<DirectorsGenresEntity, DirectorsGenresEntityPK>
        , QuerydslPredicateExecutor<DirectorsGenresEntity>
{
}
