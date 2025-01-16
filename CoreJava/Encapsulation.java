
/**
 * Data Encapsulation is an Object-Oriented Programming concept of hiding the
data attributes and their behaviours in a single unit.
It is used for the security of the private properties of an object and hence serves
the purpose of data hiding.
 */
// EncapsulationDemo.java
public class Encapsulation {
    public static void main(String[] args) {
        // Create an instance of the Person class
        Person person = new Person();

        // Set the values using setter methods
        person.setName("John Doe");
        person.setAge(30);

        // Get the values using getter methods
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());

        // Attempt to set invalid age
        person.setAge(-5); // This will display an error message
    }
}

// Person.java
class Person {
    // Private variables to store data
    private String name;
    private int age;

    // Public getter method for name
    public String getName() {
        return name;
    }

    // Public setter method for name
    public void setName(String name) {
        this.name = name;
    }

    // Public getter method for age
    public int getAge() {
        return age;
    }

    // Public setter method for age with validation
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative.");
        }
    }
}
