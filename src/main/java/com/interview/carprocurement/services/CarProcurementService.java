package com.interview.carprocurement.services;

import com.interview.carprocurement.data.TransactionRecord;
import com.interview.carprocurement.repository.CarRepository;
import com.interview.carprocurement.repository.LocationRepository;
import com.interview.carprocurement.repository.TransactionRecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/procurement")
@Validated
@Slf4j
public class CarProcurementService {

    private CarRepository carRepository;

    private LocationRepository locationRepository;

    private TransactionRecordRepository transactionRecordRepository;

    @Autowired
    public CarProcurementService(TransactionRecordRepository transactionRecordRepository) {
        this.transactionRecordRepository = transactionRecordRepository;
    }

    public CarProcurementService(CarRepository carRepository, LocationRepository locationRepository,
                                 TransactionRecordRepository transactionRecordRepository) {
        this.carRepository = carRepository;
        this.locationRepository = locationRepository;
        this.transactionRecordRepository = transactionRecordRepository;
    }

    @GetMapping("transactionrecords")
    public Iterator<TransactionRecord> transactionrecords() {
        return transactionRecordRepository.findAll().iterator();
    }

    @GetMapping("transactionrecords/{carId}")
    public List<TransactionRecord> transactionrecordsFor(@PathVariable String carId) {
        log.info("Looking up transaction record for carId {}", carId);
        List<TransactionRecord> transactionRecords = transactionRecordRepository.findAllByCarId(carId);
        if (transactionRecords != null) {
            log.info("Found {} transaction record for carId {}", transactionRecords.size(), carId);
            return transactionRecords;
        }
        return Collections.emptyList();
    }

}
