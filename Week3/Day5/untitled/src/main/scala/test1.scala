import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object test1 {
  def main(args: Array[String]): Unit = {
    // create a spark session
    // for Windows
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

    val df2 = spark.read.format("csv").option("sep",",").load("hdfs://localhost:9000/user/hive/warehouse/beva/Bev_BranchA.txt")
    df2.createOrReplaceTempView("beverage")
    spark.sql("SELECT * FROM beverage;").show()
    spark.sql("SELECT _c0 from beverage WHERE _c1='Branch6'").show()

    val df3 = spark.read.option("multiline", "true").json("hdfs://localhost:9000/user/will/people.json")
    df3.createOrReplaceTempView("people2")
    spark.sql("SELECT * from people2 where name='Justin'").show()
  }
}