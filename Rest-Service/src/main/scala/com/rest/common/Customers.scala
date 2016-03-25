package com.rest.common

import scala.slick.driver.MySQLDriver.simple._
import scala.slick.lifted.ColumnBase

/**
 * Created by Wallace on 2016/2/9.
 */
object Customers extends Table[Customer]("customers") {
  def id = column[Long]("id",O.PrimaryKey,O.AutoInc)

  def firstName = column[String]("first_name")

  def lastName = column[String]("last_name")

  def birthday = column[java.util.Date]("birthday",O.Nullable)

  override def * : ColumnBase[Customer] = id.? ~ firstName ~ lastName ~ birthday.? <>(Customer, Customer.unapply _)

  implicit val dateTypeMapper = MappedTypeMapper.base[java.util.Date,java.sql.Date](
  {
    ud =>new java.sql.Date(ud.getTime)

  }, {
    sd => new java.util.Date(sd.getTime)
  })

  val findById = for {
    id <- Parameters[Long]
    c <- this if c.id is id
  } yield c
}