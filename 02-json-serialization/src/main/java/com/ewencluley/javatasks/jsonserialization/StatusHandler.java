package com.ewencluley.javatasks.jsonserialization;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class StatusHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        byte[] response = "OK".getBytes(StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(200, response.length);
        OutputStream responseBody = exchange.getResponseBody();
        responseBody.write(response);
        responseBody.close();
    }
}
