package API;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Welcome {
	String ConsumerKey="v7ALA6DLS10E0ebiITh98pyZZ";
	String ConsumerSecret="oVSo6qngPCprr4aFeilRbKB5u9E0dDZ4c9TOVm8sa6QUqbO70G";
	String Token="1174996480915988480-PhlCbvk39TJZjgd5U7GAtRmYT8j3jh";
	String TokenSecret="4zrlQxC9t5Hx8FSvP2mI6RYsVUf14dUFZc90JG2jB5zaf";
	@Test
	public void tweet()
	{
		RestAssured.baseURI="https://api.twitter.com/1.1/direct_messages/welcome_messages/";
		Response res=given().auth(). oauth(ConsumerKey,ConsumerSecret,Token,TokenSecret).
		queryParam("id", "welcome").
		when().get("show.json").then().extract().response();
	         String response=res.asString();
		     System.out.println(response);
		     JsonPath js=new JsonPath(response);
				String id =js.get("id").toString();
				System.out.println("id="+id);
				

}
}
