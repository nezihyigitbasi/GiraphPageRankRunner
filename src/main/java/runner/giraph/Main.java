package runner.giraph;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.giraph.io.formats.IdWithValueTextOutputFormat;
import org.apache.giraph.io.formats.JsonLongDoubleFloatDoubleVertexInputFormat;
import org.apache.log4j.Logger;

/**
 * 
 * @author Nezih Yigitbasi 
 * Example to run Giraph page rank from java. Tested with Giraph 1.1.0 and Hadoop
 */
public class Main {

	private static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) throws ExecutionException,
			InterruptedException {
		// set input/output paths on HDFS
		String hdfsInputPath = "/tmp/pagerank_graph.txt";
		String hdfsOutputPath = "/tmp/giraph-output";

		// formats for input graph and the output
		// see the classes under org.apache.giraph.io.formats package
		String vertexInputFormat = JsonLongDoubleFloatDoubleVertexInputFormat.class
				.getName();
		String outputFormat = IdWithValueTextOutputFormat.class.getName();
		int numWorkers = 4;

		// setup the parameters of pagerank
		List<String> params = new ArrayList<String>();
		params.add("-vif");
		params.add(vertexInputFormat);
		params.add("-vip");
		params.add(hdfsInputPath);
		params.add("-of");
		params.add(outputFormat);
		params.add("-op");
		params.add(hdfsOutputPath);
		params.add("-w");
		params.add(String.valueOf(numWorkers));
		params.add("-mc");
		params.add(GiraphAlgorithm.PAGERANK.getMasterComputeClass());
		AlgorithmParameters p = new AlgorithmParameters(params);

		// execute in a separate thread
		ExecutorService execService = Executors.newSingleThreadExecutor();
		Integer result = execService.submit(
				new PageRankRunner(GiraphAlgorithm.PAGERANK, p)).get();
		execService.shutdown();
		logger.info("Done " + result);
	}
}
