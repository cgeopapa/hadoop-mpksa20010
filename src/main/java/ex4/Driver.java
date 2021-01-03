package ex4;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class Driver
{
    public Driver(String[] args)
    {
        if (args.length < 2) {
            System.err.println("input path ");
        }

        try {
            Job job = Job.getInstance();
            job.setJobName("movie genre mean");

            // set file input/output path
            FileInputFormat.addInputPath(job, new Path(args[1]));
            FileOutputFormat.setOutputPath(job, new Path(args[2]));

            // set jar class name
            job.setJarByClass(Driver.class);

            // set mapper and reducer to job
            job.setMapperClass(Mapper.class);
            job.setReducerClass(Reducer.class);

            // set output key class
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(IntWritable.class);

            int returnValue = job.waitForCompletion(true) ? 0 : 1;

            System.out.println(job.isSuccessful());
            System.exit(returnValue);
        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
