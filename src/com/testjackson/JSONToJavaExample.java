package com.testjackson;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by bod on 2/1/15.
 */

public class JSONToJavaExample
{
    public static void main(String[] args)
    {
        Employee employee = null;
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            employee =  mapper.readValue(new File("employee.json"), Employee.class);
        } catch (JsonGenerationException e)
        {
            e.printStackTrace();
        } catch (JsonMappingException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println(employee);
    }
}

