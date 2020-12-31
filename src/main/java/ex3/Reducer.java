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
        String title = "";

        for(Text rate: values)
        {
            double thisRate = tryParseDouble(rate.toString());
            if(thisRate == -1)
            {
                title = rate.toString();
            }
            else
            {
                sum += thisRate;
                count++;
            }
        }

        context.write(new Text(title), new DoubleWritable(sum / count));
    }

    private double tryParseDouble(String s)
    {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
