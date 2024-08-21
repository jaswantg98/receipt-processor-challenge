package org.receipt.generator.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder
public class ReceiptRequest {

    private String retailer;
    private LocalDate purchaseDate;
    private LocalTime purchaseTime;
    private double total;
    private List<ReceiptItem> items;
}
