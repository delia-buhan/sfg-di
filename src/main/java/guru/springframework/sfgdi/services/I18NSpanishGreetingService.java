package guru.springframework.sfgdi.services;

import guru.springframework.sfgdi.repositories.SpanishGreetingRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by jt on 12/27/19.
 */
//@Profile({"ES", "default"})
//@Service("i18nService")
public class I18NSpanishGreetingService implements GreetingService {

    private final SpanishGreetingRepository spanishGreetingRepository;

    public I18NSpanishGreetingService(SpanishGreetingRepository spanishGreetingRepository) {
        this.spanishGreetingRepository = spanishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return spanishGreetingRepository.getGreeting();
    }
}
