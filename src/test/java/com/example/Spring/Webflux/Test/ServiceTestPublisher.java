package com.example.Spring.Webflux.Test;

import org.junit.jupiter.api.Test;
import reactor.test.publisher.TestPublisher;

public class ServiceTestPublisher {

    @Test
    void TestPublisher(){
        TestPublisher
                .<String>create()
                .next("Primero", "Segundo", "Tercero")
                .error(new RuntimeException("Message"));

    }

}
