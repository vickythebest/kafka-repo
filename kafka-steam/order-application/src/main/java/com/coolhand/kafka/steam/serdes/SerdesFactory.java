package com.coolhand.kafka.steam.serdes;

import com.coolhand.kafka.steam.domain.Order;
import com.coolhand.kafka.steam.domain.Revenue;
import com.coolhand.kafka.steam.domain.Store;
import com.coolhand.kafka.steam.domain.TotalRevenue;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;

public class SerdesFactory {

    public static Serde<Order> orderSerdes(){
        JsonSerializer<Order> jsonSerializer= new JsonSerializer<>();
        JsonDeserializer<Order> jsonDeserializer = new JsonDeserializer<>(Order.class);
        return Serdes.serdeFrom(jsonSerializer,jsonDeserializer);
    }

    public static Serde<Revenue> revenueSerdes(){
        JsonSerializer<Revenue> jsonSerializer= new JsonSerializer<>();
        JsonDeserializer<Revenue> jsonDeserializer = new JsonDeserializer<>(Revenue.class);
        return Serdes.serdeFrom(jsonSerializer,jsonDeserializer);
    }
    public static Serde<TotalRevenue> totalRevenueSerdes(){
        JsonSerializer<TotalRevenue> jsonSerializer= new JsonSerializer<>();
        JsonDeserializer<TotalRevenue> jsonDeserializer = new JsonDeserializer<>(TotalRevenue.class);
        return Serdes.serdeFrom(jsonSerializer,jsonDeserializer);
    }

    public static Serde<Store> storeSerdes() {
        JsonSerializer jsonSerializer=new JsonSerializer();
        JsonDeserializer jsonDeserializer=new JsonDeserializer<>(Store.class);
        return Serdes.serdeFrom(jsonSerializer,jsonDeserializer);
    }
}
