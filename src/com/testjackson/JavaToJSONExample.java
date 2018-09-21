package com.testjackson;

/**
 * Created by bod on 2/1/15.
 */
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Date;


public class JavaToJSONExample
{
    public static void main(String[] args)
    {
        @SuppressWarnings("deprecation")
        Employee employee = new Employee(1, "Lokesh", "Gupta", new Date(1981,8,18));
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            mapper.writeValue(new File("employee.json"), employee);
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
    }
}
