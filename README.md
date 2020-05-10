# kafka-producer
kafka JSON Producer Template 

Download kafka for windows from below mentioned link
https://www.win-rar.com/fileadmin/winrar-versions/winrar/winrar-x64-590.exe

- Extract downloaded file
- Run Zookeeper server from kafka folder
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

- Run kafka server from kafka folder
.\bin\windows\kafka-server-start.bat .\config\server.properties

- Create Topic from kafka folder
./bin/kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic kafkaMessageBroker001

- Run kafka-conole-consumer for receive message send from springboot(kafka producer)
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning

For producer default port : 9092


Kafka by defult send only String.
Below code to send JSON object.

	@Bean
	public ProducerFactory<String, UserDetails> producerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(config);

	}
	@Bean
	public KafkaTemplate<String, UserDetails> kafkatemplate(){
		return new KafkaTemplate<>(producerFactory());
	}