package com.greenring.hackathon.application.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenring.hackathon.application.dto.WasteTrashResponse;
import com.greenring.hackathon.domain.port.client.WasteApi;
import lombok.RequiredArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class WasteService implements WasteApi {


    @Override
    @Transactional
    public List<WasteTrashResponse> getPackagingMaterial(String barcode) {

        try {
            URL url = new URL("https://world.openfoodfacts.org/api/v0/product/" + barcode);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println(response.toString());

            JSONObject myResponse = new JSONObject(response.toString());
            System.out.println("non");
            JSONArray packagingsArray = myResponse.getJSONObject("product").getJSONObject("ecoscore_data").getJSONObject("adjustments").getJSONObject("packaging").getJSONArray("packagings");
            System.out.println(packagingsArray.toString());
            List<WasteTrashResponse> trashList = new ArrayList<>();
            for (int i=0; i < packagingsArray.length(); i++) {
                String material = packagingsArray.getJSONObject(i).getString("material").split(":")[1];
                String shape = packagingsArray.getJSONObject(i).getString("shape").split(":")[1];
                if (shape.equals("unknown"))shape=material;

                WasteTrashResponse trash = new WasteTrashResponse(this.getTrashColorFromMaterial(material), shape, material);
                trashList.add(trash);
            }
            con.disconnect();
            return trashList;

        } catch (IOException | JSONException e) {
            return null;
        }
    }

    private String getTrashColorFromMaterial(String material) {

        return switch (material) {
            case "plastic" -> "yellow";
            case "glass" -> "green";
            case "cardboard", "paper" -> "blue";
            default -> "black";
        };
    }
}
