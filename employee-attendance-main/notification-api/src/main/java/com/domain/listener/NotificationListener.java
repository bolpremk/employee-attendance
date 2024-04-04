package com.domain.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Kafka listener for handling absentee notifications.
 */
@Slf4j
@Component
public class NotificationListener {

    /**
     * Listens for messages on the "absentee_notification_topic" Kafka topic.
     * When a message is received, logs the employee ID and their attendance status.
     *
     * @param record The Kafka ConsumerRecord containing the message payload.
     */
    @KafkaListener(topics = "absentee_notification_topic", groupId = "notify-app")
    public void notifyAbsentee(ConsumerRecord<Integer, String> record) {
        Integer employeeId = record.key();
        String status = record.value();
        log.info(employeeId + " is " + status + " today");
    }
}
