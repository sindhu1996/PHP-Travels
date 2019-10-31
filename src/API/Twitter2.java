package API;

import static io.restassured.RestAssured.given;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Twitter2
{
	String ConsumerKey="v7ALA6DLS10E0ebiITh98pyZZ";
	String ConsumerSecret="oVSo6qngPCprr4aFeilRbKB5u9E0dDZ4c9TOVm8sa6QUqbO70G";
	String Token="1174996480915988480-PhlCbvk39TJZjgd5U7GAtRmYT8j3jh";
	String TokenSecret="4zrlQxC9t5Hx8FSvP2mI6RYsVUf14dUFZc90JG2jB5zaf";
	Logger l=Logger.getLogger("Twitter2");
	@Test
	public void tweet()
	{
		PropertyConfigurator.configure("C:\\Selenium\\AutomationTesting\\log4jproperties");
		RestAssured.baseURI="https://api.twitter.com/1.1/search";
		Response res=given().auth(). oauth(ConsumerKey,ConsumerSecret,Token,TokenSecret).
		queryParam("q", "#Qualitest").
		when().get("/tweets.json").then().extract().response();
		
		
		String response=res.asString();
		System.out.println(response);
		l.info(response);
		JsonPath js=new JsonPath(response);
		String id =js.get("statuses.id").toString();
		l.info(id);
		System.out.println("id="+id);
		String text=js.getString("statuses.text").toString();
		l.info(text);
		System.out.println("text="+text);
		String user =js.get("statuses.user.name").toString();
		l.info("username="+user);
		
		
	}
}