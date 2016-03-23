package com.rest.service

import scala.slick.session.Database

/**
 * Created by Wallace on 2016/2/9.
 */
class DataAccessLayer {
  val db = Database.forURL(url = "jdbc:mysql://%s:%d%s".format(dbHost,dbPort,dbName),user = dbUser,password = dbPassword,driver = "com.mysql.jdbc.Driver")

}
