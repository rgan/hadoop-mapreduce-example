package com.thoughtworks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContentParserTest {

    @Test
    public void shouldParseLikes() {
        ContentParser contentParser = new ContentParser();
        String json = "{\"id\":\"24867224623\",\"name\":\"Clemson Football\",\"picture\":\"http:\\/\\/profile.ak.fbcdn.net\\/hprofile-ak-snc4\\/41577_24867224623_9223_s.jpg\",\"link\":\"http:\\/\\/www.facebook.com\\/pages\\/Clemson-Football\\/24867224623\",\"likes\":54985,\"category\":\"Professional sports team\",\"location\":{\"city\":\"Clemson\",\"state\":\"SC\",\"country\":\"United States\"}}";
        assertEquals(54985, contentParser.getLikes(json));
    }
}
