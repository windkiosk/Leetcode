package com.testjackson;

/**
 * Created by bod on 2/1/15.
 */
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public class Employee
{
    private Integer id;
    private String firstName;
    private String lastName;

    public Employee(){

    }

    public Employee(Integer id, String firstName, String lastName, Date birthDate){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    @Override
    public String toString()
    {
        return "Employee [id=" + id + ", firstName=" + firstName + ", " +
                "lastName=" + lastName + "]";
    }
}
