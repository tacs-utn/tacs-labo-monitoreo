package tacs.persona.controller;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.logging.Logger;

@Provider
public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException> {
    public static final Logger LOGGER = Logger.getLogger(RuntimeExceptionMapper.class.toString());


    public Response toResponse(RuntimeException ex) {
        LOGGER.warning(ex.getMessage());

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(ex.getMessage())
                .type("text/plain")
                .build();
    }

}
