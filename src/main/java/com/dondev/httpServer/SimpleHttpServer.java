package com.dondev.httpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.logging.Logger;

import com.dondev.httpServer.controller.FurnitureHandler;
import com.dondev.httpServer.controller.HealthHandler;
import com.sun.net.httpserver.HttpServer;

public class SimpleHttpServer {
    private HttpServer server;
    private static final Logger logger = Logger.getLogger(String.valueOf(Main.class));

    // Server Start Method
    public void start(int portId) {
        int port=portId;
        try {
            server = HttpServer.create(new InetSocketAddress(port), 0);
            server.createContext("/api/v1/furniture", new FurnitureHandler.RootHandler());
            server.createContext("/api/v1/health", new HealthHandler.RootHandler());
            server.setExecutor(null);
            server.start();
            logger.info("Server started at " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Server Stop Method
    public void stop() {
        server.stop(0);
        logger.info("Server stopped");
    }
}
