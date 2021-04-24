package com.ewencluley.javatasks.httprequests;

import com.sun.net.httpserver.HttpExchange;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.mockito.Mockito.*;

public class HandlerPostRqstTest {

    //Create the object to test. Added as a filed to create once
    HandlerPostRqst postRqstHandler = new HandlerPostRqst();

    @Test
    public void givenGetRequest_shouldRespondWith405() throws IOException {
        /*
        1. Receive a request from the client
        2. Verify the header (Anything but POST)
        3. Return header 405
        4. close output
        */

        //Create a mock object of the http exchange class to simulate the action
        HttpExchange mockExchange = mock(HttpExchange.class);

        //mock HTTP request methods and body
        when(mockExchange.getRequestMethod()).thenReturn("GET");

        //add the response to the client **** I don't think I have to add this because the object should stop before sending anything****
        ByteArrayOutputStream bodyResponse = new ByteArrayOutputStream();
        when(mockExchange.getResponseBody()).thenReturn(bodyResponse);

        postRqstHandler.handle(mockExchange);

        String expectedResponse = "Method Not allowed";

        verify(mockExchange).sendResponseHeaders(405, expectedResponse.length());

        Assert.assertEquals(expectedResponse, bodyResponse.toString());
    }

    @Test
    public void givenPostRequestWithSingleChar_shouldReturnSingleChar() throws IOException {

        // creating mock of the httpExchange class to manipulate the client's actions
        HttpExchange exchangeConnection = mock(HttpExchange.class);
        when(exchangeConnection.getRequestMethod()).thenReturn("POST");
        String clientRequestBody = "b";
        ByteArrayInputStream clientBodyInputStream = new ByteArrayInputStream(clientRequestBody.getBytes(StandardCharsets.UTF_8));
        when(exchangeConnection.getRequestBody()).thenReturn(clientBodyInputStream);

        // verify the method is returning the expected data
        ByteArrayOutputStream severResponseBody = new ByteArrayOutputStream();
        when(exchangeConnection.getResponseBody()).thenReturn(severResponseBody);

        postRqstHandler.handle(exchangeConnection);

        Assert.assertEquals(clientRequestBody, severResponseBody.toString());
    }

    @Test
    public void givenPostRequestWithSingleDigit_shouldReturnSingleDigitX2() throws IOException{

        // creating mock of the httpExchange class to manipulate the client's actions
        HttpExchange exchangeHandler = mock(HttpExchange.class);
        when(exchangeHandler.getRequestMethod()).thenReturn("POST");
        String clientRequestBody = "9";
        ByteArrayInputStream clientBodyInputStream = new ByteArrayInputStream(clientRequestBody.getBytes(StandardCharsets.UTF_8));
        when(exchangeHandler.getRequestBody()).thenReturn(clientBodyInputStream);

        //manipulate server's actions
        ByteArrayOutputStream responseBody = new ByteArrayOutputStream();
        when(exchangeHandler.getResponseBody()).thenReturn(responseBody);

        postRqstHandler.handle(exchangeHandler);

        // verify response
        Assert.assertEquals("18", responseBody.toString());
    }

    @Test
    public void givenPostRequestNumberTextBetween_shouldReturnDigitX2StringBetween() throws IOException{

        // creating mock of the httpExchange class to manipulate the client's actions
        HttpExchange exchangeHandler = mock(HttpExchange.class);
        when(exchangeHandler.getRequestMethod()).thenReturn("POST");
        String clientRequestBody = "99f3d";
        ByteArrayInputStream clientBodyInputStream = new ByteArrayInputStream(clientRequestBody.getBytes(StandardCharsets.UTF_8));
        when(exchangeHandler.getRequestBody()).thenReturn(clientBodyInputStream);

        //manipulate server's actions
        ByteArrayOutputStream responseBody = new ByteArrayOutputStream();
        when(exchangeHandler.getResponseBody()).thenReturn(responseBody);

        postRqstHandler.handle(exchangeHandler);

        Assert.assertEquals("198f6d",responseBody.toString());
    }

    @Test
    public void givenPostRequestStartingDigit_shouldReturnDigitX2ThenString() throws IOException{

        // creating mock of the httpExchange class to manipulate the client's actions
        HttpExchange exchangeHandler = mock(HttpExchange.class);
        when(exchangeHandler.getRequestMethod()).thenReturn("POST");
        String clientRequestBody = "25 days ago";
        ByteArrayInputStream clientBodyInputStream = new ByteArrayInputStream(clientRequestBody.getBytes(StandardCharsets.UTF_8));
        when(exchangeHandler.getRequestBody()).thenReturn(clientBodyInputStream);

        //manipulate server's actions
        ByteArrayOutputStream responseBody = new ByteArrayOutputStream();
        when(exchangeHandler.getResponseBody()).thenReturn(responseBody);

        postRqstHandler.handle(exchangeHandler);

        Assert.assertEquals("50 days ago",responseBody.toString());
    }

    @Test
    public void givenPostRequestStartingString_shouldReturnStringThenDigitX2() throws IOException{

        // creating mock of the httpExchange class to manipulate the client's actions
        HttpExchange exchangeHandler = mock(HttpExchange.class);
        when(exchangeHandler.getRequestMethod()).thenReturn("POST");
        String clientRequestBody = "Bladimir is 25 more information times 5";
        ByteArrayInputStream clientBodyInputStream = new ByteArrayInputStream(clientRequestBody.getBytes(StandardCharsets.UTF_8));
        when(exchangeHandler.getRequestBody()).thenReturn(clientBodyInputStream);

        //manipulate server's actions
        ByteArrayOutputStream responseBody = new ByteArrayOutputStream();
        when(exchangeHandler.getResponseBody()).thenReturn(responseBody);

        postRqstHandler.handle(exchangeHandler);

        Assert.assertEquals("Bladimir is 50 more information times 10",responseBody.toString());
    }

    @Test
    public void givenPostRequestWithEmptyString_shouldReturnEmptyString() throws IOException{

        // creating mock of the httpExchange class to manipulate the client's actions
        HttpExchange exchangeHandler = mock(HttpExchange.class);
        when(exchangeHandler.getRequestMethod()).thenReturn("POST");
        String clientRequestBody = "";
        ByteArrayInputStream clientBodyInputStream = new ByteArrayInputStream(clientRequestBody.getBytes(StandardCharsets.UTF_8));
        when(exchangeHandler.getRequestBody()).thenReturn(clientBodyInputStream);

        //manipulate server's actions
        ByteArrayOutputStream responseBody = new ByteArrayOutputStream();
        when(exchangeHandler.getResponseBody()).thenReturn(responseBody);

        postRqstHandler.handle(exchangeHandler);

        Assert.assertEquals("",responseBody.toString());
    }

    @Test
    public void givenPostRequestStartingStringWithMultipleLinesNewLinesString_shouldReturnStartingStringWithMultipleLinesNewLineString() throws IOException{

        // creating mock of the httpExchange class to manipulate the client's actions
        HttpExchange exchangeHandler = mock(HttpExchange.class);
        when(exchangeHandler.getRequestMethod()).thenReturn("POST");
        String clientRequestBody = "Edward makes $90000 a year\n" +
                "4blad3    \n" +
                "b";
        ByteArrayInputStream clientBodyInputStream = new ByteArrayInputStream(clientRequestBody.getBytes(StandardCharsets.UTF_8));
        when(exchangeHandler.getRequestBody()).thenReturn(clientBodyInputStream);

        //manipulate server's actions
        ByteArrayOutputStream responseBody = new ByteArrayOutputStream();
        when(exchangeHandler.getResponseBody()).thenReturn(responseBody);

        postRqstHandler.handle(exchangeHandler);

        Assert.assertEquals("Edward makes $180000 a year\n" +
                "8blad6    \n" +
                "b",responseBody.toString());
    }
}