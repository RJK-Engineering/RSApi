# JAX-RS: Java API for RESTful Web Services

# API Specification

https://app.swaggerhub.com/apis/RJK-Gorilla/Messages

C - POST /message - message = request.data, return /message/{id}
R - GET /message
R - GET /message/{id}
U - PUT /message/{id} - updateMessage(request.data)
D - DELETE /message/{id}

# Hypermedia links

Hypertext (ht\*) is hypermedia. Hypermedia contains hyperlinks.

rel = relation !

``
``

# Annotations

Annotation  | Import
----------- | ------
@GET        | import javax.ws.rs.GET;
@Produces   | import javax.ws.rs.Produces;
@Path       | import javax.ws.rs.Path;
@PathParam  | import javax.ws.rs.PathParam;
@QueryParam | import javax.ws.rs.QueryParam;
@POST       | import javax.ws.rs.POST;
@Consumes   | import javax.ws.rs.Consumes;
@FormParam  | import javax.ws.rs.FormParam;
@PUT        | import javax.ws.rs.PUT;
@DELETE     | import javax.ws.rs.DELETE;

# References

* https://en.wikipedia.org/wiki/Java_API_for_RESTful_Web_Services
* Richardson Maturity Model - https://www.martinfowler.com/articles/richardsonMaturityModel.html
* Diff between POST/PUT
    * https://zacharyvoase.com/2009/07/03/http-post-put-diff
    * http://restcookbook.com/HTTP%20Methods/put-vs-post
* http://www.enterpriseintegrationpatterns.com/patterns/messaging/EncapsulatedSynchronousIntegration.html
* http://www.javawebtutor.com/articles/web-services/rest/creating-web-service-with-maven-jersey.php
* http://www.docjar.com/docs/api/org/json/JSONObject.html#put(String,%20Collection)
* https://jersey.github.io/documentation/latest/getting-started.html

# Eclipse

Shortcut | Description
-------- | -----------
Ctrl+Shift+O | Organize imports

