package phone.impl;

import phone.base.Phone;

public class HomePhone implements Phone {
    @Override
    public void displayPhoneNumber(String phoneNumber) {
        System.out.printf("My home number is %s\n", phoneNumber);
    }
}
