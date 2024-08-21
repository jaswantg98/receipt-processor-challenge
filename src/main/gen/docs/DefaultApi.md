# DefaultApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**receiptsIdPointsGet**](DefaultApi.md#receiptsIdPointsGet) | **GET** /receipts/{id}/points | Returns the points awarded for the receipt |
| [**receiptsProcessPost**](DefaultApi.md#receiptsProcessPost) | **POST** /receipts/process | Submits a receipt for processing |


<a name="receiptsIdPointsGet"></a>
# **receiptsIdPointsGet**
> ReceiptsIdPointsGet200Response receiptsIdPointsGet(id)

Returns the points awarded for the receipt

Returns the points awarded for the receipt

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String id = "id_example"; // String | The ID of the receipt
    try {
      ReceiptsIdPointsGet200Response result = apiInstance.receiptsIdPointsGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#receiptsIdPointsGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**| The ID of the receipt | |

### Return type

[**ReceiptsIdPointsGet200Response**](ReceiptsIdPointsGet200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The number of points awarded |  -  |
| **404** | No receipt found for that id |  -  |

<a name="receiptsProcessPost"></a>
# **receiptsProcessPost**
> ReceiptsProcessPost200Response receiptsProcessPost(receipt)

Submits a receipt for processing

Submits a receipt for processing

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Receipt receipt = new Receipt(); // Receipt | 
    try {
      ReceiptsProcessPost200Response result = apiInstance.receiptsProcessPost(receipt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#receiptsProcessPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **receipt** | [**Receipt**](Receipt.md)|  | |

### Return type

[**ReceiptsProcessPost200Response**](ReceiptsProcessPost200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returns the ID assigned to the receipt |  -  |
| **400** | The receipt is invalid |  -  |

