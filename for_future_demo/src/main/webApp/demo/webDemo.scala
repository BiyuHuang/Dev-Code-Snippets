package demo
import spray.routing.SimpleRoutingApp

/**
 * Created by Wallace on 2015/11/7.
 */
class webDemo extends App with SimpleRoutingApp{
  implicit val system = ActorSystem("my-system")

  startServer(interface = "localhost", port = 8080) {
    path("hello") {
      get {
        complete {
          <h1>Say hello to spray</h1>
        }
      }
    }
  }
}
