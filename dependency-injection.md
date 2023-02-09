Dependency injection is a design pattern that helps us avoid __tight coupling__ in a code. 
It removes the dependencies of specific implementations and makes the code more flexible. 
Before exploring the idea of dependency injection, let's see what we mean by tight coupling. 
Assume you have such an ```Employee``` class:

```
public class Employee {
    private Phone phone;

    public Employee() {
        this.phone = new HomePhone();
    }
    
    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
```

In this code, the ```Phone``` is an interface with only one method:

```
public interface Phone {
    void displayPhoneNumber(String phoneNumber);
}
```

It has two implementations. The first one is the ```HomePhone``` class:

```
public class HomePhone implements Phone {
    @Override
    public void displayPhoneNumber(String phoneNumber) {
        System.out.printf("My home number is %s\n", phoneNumber);
    }
}
```

and the second one is the ```OfficePhone``` class:

```
public class OfficePhone implements Phone {
    @Override
    public void displayPhoneNumber(String phoneNumber) {
        System.out.printf("My office number is %s\n", phoneNumber);
    }
}
```

This ```Employee``` implementation has one issue, we hardcoded the ```Phone``` implementation inside the ```Employee```
class constructor. Every time we create an ```Employee``` object and invoke the ```displayPhoneNumber()``` method it 
will print the output using the ```HomePhone``` object:

```
public class Main {
    public static void main(String[] args) {
        Employee vahram = new Employee();
        Employee shayleigh = new Employee();

        // Prints My home number is +37410203040
        vahram.getPhone().displayPhoneNumber("+37410203040");
        // Prints My home number is +37460708090
        shayleigh.getPhone().displayPhoneNumber("+37460708090");
    }
}
```

This is the tough coupling. The ```Employee``` class is coupled with the specific implementation of the ```Phone``` 
interface. If we want to have the opportunity to decide which ```Phone``` implementation to choose when creating the
```Employee``` object we can apply the dependency injection pattern. This way, we can inject the desired implementation 
into the ```Employee``` object in different ways, for instance using the constructor or a setter. Now, let's update the ```Employee``` class this way:

```
public class Employee {
    private Phone phone;

    public Employee(Phone phone) {
        this.phone = phone;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
```

Here we don't specify any implementation and can decide which implementation(dependency) to "inject" into the 
```Employee``` constructor by switching between different implementations. This is what they call a __loose coupling__. 
After applying the dependency injection we can have a ```Main``` class like this:

```
public class Main {
    public static void main(String[] args) {
        Employee vahram = new Employee(new HomePhone());
        Employee shayleigh = new Employee(new OfficePhone());

        vahram.getPhone().displayPhoneNumber("+374(10)203040"));
        shayleigh.getPhone().displayPhoneNumber("+374(60)708090");
    }
}
```

There are two different ```Employee``` objects injected with different ```Phone``` implementations. 

With this code sample, you can understand that such an approach not only gives you freedom of choice and 
makes the code reusable but also brings benefits when testing the application since you can easily create mock 
objects and inject them into your tests. This is why you should use the dependency injection pattern.
