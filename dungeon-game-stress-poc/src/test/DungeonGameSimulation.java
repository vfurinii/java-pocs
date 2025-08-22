import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class DungeonGameSimulation extends Simulation {

    HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://localhost:8080")
            .acceptHeader("application/json");

    ScenarioBuilder scn = scenario("Stress Test")
            .exec(http("GET Health")
                    .get("/v1/dungoens")
                    .check(status().is(200)));
//            .pause(1)
//            .exec(http("POST Usuario")
//                    .post("/api/usuarios")
//                    .body(StringBody("{\"nome\":\"Teste\",\"email\":\"teste@example.com\"}")).asJson()
//                    .check(status().is(201)));

    {
        setUp(scn.injectOpen(rampUsersPerSec(1).to(200).during(60))).protocols(httpProtocol);
    }
}
