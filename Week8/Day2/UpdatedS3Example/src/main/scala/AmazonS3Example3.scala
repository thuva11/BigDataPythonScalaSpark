import com.amazonaws.auth.{AWSStaticCredentialsProvider, BasicAWSCredentials}
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.model.GetObjectRequest
import com.amazonaws.services.s3.{AmazonS3, AmazonS3ClientBuilder}

import java.io.File

object AmazonS3Example3 extends App {
  val accessKey = "BdfgdfbsdasdvPVV8912"
  val secretKey = "gjsdhmrkdhwbrjfnejd87"
  val bucketName = "willnewbucketjuly26"

  val creds:BasicAWSCredentials = new BasicAWSCredentials(accessKey, secretKey);
  val client:AmazonS3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(creds)).withRegion(Regions.US_EAST_2).build()


  client.putObject(bucketName,"test5",new File("C:\\input\\Bev_BranchA.txt"))
  println(client.getUrl(bucketName,"test5"))
  client.getObject(new GetObjectRequest(bucketName, "test5"),
  (new File("test5.txt")))

}
