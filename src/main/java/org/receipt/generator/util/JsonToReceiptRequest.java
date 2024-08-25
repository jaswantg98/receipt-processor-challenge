package org.receipt.generator.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.log4j.Log4j2;
import org.receipt.generator.exception.InvalidReceiptRequestException;
import org.receipt.generator.model.ReceiptItem;
import org.receipt.generator.model.ReceiptRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class JsonToReceiptRequest {

    public static ReceiptRequest fromJson(String jsonString) {
        try {
            JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();

            // Validate required fields
            if (!jsonObject.has("retailer") || jsonObject.get("retailer").getAsString().isEmpty()) {
                throw new InvalidReceiptRequestException("Missing required field: retailer");
            }
            if (!jsonObject.has("purchaseDate") || jsonObject.get("purchaseDate").getAsString().isEmpty()) {
                throw new InvalidReceiptRequestException("Missing required field: purchaseDate");
            }
            if (!jsonObject.has("purchaseTime") || jsonObject.get("purchaseTime").getAsString().isEmpty()) {
                throw new InvalidReceiptRequestException("Missing required field: purchaseTime");
            }
            if (!jsonObject.has("total") || jsonObject.get("total").getAsString().isEmpty()) {
                throw new InvalidReceiptRequestException("Missing required field: total");
            }
            if (!jsonObject.has("items") || !jsonObject.get("items").isJsonArray()) {
                throw new InvalidReceiptRequestException("Missing required field: items");
            }

            String retailer = jsonObject.get("retailer").getAsString();
            LocalDate purchaseDate = LocalDate.parse(jsonObject.get("purchaseDate").getAsString());
            LocalTime purchaseTime = LocalTime.parse(jsonObject.get("purchaseTime").getAsString());
            double total = Double.parseDouble(jsonObject.get("total").getAsString());

            JsonArray itemsArray = jsonObject.getAsJsonArray("items");
            List<ReceiptItem> items = new ArrayList<>();
            for (int i = 0; i < itemsArray.size(); i++) {
                JsonObject itemObject = itemsArray.get(i).getAsJsonObject();
                ReceiptItem item = ReceiptItem.builder()
                        .shortDescription(itemObject.get("shortDescription").getAsString())
                        .price(Double.parseDouble(itemObject.get("price").getAsString()))
                        .build();
                items.add(item);
            }

            return ReceiptRequest.builder()
                    .retailer(retailer)
                    .purchaseDate(purchaseDate)
                    .purchaseTime(purchaseTime)
                    .items(items)
                    .total(total)
                    .build();
        } catch (InvalidReceiptRequestException e) {
            log.error("Validation error: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("Exception occurred during parsing input request due to: {}", e.getMessage());
            throw new InvalidReceiptRequestException("Invalid JSON format or missing required fields.");
        }
    }
}