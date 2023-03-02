package com.greenring.hackathon.domain;

import com.greenring.hackathon.application.service.*;
import com.greenring.hackathon.domain.port.client.*;
import com.greenring.hackathon.domain.port.server.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfiguration {

    @Bean
    TransactionApi transactionApi(TransactionPersistenceSpi transactionPersistenceSpi) {
        return new TransactionService(transactionPersistenceSpi);
    }
    @Bean
    DistributorApi distributorApi(DistributorPersistenceSpi distributorPersistenceSpi, ProductPersistenceSpi productPersistenceSpi, UserPersistenceSpi userPersistenceSpi) {
        return new DistributorService(distributorPersistenceSpi,userPersistenceSpi,productPersistenceSpi);
    }

    @Bean
    ProductApi productApi(ProductPersistenceSpi productPersistenceSpi) {
        return new ProductService(productPersistenceSpi);
    }

    @Bean
    TrashApi trashApi(TrashPersistenceSpi trashPersistenceSpi) {
        return new TrashService(trashPersistenceSpi);
    }

    @Bean
    UserApi userApi(UserPersistenceSpi userPersistenceSpi, TransactionPersistenceSpi transactionPersistenceSpi) {
        return new UserService(userPersistenceSpi,transactionPersistenceSpi);
    }
}
