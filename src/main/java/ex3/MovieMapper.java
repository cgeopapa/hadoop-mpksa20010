package ex3;

import org.apache.hadoop.io.Text;

import java.io.IOException;
import java.util.StringTokenizer;

public class MovieMapper extends org.apache.hadoop.mapreduce.Mapper<Object, Text, Text, Text>
{
    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException
    {
        String line = value.toString();
        StringTokenizer itr = new StringTokenizer(line, ",");

        String movieId = itr.nextToken();
        if(tryParseInt(movieId))
        {
            context.write(new Text(movieId), new Text(itr.nextToken()));
        }
    }

    private boolean tryParseInt(String s)
    {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
