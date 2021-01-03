package ex4;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

public class Reducer extends org.apache.hadoop.mapreduce.Reducer<Text, IntWritable, Text, DoubleWritable>
{
    int movieCount = 0;
    int sum = 0;

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException
    {
        movieCount++;
        sum += values.iterator().next().get();
    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException
    {
        double mean = ((double) sum)/movieCount;
        context.write(new Text("Movie genre mean:"), new DoubleWritable(mean));
    }
}
