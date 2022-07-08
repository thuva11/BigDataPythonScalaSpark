import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{SaveMode, SparkSession}

  object test2 {
  def main(args: Array[String]): Unit = {
    // create a spark session
    val spark = SparkSession
      .builder
      .appName("hello hive")
      .config("spark.master", "local[*]")
      .enableHiveSupport()
      .getOrCreate()
    Logger.getLogger("org").setLevel(Level.ERROR)
    println("created spark session")
    val df1 = spark.read.csv("hdfs://localhost:9000/user/will/people.csv")
    //df1.createOrReplaceTempView("people")
    //spark.sql("SELECT * from people WHERE _c1=23; ").show()

    df1.write.mode(SaveMode.Overwrite).option("path","hdfs://localhost:9000/user/will/test10").saveAsTable("PeopleTable10000")
    spark.sql("SELECT * FROM PeopleTable10000").show()

    spark.read.option("path","hdfs://localhost:9000/user/will/test10").table("PeopleTable10000").show()
    spark.sql("SELECT _c0 As name, _c1 As age FROM PeopleTable10000 where _c1>25 ").show()


  }
}


//https://spark.apache.org/docs/latest/sql-data-sources-hive-tables.html