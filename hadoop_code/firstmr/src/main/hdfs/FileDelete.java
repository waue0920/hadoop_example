package hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

public class FileDelete {


    public void deleteFile(Path path, Configuration conf) throws IOException {
        FileSystem fileSystem = FileSystem.get(conf);

//        Path path = new Path(file);
        if (!fileSystem.exists(path)) {
            System.out.println("File " + path + " does not exists");
            return;
        }
        System.out.println("Path : " + path + " deleted!");
        fileSystem.delete(path, true);

        fileSystem.close();
    }

}