package runner.giraph;

import java.util.List;

/**
 * @author Nezih Yigitbasi
 * Command line arguments for the algorithm.
 */
public class AlgorithmParameters {
	private List<String> parameterValues;

	public AlgorithmParameters(List<String> parameterValues) {
		this.parameterValues = parameterValues;
	}

	public List<String> getParameterValues() {
		return parameterValues;
	}

}
