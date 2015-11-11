package org.nchc.ltu.mr1;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class R2_CAC extends Configured implements Tool {

	public static void main(String[] args) throws Exception {
		String[] argv = { "/tmp/mr_test/result1", "/tmp/mr_test/result2", "/tmp/mr_test/result3" };
		args = argv;

		System.exit(go(args));
	}

	public static int go(String[] args) throws Exception {
		String[] otherArgs = new GenericOptionsParser(args).getRemainingArgs();
		if (otherArgs.length < 3) {
			System.err.println("Usage: R2_CAC <input> <result1> <result2> ");
			System.exit(2);
		}

		int res = ToolRunner.run(new R2_CAC(), args);
		return res;
	}

	public int run(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Configuration conf = new Configuration();

		OperatingFiles otf = new OperatingFiles();

		otf.deleteFile(args[0] + "_SUCCESS");
		otf.deleteFile(args[1]);
		otf.deleteFile(args[2]);
		R2_CAC r2 = new R2_CAC();
		r2.cleanR1Output();

		conf.set("mapred.textoutputformat.separator", "@");
		Job job = Job.getInstance(conf, "R2_CAC");

		job.setJarByClass(R2_CAC.class);
		job.setMapperClass(R2_Mapper.class);
		// job.setCombinerClass(R2_Reducer.class);
		job.setReducerClass(R2_Reducer.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		return (job.waitForCompletion(true) ? 0 : 1);
	}

	private void cleanR1Output() {
		// TODO Auto-generated method stub

	}
}
