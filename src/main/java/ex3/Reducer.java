package ex3;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

public class Reducer extends org.apache.hadoop.mapreduce.Reducer<Text, Text, Text, DoubleWritable>
{
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException
    {
        double sum = 0;
        int count = 0;
        Text title = new Text();

        for(Text rate: values)
        {
            double thisRate = tryParseDouble(rate.toString());
            if(thisRate == -1)
            {
                title = new Text(rate.toString());
            }
            else
            {
                sum += thisRate;
                count++;
            }
        }

        context.write(title, new DoubleWritable(sum / count));
    }

    private double tryParseDouble(String s)
    {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
