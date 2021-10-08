package com.qraphql.imdb.web.rest;

import com.qraphql.imdb.domain.ActorsEntity;
import com.qraphql.imdb.domain.MoviesEntity;
import com.qraphql.imdb.repository.MoviesRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author : mohammad
 * @since : 10/6/2021 9:48 PM , Wed
 * graphql-imdb
 **/

@Controller
public class MovieController
{
    private final MoviesRepository  moviesRepository;

    public MovieController(MoviesRepository moviesRepository) {this.moviesRepository = moviesRepository;}

    @QueryMapping("moviesByName")
    public List<MoviesEntity> movies(@Argument("name") String name)
    {
        return moviesRepository.findAllByNameContains(name);
    }
}
