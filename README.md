# kafka-streams-spring-boot-json-example

This is a Spring Boot example of how to read in JSON from a Kakfa topic and, via Kafka Streams, create a single json doc from subsequent JSON documents. 

The reason I created this is because I need to combine multiple JSON different documents into a single JSON document and I could not find a good example for all of the parts. There will be an upstream process to convert the different documents into a single format. A process will listen to the output topic and as changes are emitted, it query the state store to ensure it has the latest in case there are multiple consumers and insert it into full-text index.

To run this locally, 

1. Get Kafka and run it. Follow the directions (if you are running on Windows) in the following link (except get kafka_2.11-1.0.0) -  https://stackoverflow.com/questions/23115013/is-there-an-easy-way-to-install-kafka-on-windows/44514537#44514537. If you are running Linux or OSX, instructions are here - https://kafka.apache.org/quickstart .

2. Create the 3 topics in the KafkaStreamsDefaultConfiguration class.  Instructions are here - https://kafka.apache.org/quickstart#quickstart_createtopic .  

3. Start the Spring Boot app. I like doing it from STS.

4. Start the consumer connecting to the output topic. Instructions for running it are here - https://kafka.apache.org/quickstart#quickstart_consume .

5. Run the producer connecting to the input topic and send JSON messages.	
	a. Instructions are here - https://kafka.apache.org/quickstart#quickstart_send 
	b. The JSON format is like this - {"key":"somekey","words":["word1"]} 
	c. Send subsequent JSON documents changing the "words". e.g. {"key":"somekey","words":["word2"]}.
    
    
If you forget to create the topics first, weird things will happen (i.e. messages might not seem to process till you send another or restart the app). If things get screwed up, stop all the processes (Consumer, App, Producer, Kafka, Zookeeper), delete things in /logs and /tmp and redo 1-5 (sans the install parts - Run Zookeeper, Kafka. Create topics. Run App, Consumer, Producer. Send JSON).