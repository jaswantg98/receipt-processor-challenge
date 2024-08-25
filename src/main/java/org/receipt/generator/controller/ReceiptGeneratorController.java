package org.receipt.generator.controller;

import lombok.RequiredArgsConstructor;
import org.receipt.generator.exception.InvalidReceiptRequestException;
import org.receipt.generator.exception.InvalidUUIDException;
import org.receipt.generator.model.ReceiptPointsResponse;
import org.receipt.generator.model.ReceiptProcessorResponse;
import org.receipt.generator.model.ReceiptRequest;
import org.receipt.generator.service.ReceiptProcessorService;
import org.receipt.generator.util.JsonToReceiptRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ReceiptGeneratorController {

    JsonToReceiptRequest jsonToReceiptRequest;
    @Autowired
    ReceiptProcessorService receiptProcessorService;

    @PostMapping("/process")
    public ResponseEntity<ReceiptProcessorResponse> processReceipts(@RequestBody String receiptRequestJson) {
        try {
            var receiptRequest = JsonToReceiptRequest.fromJson(receiptRequestJson);
            return ResponseEntity.status(HttpStatus.CREATED).body(receiptProcessorService.processReceipts(receiptRequest));
        } catch (InvalidReceiptRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ReceiptProcessorResponse());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ReceiptProcessorResponse());
        }
    }

    @GetMapping("/{id}/points")
    public ResponseEntity<ReceiptPointsResponse> getPoints(@PathVariable UUID id) {
        if (id == null) {
            throw new InvalidUUIDException("The provided ID is null.");
        }

        ReceiptPointsResponse response = receiptProcessorService.getPoints(id);

        if (response == null) {
            throw new InvalidUUIDException("The provided ID is invalid or not found.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
