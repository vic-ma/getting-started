package org.acme.getting.started;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jdk.jfr.*;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws Exception {
        Alpha a = new Alpha();
        Beta b = new Beta();
        Gamma g = new Gamma();

        a.begin();
        methodAlpha();
        a.commit();

        b.begin();
        methodBeta();
        b.commit();

        g.begin();
        methodGamma();
        g.commit();

        return "Hello RESTEasy";
    }

    @Name("org.acme.getting.started.Alpha")
    @Label("Alpha")
    @Description("Event for the methodAlpha method")
    static class Alpha extends Event {
    }

    @Name("org.acme.getting.started.Beta")
    @Label("Beta")
    @Description("Event for the methodBeta method")
    static class Beta extends Event {
    }

    @Name("org.acme.getting.started.Gamma")
    @Label("Gamma")
    @Description("Event for the methodGamma method")
    static class Gamma extends Event {
    }

    static void methodAlpha() throws InterruptedException {
        Thread.sleep(500);
    }

    static void methodBeta() {
    }

    static void methodGamma() throws InterruptedException {
        Thread.sleep(1000);
    }
}
