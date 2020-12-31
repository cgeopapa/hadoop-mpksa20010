package ex3;

import org.apache.hadoop.io.Text;

import java.io.IOException;
import java.util.StringTokenizer;

public class RatingMapper extends org.apache.hadoop.mapreduce.Mapper<Object, Text, Text, Text>
{
    private boolean header = false;

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException
    {
        if(header)
        {
            String line = value.toString();
            StringTokenizer itr = new StringTokenizer(line, ",");

            String userId = itr.nextToken();
            String movieId = itr.nextToken();
            String rating = itr.nextToken();

            context.write(new Text(movieId), new Text(rating));
        }
        else
        {
            header = true;
        }
    }
}
