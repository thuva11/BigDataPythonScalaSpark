import findspark
from pyspark.sql import SparkSession
from pyspark.sql import*
from os.path import abspath

findspark.init()


spark = SparkSession.builder.appName("example-pyspark-hdfs")\
.config("spark.master", "local")\
.enableHiveSupport().getOrCreate()

spark.sparkContext.setLogLevel("ERROR")


print("created Spark Session")