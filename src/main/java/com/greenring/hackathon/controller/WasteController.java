package com.greenring.hackathon.controller;

import com.greenring.hackathon.application.service.WasteService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Api
@RequestMapping("/wastes")
public class WasteController {

    /*@GetMapping("/{barcode}")
    public WasteResponse getTrash(@PathVariable String barcode) {

        WasteService wasteService = new WasteService();

        wasteService.getPackagingMaterial(barcode);
        return new WasteResponse();
    }*/
}