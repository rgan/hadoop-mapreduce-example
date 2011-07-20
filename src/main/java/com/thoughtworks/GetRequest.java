package com.thoughtworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GetRequest {

    public String get(String uri) throws IOException {
        BufferedReader in = null;
        try {
            URL url = new URL(uri);
            URLConnection urlConnection = url.openConnection();
            in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputLine;
            StringBuffer result = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                result.append(inputLine);
            }
            return result.toString();
        } catch (Exception ex) {
            throw new IOException(ex.getMessage());
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
}
