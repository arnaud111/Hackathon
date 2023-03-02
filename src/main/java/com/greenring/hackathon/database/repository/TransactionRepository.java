package com.greenring.hackathon.database.repository;

import com.greenring.hackathon.database.entity.ProductEntity;
import com.greenring.hackathon.database.entity.TransactionEntity;
import io.vavr.control.Option;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends MongoRepository<TransactionEntity, String> {
    Option<TransactionEntity> findBy_id(UUID _id);

    @Query(value = "{'user_id' :  ?0, 'date' : {$gte :  ?1}, 'product_id' :  null}")
    List<TransactionEntity> findAllTransactionsby_idAnddate(UUID _id, LocalDateTime startDate, LocalDateTime endDate);

    @Query(value = "{'user_id' :  ?0, 'date' : {$gte :  ?1, $lte :  ?2}}")
    List<TransactionEntity> findAllTransactionsbyDate(UUID _id, LocalDateTime startDate, LocalDateTime endDate);
}
