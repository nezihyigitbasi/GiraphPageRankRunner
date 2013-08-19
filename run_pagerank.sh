for f in lib/*.jar; do
   CLASSPATH=${CLASSPATH}:$f;
done

export CLASSPATH=$CLASSPATH:`hadoop classpath`
export CLASSPATH=$CLASSPATH:GiraphPagerankRunner-1.0.0-SNAPSHOT.jar
#echo $CLASSPATH
java runner.giraph.Main "$@"