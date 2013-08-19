GiraphPageRankRunner
====================

Demonstrates how to run Giraph pagerank within a Java app. Sample input graph is under test-data/ folder.

* Checkout Giraph 1.1.0 and build it (see http://giraph.apache.org/).
* Link giraph-examples-1.1.0-SNAPSHOT-jar-with-dependencies.jar that you built in the first step under lib/ so that run_pagerank.sh script can add it to CLASSPATH correctly.
* Build GiraphPageRankRunner [You may need to put Giraph jars under your local maven directory as 1.1.0 is not officially released]
   mvn clean package
* Upload the sample graph to HDFS:
   hadoop dfs -put test-data/pagerank_input_graph.txt /tmp/
* Run the algorithm
   ./run_pagerank.sh

Please take a look at Main.java to play with the parameters of the algorithm. 
