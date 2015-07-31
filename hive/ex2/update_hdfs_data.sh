bin=`dirname "$0"`
bin=`cd "$bin"; pwd`
cd $bin;

hadoop fs -rmr ./hive_2_input

if [ ! -d ./input ];then
    echo "[Warn] Can't find input dir; execute command first"
    echo " ./get_taiwan_landprice.sh"
    exit 0 ;
fi
hadoop fs -put input ./hive_2_input

