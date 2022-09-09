###### ###############Kafka Tutorial###########

(1) Download kafka binary from the following URL
https://kafka.apache.org/downloads download the scala version. Zookeeper is already included in it. Unzip and  
Start zooKeeper\
./zookeeper-server-start.sh ../config/zookeeper.properties => zookeeper.properties contains the properties stored for
zookeeper.

Start Kafka\
./kafka-server-start.sh ../config/server.properties => we need to change the log folder of kafka(Not done yet)

###### #############Kafka CommandLine Tools############

Kafka CommandLine Tools can be used to quickly setup topic, test consumers and producers
https://docs.cloudera.com/documentation/kafka/latest/topics/kafka_command_line.html

Installation Guide For This Project

create the data volumns for zookeeper and kafka

mkdir -p data/vol1/zk-data&mkdir -p data/vol2/zk-txn-logs&mkdir -p data/vol3/kafka-data

### this one changes the folder to current user

chown -R 1000:1000 /vol1/zk-data&&chown -R 1000:1000 /vol2/zk-txn-logs&&chown -R 1000:1000 /vol3/kafka-data

###### Kafka commands

Commands ./broker-list.sh list all the started kafka brokers

Setup Kafka Using Confluenct Docker

https://docs.confluent.io/platform/current/quickstart/ce-docker-quickstart.html#cp-quickstart-step-1

curl --silent --output docker-compose.yml \
https://raw.githubusercontent.com/confluentinc/cp-all-in-one/7.2.1-post/cp-all-in-one/docker-compose.yml

docker-compose up -d

