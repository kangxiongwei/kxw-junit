package com.kxw.junit.stubs;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.ResourceHandler;
import org.mortbay.jetty.servlet.Context;

/**
 * Jetty启动服务的示例
 */
public class JettySample {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        Context root = new Context(server, "/");
        root.setResourceBase("E://workspace/pom.xml");
        root.setHandler(new ResourceHandler());
        server.start();
    }
}
