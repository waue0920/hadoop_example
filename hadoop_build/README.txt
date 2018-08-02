#################
# READ ME       #
#               #
#################
## author : wychen@nchc.org.tw

### install Java8 ###
$ sudo add-apt-repository ppa:webupd8team/java
$ sudo apt update
$ sudo apt-get install oracle-java8-installer
$ sudo apt-get install oracle-java8-set-default

### ssh login without password ###
$ sudo apt-get install ssh
$ /etc/init.d/ssh start
$ ssh-keygen -t rsa
$ ssh-copy-id localhost
$ ssh 
$ exit

### download the hadoop ###
$ wget http://www.apache.org/dyn/closer.cgi/hadoop/common/hadoop-2.8.4/hadoop-2.8.4.tar.gz
$ tar -xzvf hadoop-2.8.4.tar.gz 
$ sudo mv hadoop-2.8.4 /opt/hadoop

### edit file ###
$ gedit ~/.bashrc
export JAVA_HOME=/usr/lib/jvm/java-8-oracle
export JRE_HOME=/usr/lib/jvm/java-8-oracle/jre
export HADOOP_HOME=/opt/hadoop
export PATH=$HADOOP_HOME/bin:$HADOOP_HOME/sbin:$PATH

$ scp -r hadoop <remote>:~/
$ hadoop namenode -format
$ start-dfs.sh
$ start-yarn.sh
