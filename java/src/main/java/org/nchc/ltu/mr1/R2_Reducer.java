package org.nchc.ltu.mr1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class R2_Reducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	@Override
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		
		List<Integer> intlist = new ArrayList<Integer>();

		int sum = 0;
		int count = 0;

		String str = " ## same frame but different solid color ## \n";
		IntWritable iw = new IntWritable();
		for (IntWritable val : values) {
			count++;
			
			sum += val.get();
			intlist.add(val.get());
			// check same range or not
		}
		iw.set(sum);
		context.write(key, iw);
		// same frame different solid color
		if (count > 1) {
			for (int i : intlist ){
				str +=  key.toString() + "==>" + i + "\n";
			}
		}

		OperatingFiles of = new OperatingFiles();
		of.createDir("/tmp/mr_test/result3/");
		of.createFile("/tmp/mr_test/result3/diff_list.txt", str);
		
		
		
	}
}
