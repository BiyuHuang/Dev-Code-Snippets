# ___MyCode___
    my coding~~~~~~~

    Just for practice


# add src code for DataFrame Demo

  val columNum = 5

  def padto(ls: Array[String]): Array[String] = if (ls.length > columNum) ls.dropRight(ls.length - columNum) else ls.padTo(columNum, "")

  val conf = new SparkConf().setMaster("local[*]").setAppName("DfDemo")
  val sc = new SparkContext(conf)

  val data = List(("Wallace Huang", 26, "Male", "Single", "Baseketball"), ("Bruce Wade", 24, "Male", "Double", "Book"),
    ("Lucy Adan", 21, "Female", "Single", "Computer"), ("Lina Anna", 27, "Female", "Double", "Shopping"))
  val rdd = sc.makeRDD(data, 2)
  //  rdd.foreach {
  //    column =>
  //      println(column.take(2).toString)
  //  }
  //  userLog.error("#########" + rdd.collect.toList)
  val df = rdd.map(line => padto(line.toString().split(",", -1)))
    .map(
      column => Person(column(NAME.id),
        column(AGE.id).toInt,
        column(GENDER.id),
        column(MARITAL_STATUS.id),
        column(HOBBY.id))
    ).toDF()
