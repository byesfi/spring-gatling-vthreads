package gatling.basic

import com.byesfi.vthreads.VirtualThreadDemoApplication
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._
import org.springframework.boot.SpringApplication

class VirtualThreadSimulation extends Simulation {

  before {
    val app = SpringApplication.run(classOf[VirtualThreadDemoApplication])
    app.registerShutdownHook()
  }

  val httpProtocol = http
    .baseUrl("http://localhost:8080")
    .acceptHeader("application/json")
    .contentTypeHeader("application/json")

  val vtScenario = scenario("Virtual Thread Scenario").repeat(10) {
    exec(http("Call the Controller")
      .get("/hello/Gatling")
      .check(status.is(200)))
  }

  setUp(
    vtScenario.inject(atOnceUsers(100))
  ).protocols(httpProtocol)

}