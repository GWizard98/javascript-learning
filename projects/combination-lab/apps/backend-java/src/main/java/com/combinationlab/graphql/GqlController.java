package com.combinationlab.graphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GqlController {

    @QueryMapping
    public Greeting helloGraph(@Argument String name) {
        String who = (name == null || name.isBlank()) ? "world" : name;
        return new Greeting(
                "Hello, " + who + " (from GraphQL)",
                "Spring Boot",
                "Java"
        );
    }
}
