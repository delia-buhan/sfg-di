package guru.springframework.sfgdi.repositories;

public class SpanishGreetingRepositoryImpl implements SpanishGreetingRepository {
    @Override
    public String getGreeting() {
        return "Hola Mundo - ES";
    }
}
