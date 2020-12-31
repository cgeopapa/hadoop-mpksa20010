package ex2;

import org.apache.hadoop.io.Text;

import java.io.IOException;
import java.util.StringTokenizer;

public class TagMapper extends org.apache.hadoop.mapreduce.Mapper<Object, Text, Text, Text>
{
    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException
    {
        String line = value.toString();
        StringTokenizer itr = new StringTokenizer(line, ",");

        String userId = itr.nextToken();
        if(tryParseInt(userId))
        {
            context.write(new Text(userId), new Text("+1"));
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
