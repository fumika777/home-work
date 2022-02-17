package com.sbrf.reboot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class SerializeUtil {

    private XmlMapper xmlMapper = new XmlMapper();
    private ObjectMapper objectMapper = new ObjectMapper();

    public String requestToXML(Request request) throws JsonProcessingException {
       return xmlMapper.writeValueAsString(request);
    }

    public String responseToXML(Response response) throws JsonProcessingException {
       return xmlMapper.writeValueAsString(response);
    }

    public Response getResponseFromXML (String responseXML) throws JsonProcessingException {
        return xmlMapper.readValue(responseXML, Response.class);
    }

    public Request getRequestFromXML (String requestXML) throws JsonProcessingException {
        return xmlMapper.readValue(requestXML, Request.class);
    }

    public String requestToJson(Request request) throws JsonProcessingException {
       return objectMapper.writeValueAsString(request);
    }

    public String responseToJson(Response response) throws JsonProcessingException {
       return objectMapper.writeValueAsString(response);
    }

    public Request getRequestFromJson(String requestJson) throws JsonProcessingException {
        return objectMapper.readValue(requestJson, Request.class);
    }

    public Response getResponseFromJson(String responseJson) throws JsonProcessingException {
        return objectMapper.readValue(responseJson, Response.class);
    }
}
