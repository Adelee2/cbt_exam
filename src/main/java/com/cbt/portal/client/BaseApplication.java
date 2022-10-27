package com.cbt.portal.client;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
public class BaseApplication extends Application {
    private final Set<Object> singletons = new HashSet<>();

    @Override
    public Set<Class<?>> getClasses() {
        return Collections.EMPTY_SET;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}