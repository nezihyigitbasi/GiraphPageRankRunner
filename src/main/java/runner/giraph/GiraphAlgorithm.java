package runner.giraph;

import org.apache.giraph.examples.SimplePageRankComputation;
import org.apache.giraph.graph.Computation;
import org.apache.giraph.master.MasterCompute;

/**
 * @author Nezih Yigitbasi
 */
public enum GiraphAlgorithm {
	PAGERANK("pagerank", SimplePageRankComputation.class, SimplePageRankComputation.SimplePageRankMasterCompute.class);

	private <T> GiraphAlgorithm(String shortName,
			Class<? extends Computation<?, ?, ?, ?, ?>> mainClass,
			Class<? extends MasterCompute> masterComputeClass) {
		this.clazz = mainClass;
		this.shortName = shortName;
		this.masterComputeClass = masterComputeClass;
	}

	public String getShortName() {
		return shortName;
	}

	public String getAlgorithmClass() {
		return clazz.getName();
	}

	public String getMasterComputeClass() {
		return getAlgorithmClass() + "$" + masterComputeClass.getSimpleName();
	}

	private String shortName;// descriptive short name
	private Class<? extends Computation<?, ?, ?, ?, ?>> clazz;// impl class
	private Class<? extends MasterCompute> masterComputeClass;// master compute
																// class
}
