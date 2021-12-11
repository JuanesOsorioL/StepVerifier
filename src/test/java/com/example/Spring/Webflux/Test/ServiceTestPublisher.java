package com.example.Spring.Webflux.Test;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

public class ServiceTestPublisher {

    @Test
    void TestPublisher(){
        TestPublisher
                .<String>create()
                .next("Primero", "Segundo", "Tercero")
                .error(new RuntimeException("Message"));

    }


    @Test
    void testUpperCase() {
        final TestPublisher<String> testPublisher = TestPublisher.create();
        UppercaseConverter uppercaseConverter = new UppercaseConverter(testPublisher.flux());
        StepVerifier.create(uppercaseConverter.getUpperCase())
                .then(() -> testPublisher.emit("datos", "GeNeRaDoS", "Sofka"))
                .expectNext("DATOS", "GENERADOS", "SOFKA")
                .verifyComplete();
    }

}
