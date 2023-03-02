package com.greenring.hackathon.application.service;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.application.service.validator.DistributorValidator;
import com.greenring.hackathon.application.service.validator.UserValidator;
import com.greenring.hackathon.application.service.validator.WalletValidator;
import com.greenring.hackathon.domain.model.Distributor;
import com.greenring.hackathon.domain.model.Product;
import com.greenring.hackathon.domain.model.User;
import com.greenring.hackathon.domain.port.client.DistributorApi;
import com.greenring.hackathon.domain.port.server.DistributorPersistenceSpi;
import com.greenring.hackathon.domain.port.server.ProductPersistenceSpi;
import com.greenring.hackathon.domain.port.server.UserPersistenceSpi;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class DistributorService implements DistributorApi {

    private final DistributorPersistenceSpi distributorSpi;
    private final UserPersistenceSpi userSpi;
    private final ProductPersistenceSpi productSpi;

    @Override
    @Transactional
    public Either<ApplicationError, Distributor> create(Distributor distributor) {
        return DistributorValidator.validate(distributor)
                .toEither()
                .peekLeft(System.out::println)
                .flatMap(distributorSpi::save);
    }

    @Override
    @Transactional
    public List<Distributor> getAll() {
        return distributorSpi.findAll();
    }

    @Override
    @Transactional
    public Option<Distributor> getOne(UUID disctributor_id) {
        return distributorSpi.findById(disctributor_id);
    }

    @Override
    public Either<ApplicationError, User> buyProduct(UUID distributor_id, UUID product_id, UUID user_id) {
        Option<User> findUser = userSpi.findById(user_id);
        Option<Product> findProduct = productSpi.findById(product_id);
        Option<Distributor> findDistributor = distributorSpi.findById(distributor_id);
        User newUser = findUser.get().updateCoins(findUser.get().getCoins() - findProduct.get().getPrice());

        if(WalletValidator.validate(newUser).isValid()){
            Distributor newDistributor = findDistributor.get().deleteProduct(findProduct.get());
            DistributorValidator.validate(newDistributor)
                    .toEither()
                    .peekLeft(System.out::println)
                    .flatMap(distributorSpi::save);
        }
        return WalletValidator.validate(newUser)
                .toEither()
                .peekLeft(System.out::println)
                .flatMap(userSpi::save);

    }

    @Override
    public Either<ApplicationError, Distributor> addProduct(UUID distributor_id, UUID product_id) {
        Option<Product> findProduct = productSpi.findById(product_id);
        Option<Distributor> findDistributor = distributorSpi.findById(distributor_id);
        findDistributor.get().getProducts().add(findProduct.get());
        return DistributorValidator.validate(findDistributor.get())
                .toEither()
                .peekLeft(System.out::println)
                .flatMap(distributorSpi::save);
    }


}
