import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

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
    df1.createOrReplaceTempView("people")
    spark.sql("SELECT * from people WHERE _c1=23; ").show()

    df1.write.option("path","hdfs://localhost:9000/user/will/test10").saveAsTable("PeopleTable10000")
    spark.sql("SELECT * FROM PeopleTable10000").show()


  }
}
