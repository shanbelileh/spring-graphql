````
 _____  _              _         _  _  _       _   
|   __|| |_  ___  ___ | |_  ___ | ||_|| | ___ | |_ 
|__   ||   || .'||   || . || -_|| || || || -_||   |
|_____||_|_||__,||_|_||___||___||_||_||_||___||_|_|

````

# GraphQL and Graph*i*QL Spring Boot  example

A simple GraphQL Spring Boot example based on imdb data model.   

Run the application 
```shell
./mvnw spring-boot:run
```

Run the application and go to http://localhost:7575/graphql/schema. You should see a description of the GraphQL schema, something like this:

```graphql
"Directs the executor to include this field or fragment only when the `if` argument is true"
directive @include(
    "Included when true."
    if: Boolean!
  ) on FIELD | FRAGMENT_SPREAD | INLINE_FRAGMENT

"Directs the executor to skip this field or fragment when the `if`'argument is true."
directive @skip(
    "Skipped when true."
    if: Boolean!
  ) on FIELD | FRAGMENT_SPREAD | INLINE_FRAGMENT

"Marks the field or enum value as deprecated"
directive @deprecated(
    "The reason for the deprecation"
    reason: String = "No longer supported"
  ) on FIELD_DEFINITION | ARGUMENT_DEFINITION | ENUM_VALUE | INPUT_FIELD_DEFINITION

"Exposes a URL that specifies the behaviour of this scalar."
directive @specifiedBy(
    "The URL that specifies the behaviour of this scalar."
    url: String!
  ) on SCALAR

type ActorsEntity {
  firstName: String!
  gender: Gender!
  id: ID!
  lastName: String!
  roles: [RolesEntity]
}

type DirectorsEntity {
  firstName: String!
  genres: [DirectorsGenresEntity]
  id: ID!
  lastName: String!
  movies: [MoviesDirectorsEntity]
}

type DirectorsGenresEntity {
  director: DirectorsEntity!
  directorId: ID!
  genre: ID!
  prob: Float!
}

type MoviesDirectorsEntity {
  director: DirectorsEntity!
  directorId: ID!
  movie: MoviesEntity!
  movieId: ID!
}

type MoviesEntity {
  directors: [MoviesDirectorsEntity]
  genres: [MoviesGenresEntity]
  id: ID!
  name: String!
  rank: Float
  roles: [RolesEntity]
  year: Int!
}

type MoviesGenresEntity {
  genre: ID!
  movie: MoviesEntity!
  movieId: ID!
}

type Query {
  actorByFirstName(firstName: String!): [ActorsEntity]
  actorNameLike(name: String!): [ActorsEntity]
  actors: [ActorsEntity]
  directors: [DirectorsEntity]
  movies: [MoviesEntity]
  moviesByName(name: String!): [MoviesEntity]
  roles: [RolesEntity]
}

type RolesEntity {
  actor: ActorsEntity!
  actorId: ID!
  movie: MoviesEntity!
  movieId: ID!
  role: String!
}

enum Gender {
  FEMALE
  MALE
}
```
go to http://localhost:7575/graphiql. You should see `GraphiQL` console, an in-browser tool for writing, validating, and testing GraphQL queries

### Now go to Graph*i*QL and execute a query, for example:

```graphql
{
  moviesByName(name:"Matrix")
  {
    name
    year
    rank
    directors{
      director{
        firstName
        lastName
      }
    }
    roles{
      role
      actor{
        firstName
        lastName
        gender
      }
    }
  }
}
```
**and see result like**  

```json
{
  "data": {
    "moviesByName": [
      {
        "name": "Matrix, The",
        "year": 1999,
        "rank": 8.5,
        "directors": [
          {
            "director": {
              "firstName": "Andy",
              "lastName": "Wachowski"
            }
          },
          {
            "director": {
              "firstName": "Larry",
              "lastName": "Wachowski"
            }
          }
        ],
        "roles": [
          {
            "role": "Morpheus",
            "actor": {
              "firstName": "Laurence",
              "lastName": "Fishburne",
              "gender": "MALE"
            }
          },
          {
            "role": "Cypher",
            "actor": {
              "firstName": "Joe",
              "lastName": "Pantoliano",
              "gender": "MALE"
            }
          },
          {
            "role": "Neo",
            "actor": {
              "firstName": "Keanu",
              "lastName": "Reeves",
              "gender": "MALE"
            }
          },
          {
            "role": "Agent Smith",
            "actor": {
              "firstName": "Hugo",
              "lastName": "Weaving",
              "gender": "MALE"
            }
          },
          {
            "role": "Oracle",
            "actor": {
              "firstName": "Gloria",
              "lastName": "Foster",
              "gender": "FEMALE"
            }
          },
          {
            "role": "Trinity",
            "actor": {
              "firstName": "Carrie-Anne",
              "lastName": "Moss",
              "gender": "FEMALE"
            }
          }
        ]
      }
    ]
  }
}
```


# Conclusion   

GraphQL is a flexible and powerful alternative to REST for building APIs. Here are some points to remember:
- GraphQL is a query language that is independent of the source of the data (database, web service, etc.).
- GraphQL describes the data that an API provides via a strong typing system.
- Through a schema, GraphQL declares the resources, relationships between them, and operations available.
- All operations go through a single endpoing that can be accessed through HTTP.

There's a lot more to learn about GraphQL, of course. Here are some good resources:
- [graphql-spring documentation](https://docs.spring.io/spring-graphql/docs/1.0.0-M2/reference/html/)
- [GrapQL official documentation](http://graphql.org/learn/)
- [How to GraphQL](https://www.howtographql.com/basics/0-introduction/)

