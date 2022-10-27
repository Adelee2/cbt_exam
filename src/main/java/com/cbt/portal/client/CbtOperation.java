package com.cbt.portal.client;

import com.cbt.portal.service.CbtService;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("v1")
public class CbtOperation {
    @Inject
    private CbtService cbtService;
    @Context
    private ServletContext context;

    @Path("/login")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void login() {

    }

    @Path("/{studentid}/{courseid}/questions")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void start(@PathParam("studentid") String studentid,@PathParam("courseid") String courseid) {

    }

    @Path("/{studentid}/{courseid}/answer")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void studentanswer(@PathParam("studentid") String studentid,@PathParam("courseid") String courseid) {
//        cbtService.updateStudentAnswer();
    }

    @Path("/{studentid}/{courseid}/result")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getresult(@PathParam("studentid") String studentid,@PathParam("courseid") String courseid) {
        return Response.status(200).entity("studentid= "+ studentid+", courseid= "+courseid+" <br/> <a href='"+context.getContextPath()+"'>Back</a>").build();
    }
}
