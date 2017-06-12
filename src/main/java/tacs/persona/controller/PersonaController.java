package tacs.persona.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import tacs.persona.domain.Persona;
import tacs.persona.service.PersonaService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("personas")
public class PersonaController {
        @Inject
    private ObjectMapper mapper;

    @Inject
    private PersonaService personaService;

    @GET
    @Path("health-check")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return "Hello, world!";
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() throws JsonProcessingException {
        List<Persona> personas = personaService.getAll();
        Persona persona = personas.get(0);

        return mapper.writeValueAsString(personas);
    }
/*

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Persona getAll() {
        return personaService.getAll().get(0);
    }
*/

    public void setMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }
}
