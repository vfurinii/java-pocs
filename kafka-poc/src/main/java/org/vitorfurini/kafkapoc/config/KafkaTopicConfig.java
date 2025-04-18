package org.vitorfurini.kafkapoc.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name("events-topic").build();
    }

    @Bean
    public NewTopic topicJson() {
        return TopicBuilder.name("events-topic-json").build();
    }
}
