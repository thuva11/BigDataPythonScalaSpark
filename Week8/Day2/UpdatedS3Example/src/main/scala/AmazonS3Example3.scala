import com.amazonaws.auth.{AWSStaticCredentialsProvider, BasicAWSCredentials}
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.model.GetObjectRequest
import com.amazonaws.services.s3.{AmazonS3, AmazonS3ClientBuilder}

import java.io.File

object AmazonS3Example3 extends App {
  val accessKey = "BFHELSUVENFEMDU8"
  val secretKey = "gkd/73HGJRJEkghenjcjwhdiefjrks923"
  val bucketName = "willsbucket1"

  val credentials = new BasicAWSCredentials(accessKey, secretKey)
  val creds:BasicAWSCredentials = new BasicAWSCredentials(accessKey, secretKey);
  val client:AmazonS3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(creds)).withRegion(Regions.US_EAST_2).build()

  client.putObject(bucketName,"test5",new File("C:\\input\\Bev_BranchA.txt"))
  println(client.getUrl(bucketName,"test5"))
  client.getObject(new GetObjectRequest(bucketName, "test5"),
  (new File("test5.txt")))

}
