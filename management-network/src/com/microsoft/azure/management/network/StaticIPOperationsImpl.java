/**
 * 
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.azure.management.network;

import com.microsoft.azure.AzureHttpStatus;
import com.microsoft.azure.core.ServiceOperations;
import com.microsoft.azure.core.utils.BOMInputStream;
import com.microsoft.azure.exception.ServiceException;
import com.microsoft.azure.management.network.models.NetworkStaticIPAvailabilityResponse;
import com.microsoft.azure.tracing.CloudTracing;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
* The Network Management API includes operations for managing the static IPs
* for your subscription.
*/
public class StaticIPOperationsImpl implements ServiceOperations<NetworkManagementClientImpl>, StaticIPOperations {
    /**
    * Initializes a new instance of the StaticIPOperationsImpl class.
    *
    * @param client Reference to the service client.
    */
    StaticIPOperationsImpl(NetworkManagementClientImpl client) {
        this.client = client;
    }
    
    private NetworkManagementClientImpl client;
    
    /**
    * Gets a reference to the
    * microsoft.windowsazure.management.network.NetworkManagementClientImpl.
    * @return The Client value.
    */
    public NetworkManagementClientImpl getClient() {
        return this.client;
    }
    
    /**
    * The Check Static IP operation retrieves the details for the availability
    * of static IP addresses for the given virtual network.
    *
    * @param networkName Required. The name of the virtual network.
    * @param ipAddress Required. The address of the static IP.
    * @return A response that indicates the availability of a static IP
    * address, and if not, provides a list of suggestions.
    */
    @Override
    public Future<NetworkStaticIPAvailabilityResponse> checkAsync(final String networkName, final InetAddress ipAddress) {
        return this.getClient().getExecutorService().submit(new Callable<NetworkStaticIPAvailabilityResponse>() { 
            @Override
            public NetworkStaticIPAvailabilityResponse call() throws Exception {
                return check(networkName, ipAddress);
            }
         });
    }
    
    /**
    * The Check Static IP operation retrieves the details for the availability
    * of static IP addresses for the given virtual network.
    *
    * @param networkName Required. The name of the virtual network.
    * @param ipAddress Required. The address of the static IP.
    * @throws MalformedURLException Thrown in case of an invalid request URL
    * @throws ProtocolException Thrown if invalid request method
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred
    * @throws XmlPullParserException This exception is thrown to signal XML
    * Pull Parser related faults.
    * @return A response that indicates the availability of a static IP
    * address, and if not, provides a list of suggestions.
    */
    @Override
    public NetworkStaticIPAvailabilityResponse check(String networkName, InetAddress ipAddress) throws MalformedURLException, ProtocolException, ServiceException, IOException, XmlPullParserException {
        // Validate
        if (networkName == null) {
            throw new NullPointerException("networkName");
        }
        if (ipAddress == null) {
            throw new NullPointerException("ipAddress");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("networkName", networkName);
            tracingParameters.put("ipAddress", ipAddress);
            CloudTracing.enter(invocationId, this, "checkAsync", tracingParameters);
        }
        
        // Construct URL
        String url = "/" + (this.getClient().getCredentials().getSubscriptionId() != null ? this.getClient().getCredentials().getSubscriptionId().trim() : "") + "/services/networking/" + networkName.trim() + "?";
        url = url + "op=checkavailability";
        url = url + "&" + "address=" + URLEncoder.encode(ipAddress.getHostAddress(), "UTF-8");
        String baseUrl = this.getClient().getBaseUri().toString();
        // Trim '/' character from the end of baseUrl and beginning of url.
        if (baseUrl.charAt(baseUrl.length() - 1) == '/') {
            baseUrl = baseUrl.substring(0, (baseUrl.length() - 1) + 0);
        }
        if (url.charAt(0) == '/') {
            url = url.substring(1);
        }
        url = baseUrl + "/" + url;
        url = url.replace(" ", "%20");
        
        // Create HTTP transport objects
        URL serverAddress = new URL(url);
        HttpURLConnection httpRequest = ((HttpURLConnection) serverAddress.openConnection());
        httpRequest.setRequestMethod("GET");
        httpRequest.setDoInput(true);
        
        // Set Headers
        httpRequest.setRequestProperty("x-ms-version", "2014-05-01");
        
        // Set Credentials
        this.getClient().getCredentials().processRequest(httpRequest);
        
        // Send Request
        try {
            int statusCode = httpRequest.getResponseCode();
            if (statusCode != AzureHttpStatus.OK) {
                ServiceException ex = null;
                if (httpRequest.getResponseCode() < 400) {
                    ex = ServiceException.createFromXml(null, httpRequest.getResponseMessage(), httpRequest.getResponseCode(), httpRequest.getContentType(), httpRequest.getInputStream());
                } else {
                    ex = ServiceException.createFromXml(null, httpRequest.getResponseMessage(), httpRequest.getResponseCode(), httpRequest.getContentType(), httpRequest.getErrorStream());
                }
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            NetworkStaticIPAvailabilityResponse result = null;
            // Deserialize Response
            InputStream responseContent = httpRequest.getInputStream();
            result = new NetworkStaticIPAvailabilityResponse();
            XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
            xmlPullParserFactory.setNamespaceAware(true);
            XmlPullParser xmlPullParser = xmlPullParserFactory.newPullParser();
            xmlPullParser.setInput(new InputStreamReader(new BOMInputStream(responseContent)));
            
            int eventType = xmlPullParser.getEventType();
            while ((eventType == XmlPullParser.END_DOCUMENT) != true) {
                if (eventType == XmlPullParser.START_TAG && "AddressAvailabilityResponse".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) {
                    while ((eventType == XmlPullParser.END_TAG && "AddressAvailabilityResponse".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) != true) {
                        if (eventType == XmlPullParser.START_TAG && "IsAvailable".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) {
                            while ((eventType == XmlPullParser.END_TAG && "IsAvailable".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) != true) {
                                boolean isAvailableInstance;
                                if (eventType == XmlPullParser.TEXT) {
                                    isAvailableInstance = Boolean.parseBoolean(xmlPullParser.getText().toLowerCase());
                                    result.setIsAvailable(isAvailableInstance);
                                }
                                
                                eventType = xmlPullParser.next();
                            }
                        }
                        
                        if (eventType == XmlPullParser.START_TAG && "AvailableAddresses".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) {
                            while ((eventType == XmlPullParser.END_TAG && "AvailableAddresses".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) != true) {
                                if (eventType == XmlPullParser.TEXT) {
                                    result.getAvailableAddresses().add(InetAddress.getByName(xmlPullParser.getText()));
                                }
                                
                                eventType = xmlPullParser.next();
                            }
                        }
                        
                        eventType = xmlPullParser.next();
                    }
                }
                
                eventType = xmlPullParser.next();
            }
            
            result.setStatusCode(statusCode);
            result.setRequestId(httpRequest.getHeaderField("x-ms-request-id"));
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpRequest != null) {
                httpRequest.disconnect();
            }
        }
    }
}
