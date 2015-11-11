package org.nchc.ltu.mr1;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.GenericOptionsParser;

public class Color_Run {
	public static void main(String[] args) throws Exception {

		Configuration conf = new Configuration();
		String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();

		String[] str_arr = {"","",""};
		if (otherArgs.length != 2)

		{
			System.err.println("Usage: Color_Run <local_input> <local_output> ");
			System.exit(2);
		}

		OperatingFiles of = new OperatingFiles();
		of.deleteFile("/tmp/mr_test/");
		of.copyFile(otherArgs[0], "/tmp/mr_test/input");
		str_arr[0] = "/tmp/mr_test/input";
		str_arr[1] = "/tmp/mr_test/result1";
		R1_WC.go(str_arr);
		str_arr[0] = "/tmp/mr_test/result1";
		str_arr[1] = "/tmp/mr_test/result2";
		str_arr[2] = "/tmp/mr_test/result3";
		R2_CAC.go(str_arr);
		of.getFile("/tmp/mr_test/", otherArgs[1]);

	}
}
