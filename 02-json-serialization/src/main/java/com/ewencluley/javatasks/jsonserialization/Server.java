package com.ewencluley.javatasks.jsonserialization;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class Server {

    public Server() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/status", new StatusHandler());
        server.start();
    }

    public static void main(String[] args) throws IOException {
        new Server();
    }
}
