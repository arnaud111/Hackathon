package com.greenring.hackathon.controller.distributor;

import com.greenring.hackathon.controller.distributor.request.CreateDistributorRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/distributor")
public class DistributorController {

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody @Valid CreateDistributorRequest createDistributorRequest) {

    }
}
