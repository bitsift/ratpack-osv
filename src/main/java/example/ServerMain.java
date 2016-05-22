package example;

import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.server.RatpackServer;

/**
 * Minimal Ratpack server example for porting to OSv.<br>
 * The server listens on port 8080 and serves URI http://localhost:8080/hello.
 */
public class ServerMain {

  public static void main(String[] args) throws Exception {
    RatpackServer.start(s -> s.serverConfig(serverConfigBuilder -> {
      serverConfigBuilder.port(8080);
      serverConfigBuilder.threads(1);
    }).handlers(chain -> {
      chain.path("hello", new HelloWorldHandler());
    }));
  }

  private static class HelloWorldHandler implements Handler {
    @Override
    public void handle(Context ctx) throws Exception {
      ctx.render("Hello World.");
    }
  }
}

