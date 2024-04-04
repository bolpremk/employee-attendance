package com.employee.attendance.listener;

import com.employee.attendance.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Kafka listener for updating entry status received from Kafka topic.
 */
@Component
@Slf4j
public class EntryStatusListener {

    @Autowired
    private ReportService reportService;

    /**
     * Listens for messages on the "attendance_report_topic" Kafka topic.
     * When a message is received, updates the report data with the new status.
     *
     * @param record The Kafka ConsumerRecord containing the message payload.
     */
    @KafkaListener(topics = "attendance_report_topic", groupId = "report-app")
    public void updateStatus(ConsumerRecord<Integer, String> record) {
        Integer employeeId = record.key();
        String status = record.value();
        reportService.updateReportData(Long.valueOf(employeeId), status);
        log.info(employeeId + " : " + status);
    }
}
