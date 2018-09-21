package com.java.language.serialization;

import java.io.Serializable;

/**
 * Created by titan-developer on 12/12/14.
 */

public class Person implements Serializable {
    private String firstName;
    private String lastName;
    // stupid example for transient
    transient private Thread myThread;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.myThread = new Thread();
    }

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

    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName
                + "]";
    }

}
