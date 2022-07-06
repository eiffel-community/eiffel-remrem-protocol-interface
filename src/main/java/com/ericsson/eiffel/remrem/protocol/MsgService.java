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

import java.util.Collection;

import com.google.gson.JsonElement;
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
     * Generate takes a partial message in JSON format, 
     * validates it and adds mandatory fields before outputting a complete, valid Eiffel message.
     * lenientValidation will perform the only mandatory field validation and non-mandatory validation failures will place in Eiffel message as a new property(remremGenerateFailures)
     * 
     * @param msgType
     * @param jsonMessage
     * @param lenientValidation
     * @return the generated and validate Eiffel messages as json String
     */
    String generateMsg(String msgType, JsonObject jsonMessage, Boolean lenientValidation);

    /**
     * Returns the Event Id from json formatted eiffel message. 
     * 
     * @param JsonObject eiffelMessage
     * @return the eventId from eiffelMessage if event id not available then returns the null value
     */
    String getEventId(JsonObject eiffelMessage);

    /**
     * Returns the Event type from json formatted eiffel message.
     * @param eiffelMessage eiffel message in json format
     * @return the eventType from eiffelMessage if event type is not available then returns the null value
     */
    String getEventType(JsonObject eiffelMessage);

    /** 
     * Returns a collection of event types supported by this protocol.
     * Use iterator to iterate throught the collection.
     * @return collection of supported event types
     */
    Collection<String> getSupportedEventTypes();

    /** 
     * Returns a template for the specified event type.
     * @return Json of template file
     */
    JsonElement getEventTemplate(String eventType);
    
    /**
     * Returns message protocol edition name
     * 
     * @return edition name
     */

    String getProtocolEdition();
    
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
    /**
     * Method validates the jsonObject based on the event message type. 
     * @param JsonObject bodyJson
     * @param jsonvalidateMessage
     * @param lenientValidation
     * @return ValidationResult with true if validation is success, if validation fails ValidationResult has false and validation message property's.
     */
    ValidationResult validateMsg(String msgType, JsonObject jsonvalidateMessage, Boolean lenientValidation);

    /**
     * Returns Routing key from the messaging library based on the eiffel message eventType.<br>
     * In general, Routing key of eiffel message is in the format<br>
                 <b>&lt;protocol&gt;.&lt;family&gt;.&lt;type&gt;.&lt;tag&gt;.&lt;domain&gt;</b><br>
     * &lt;protocol&gt; is used if provided by the protocol library used.<br>
     * &lt;family&gt; and &lt;type&gt; are provided by the protocol library.<br>
     * &lt;tag&gt; which needs to be put in the Routing key<br>
     * &lt;domain&gt; is configured and can be suffixed by a user domain.<br>
     * @param eiffelMessage eiffel message in json format
     * @param tag
     * @param domain from which the message is sent
     * @param userDomainSuffix
     * @return Routing key in String format.
     */
    String generateRoutingKey(JsonObject eiffelMessage, String tag, String domain, String userDomainSuffix);

    /**
     * Returns Routing key from the messaging library based on the eiffel message eventType.<br>
     * In general, Routing key of eiffel message is in the format<br>
                 <b>&lt;protocol&gt;.&lt;family&gt;.&lt;type&gt;.&lt;tag&gt;.&lt;domain&gt;</b><br>
     * &lt;protocol&gt; is used if provided by the protocol library used.<br>
     * &lt;family&gt; and &lt;type&gt; are provided by the protocol library.<br>
     * &lt;type&gt; is configured. If not then, protocol library will provide.<br>
     * &lt;tag&gt; which needs to be put in the Routing key<br>
     * &lt;domain&gt; is configured and can be suffixed by a user domain.<br>
     * @param eiffelMessage eiffel message in json format
     * @param tag
     * @param domain from which the message is sent
     * @param userDomainSuffix
     * @param type
     * @return Routing key in String format.
     */
    String generateRoutingKey(JsonObject eiffelMessage, String tag, String domain, String userDomainSuffix, String type);
}
