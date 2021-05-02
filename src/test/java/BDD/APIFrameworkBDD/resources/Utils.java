package BDD.APIFrameworkBDD.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	
	public static RequestSpecification reqSpec;
	public static ResponseSpecification respSpec;
	Properties prop;
	FileInputStream fis;
	JsonPath js;
	String MacPropertiesFilePath="/src/test/java/BDD/APIFrameworkBDD/resources/global.properties";
	
	
	public RequestSpecification requestSpecification() throws FileNotFoundException {
		if(reqSpec==null) {
			PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));		//used for loging request to logging.txt
			reqSpec=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURL")).
					addHeader("Content-Type", "application/json").
					addHeader("authorization", "Bearer dG9rZW5WYWx1ZUZvcktQTUdDb3JwUHVibGljQVBJ").
					addHeader("Host","sodexo-vn.preprod.zeta.in").
					addHeader("Accept-Encoding", "gzip, deflate, br").
					addHeader("Connection","keep-alive").
					//setContentType(ContentType.JSON).                 //used for parsing request to Json
					addFilter(RequestLoggingFilter.logRequestTo(log)).  //used for loging request to logging.txt	
					addFilter(ResponseLoggingFilter.logResponseTo(log)).	//used for loging response to logging.txt	
					build();
			return reqSpec;
		}
		return reqSpec;
		
	}
	
	public ResponseSpecification responseSpecification() {
		if(respSpec==null) {
			respSpec=new ResponseSpecBuilder().expectContentType("application/json;charset=UTF-8").
					expectStatusCode(200).
					expectHeader("Connection", "keep-alive")
					.build();
			return respSpec;
		}
		return respSpec;
		
	}
	
	public String getGlobalValue(String key) throws FileNotFoundException {
		
		try {
			prop=new Properties();
			fis=new FileInputStream(System.getProperty("user.dir")
												+ MacPropertiesFilePath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
	        if (fis != null) {
	            try {
	                fis.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
		}
		
		return prop.getProperty(key);	
	}
	
	public String getJsonPath(Response response, String key) {    //utility to know any key value in json, just call this method
		String resp=response.asString();
		js=new JsonPath(resp);
		return js.get(key).toString();
	}

}
