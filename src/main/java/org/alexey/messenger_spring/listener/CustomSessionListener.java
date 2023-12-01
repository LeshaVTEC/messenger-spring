package org.alexey.messenger_spring.listener;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import org.alexey.messenger_spring.service.SessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

@WebListener
public class CustomSessionListener implements HttpSessionAttributeListener {

    @Autowired
    private SessionService sessionService;

    private static final Logger LOG= LoggerFactory.getLogger(CustomSessionListener.class);

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        if(se.getSession().getAttribute("UUID") != null) {
            LOG.info("New session is created. Adding Session to the counter.");
            sessionService.incSessionCount();
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        if(Collections.list(se.getSession().getAttributeNames()).contains("UUID")) {
            LOG.info("Session destroyed. Removing the Session from the counter.");
            sessionService.decSessionCount();
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        if(Collections.list(event.getSession().getAttributeNames()).contains("UUID")) {
            LOG.info("Session attribute replaced. Removing the Session from the counter.");
            sessionService.incSessionCount();
        }
    }

}
