package com.qraphql.imdb.web.rest;

import com.qraphql.imdb.domain.ActorsEntity;
import com.qraphql.imdb.repository.ActorsRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author : mohammad
 * @since : 10/6/2021 5:57 PM , Wed
 * imdb
 **/
@Controller
public class ActorController
{

    private final ActorsRepository actorsRepository;

    public ActorController(ActorsRepository actorsRepository) {this.actorsRepository = actorsRepository;}

    @QueryMapping("actorNameLike")
    public List<ActorsEntity> actors(@Argument String name)
    {
        return actorsRepository.findActorsLike(name);
    }

}
