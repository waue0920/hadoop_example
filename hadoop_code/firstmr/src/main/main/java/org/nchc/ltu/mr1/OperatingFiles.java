package org.nchc.ltu.mr1;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * @author waue
 *
 */
public class OperatingFiles {
	// initialization
	Configuration conf;
	FileSystem hdfs;

	public OperatingFiles() throws IOException {
		this.conf = new Configuration();
		this.hdfs = FileSystem.get(conf);
	}

	// create a direction
	public void createDir(String dir) throws IOException {
		Path path = new Path(dir);
		hdfs.mkdirs(path);
		System.out.println("new dir \t" + conf.get("fs.default.name") + dir);
	}

	public void getFile(String hdfsDst, String localSrc) throws IOException {
		Path dst = new Path(localSrc);
		Path src = new Path(hdfsDst);
		hdfs.copyToLocalFile(src, dst);

		// list all the files in the current direction
		FileStatus files[] = hdfs.listStatus(src);
		System.out.println("download from \t" + conf.get("fs.default.name") + hdfsDst +"to local" );
		for (FileStatus file : files) {
			System.out.println(file.getPath());
		}
	}
	// copy from local file to HDFS file
	public void copyFile(String localSrc, String hdfsDst) throws IOException {
		Path src = new Path(localSrc);
		Path dst = new Path(hdfsDst);
		hdfs.copyFromLocalFile(src, dst);

		// list all the files in the current direction
		FileStatus files[] = hdfs.listStatus(dst);
		System.out.println("Upload to \t" + conf.get("fs.default.name") + hdfsDst);
		for (FileStatus file : files) {
			System.out.println(file.getPath());
		}
	}

	// create a new file
	public void createFile(String fileName, String fileContent) throws IOException {
		Path dst = new Path(fileName);
		byte[] bytes = fileContent.getBytes();
		FSDataOutputStream output = hdfs.create(dst);
		output.write(bytes);
		System.out.println("new file \t" + conf.get("fs.default.name") + fileName);
		output.close();
	}

	// list all files
	public void listFiles(String dirName) throws IOException {
		Path f = new Path(dirName);
		FileStatus[] status = hdfs.listStatus(f);
		System.out.println(dirName + " has all files:");
		for (int i = 0; i < status.length; i++) {
			System.out.println(status[i].getPath().toString());
		}
	}

	// judge a file existed? and delete it!
	public void deleteFile(String fileName) throws IOException {
		Path f = new Path(fileName);
		boolean isExists = hdfs.exists(f);
		if (isExists) { // if exists, delete
			boolean isDel = hdfs.delete(f, true);
			System.out.println(fileName + "  delete? \t" + isDel);
		} else {
			System.out.println(fileName + "  exist? \t" + isExists);
		}
	}

	public static void main(String[] args) throws IOException {
		OperatingFiles ofs = new OperatingFiles();
		System.out.println("\n=======create dir=======");
		String dir = "/tmp/test";
		ofs.createDir(dir);
		System.out.println("\n=======copy file=======");
		String src = "/home/hadoop/examples.desktop";
		ofs.copyFile(src, dir);
		System.out.println("\n=======create a file=======");
		String fileContent = "Hello, world! Just a test.";
		ofs.createFile(dir + "/word.txt", fileContent);
		System.out.println("\n=======delete directory=======");
		ofs.deleteFile(dir);
	}
}