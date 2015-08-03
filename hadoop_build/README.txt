#################
# READ ME       #
#               #
#################
## author : wychen@nchc.org.tw

This script will build an agile hadoop environment, 
that user = hadoop, and work on /home/hadoop.

 * real workspace
================
all_project_dir=/home/hadoop/tarball
hdfs_working_dir=/home/hadoop/hadoop_dir
hive_metastore_db=/home/hadoop/metastore_db
================

 * other path is 
================
export JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64

export HADOOP_HOME=/home/hadoop/hadoop
export HADOOP_MAPRED_HOME=$HADOOP_HOME
export HADOOP_COMMON_HOME=$HADOOP_HOME
export HADOOP_HDFS_HOME=$HADOOP_HOME
export HADOOP_CONF_DIR=$HADOOP_HOME/etc/hadoop

export YARN_HOME=$HADOOP_HOME
export YARN_CONF_DIR=$HADOOP_HOME/etc/hadoop

export SQOOP_HOME=/home/hadoop/sqoop
export HIVE_HOME=/home/hadoop/hive
export PIG_HOME=/home/hadoop/pig
export HBASE_HOME=/home/hadoop/hbase
export HCAT_HOME=${HIVE_HOME}/hcatalog
export MAHOUT_HOME=/home/hadoop/mahout
export FLUME_HOME=/home/hadoop/flume
export MAVEN_HOME=/home/hadoop/maven
================
