#!/bin/bash

cd /home/hadoop/
wget http://crawlzilla.nchc.org.tw/data/hadoop_tarball_cdh532.tar.gz
tar -zxvf hadoop_tarball_cdh532.tar.gz
ln -sf /home/hadoop/tarball/apache-flume-1.6.0-bin flume
ln -sf /home/hadoop/tarball/hadoop-2.5.0-cdh5.3.2 hadoop
ln -sf /home/hadoop/tarball/hbase-0.98.6-cdh5.3.2 hbase
ln -sf /home/hadoop/tarball/hive-0.13.1-cdh5.3.2 hive
ln -sf /home/hadoop/tarball/hue-3.7.0-cdh5.3.2 hue
ln -sf /home/hadoop/tarball/mahout-0.9-cdh5.3.2 mahout
ln -sf /home/hadoop/tarball/apache-maven-3.2.3 maven
ln -sf /home/hadoop/tarball/pig-0.12.0-cdh5.3.2 pig
ln -sf /home/hadoop/tarball/sqoop-1.4.5-cdh5.3.2 sqoop

mv /home/hadoop/bashrc /home/hadoop/.bashrc
source ~/.bashrc

ssh-keygen -t rsa -N "" -f ~/.ssh/id_rsa

sed -i "s|java-7-openjdk-i386|default-java|g" /home/hadoop/hadoop/etc/hadoop/hadoop-env.sh

sed -i "s|java-7-openjdk-i386|default-java|g" /home/hadoop/hadoop/libexec/hadoop-config.sh

cp ~/.ssh/id_rsa.pub ~/.ssh/authorized_keys

sudo apt-get install -y openjdk-7-jdk
sudo apt-get install -y python-software-properties
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install -y oracle-java7-installer
sudo apt-get install -y mysql-server mysql-client libmysql-java

echo "done! you can go to hadoop_sbin_dir, and run start-all.sh"
