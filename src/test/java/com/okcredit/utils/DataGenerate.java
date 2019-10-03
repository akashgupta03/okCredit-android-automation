package com.okcredit.utils;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Locale;

public class DataGenerate {


    public String setName() {
        Faker faker = new Faker(new Locale("en-IND"));
        String fullName = faker.name().fullName();
        System.out.println(fullName);
        return fullName;
    }
    public String setPhoneNumber() {
        String phoneNumber = "1" + RandomStringUtils.randomNumeric(9);
        return phoneNumber;
    }


}
