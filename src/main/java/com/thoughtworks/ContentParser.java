package com.thoughtworks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContentParser {
    public int getLikes(String json) {
        Pattern pattern = Pattern.compile("\"likes\"\\s*:\\s*(\\d+),");
        Matcher matcher = pattern.matcher(json);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 0;
    }
}
