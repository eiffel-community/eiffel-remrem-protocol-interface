/*
    Copyright 2017 Ericsson AB.
    For a full list of individual contributors, please see the commit history.
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/
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
     * Returns the Event Id from json formatted eiffel message. 
     * 
     * @param JsonObject eiffelMessage
     * @return the eventId from eiffelMessage if event id not available then returns the null value
     */
    String getEventId(JsonObject eiffelMessage);

    /**
     * Returns Family Routing Key Word from the messaging library based on the eiffel message eventType.
     * @param JsonObject eiffelMessage
     * @return family routing key word in String format.
     */
    String getFamily(JsonObject eiffelMessage);

    /**
     * Returns Type Routing Key Word from the messaging library based on the eiffel message eventType.
     * @param JsonObject eiffelMessage
     * @return type routing key word in String format.
     */
    String getType(JsonObject eiffelMessage);
    
    /**
     * Returns service name.
     * 
     * @return service name from the messaging library.
     */
    
    String getServiceName();
    
    /**
     * Method validates the jsonObject based on the event message type. 
     * @param JsonObject bodyJson
     * @param jsonvalidateMessage
     * @return ValidationResult with true if validation is success, if validation fails ValidationResult has false and validation message property's.
     */
    ValidationResult validateMsg(String msgType, JsonObject jsonvalidateMessage);
}
