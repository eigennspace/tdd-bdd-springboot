package com.example.demo.cucumber_junit_5;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DefaultDataTableCellTransformer;
import io.cucumber.java.DefaultDataTableEntryTransformer;
import io.cucumber.java.DefaultParameterTransformer;

import java.lang.reflect.Type;

/***
 * @author : github.com/eigennspace
 * @since : Sat 17/02/2024 22:39
 * @Project : demo
 * @Created_by : IdeaU
 */
public class CucumberConfiguration {

    private final ObjectMapper objectMapper;

    public CucumberConfiguration() {
        objectMapper = new ObjectMapper();
    }

    @DefaultDataTableCellTransformer
    @DefaultDataTableEntryTransformer
    @DefaultParameterTransformer
    public Object transform(final Object from, final Type to) {
        return objectMapper.convertValue(from, objectMapper.constructType(to));
    }
}
