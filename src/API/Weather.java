package API;

import static io.restassured.RestAssured.given;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Weather {
	int[] k = {1,2295383,28218,23424977,23424852};

	String ConsumerKey="v7ALA6DLS10E0ebiITh98pyZZ";
	String ConsumerSecret="oVSo6qngPCprr4aFeilRbKB5u9E0dDZ4c9TOVm8sa6QUqbO70G";
	String Token="1174996480915988480-PhlCbvk39TJZjgd5U7GAtRmYT8j3jh";
	String TokenSecret="4zrlQxC9t5Hx8FSvP2mI6RYsVUf14dUFZc90JG2jB5zaf";
	Logger l=Logger.getLogger("Weather");
	@Test
	public void tweet()
	{
		PropertyConfigurator.configure("C:\\Selenium\\AutomationTesting\\log4jproperties");
		for(int i=0;i<k.length;i++)
		{
		RestAssured.baseURI="https://api.twitter.com/1.1/trends/";
		Response res=given().auth(). oauth(ConsumerKey,ConsumerSecret,Token,TokenSecret).
		queryParam("id", k[i]).
		when().get("place.json").then().extract().response();
	         String response=res.asString();
	        l.info(response);
		     System.out.println(response);
		}	

}
}