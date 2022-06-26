package com.pragmatic.util;

import com.github.javafaker.Faker;

public class RandomData {

    static Faker faker;

    public RandomData(){
        faker = new Faker();
    }

    public   static String getFirstName() {
        return faker.name().firstName();
    }
}
