package api.test;

import api.payload.POJO;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

 

public class SerilizationDeseriliztionTest {

	  @Test(priority = 1, groups = { "sanity", "regression", "functionality"})
    public void SerilizationDeseriliztionTests() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Faker faker = new Faker();

        // Create a POJO object and set values using Faker
        POJO person = new POJO();
        person.setFirstName(faker.name().firstName());
        person.setLastName(faker.name().lastName());
        person.setAge(faker.number().numberBetween(18, 80));

        // Serialize: Java object to JSON string
        String jsonString = mapper.writeValueAsString(person);
        System.out.println("Serialized JSON:\n" + jsonString);

        // Create a JSON input string using Faker data for deserialization example
        String jsonInput = String.format(
            "{\"firstName\":\"%s\",\"lastName\":\"%s\",\"age\":%d}",
            faker.name().firstName(),
            faker.name().lastName(),
            faker.number().numberBetween(18, 80)
        );

        // Deserialize: JSON string back to Java object
        POJO deserializedPerson = mapper.readValue(jsonInput, POJO.class);
        System.out.println("Deserialized Java Object:\n" + deserializedPerson);
    }
}
