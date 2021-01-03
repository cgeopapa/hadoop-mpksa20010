package ex2;

import org.apache.hadoop.io.Text;

import java.io.IOException;

public class TagMapper extends org.apache.hadoop.mapreduce.Mapper<Object, Text, Text, Text>
{
    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException
    {
        String line = value.toString();
        String[] items = line.split("(?!\\B\"[^\"]*),(?![^\"]*\"\\B)");

        String movieId = items[1].trim();
        if(tryParseInt(movieId))
        {
            context.write(new Text(movieId), new Text("_"));
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
