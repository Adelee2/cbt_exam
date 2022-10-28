package com.cbt.portal.client;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class BaseApplication extends Application {
    private final Set<Object> singletons = new HashSet<>();

    @Override
    public Set<Class<?>> getClasses ()
    {
        return Collections.EMPTY_SET;
    }

    @Override
    public Set<Object> getSingletons ()
    {
        return singletons;
    }
}