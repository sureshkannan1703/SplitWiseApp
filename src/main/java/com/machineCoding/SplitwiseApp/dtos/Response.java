package com.machineCoding.SplitwiseApp.dtos;

import lombok.Data;

@Data
public class Response {

    private String errormessage;

    private ResponseType responseType;

     static Response response;
    public static Response getFailureResponse(String message){

        response = new Response();
        response.setErrormessage(message);
        response.setResponseType(ResponseType.FAILURE);
        return response;
    }

    public static Response getSuccessResponse(){
        response = new Response();
        response.setResponseType(ResponseType.SUCCESS);
        return response;
    }
}
