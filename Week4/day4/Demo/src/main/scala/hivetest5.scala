import org.apache.spark.sql.SparkSession
import org.apache.log4j.{Level, Logger}
import java.sql.{Connection,DriverManager,ResultSet}


object hivetest5 {

  def main(args: Array[String]): Unit = {
    // create a spark session
    // for Windows
    System.setProperty("hadoop.home.dir", "C:\\Hadoop3")
    val spark = SparkSession
      .builder
      .appName("hello hive")
      .config("spark.master", "local[*]")
      //.config("spark.driver.allowMultipleContexts","true")
      .enableHiveSupport()
      .getOrCreate()
    Logger.getLogger("org").setLevel(Level.ERROR)
    println("created spark session")
    var dfload = spark.read.csv("hdfs://localhost:9000/user/will/people.csv")
    dfload.createOrReplaceTempView("people")
    dfload.show()
    spark.sql("SELECT * FROM people").show()

    //val driver = com.mysql.jdbc.driver
    val url = "jdbc:mysql://localhost:3306/test"
    val user = "root"
    val pass = "p4ssword"

    val sourceDf=spark.read.format("jdbc").option("url",url).option("dbtable","users").option("user",user).option("password",pass).load()
    sourceDf.show()

    sourceDf.createOrReplaceTempView("users1")
    spark.sql("SELECT * FROM users1 where user_id=1").show()

    val sql="select * from users"
    val sourceDf2=spark.read.format("jdbc").option("url",url).option("dbtable",s"( $sql ) as t").option("user",user).option("password",pass).load()
    sourceDf2.show()

    sourceDf2.createOrReplaceTempView("users2")
    spark.sql("SELECT * FROM users2 where user_id=2").show()

    spark.close()
  }
}
