package nl.rob.rest;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

@Path("/messages")
public class MessageStoreService {

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMsg(InputStream data) {
		return null;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMsg(@PathParam("id") String idParam) {

        JSONObject json = new JSONObject()
            .put("firstName", "John")
            .put("lastName", "Smith")
            .put("age", 25)
            .put("address", new JSONObject()
                .put("streetAddress", "21 2nd Street")
                .put("city", "New York")
                .put("state", "NY")
                .put("postalCode", "10021"))
            .append("phoneNumber", new JSONObject()
                .put("type", "home")
                .put("number", "212 555-1234"))
            .append("phoneNumber", new JSONObject()
                .put("type", "fax")
                .put("number", "646 555-4567"));
//        int id = Integer.parseInt(idParam);

        return Response.status(200).entity(json.toString()).build();

    }

}
