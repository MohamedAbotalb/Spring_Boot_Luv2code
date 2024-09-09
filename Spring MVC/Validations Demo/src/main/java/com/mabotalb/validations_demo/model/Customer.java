package com.mabotalb.validations_demo.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {

    private String firstName;

    @NotNull(message = "Last name is required")
    @Size(min = 2, message = "Last name must be at least 2 characters long")
    private String lastName = "";

    @Min(value = 0, message = "Free passes must be greater than or equal to 0")
    @Max(value = 10, message = "Free passes must be less than or equal to 10")
    private int freePasses;

    public Customer() {}

    public Customer(String firstName, String lastName, int freePasses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.freePasses = freePasses;
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

    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }
}
