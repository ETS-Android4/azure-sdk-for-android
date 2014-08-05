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

package com.microsoft.azure.management;

import com.microsoft.azure.AzureHttpStatus;
import com.microsoft.azure.core.ServiceOperations;
import com.microsoft.azure.core.utils.BOMInputStream;
import com.microsoft.azure.exception.ServiceException;
import com.microsoft.azure.management.models.RoleSizeListResponse;
import com.microsoft.azure.tracing.CloudTracing;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
* The Service Management API includes operations for listing the available role
* sizes for VMs in your subscription.
*/
public class RoleSizeOperationsImpl implements ServiceOperations<ManagementClientImpl>, RoleSizeOperations {
    /**
    * Initializes a new instance of the RoleSizeOperationsImpl class.
    *
    * @param client Reference to the service client.
    */
    RoleSizeOperationsImpl(ManagementClientImpl client) {
        this.client = client;
    }
    
    private ManagementClientImpl client;
    
    /**
    * Gets a reference to the
    * microsoft.windowsazure.management.ManagementClientImpl.
    * @return The Client value.
    */
    public ManagementClientImpl getClient() {
        return this.client;
    }
    
    /**
    * The List Role Sizes operation lists all of the role sizes that are valid
    * for your subscription.
    *
    * @return The List Role Sizes operation response.
    */
    @Override
    public Future<RoleSizeListResponse> listAsync() {
        return this.getClient().getExecutorService().submit(new Callable<RoleSizeListResponse>() { 
            @Override
            public RoleSizeListResponse call() throws Exception {
                return list();
            }
         });
    }
    
    /**
    * The List Role Sizes operation lists all of the role sizes that are valid
    * for your subscription.
    *
    * @throws MalformedURLException Thrown in case of an invalid request URL
    * @throws ProtocolException Thrown if invalid request method
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred
    * @throws XmlPullParserException This exception is thrown to signal XML
    * Pull Parser related faults.
    * @throws DatatypeConfigurationException Invalid datatype configuration
    * @return The List Role Sizes operation response.
    */
    @Override
    public RoleSizeListResponse list() throws MalformedURLException, ProtocolException, ServiceException, IOException, XmlPullParserException, DatatypeConfigurationException {
        // Validate
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            CloudTracing.enter(invocationId, this, "listAsync", tracingParameters);
        }
        
        // Construct URL
        String url = "/" + (this.getClient().getCredentials().getSubscriptionId() != null ? this.getClient().getCredentials().getSubscriptionId().trim() : "") + "/rolesizes";
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
            RoleSizeListResponse result = null;
            // Deserialize Response
            InputStream responseContent = httpRequest.getInputStream();
            result = new RoleSizeListResponse();
            XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
            xmlPullParserFactory.setNamespaceAware(true);
            XmlPullParser xmlPullParser = xmlPullParserFactory.newPullParser();
            xmlPullParser.setInput(new InputStreamReader(new BOMInputStream(responseContent)));
            
            int eventType = xmlPullParser.getEventType();
            while ((eventType == XmlPullParser.END_DOCUMENT) != true) {
                if (eventType == XmlPullParser.START_TAG && "RoleSizes".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) {
                    while ((eventType == XmlPullParser.END_TAG && "RoleSizes".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) != true) {
                        if (eventType == XmlPullParser.START_TAG && "RoleSize".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) {
                            RoleSizeListResponse.RoleSize roleSizeInstance;
                            roleSizeInstance = new RoleSizeListResponse.RoleSize();
                            result.getRoleSizes().add(roleSizeInstance);
                            
                            while ((eventType == XmlPullParser.END_TAG && "RoleSize".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) != true) {
                                if (eventType == XmlPullParser.START_TAG && "Name".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) {
                                    while ((eventType == XmlPullParser.END_TAG && "Name".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) != true) {
                                        String nameInstance;
                                        if (eventType == XmlPullParser.TEXT) {
                                            nameInstance = xmlPullParser.getText();
                                            roleSizeInstance.setName(nameInstance);
                                        }
                                        
                                        eventType = xmlPullParser.next();
                                    }
                                }
                                
                                if (eventType == XmlPullParser.START_TAG && "Label".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) {
                                    while ((eventType == XmlPullParser.END_TAG && "Label".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) != true) {
                                        String labelInstance;
                                        if (eventType == XmlPullParser.TEXT) {
                                            labelInstance = xmlPullParser.getText();
                                            roleSizeInstance.setLabel(labelInstance);
                                        }
                                        
                                        eventType = xmlPullParser.next();
                                    }
                                }
                                
                                if (eventType == XmlPullParser.START_TAG && "Cores".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) {
                                    while ((eventType == XmlPullParser.END_TAG && "Cores".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) != true) {
                                        int coresInstance;
                                        if (eventType == XmlPullParser.TEXT) {
                                            coresInstance = Integer.parseInt(xmlPullParser.getText());
                                            roleSizeInstance.setCores(coresInstance);
                                        }
                                        
                                        eventType = xmlPullParser.next();
                                    }
                                }
                                
                                if (eventType == XmlPullParser.START_TAG && "MemoryInMb".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) {
                                    while ((eventType == XmlPullParser.END_TAG && "MemoryInMb".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) != true) {
                                        int memoryInMbInstance;
                                        if (eventType == XmlPullParser.TEXT) {
                                            memoryInMbInstance = Integer.parseInt(xmlPullParser.getText());
                                            roleSizeInstance.setMemoryInMb(memoryInMbInstance);
                                        }
                                        
                                        eventType = xmlPullParser.next();
                                    }
                                }
                                
                                if (eventType == XmlPullParser.START_TAG && "SupportedByWebWorkerRoles".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) {
                                    while ((eventType == XmlPullParser.END_TAG && "SupportedByWebWorkerRoles".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) != true) {
                                        boolean supportedByWebWorkerRolesInstance;
                                        if (eventType == XmlPullParser.TEXT) {
                                            supportedByWebWorkerRolesInstance = Boolean.parseBoolean(xmlPullParser.getText().toLowerCase());
                                            roleSizeInstance.setSupportedByWebWorkerRoles(supportedByWebWorkerRolesInstance);
                                        }
                                        
                                        eventType = xmlPullParser.next();
                                    }
                                }
                                
                                if (eventType == XmlPullParser.START_TAG && "SupportedByVirtualMachines".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) {
                                    while ((eventType == XmlPullParser.END_TAG && "SupportedByVirtualMachines".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) != true) {
                                        boolean supportedByVirtualMachinesInstance;
                                        if (eventType == XmlPullParser.TEXT) {
                                            supportedByVirtualMachinesInstance = Boolean.parseBoolean(xmlPullParser.getText().toLowerCase());
                                            roleSizeInstance.setSupportedByVirtualMachines(supportedByVirtualMachinesInstance);
                                        }
                                        
                                        eventType = xmlPullParser.next();
                                    }
                                }
                                
                                if (eventType == XmlPullParser.START_TAG && "MaxDataDiskCount".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) {
                                    while ((eventType == XmlPullParser.END_TAG && "MaxDataDiskCount".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) != true) {
                                        int maxDataDiskCountInstance;
                                        if (eventType == XmlPullParser.TEXT) {
                                            maxDataDiskCountInstance = Integer.parseInt(xmlPullParser.getText());
                                            roleSizeInstance.setMaxDataDiskCount(maxDataDiskCountInstance);
                                        }
                                        
                                        eventType = xmlPullParser.next();
                                    }
                                }
                                
                                if (eventType == XmlPullParser.START_TAG && "WebWorkerResourceDiskSizeInMb".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) {
                                    while ((eventType == XmlPullParser.END_TAG && "WebWorkerResourceDiskSizeInMb".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) != true) {
                                        int webWorkerResourceDiskSizeInMbInstance;
                                        if (eventType == XmlPullParser.TEXT) {
                                            webWorkerResourceDiskSizeInMbInstance = Integer.parseInt(xmlPullParser.getText());
                                            roleSizeInstance.setWebWorkerResourceDiskSizeInMb(webWorkerResourceDiskSizeInMbInstance);
                                        }
                                        
                                        eventType = xmlPullParser.next();
                                    }
                                }
                                
                                if (eventType == XmlPullParser.START_TAG && "VirtualMachineResourceDiskSizeInMb".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) {
                                    while ((eventType == XmlPullParser.END_TAG && "VirtualMachineResourceDiskSizeInMb".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) != true) {
                                        int virtualMachineResourceDiskSizeInMbInstance;
                                        if (eventType == XmlPullParser.TEXT) {
                                            virtualMachineResourceDiskSizeInMbInstance = Integer.parseInt(xmlPullParser.getText());
                                            roleSizeInstance.setVirtualMachineResourceDiskSizeInMb(virtualMachineResourceDiskSizeInMbInstance);
                                        }
                                        
                                        eventType = xmlPullParser.next();
                                    }
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
