/*
 * Receipt Processor
 * A simple receipt processor
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.api;

import org.openapitools.client.ApiCallback;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.Pair;
import org.openapitools.client.ProgressRequestBody;
import org.openapitools.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import org.openapitools.client.model.Receipt;
import org.openapitools.client.model.ReceiptsIdPointsGet200Response;
import org.openapitools.client.model.ReceiptsProcessPost200Response;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class DefaultApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public DefaultApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DefaultApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    /**
     * Build call for receiptsIdPointsGet
     * @param id The ID of the receipt (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The number of points awarded </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No receipt found for that id </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call receiptsIdPointsGetCall(String id, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/receipts/{id}/points"
            .replaceAll("\\{" + "id" + "\\}", localVarApiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call receiptsIdPointsGetValidateBeforeCall(String id, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling receiptsIdPointsGet(Async)");
        }
        

        okhttp3.Call localVarCall = receiptsIdPointsGetCall(id, _callback);
        return localVarCall;

    }

    /**
     * Returns the points awarded for the receipt
     * Returns the points awarded for the receipt
     * @param id The ID of the receipt (required)
     * @return ReceiptsIdPointsGet200Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The number of points awarded </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No receipt found for that id </td><td>  -  </td></tr>
     </table>
     */
    public ReceiptsIdPointsGet200Response receiptsIdPointsGet(String id) throws ApiException {
        ApiResponse<ReceiptsIdPointsGet200Response> localVarResp = receiptsIdPointsGetWithHttpInfo(id);
        return localVarResp.getData();
    }

    /**
     * Returns the points awarded for the receipt
     * Returns the points awarded for the receipt
     * @param id The ID of the receipt (required)
     * @return ApiResponse&lt;ReceiptsIdPointsGet200Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The number of points awarded </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No receipt found for that id </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ReceiptsIdPointsGet200Response> receiptsIdPointsGetWithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = receiptsIdPointsGetValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<ReceiptsIdPointsGet200Response>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Returns the points awarded for the receipt (asynchronously)
     * Returns the points awarded for the receipt
     * @param id The ID of the receipt (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The number of points awarded </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No receipt found for that id </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call receiptsIdPointsGetAsync(String id, final ApiCallback<ReceiptsIdPointsGet200Response> _callback) throws ApiException {

        okhttp3.Call localVarCall = receiptsIdPointsGetValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<ReceiptsIdPointsGet200Response>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for receiptsProcessPost
     * @param receipt  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns the ID assigned to the receipt </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The receipt is invalid </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call receiptsProcessPostCall(Receipt receipt, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = receipt;

        // create path and map variables
        String localVarPath = "/receipts/process";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call receiptsProcessPostValidateBeforeCall(Receipt receipt, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'receipt' is set
        if (receipt == null) {
            throw new ApiException("Missing the required parameter 'receipt' when calling receiptsProcessPost(Async)");
        }
        

        okhttp3.Call localVarCall = receiptsProcessPostCall(receipt, _callback);
        return localVarCall;

    }

    /**
     * Submits a receipt for processing
     * Submits a receipt for processing
     * @param receipt  (required)
     * @return ReceiptsProcessPost200Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns the ID assigned to the receipt </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The receipt is invalid </td><td>  -  </td></tr>
     </table>
     */
    public ReceiptsProcessPost200Response receiptsProcessPost(Receipt receipt) throws ApiException {
        ApiResponse<ReceiptsProcessPost200Response> localVarResp = receiptsProcessPostWithHttpInfo(receipt);
        return localVarResp.getData();
    }

    /**
     * Submits a receipt for processing
     * Submits a receipt for processing
     * @param receipt  (required)
     * @return ApiResponse&lt;ReceiptsProcessPost200Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns the ID assigned to the receipt </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The receipt is invalid </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ReceiptsProcessPost200Response> receiptsProcessPostWithHttpInfo(Receipt receipt) throws ApiException {
        okhttp3.Call localVarCall = receiptsProcessPostValidateBeforeCall(receipt, null);
        Type localVarReturnType = new TypeToken<ReceiptsProcessPost200Response>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Submits a receipt for processing (asynchronously)
     * Submits a receipt for processing
     * @param receipt  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns the ID assigned to the receipt </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The receipt is invalid </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call receiptsProcessPostAsync(Receipt receipt, final ApiCallback<ReceiptsProcessPost200Response> _callback) throws ApiException {

        okhttp3.Call localVarCall = receiptsProcessPostValidateBeforeCall(receipt, _callback);
        Type localVarReturnType = new TypeToken<ReceiptsProcessPost200Response>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
