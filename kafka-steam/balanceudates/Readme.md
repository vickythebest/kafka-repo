Bank transaction application to update the update the customer bank balance

kafka-console-consumer --bootstrap-server localhost:9092 \
--topic bank-balance-updates-stream-output-v1 \
--from-beginning \
--formatter kafka.tools.DefaultMessageFormatter \
--property print.key=true \
--property print.value=true \
--property key.deserializer=org.apache.kafka.common.serialization.StringDeserializer \
--property value.deserializer=org.apache.kafka.common.serialization.StringDeserializer
