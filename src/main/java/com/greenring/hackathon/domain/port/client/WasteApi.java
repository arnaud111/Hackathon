package com.greenring.hackathon.domain.port.client;

import java.util.List;

public interface WasteApi {

    List<String> getPackagingMaterial(String barcode);
}
