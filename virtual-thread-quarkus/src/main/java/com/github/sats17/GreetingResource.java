package com.github.sats17;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    SyncClassFactory syncClassFactory = new SyncClassFactory();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @RunOnVirtualThread
    public String hello() {
        System.out.println(Thread.currentThread().getName());
        SyncClass syncClass = syncClassFactory.getSyncClass(1);
        syncClass.increase();
        return "Hello from Quarkus REST";
    }
}
