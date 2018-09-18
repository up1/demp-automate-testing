package sck.demo.application;

import java.util.Objects;

public class SuccessResponse {

    private String responseCode;
    private String responseMessage;
    private String result;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "SuccessResponse{" +
                "responseCode='" + responseCode + '\'' +
                ", responseMessage='" + responseMessage + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuccessResponse response = (SuccessResponse) o;
        return Objects.equals(responseCode, response.responseCode) &&
                Objects.equals(responseMessage, response.responseMessage) &&
                Objects.equals(result, response.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(responseCode, responseMessage, result);
    }
}
