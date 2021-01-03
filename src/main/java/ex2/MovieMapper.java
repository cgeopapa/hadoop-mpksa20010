package ex2;

import org.apache.hadoop.io.Text;

import java.io.IOException;

public class MovieMapper extends org.apache.hadoop.mapreduce.Mapper<Object, Text, Text, Text>
{
    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException
    {
        String line = value.toString();
        String[] items = line.split("(?!\\B\"[^\"]*),(?![^\"]*\"\\B)"); //comma not in quotes

        String movieId = items[0].trim();
        if(tryParseInt(movieId))
        {
            context.write(new Text(movieId), new Text(items[1].trim()));
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
