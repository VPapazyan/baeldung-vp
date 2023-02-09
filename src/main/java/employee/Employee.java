package employee;

import phone.base.Phone;
import phone.impl.HomePhone;

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
