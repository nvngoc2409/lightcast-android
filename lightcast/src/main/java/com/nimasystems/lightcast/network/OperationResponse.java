/*
 * While Clicking Favorite button in Nutrition Sub Catorgory
 * Its used to Update the favorite task form backend
 * After getting success response status will updated for the corressponding item
 * */
package com.nimasystems.lightcast.network;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class OperationResponse {
    private int code;
    private String message;
    private boolean isSuccessful;
    private HashMap<String, Object> data;
    private ApiServerErrorModel serverError;

    private int fetchedDataCount;
    private List<?> fetchedData;

    public OperationResponse(final Object fetchedDataItem) {
        if (fetchedDataItem instanceof ApiServerErrorModel) {
            this.serverError = (ApiServerErrorModel) fetchedDataItem;
            this.isSuccessful = false;
            this.code = serverError.code;
            this.message = serverError.message;
        } else if (fetchedDataItem != null) {
            this.fetchedData = new ArrayList<Object>() {{
                add(fetchedDataItem);
            }};
            this.fetchedDataCount = 1;
            isSuccessful = true;
        }
    }

    public OperationResponse(final List<?> fetchedData, int fetchedDataCount) {
        this.fetchedData = fetchedData;
        this.fetchedDataCount = fetchedDataCount;
        isSuccessful = true;
    }

    public OperationResponse(final HashMap<String, Object> data) {
        this.data = data;
        isSuccessful = true;
    }

    public OperationResponse(int code, final String message, final ApiServerErrorModel serverError) {
        this.code = code;
        this.message = message;
        this.serverError = serverError;
        isSuccessful = false;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public ApiServerErrorModel getServerError() {
        return serverError;
    }

    public int getInt(@NonNull String key) {
        return data != null ? (int) data.get(key) : 0;
    }

    public float getFloat(@NonNull String key) {
        return data != null ? (float) data.get(key) : 0.0f;
    }

    public double getDouble(@NonNull String key) {
        return data != null ? (double) data.get(key) : 0.0f;
    }

    public List<?> getList(@NonNull String key) {
        return data != null ? (List<?>) data.get(key) : null;
    }

    public Date getDate(@NonNull String key) {
        return data != null ? (Date) data.get(key) : null;
    }

    public String getString(@NonNull String key) {
        return data != null ? (String) data.get(key) : "";
    }

    public boolean getBoolean(@NonNull String key) {
        return data != null && (boolean) data.get(key);
    }

    public HashMap<String, Object> getMap(@NonNull String key) {
        //noinspection unchecked
        return data != null ? (HashMap<String, Object>) data.get(key) : null;
    }

    public List<HashMap<String, Object>> getMapList(@NonNull String key) {
        //noinspection unchecked
        return data != null ? (List<HashMap<String, Object>>) data.get(key) : null;
    }

    public int getFetchedDataCount() {
        return fetchedDataCount;
    }

    public List<?> getFetchedData() {
        return fetchedData;
    }

    public Object getFirstObject() {
        return fetchedData != null && fetchedData.size() > 0 ? fetchedData.get(0) : null;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }
}