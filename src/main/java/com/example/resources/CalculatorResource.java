package com.example.resources;

import com.example.service.CalculatorService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/calculator")
@Produces(MediaType.APPLICATION_JSON)
public class CalculatorResource {

    private final CalculatorService service = new CalculatorService();

    @GET
    @Path("/add")
    //[icon] 120qps. 20%
    public Response add(@QueryParam("a") Integer a, @QueryParam("b") Integer b) {
        if (a == null || b == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Parameters 'a' and 'b' are required")
                    .build();
        }
        return Response.ok(service.addOrSubtract(a, b)).build();
    }

    @GET
    @Path("/subtract")
    //[icon] 100qps. 16.6%
    public Response subtract(@QueryParam("a") Integer a, @QueryParam("b") Integer b) {
        if (a == null || b == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Parameters 'a' and 'b' are required")
                    .build();
        }
        return Response.ok(service.addOrSubtract(a, -b)).build();
    }

    @GET
    @Path("/multiply")
    public Response multiply(@QueryParam("a") Integer a, @QueryParam("b") Integer b) {
        if (a == null || b == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Parameters 'a' and 'b' are required")
                    .build();
        }
        return Response.ok(service.calculate(a, b, "multiply")).build();
    }

    @GET
    @Path("/divide")
    public Response divide(@QueryParam("a") Integer a, @QueryParam("b") Integer b) {
        if (a == null || b == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Parameters 'a' and 'b' are required")
                    .build();
        }
        if (b == 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Division by zero is not allowed")
                    .build();
        }
        return Response.ok(service.calculate(a, b, "divide")).build();
    }

    @GET
    @Path("/modulus")
    public Response modulus(@QueryParam("a") Integer a, @QueryParam("b") Integer b) {
        if (a == null || b == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Parameters 'a' and 'b' are required")
                    .build();
        }
        return Response.ok(service.calculate(a, b, "modulus")).build();
    }

    @GET
    @Path("/sine")
    public Response sine(@QueryParam("value") Double value) {
        if (value == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Parameter 'value' is required")
                    .build();
        }
        return Response.ok(service.calculateUnary(value, "sine")).build();
    }

    @GET
    @Path("/cosine")
    public Response cosine(@QueryParam("value") Double value) {
        if (value == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Parameter 'value' is required")
                    .build();
        }
        return Response.ok(service.calculateUnary(value, "cosine")).build();
    }

    @GET
    @Path("/tangent")
    public Response tangent(@QueryParam("value") Double value) {
        if (value == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Parameter 'value' is required")
                    .build();
        }
        return Response.ok(service.calculateUnary(value, "tangent")).build();
    }
}
