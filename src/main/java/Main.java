import employee.Employee;
import phone.impl.HomePhone;
import phone.impl.OfficePhone;

public class Main {
    public static void main(String[] args) {
        Employee vahram = new Employee(new HomePhone());
        Employee shayleigh = new Employee(new OfficePhone());

        vahram.getPhone().displayPhoneNumber("+37410203040");
        shayleigh.getPhone().displayPhoneNumber("+37460708090");
    }
}
