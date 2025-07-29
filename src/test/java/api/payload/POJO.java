package api.payload;

public class POJO {

	 private String firstName;
	    private String lastName;
	    private int age;

	    // Default constructor
	    public POJO() {
	    }

	    // Parameterized constructor
	    public POJO(String firstName, String lastName, int age) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.age = age;
	    }

	    // Getters and setters
	    public String getFirstName() {
	        return firstName;
	    }
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }
	    public String getLastName() {
	        return lastName;
	    }
	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }
	    public int getAge() {
	        return age;
	    }
	    public void setAge(int age) {
	        this.age = age;
	    }

	    // toString
	    @Override
	    public String toString() {
	        return firstName + " " + lastName + ", Age: " + age;
	    }

}
