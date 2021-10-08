package com.qraphql.imdb.repository;

import com.qraphql.imdb.domain.ActorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.graphql.data.GraphQlRepository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.<br/>
 *
 * @author : mohammad<br/>
 * <p>
 * Date : 10/6/2021:11:13 AM<br/>
 * project : graphql-imdb <br/>
 */
@GraphQlRepository
public interface ActorsRepository extends JpaRepository<ActorsEntity,Long> , QuerydslPredicateExecutor<ActorsEntity>
{

    @Query("select a from ActorsEntity  a where a.firstName like CONCAT('%',:name,'%') or a.lastName like CONCAT('%',:name,'%')")
    List<ActorsEntity> findActorsLike(String name);
}
