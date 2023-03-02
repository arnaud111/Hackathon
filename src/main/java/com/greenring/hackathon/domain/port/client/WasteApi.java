package com.greenring.hackathon.domain.port.client;

import com.greenring.hackathon.application.dto.WasteTrashResponse;

import java.util.List;

public interface WasteApi {

    List<WasteTrashResponse> getPackagingMaterial(String barcode);
}
