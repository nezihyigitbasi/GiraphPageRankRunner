GiraphPageRankRunner
====================

Demonstrates how to run Giraph pagerank within a Java app. Sample input graph is under test-data/ folder.

* Checkout Giraph 1.1.0 and build it (see http://giraph.apache.org/).
* Install Giraph jars to your local mvn repo as 1.1.0 is not officially released yet
* Link giraph-examples-1.1.0-SNAPSHOT-jar-with-dependencies.jar that you built in the first step under lib/ so that run_pagerank.sh can pick it up
* Build GiraphPageRankRunner
   mvn clean package
* Upload the sample graph to HDFS:
   hadoop dfs -put test-data/pagerank_input_graph.txt /tmp/
* Run the algorithm
   ./run_pagerank.sh

Please take a look at Main.java to play with the parameters of the algorithm. If you change the source and rebuild it, don't forget to update the 
GiraphPagerankRunner-1.0.0-SNAPSHOT.jar under lib/ as run_pagerank.sh uses that.
