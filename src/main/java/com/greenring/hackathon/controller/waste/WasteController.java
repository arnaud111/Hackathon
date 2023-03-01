package com.greenring.hackathon.controller.waste;

import com.greenring.hackathon.controller.waste.response.WasteResponse;
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

    @GetMapping("/{barcode}")
    public WasteResponse getTrash(@PathVariable String barcode) {

        return new WasteResponse();
    }
}
