package nl.rob.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

@Path("/messages")
public class MessageStoreService {

	@GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIndex() {
		MessageStore ms = getMessageStore();
        JSONArray data = new JSONArray();
        for (Message m : ms.getMessages()) {
        	data.put(toJSON(m));
        }
        return Response.status(200).entity(data.toString()).build();
    }

	@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessage(@PathParam("id") String idParam) {
		MessageStore ms = getMessageStore();
		int id = Integer.parseInt(idParam);
		Message m = ms.getMessage(id);
        return Response.status(200).entity(toJSON(m).toString()).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response createMessage(String body) {
    	JSONObject data = new JSONObject(body);
		MessageStore ms = getMessageStore();
		Message m = ms.createMessage(data.getString("text"));
		return Response.status(200).entity(toJSON(m).toString()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateMsg(String body) {    	
    	JSONObject data = new JSONObject(body);
		MessageStore ms = getMessageStore();
		Message m = ms.getMessage(data.getInt("id"));
		m.text = data.getString("text");
        return Response.status(200).entity(toJSON(m).toString()).build();
    }

	@DELETE
    @Path("/{id}")
    public Response deleteMessage(@PathParam("id") String idParam) {
		MessageStore ms = getMessageStore();
		int id = Integer.parseInt(idParam);
		ms.deleteMessage(id);
        return Response.status(200).build();
    }

    private MessageStore getMessageStore() {
		MessageStore ms = new MessageStore();
		return ms;
	}

	private static JSONObject toJSON(Message m) {
		JSONObject o = new JSONObject();
		if (m != null) {
			o.put("id", m.id);
			o.put("text", m.text);
		}
		return o;
	}

}
