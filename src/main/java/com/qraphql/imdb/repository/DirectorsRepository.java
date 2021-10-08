package com.qraphql.imdb.repository;

import com.qraphql.imdb.domain.DirectorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.graphql.data.GraphQlRepository;

/**
 * Created by IntelliJ IDEA.<br/>
 *
 * @author : mohammad<br/>
 * <p>
 * Date : 10/6/2021:11:14 AM<br/>
 * project : graphql-imdb <br/>
 */
@GraphQlRepository
public interface DirectorsRepository extends JpaRepository<DirectorsEntity,Long>, QuerydslPredicateExecutor<DirectorsEntity>
{
}
