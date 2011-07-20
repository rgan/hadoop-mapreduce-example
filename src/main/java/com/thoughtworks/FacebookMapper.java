package com.thoughtworks;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class FacebookMapper
        extends Mapper<Object, Text, Text, IntWritable> {

    private Text word = new Text();

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        StringTokenizer itr = new StringTokenizer(value.toString());
        while (itr.hasMoreTokens()) {
            // <college_acronym>;http://graph.facebook.com/BostonCollegeAthletics
            String token = itr.nextToken();
            String[] strings = token.split(";");
            word.set(strings[0].trim());
            String json = new GetRequest().get(strings[1].trim());
            int likes = new ContentParser().getLikes(json);
            context.write(word, new IntWritable(likes));
        }
    }
}
