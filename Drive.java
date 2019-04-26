import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Drive {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "JobName");
		job.setJarByClass(Drive.class);
		// TODO: specify a mapper
		job.setMapperClass(Mapp.class);
		// TODO: specify a reducer
		job.setReducerClass(Red.class);
		job.setNumReduceTasks(1);
MultipleInputs.addInputPath(job,new Path("hdfs://localhost:9000/inp"), TextInputFormat.class);
MultipleInputs.addInputPath(job,new Path("hdfs://localhost:9000/inp2"), TextInputFormat.class);		// 
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		FileOutputFormat.setOutputPath(job, new Path("hdfs://localhost:9000/np1"));

		if (!job.waitForCompletion(true))
			return;
	}

}
