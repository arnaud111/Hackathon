package com.greenring.hackathon.controller.distributor;

import com.greenring.hackathon.controller.distributor.request.CreateDistributorRequest;
import com.greenring.hackathon.domain.model.Distributor;
import com.greenring.hackathon.domain.port.client.DistributorApi;
import lombok.RequiredArgsConstructor;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Api
@RequestMapping("/distributors")
public class DistributorController {

    private final DistributorApi api;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody @Valid CreateDistributorRequest createDistributorRequest) {
        Distributor newDistributor = Distributor.builder()
                .name(createDistributorRequest.getName())
                .room(createDistributorRequest.getRoom())
                .build();

        return api
                .create(newDistributor)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }
}
