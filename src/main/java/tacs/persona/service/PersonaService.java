package tacs.persona.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import tacs.persona.domain.Persona;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by srosenbolt on 11/06/17.
 */
@Resource
public class PersonaService {
    @Inject
    private ObjectMapper mapper;

    public List<Persona> getAll() {
        try {
//            URL url = this.getClass().getResource("/personas.json");
//            File file = new File(url.toURI());

            InputStream in = this.getClass().getClassLoader().getResourceAsStream("personas.json");

            Persona[] personas = mapper.readValue(in, Persona[].class);

//            Persona[] personas = mapper.readValue(file, Persona[].class);

            return Arrays.asList(personas);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }
}
