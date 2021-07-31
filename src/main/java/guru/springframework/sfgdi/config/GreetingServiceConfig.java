package guru.springframework.sfgdi.config;

import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.repositories.SpanishGreetingRepository;
import guru.springframework.sfgdi.repositories.SpanishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.*;
import org.springframework.context.annotation.*;

@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }

    // moved to xml
    /*@Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }*/

    @Primary
    @Bean
    PrimaryGreetingService PrimaryGreetingService(){
        return new PrimaryGreetingService();
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18NSpanishGreetingService i18NSpanishService(SpanishGreetingRepository spanishGreetingRepository){
        return new I18NSpanishGreetingService(spanishGreetingRepository);
    }

    @Profile("EN")
    @Bean("i18nService")
    I18nEnglishGreetingService i18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Bean
    SpanishGreetingRepository spanishGreetingRepository(){
        return new SpanishGreetingRepositoryImpl();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }


    @Profile({"dog", "default"})
    @Bean("petService")
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean("petService")
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat"); //new CatPetService();
    }

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }
}
