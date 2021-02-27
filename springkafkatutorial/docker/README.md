create the data volumns for zookeeper and kafka

mkdir -p data/vol1/zk-data&mkdir -p data/vol2/zk-txn-logs&mkdir -p data/vol3/kafka-data

### this one changes the folder to user docker

chown -R 1000:1000 /vol1/zk-data&&chown -R 1000:1000 /vol2/zk-txn-logs&&chown -R 1000:1000 /vol3/kafka-data

###### Kafka commands

Commands ./broker-list.sh list all the started kafka brokers

