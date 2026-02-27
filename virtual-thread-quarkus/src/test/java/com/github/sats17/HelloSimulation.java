package com.github.sats17;


import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class HelloSimulation extends Simulation {

    HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://localhost:8080")
            .acceptHeader("text/plain");

    ScenarioBuilder scn = scenario("Hello Load Test")
            .exec(
                    http("GET /hello")
                            .get("/hello")
                            .check(status().is(200))
            );

    {
        setUp(
                scn.injectOpen(
                        rampUsers(100).during(30),
                        constantUsersPerSec(50).during(60)
                )
        ).protocols(httpProtocol);
    }
}
