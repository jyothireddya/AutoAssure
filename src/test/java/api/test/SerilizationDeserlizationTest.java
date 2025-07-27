package api.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import api.payload.PlainOldJavaObject;
import api.payload.Student;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;


public class SerilizationDeserlizationTest { 
	
	@Step("TestCase_001")
	
	@Test(priority = 1)
    public void convertPOJOtoJson() throws IOException {
        PlainOldJavaObject data = new PlainOldJavaObject();
        data.setName("jyothireddy");
        data.setLocation("nellore");
        data.setPhone("6893968874");

        ObjectMapper om = new ObjectMapper();
        String jsonData = om.writerWithDefaultPrettyPrinter().writeValueAsString(data);
        System.out.println("Serialized JSON:\n" + jsonData);
    }

    @Test(priority = 2) 
    @Severity(SeverityLevel.CRITICAL)
    @Description(" convert Json to POJO")

    public void convertJsonToPOJO() throws IOException {
        String jsondata = "{\r\n"
                + "  \"id\": 12,\r\n"
                + "  \"email\": \"rachel.howell@reqres.in\",\r\n"
                + "  \"first_name\": \"Rachel\",\r\n"
                + "  \"last_name\": \"Howell\",\r\n"
                + "  \"avatar\": \"https://reqres.in/img/faces/12-image.jpg\"\r\n"
                + "}";

        ObjectMapper om1 = new ObjectMapper();
        Student studata = om1.readValue(jsondata, Student.class);

        System.out.println("Deserialized Student:");
        
        System.out.println("Deserialized Student:");
        System.out.println("ID: " + studata.getId());
        System.out.println("Email: " + studata.getEmail());
        System.out.println("First Name: " + studata.getFirst_name());
        System.out.println("Last Name: " + studata.getLast_name());
        System.out.println("Avatar: " + studata.getAvatar());
       
    }

}
