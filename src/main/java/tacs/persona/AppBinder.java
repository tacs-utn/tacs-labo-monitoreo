package tacs.persona;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import tacs.persona.service.PersonaService;

import javax.inject.Singleton;

public class AppBinder extends AbstractBinder {
    private boolean serialize;

    public AppBinder(boolean serialize) {

        this.serialize = serialize;
    }

    @Override
    protected void configure() {
        bind(new ObjectMapper()).to(ObjectMapper.class);
        bind(PersonaService.class).to(PersonaService.class).in(Singleton.class);
    }
}
