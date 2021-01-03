package ex2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

public class Reducer extends org.apache.hadoop.mapreduce.Reducer<Text, Text, Text, IntWritable>
{
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException
    {
        int noOfFrequency = 0;
        Text movieTitle = new Text();
        for (Text o : values)
        {
            if(o.toString().trim().equals("_"))
            {
                noOfFrequency++;
            }
            else
            {
                System.out.println(o.toString());
                movieTitle = o;
            }
        }
        context.write(movieTitle, new IntWritable(noOfFrequency));
    }
}
