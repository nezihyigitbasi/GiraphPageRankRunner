package runner.giraph;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import org.apache.giraph.GiraphRunner;
import org.apache.hadoop.util.ToolRunner;
import org.apache.log4j.Logger;

/**
 * @author Nezih Yigitbasi
 */
public class PageRankRunner implements Callable<Integer> {
	private Logger logger = Logger.getLogger(PageRankRunner.class);

	private GiraphAlgorithm algorithm;
	private AlgorithmParameters params;

	public PageRankRunner(GiraphAlgorithm algorithm, AlgorithmParameters params) {
		this.algorithm = algorithm;
		this.params = params;
	}

	@Override
	public Integer call() throws Exception {
		logger.info("Starting giraph algorithm " + algorithm.getShortName());
		List<String> argsList = new ArrayList<String>();
		argsList.add(algorithm.getAlgorithmClass());
		argsList.addAll(params.getParameterValues());
		return ToolRunner.run(new GiraphRunner(),
				argsList.toArray(new String[argsList.size()]));
	}

}
