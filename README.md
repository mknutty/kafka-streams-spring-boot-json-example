# kafka-streams-spring-boot-json-example

This is a Spring Boot example of how to read in JSON from a Kakfa topic and, via Kafka Streams, create a single json doc from subsequent JSON documents. 

The reason I created this is because I need to combine multiple JSON different documents into a single JSON document and I could not find a good example for all of the parts. There will be an upstream process to convert the different documents into a single format. A process will listen to the output topic and as changes are emitted, it query the state store to ensure it has the latest in case there are multiple consumers and insert it into full-text index.
