package com.pragmatic.temp;

public class SystemExample {


    public static void main(String[] args) {
        String firstName = "Janesh";
        String lastName = "Kodi";
        String username = String.format("%s.%s", firstName, lastName) ;
        System.out.println("username = " + username);
    }
}
