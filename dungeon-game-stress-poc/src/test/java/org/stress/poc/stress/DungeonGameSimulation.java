package org.stress.poc.stress;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class DungeonGameSimulation extends Simulation {

    private final HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://localhost:8080")
            .acceptHeader("application/json")
            .contentTypeHeader("application/json");

    private final String testDungeon = """
        {
            "dungeon": [
                [-3, 5],
                [1, -4]
            ]
        }
        """;

    private final ScenarioBuilder basicLoad = scenario("Basic Load Test")
            .exec(
                    http("calculate-dungeon")
                            .post("/v1/dungeons")
                            .body(StringBody(testDungeon))
                            .check(status().is(200))
            );

    {
        setUp(
                basicLoad.injectOpen(
                        rampUsersPerSec(1).to(10).during(30),
                        constantUsersPerSec(10).during(60)
                )
        )
                .protocols(httpProtocol)
                .assertions(
                        global().responseTime().max().lt(3000),
                        global().successfulRequests().percent().gt(99.0)
                );
    }
}
