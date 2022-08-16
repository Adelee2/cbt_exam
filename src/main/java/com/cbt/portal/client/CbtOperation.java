package com.cbt.portal.client;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("api/v1")
public class CbtOperation {
    @Path("/login")
    @POST
    public void login(){

    }
    @Path("/:studentid/:courseid/questions")
    @POST
    public void start(){

    }
    @Path("/:studentid/:courseid/answer")
    @POST
    public void studentanswer(){

    }
    @Path("/:studentid/:courseid/result")
    @GET
    public void getresult(){

    }
}
