package com.thoughtworks;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class GetRequestTest {

    @Test
    public void shouldReturnJson() throws IOException {
        String json = new GetRequest().get("http://graph.facebook.com/BostonCollegeAthletics");
        assertTrue(json.contains("likes"));
    }
}
