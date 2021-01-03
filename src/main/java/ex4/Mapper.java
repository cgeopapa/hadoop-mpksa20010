package ex4;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

public class Mapper extends org.apache.hadoop.mapreduce.Mapper<Object, Text, Text, IntWritable>
{
    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException
    {
        String line = value.toString();
        String[] items = line.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)"); //comma not in quotes

        String title = items[1];
        int genreCount = items[2].split("\\|").length;
        context.write(new Text(title), new IntWritable(genreCount));
    }
}
