package com.greenring.hackathon.controller;

import com.greenring.hackathon.application.dto.TransactionCreationDto;
import com.greenring.hackathon.application.dto.TransactionSearchDto;
import com.greenring.hackathon.application.mapper.TransactionDtoMapper;
import com.greenring.hackathon.domain.model.Transaction;
import com.greenring.hackathon.domain.port.client.TransactionApi;
import io.swagger.annotations.Api;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
@Api
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionApi transactionsApi;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody @Valid TransactionCreationDto dto) {

        return transactionsApi
                .create(TransactionDtoMapper.transactionCreationToDomain(dto))
                .map(TransactionDtoMapper::toDto)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }

    @GetMapping(value = "/{transactions_id}")
    public Option<Transaction> getTransaction(@PathVariable UUID transactions_id) {
        return transactionsApi
                .getOne(transactions_id);
    }

    @GetMapping(value = "/")
    public List<Transaction> getTransactions() {
        return transactionsApi
                .getAll();
    }

    @GetMapping(value = "/today/{user_id}")
    public List<Transaction> getTodaytransactions(@PathVariable UUID user_id){
        LocalDateTime today = LocalDate.now().atTime(0,0);
        System.out.println(today);
        return transactionsApi.getToday(user_id,today,today);

    }

    @GetMapping(value = "/historic/{user_id}")
    public List<Transaction> getTransactionsByDate(@PathVariable UUID user_id, @RequestBody TransactionSearchDto dto){
        return transactionsApi.getHistoric(user_id,
                dto.startDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                dto.endDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
        );

    }
}
