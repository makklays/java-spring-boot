package org.example.web.rest;

public class Response {

    private String message;
    private String status;

    private Object object;

    public Response(String message, String status, Object object) {
        this.message = message;
        this.status = status;
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public Object getObject() {
        return object;
    }
}
