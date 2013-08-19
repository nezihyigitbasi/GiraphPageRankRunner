for f in lib/*.jar; do
   CLASSPATH=${CLASSPATH}:$f;
done

export CLASSPATH=$CLASSPATH:`hadoop classpath`
#echo $CLASSPATH
java runner.giraph.Main "$@"