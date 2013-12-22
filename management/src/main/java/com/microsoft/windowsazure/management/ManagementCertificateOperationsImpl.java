// 
// Copyright (c) Microsoft and contributors.  All rights reserved.
// 
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//   http://www.apache.org/licenses/LICENSE-2.0
// 
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// 
// See the License for the specific language governing permissions and
// limitations under the License.
// 

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.windowsazure.management;

import com.microsoft.windowsazure.core.OperationResponse;
import com.microsoft.windowsazure.core.ServiceOperations;
import com.microsoft.windowsazure.core.pipeline.apache.CustomHttpDelete;
import com.microsoft.windowsazure.management.models.ManagementCertificateCreateParameters;
import com.microsoft.windowsazure.management.models.ManagementCertificateGetResponse;
import com.microsoft.windowsazure.management.models.ManagementCertificateListResponse;
import com.microsoft.windowsazure.exception.ServiceException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
* You can use management certificates, which are also known as subscription
* certificates, to authenticate clients attempting to connect to resources
* associated with your Windows Azure subscription.  (see
* http://msdn.microsoft.com/en-us/library/windowsazure/jj154124.aspx for more
* information)
*/
public class ManagementCertificateOperationsImpl implements ServiceOperations<ManagementClientImpl>, ManagementCertificateOperations
{
    /**
    * Initializes a new instance of the ManagementCertificateOperationsImpl
    * class.
    *
    * @param client Reference to the service client.
    */
    ManagementCertificateOperationsImpl(ManagementClientImpl client)
    {
        this.client = client;
    }
    
    private ManagementClientImpl client;
    
    /**
    * Gets a reference to the
    * microsoft.windowsazure.management.ManagementClientImpl.
    */
    public ManagementClientImpl getClient() { return this.client; }
    
    /**
    * The Add Management Certificate operation adds a certificate to the list
    * of management certificates. Management certificates, which are also
    * known as subscription certificates, authenticate clients attempting to
    * connect to resources associated with your Windows Azure subscription.
    * (see http://msdn.microsoft.com/en-us/library/windowsazure/jj154123.aspx
    * for more information)
    *
    * @param parameters Parameters supplied to the Create Management
    * Certificate operation.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    @Override
    public Future<OperationResponse> createAsync(final ManagementCertificateCreateParameters parameters)
    {
        return this.getClient().getExecutorService().submit(new Callable<OperationResponse>() { 
            @Override
            public OperationResponse call() throws Exception
            {
                return create(parameters);
            }
         });
    }
    
    /**
    * The Add Management Certificate operation adds a certificate to the list
    * of management certificates. Management certificates, which are also
    * known as subscription certificates, authenticate clients attempting to
    * connect to resources associated with your Windows Azure subscription.
    * (see http://msdn.microsoft.com/en-us/library/windowsazure/jj154123.aspx
    * for more information)
    *
    * @param parameters Parameters supplied to the Create Management
    * Certificate operation.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    @Override
    public OperationResponse create(ManagementCertificateCreateParameters parameters) throws ParserConfigurationException, SAXException, TransformerConfigurationException, TransformerException, UnsupportedEncodingException, IOException, ServiceException
    {
        // Validate
        if (parameters == null)
        {
            throw new NullPointerException("parameters");
        }
        
        // Tracing
        
        // Construct URL
        String url = this.getClient().getBaseUri() + "/" + this.getClient().getCredentials().getSubscriptionId() + "/certificates";
        
        // Create HTTP transport objects
        HttpPost httpRequest = new HttpPost(url);
        
        // Set Headers
        httpRequest.setHeader("Content-Type", "application/xml");
        httpRequest.setHeader("x-ms-version", "2013-03-01");
        
        // Serialize Request
        String requestContent = null;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document requestDoc = documentBuilder.newDocument();
        
        Element subscriptionCertificateElement = requestDoc.createElementNS("http://schemas.microsoft.com/windowsazure", "SubscriptionCertificate");
        requestDoc.appendChild(subscriptionCertificateElement);
        
        if (parameters.getPublicKey() != null)
        {
            Element subscriptionCertificatePublicKeyElement = requestDoc.createElementNS("http://schemas.microsoft.com/windowsazure", "SubscriptionCertificatePublicKey");
            subscriptionCertificatePublicKeyElement.appendChild(requestDoc.createTextNode(new String(Base64.encodeBase64(parameters.getPublicKey()))));
            subscriptionCertificateElement.appendChild(subscriptionCertificatePublicKeyElement);
        }
        
        if (parameters.getThumbprint() != null)
        {
            Element subscriptionCertificateThumbprintElement = requestDoc.createElementNS("http://schemas.microsoft.com/windowsazure", "SubscriptionCertificateThumbprint");
            subscriptionCertificateThumbprintElement.appendChild(requestDoc.createTextNode(parameters.getThumbprint()));
            subscriptionCertificateElement.appendChild(subscriptionCertificateThumbprintElement);
        }
        
        if (parameters.getData() != null)
        {
            Element subscriptionCertificateDataElement = requestDoc.createElementNS("http://schemas.microsoft.com/windowsazure", "SubscriptionCertificateData");
            subscriptionCertificateDataElement.appendChild(requestDoc.createTextNode(new String(Base64.encodeBase64(parameters.getData()))));
            subscriptionCertificateElement.appendChild(subscriptionCertificateDataElement);
        }
        
        DOMSource domSource = new DOMSource(requestDoc);
        StringWriter stringWriter = new StringWriter();
        StreamResult streamResult = new StreamResult(stringWriter);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(domSource, streamResult);
        requestContent = stringWriter.toString();
        StringEntity entity = new StringEntity(requestContent);
        httpRequest.setEntity(entity);
        httpRequest.setHeader("Content-Type", "application/xml");
        
        // Send Request
        HttpResponse httpResponse = null;
        httpResponse = this.getClient().getHttpClient().execute(httpRequest);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode != 200)
        {
            ServiceException ex = ServiceException.createFromXml(httpRequest, requestContent, httpResponse, httpResponse.getEntity());
            throw ex;
        }
        
        // Create Result
        OperationResponse result = null;
        result = new OperationResponse();
        result.setStatusCode(statusCode);
        if (httpResponse.getHeaders("x-ms-request-id").length > 0)
        {
            result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
        }
        
        return result;
    }
    
    /**
    * The Delete Management Certificate operation deletes a certificate from
    * the list of management certificates. Management certificates, which are
    * also known as subscription certificates, authenticate clients attempting
    * to connect to resources associated with your Windows Azure subscription.
    * (see http://msdn.microsoft.com/en-us/library/windowsazure/jj154127.aspx
    * for more information)
    *
    * @param thumbprint the thumbprint value of the certificate to delete.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    @Override
    public Future<OperationResponse> deleteAsync(final String thumbprint)
    {
        return this.getClient().getExecutorService().submit(new Callable<OperationResponse>() { 
            @Override
            public OperationResponse call() throws Exception
            {
                return delete(thumbprint);
            }
         });
    }
    
    /**
    * The Delete Management Certificate operation deletes a certificate from
    * the list of management certificates. Management certificates, which are
    * also known as subscription certificates, authenticate clients attempting
    * to connect to resources associated with your Windows Azure subscription.
    * (see http://msdn.microsoft.com/en-us/library/windowsazure/jj154127.aspx
    * for more information)
    *
    * @param thumbprint the thumbprint value of the certificate to delete.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    @Override
    public OperationResponse delete(String thumbprint) throws IOException, ServiceException
    {
        // Validate
        if (thumbprint == null)
        {
            throw new NullPointerException("thumbprint");
        }
        
        // Tracing
        
        // Construct URL
        String url = this.getClient().getBaseUri() + "/" + this.getClient().getCredentials().getSubscriptionId() + "/certificates/" + thumbprint;
        
        // Create HTTP transport objects
        CustomHttpDelete httpRequest = new CustomHttpDelete(url);
        
        // Set Headers
        httpRequest.setHeader("x-ms-version", "2013-03-01");
        
        // Send Request
        HttpResponse httpResponse = null;
        httpResponse = this.getClient().getHttpClient().execute(httpRequest);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode != 200 && statusCode != 404)
        {
            ServiceException ex = ServiceException.createFromXml(httpRequest, null, httpResponse, httpResponse.getEntity());
            throw ex;
        }
        
        // Create Result
        OperationResponse result = null;
        result = new OperationResponse();
        result.setStatusCode(statusCode);
        if (httpResponse.getHeaders("x-ms-request-id").length > 0)
        {
            result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
        }
        
        return result;
    }
    
    /**
    * The Get Management Certificate operation retrieves information about the
    * management certificate with the specified thumbprint. Management
    * certificates, which are also known as subscription certificates,
    * authenticate clients attempting to connect to resources associated with
    * your Windows Azure subscription.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/jj154131.aspx for
    * more information)
    *
    * @param thumbprint The thumbprint value of the certificate to retrieve
    * information about.
    * @return The Get Management Certificate operation response.
    */
    @Override
    public Future<ManagementCertificateGetResponse> getAsync(final String thumbprint)
    {
        return this.getClient().getExecutorService().submit(new Callable<ManagementCertificateGetResponse>() { 
            @Override
            public ManagementCertificateGetResponse call() throws Exception
            {
                return get(thumbprint);
            }
         });
    }
    
    /**
    * The Get Management Certificate operation retrieves information about the
    * management certificate with the specified thumbprint. Management
    * certificates, which are also known as subscription certificates,
    * authenticate clients attempting to connect to resources associated with
    * your Windows Azure subscription.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/jj154131.aspx for
    * more information)
    *
    * @param thumbprint The thumbprint value of the certificate to retrieve
    * information about.
    * @return The Get Management Certificate operation response.
    */
    @Override
    public ManagementCertificateGetResponse get(String thumbprint) throws IOException, ServiceException, ParserConfigurationException, SAXException, URISyntaxException, ParseException
    {
        // Validate
        if (thumbprint == null)
        {
            throw new NullPointerException("thumbprint");
        }
        
        // Tracing
        
        // Construct URL
        String url = this.getClient().getBaseUri() + "/" + this.getClient().getCredentials().getSubscriptionId() + "/certificates/" + thumbprint;
        
        // Create HTTP transport objects
        HttpGet httpRequest = new HttpGet(url);
        
        // Set Headers
        httpRequest.setHeader("x-ms-version", "2013-03-01");
        
        // Send Request
        HttpResponse httpResponse = null;
        httpResponse = this.getClient().getHttpClient().execute(httpRequest);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode != 200)
        {
            ServiceException ex = ServiceException.createFromXml(httpRequest, null, httpResponse, httpResponse.getEntity());
            throw ex;
        }
        
        // Create Result
        ManagementCertificateGetResponse result = null;
        // Deserialize Response
        InputStream responseContent = httpResponse.getEntity().getContent();
        result = new ManagementCertificateGetResponse();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document responseDoc = documentBuilder.parse(responseContent);
        
        NodeList elements = responseDoc.getElementsByTagName("SubscriptionCertificate");
        Element subscriptionCertificateElement = elements.getLength() > 0 ? ((Element)elements.item(0)) : null;
        if (subscriptionCertificateElement != null)
        {
            NodeList elements2 = subscriptionCertificateElement.getElementsByTagName("SubscriptionCertificatePublicKey");
            Element subscriptionCertificatePublicKeyElement = elements2.getLength() > 0 ? ((Element)elements2.item(0)) : null;
            if (subscriptionCertificatePublicKeyElement != null)
            {
                byte[] subscriptionCertificatePublicKeyInstance;
                subscriptionCertificatePublicKeyInstance = subscriptionCertificatePublicKeyElement.getTextContent() != null ? Base64.decodeBase64(subscriptionCertificatePublicKeyElement.getTextContent().getBytes()) : null;
                result.setPublicKey(subscriptionCertificatePublicKeyInstance);
            }
            
            NodeList elements3 = subscriptionCertificateElement.getElementsByTagName("SubscriptionCertificateThumbprint");
            Element subscriptionCertificateThumbprintElement = elements3.getLength() > 0 ? ((Element)elements3.item(0)) : null;
            if (subscriptionCertificateThumbprintElement != null)
            {
                String subscriptionCertificateThumbprintInstance;
                subscriptionCertificateThumbprintInstance = subscriptionCertificateThumbprintElement.getTextContent();
                result.setThumbprint(subscriptionCertificateThumbprintInstance);
            }
            
            NodeList elements4 = subscriptionCertificateElement.getElementsByTagName("SubscriptionCertificateData");
            Element subscriptionCertificateDataElement = elements4.getLength() > 0 ? ((Element)elements4.item(0)) : null;
            if (subscriptionCertificateDataElement != null)
            {
                byte[] subscriptionCertificateDataInstance;
                subscriptionCertificateDataInstance = subscriptionCertificateDataElement.getTextContent() != null ? Base64.decodeBase64(subscriptionCertificateDataElement.getTextContent().getBytes()) : null;
                result.setData(subscriptionCertificateDataInstance);
            }
            
            NodeList elements5 = subscriptionCertificateElement.getElementsByTagName("Created");
            Element createdElement = elements5.getLength() > 0 ? ((Element)elements5.item(0)) : null;
            if (createdElement != null)
            {
                Calendar createdInstance;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(simpleDateFormat.parse(createdElement.getTextContent()));
                createdInstance = calendar;
                result.setCreated(createdInstance);
            }
        }
        
        result.setStatusCode(statusCode);
        if (httpResponse.getHeaders("x-ms-request-id").length > 0)
        {
            result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
        }
        
        return result;
    }
    
    /**
    * The List Management Certificates operation lists and returns basic
    * information about all of the management certificates associated with the
    * specified subscription. Management certificates, which are also known as
    * subscription certificates, authenticate clients attempting to connect to
    * resources associated with your Windows Azure subscription.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/jj154105.aspx for
    * more information)
    *
    * @return The List Management Certificates operation response.
    */
    @Override
    public Future<ManagementCertificateListResponse> listAsync()
    {
        return this.getClient().getExecutorService().submit(new Callable<ManagementCertificateListResponse>() { 
            @Override
            public ManagementCertificateListResponse call() throws Exception
            {
                return list();
            }
         });
    }
    
    /**
    * The List Management Certificates operation lists and returns basic
    * information about all of the management certificates associated with the
    * specified subscription. Management certificates, which are also known as
    * subscription certificates, authenticate clients attempting to connect to
    * resources associated with your Windows Azure subscription.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/jj154105.aspx for
    * more information)
    *
    * @return The List Management Certificates operation response.
    */
    @Override
    public ManagementCertificateListResponse list() throws IOException, ServiceException, ParserConfigurationException, SAXException, ParseException
    {
        // Validate
        
        // Tracing
        
        // Construct URL
        String url = this.getClient().getBaseUri() + "/" + this.getClient().getCredentials().getSubscriptionId() + "/certificates";
        
        // Create HTTP transport objects
        HttpGet httpRequest = new HttpGet(url);
        
        // Set Headers
        httpRequest.setHeader("x-ms-version", "2013-03-01");
        
        // Send Request
        HttpResponse httpResponse = null;
        httpResponse = this.getClient().getHttpClient().execute(httpRequest);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode != 200)
        {
            ServiceException ex = ServiceException.createFromXml(httpRequest, null, httpResponse, httpResponse.getEntity());
            throw ex;
        }
        
        // Create Result
        ManagementCertificateListResponse result = null;
        // Deserialize Response
        InputStream responseContent = httpResponse.getEntity().getContent();
        result = new ManagementCertificateListResponse();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document responseDoc = documentBuilder.parse(responseContent);
        
        NodeList elements = responseDoc.getElementsByTagName("SubscriptionCertificates");
        Element subscriptionCertificatesSequenceElement = elements.getLength() > 0 ? ((Element)elements.item(0)) : null;
        if (subscriptionCertificatesSequenceElement != null)
        {
            for (int i1 = 0; i1 < subscriptionCertificatesSequenceElement.getElementsByTagName("SubscriptionCertificate").getLength(); i1 = i1 + 1)
            {
                org.w3c.dom.Element subscriptionCertificatesElement = ((org.w3c.dom.Element)subscriptionCertificatesSequenceElement.getElementsByTagName("SubscriptionCertificate").item(i1));
                ManagementCertificateListResponse.SubscriptionCertificate subscriptionCertificateInstance = new ManagementCertificateListResponse.SubscriptionCertificate();
                result.getSubscriptionCertificates().add(subscriptionCertificateInstance);
                
                NodeList elements2 = subscriptionCertificatesElement.getElementsByTagName("SubscriptionCertificatePublicKey");
                Element subscriptionCertificatePublicKeyElement = elements2.getLength() > 0 ? ((Element)elements2.item(0)) : null;
                if (subscriptionCertificatePublicKeyElement != null)
                {
                    byte[] subscriptionCertificatePublicKeyInstance;
                    subscriptionCertificatePublicKeyInstance = subscriptionCertificatePublicKeyElement.getTextContent() != null ? Base64.decodeBase64(subscriptionCertificatePublicKeyElement.getTextContent().getBytes()) : null;
                    subscriptionCertificateInstance.setPublicKey(subscriptionCertificatePublicKeyInstance);
                }
                
                NodeList elements3 = subscriptionCertificatesElement.getElementsByTagName("SubscriptionCertificateThumbprint");
                Element subscriptionCertificateThumbprintElement = elements3.getLength() > 0 ? ((Element)elements3.item(0)) : null;
                if (subscriptionCertificateThumbprintElement != null)
                {
                    String subscriptionCertificateThumbprintInstance;
                    subscriptionCertificateThumbprintInstance = subscriptionCertificateThumbprintElement.getTextContent();
                    subscriptionCertificateInstance.setThumbprint(subscriptionCertificateThumbprintInstance);
                }
                
                NodeList elements4 = subscriptionCertificatesElement.getElementsByTagName("SubscriptionCertificateData");
                Element subscriptionCertificateDataElement = elements4.getLength() > 0 ? ((Element)elements4.item(0)) : null;
                if (subscriptionCertificateDataElement != null)
                {
                    byte[] subscriptionCertificateDataInstance;
                    subscriptionCertificateDataInstance = subscriptionCertificateDataElement.getTextContent() != null ? Base64.decodeBase64(subscriptionCertificateDataElement.getTextContent().getBytes()) : null;
                    subscriptionCertificateInstance.setData(subscriptionCertificateDataInstance);
                }
                
                NodeList elements5 = subscriptionCertificatesElement.getElementsByTagName("Created");
                Element createdElement = elements5.getLength() > 0 ? ((Element)elements5.item(0)) : null;
                if (createdElement != null)
                {
                    Calendar createdInstance;
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(simpleDateFormat.parse(createdElement.getTextContent()));
                    createdInstance = calendar;
                    subscriptionCertificateInstance.setCreated(createdInstance);
                }
            }
        }
        
        result.setStatusCode(statusCode);
        if (httpResponse.getHeaders("x-ms-request-id").length > 0)
        {
            result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
        }
        
        return result;
    }
}
