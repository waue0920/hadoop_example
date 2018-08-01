package KMeans.mapreduce;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import KMeans.distance.CosineDistance;
import KMeans.distance.DistanceMeasurer;
import KMeans.distance.ManhattanDistance;
import KMeans.model.ClusterCenter;
import KMeans.model.VectorWritable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.mapreduce.Mapper;



// first iteration, k-random centers, in every follow-up iteration we have new calculated centers
public class KMeansMapper extends Mapper<ClusterCenter, VectorWritable, ClusterCenter, VectorWritable> {

	private final List<ClusterCenter> centers = new ArrayList<>();
	private DistanceMeasurer distanceMeasurer;

	@SuppressWarnings("deprecation")
	@Override
	protected void setup(Context context) throws IOException, InterruptedException {
		super.setup(context);
		Configuration conf = context.getConfiguration();
		Path centroids = new Path(conf.get("centroid.path"));
		FileSystem fs = FileSystem.get(conf);

		try (SequenceFile.Reader reader = new SequenceFile.Reader(fs, centroids, conf)) {
			ClusterCenter key = new ClusterCenter();
			IntWritable value = new IntWritable();
			int index = 0;
			while (reader.next(key, value)) {
				ClusterCenter clusterCenter = new ClusterCenter(key);
				clusterCenter.setClusterIndex(index++);
				centers.add(clusterCenter);
			}
		}
		distanceMeasurer = new ManhattanDistance();
	}

	@Override
	protected void map(ClusterCenter key, VectorWritable value, Context context) throws IOException,
			InterruptedException {

		ClusterCenter nearest = null;
		double nearestDistance = Double.MAX_VALUE;
		for (ClusterCenter c : centers) {
			double dist = distanceMeasurer.measureDistance(c.getCenterVector(), value.getVector());
			if (nearest == null) {
				nearest = c;
				nearestDistance = dist;
			} else {
				if (nearestDistance > dist) {
					nearest = c;
					nearestDistance = dist;
				}
			}
		}
		context.write(nearest, value);
	}

}
