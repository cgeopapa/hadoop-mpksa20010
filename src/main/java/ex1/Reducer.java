package ex1;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

public class Reducer extends org.apache.hadoop.mapreduce.Reducer<Text, IntWritable, Text, IntWritable>
{
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException
    {
        int noOfFrequency = 0;
        for (IntWritable o : values)
        {
            noOfFrequency++;
        }
        if(noOfFrequency >= 10)
        {
            context.write(key, new IntWritable(noOfFrequency));
        }
    }
}
