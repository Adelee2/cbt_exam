package com.cbt.portal.client;

import com.cbt.portal.service.CbtService;
import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Path("v1/cbt")
public class CbtOperation {

    @Context
    private ServletContext context;
    @Resource
    private ManagedExecutorService executor;

    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public void login() {

    }
    @POST
    @Path("{studentid}/{courseid}/questions")
    @Produces(MediaType.APPLICATION_JSON)
    public void start(@PathParam("studentid") String studentid,@PathParam("courseid") String courseid) {

    }
    @POST
    @Path("{studentid}/{courseid}/answer")
    @Produces(MediaType.APPLICATION_JSON)
    public void studentanswer(@PathParam("studentid") String studentid,@PathParam("courseid") String courseid) {
//        cbtService.updateStudentAnswer();
    }
    @GET
    @Path("/{studentid}/{courseid}/result")
    @Produces(MediaType.TEXT_HTML)
    public Response getresult(@PathParam("studentid") String studentid,@PathParam("courseid") String courseid) {
        return Response.status(200).entity("studentid= "+ studentid+", courseid= "+courseid+" <br/> <a href='"+context.getContextPath()+"'>Back</a>").build();
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public void index(@Suspended final AsyncResponse asyncResponse){
        asyncResponse.setTimeout(0, TimeUnit.SECONDS);
        asyncResponse.setTimeoutHandler((AsyncResponse response)
                -> {
            response.resume("Welcome to the Api world");
        });
        executor.submit(()
                -> {
            try {
                System.out.println("Welcome to the Api world2");

            } catch (Exception e) {
                asyncResponse.resume(e.getMessage());
            }
        });
    }
    @POST
    @Path("upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_HTML)
    public Response fileUpload(MultipartFormDataInput input) throws IOException
    {
        Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
        // Get file data to save
        List<InputPart> inputParts = uploadForm.get("file");
        for (InputPart inputPart : inputParts) {
            try {
                MultivaluedMap<String, String> header = inputPart.getHeaders();
                String fileName = getFileName(header);
                // convert the uploaded file to inputstream
                InputStream inputStream = inputPart.getBody(InputStream.class, null);
                byte[] bytes = IOUtils.toByteArray(inputStream);
                String path = System.getProperty("user.home") + File.separator + "uploads";
                System.out.println("\n-----------\nfile uploaded to "+path+"\n-----------\n");
                File customDir = new File(path);
                if (!customDir.exists()) {
                    customDir.mkdir();
                }
                fileName = customDir.getCanonicalPath() + File.separator + fileName;
                writeFile(bytes, fileName);
                return Response.status(200).entity("Uploaded file name : " + fileName+" . <br/> <a href='"+context.getContextPath()+"'>Back</a>").build();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    @POST
    @Path("download")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Consumes("application/x-www-form-urlencoded")
    public Response downloadFileWithPost(@FormParam("file") String file) {
        String path = System.getProperty("user.home") + File.separator + "uploads";
        File fileDownload = new File(path + File.separator + file);
        Response.ResponseBuilder response = Response.ok((Object) fileDownload);
        response.header("Content-Disposition", "attachment;filename=" + file);
        return response.build();
    }

    private String getFileName(MultivaluedMap<String, String> header) {
        String[] contentDisposition = header.getFirst("Content-Disposition").split(";");
        for (String filename : contentDisposition) {
            if ((filename.trim().startsWith("filename"))) {
                String[] name = filename.split("=");
                String finalFileName = name[1].trim().replaceAll("\"", "");
                return finalFileName;
            }
        }
        return "unknown";
    }
    // Utility method
    private void writeFile(byte[] content, String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fop = new FileOutputStream(file);
        fop.write(content);
        fop.flush();
        fop.close();
    }
}
