package org.alexey.messenger_spring.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class SessionService {

    private final AtomicLong counterActiveSession = new AtomicLong(0);

    public void incSessionCount() {
        this.counterActiveSession.incrementAndGet();
    }

    public void decSessionCount() {
        this.counterActiveSession.decrementAndGet();
    }

    public Long getSessionCount() {
        return this.counterActiveSession.get();
    }
}
