package com.aegon.calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ResultTest {

    @Test
    public void testResultData(){
       Result result = new Result(3.0);
        assertNotNull(result);
    }

    @Test
    public void testResultSet(){
        Result result = new Result();
        result.setResult(4.0);
        assertEquals(4.0, result.getResult());
    }

    @Test
    public void testResultNull(){
        Result result = null;
        assertNull(result);
    }

    @Test
    public void equalsHashTest() {
        Result result1 = new Result(2.0);
        Result result2 = new Result(3.0);
        Assertions.assertEquals(result1, result1);

        result2.setResult(4.0);
        Assertions.assertFalse(result1.equals(result2));
        Assertions.assertNotEquals(result1.hashCode(), result2.hashCode());


        result2.setResult(result1.getResult());

        assertEquals(result1 ,result2);
        assertEquals(result1.hashCode(), result2.hashCode());

        Assertions.assertFalse(result1.equals(null));
    }
}
