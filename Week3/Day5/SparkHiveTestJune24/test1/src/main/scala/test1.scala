import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object test1 {
  def main(args: Array[String]): Unit = {
    // create a spark session
    // for Windows
    System.setProperty("hadoop.home.dir", "C:\\hadoop2")
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
    spark.sql("SELECT * FROM people").show()
  }
}
