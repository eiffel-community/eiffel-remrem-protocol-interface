package com.ericsson.eiffel.remrem.protocol;

import com.google.gson.JsonObject;

public interface MsgService {

    /**
     * Generate takes a partial message in JSON format, 
     * validates it and adds mandatory fields before outputting a complete, valid Eiffel message.
     * 
     * @param String msgType
     * @param JsonObject jsonMessage
     * @return the generated and validate Eiffel messages as json String
     */
    String generateMsg(String msgType, JsonObject jsonMessage);

    /**
     * Returns the Event Id from the json object.
     * 
     * @param JsonObject bodyJson
     * @return the eventId from json object if event id not available then returns the null value
     */
    String getEventId(JsonObject bodyJson);

    /**
     * Returns Family.
     * 
     * @return Family from the messaging library.
     */
    String getFamily();

    /**
     * Returns event type.
     * 
     * @return event type from the messaging library.
     */
    String getType();
    
    /**
     * Returns service name.
     * 
     * @return service name from the messaging library.
     */
    
    String getServiceName();
    
    /**
     * Method validates the jsonObject based on the event message type. 
     * @param JsonObject bodyJson
     * @param msgType
     * @return ValidationResult with true if validation is success, if validation fails ValidationResult has false and validation message property's.
     */
    ValidationResult validateMsg(String msgType, JsonObject bodyJson);
}
