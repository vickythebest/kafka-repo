package com.coolhand.kafka.steam.serdes;

import com.coolhand.kafka.steam.domain.Greeting;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
@Slf4j
public class JsonDeserializer<T> implements Deserializer<T> {

    private Class<T> destinationClass;

    public JsonDeserializer(Class<T> destinationClass) {
        this.destinationClass = destinationClass;
    }

    ObjectMapper objectMapper =new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS,false);
    @Override
    public T deserialize(String topic, byte[] data) {
        if(data==null){
            return  null;
        }
        try {
            return objectMapper.readValue(data, destinationClass);
        } catch (IOException e) {
            log.error("IOException Deserializer: {} ",e.getMessage(),e);
            throw new RuntimeException(e);
        }catch (Exception e){
            log.error("Exception Deserializer: {} ",e.getMessage(),e);
            throw new RuntimeException(e);
        }
    }
}
