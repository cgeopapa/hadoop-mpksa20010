package ex3;

import org.apache.hadoop.io.Text;

import java.io.IOException;

public class RatingMapper extends org.apache.hadoop.mapreduce.Mapper<Object, Text, Text, Text>
{
    private boolean header = false;

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException
    {
        if(header)
        {
            String line = value.toString();
            String[] items = line.split("(?!\\B\"[^\"]*),(?![^\"]*\"\\B)"); //comma not in quotes

            String movieId = items[1];
            String rating = items[2];
            context.write(new Text(movieId), new Text(rating));
        }
        else
        {
            header = true;
        }
    }
}