package com.coolhand.kafka.steam.orders.service;

import com.coolhand.kafka.stream.orders.domain.TotalRevenue;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.state.QueryableStoreType;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.apache.kafka.streams.state.ReadOnlyWindowStore;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.stereotype.Service;

@Service
public class OrderStoreService {

    StreamsBuilderFactoryBean streamsBuilderFactoryBean;

    public OrderStoreService(StreamsBuilderFactoryBean streamsBuilderFactoryBean) {
        this.streamsBuilderFactoryBean = streamsBuilderFactoryBean;
    }


    public ReadOnlyKeyValueStore<String , TotalRevenue> orderRevenueStore(String storeName) {
        return streamsBuilderFactoryBean.getKafkaStreams()
                .store(StoreQueryParameters.fromNameAndType(
                        storeName,
                        QueryableStoreTypes.keyValueStore()
                ));
    }
    public ReadOnlyKeyValueStore<String ,Long> orderCountStore(String storeName) {

        return streamsBuilderFactoryBean.getKafkaStreams()
                .store(StoreQueryParameters.fromNameAndType(
                        storeName,
                        QueryableStoreTypes.keyValueStore()
                ));
    }

    public ReadOnlyWindowStore<String ,Long> orderWindowsCountStore(String storeName) {
        return streamsBuilderFactoryBean.getKafkaStreams()
                .store(StoreQueryParameters.fromNameAndType(
                        storeName,
                        QueryableStoreTypes.windowStore()
                ));
    }

    public ReadOnlyWindowStore<String, TotalRevenue> orderWindowsRenenueStore(String storeName) {
        return streamsBuilderFactoryBean.getKafkaStreams()
                .store(StoreQueryParameters.fromNameAndType(
                        storeName,
                        QueryableStoreTypes.windowStore()
                ));
    }
}
