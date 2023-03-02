package com.greenring.hackathon.domain;

import com.greenring.hackathon.application.service.DistributorService;
import com.greenring.hackathon.application.service.ProductService;
import com.greenring.hackathon.application.service.TrashService;
import com.greenring.hackathon.application.service.UserService;
import com.greenring.hackathon.domain.port.client.DistributorApi;
import com.greenring.hackathon.domain.port.client.ProductApi;
import com.greenring.hackathon.domain.port.client.TrashApi;
import com.greenring.hackathon.domain.port.client.UserApi;
import com.greenring.hackathon.domain.port.server.DistributorPersistenceSpi;
import com.greenring.hackathon.domain.port.server.ProductPersistenceSpi;
import com.greenring.hackathon.domain.port.server.TrashPersistenceSpi;
import com.greenring.hackathon.domain.port.server.UserPersistenceSpi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfiguration {

    @Bean
    DistributorApi distributorApi(DistributorPersistenceSpi distributorPersistenceSpi) {
        return new DistributorService(distributorPersistenceSpi);
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
    UserApi userApi(UserPersistenceSpi userPersistenceSpi) {
        return new UserService(userPersistenceSpi);
    }
}
