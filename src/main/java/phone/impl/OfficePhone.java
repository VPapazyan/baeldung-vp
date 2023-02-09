package phone.impl;

import phone.base.Phone;

public class OfficePhone implements Phone {
    @Override
    public void displayPhoneNumber(String phoneNumber) {
        System.out.printf("My office number is %s\n", phoneNumber);
    }
}
