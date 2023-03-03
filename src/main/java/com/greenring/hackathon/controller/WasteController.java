package com.greenring.hackathon.controller;

import com.greenring.hackathon.application.dto.WasteTrashResponse;
import com.greenring.hackathon.application.service.WasteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/wastes")
public class WasteController {

    @GetMapping("/{barcode}")
    public List<WasteTrashResponse> getTrash(@PathVariable String barcode) {
        WasteService wasteService = new WasteService();
        return wasteService.getPackagingMaterial(barcode);
    }
}
