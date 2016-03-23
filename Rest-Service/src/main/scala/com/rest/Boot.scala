package com.rest

import javax.security.auth.login.Configuration

import akka.actor.{Props, ActorSystem}
import akka.io.IO
import spray.can.Http


/**
 * Created by Wallace on 2016/2/9.
 */
object Boot extends App with Configuration {

  implicit val system = ActorSystem("rest-service-example")

  val restService = system.actorOf(Props[RestServiceActor],"rest-endpoint")

  IO(Http) ! Http.Bind(restService,serviceHost,servicePort)
}
