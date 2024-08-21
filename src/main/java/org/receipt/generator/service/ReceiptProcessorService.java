package org.receipt.generator.service;

import org.receipt.generator.model.ReceiptPointsResponse;
import org.receipt.generator.model.ReceiptProcessorResponse;
import org.receipt.generator.model.ReceiptRequest;

import java.util.UUID;

public interface ReceiptProcessorService {

    ReceiptProcessorResponse processReceipts(ReceiptRequest receiptRequest);

    ReceiptPointsResponse getPoints(UUID id);
}
