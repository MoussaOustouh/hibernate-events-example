package mo.spring.hibernateeventsexample;

import mo.spring.hibernateeventsexample.listener.DeleteListener;
import mo.spring.hibernateeventsexample.listener.InsertListener;
import mo.spring.hibernateeventsexample.listener.UpdateListener;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Component
public class HibernateListenerConfigurer {

    @PersistenceUnit
    private EntityManagerFactory emf;

    private final UpdateListener updateListener;
    private final InsertListener insertListener;
    private final DeleteListener deleteListener;

    @Autowired
    public HibernateListenerConfigurer(UpdateListener updateListener, InsertListener insertListener, DeleteListener deleteListener) {
        this.updateListener = updateListener;
        this.insertListener = insertListener;
        this.deleteListener = deleteListener;
    }

    @PostConstruct
    protected void init() {
        SessionFactoryImpl sessionFactory = emf.unwrap(SessionFactoryImpl.class);
        EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
        registry.getEventListenerGroup(EventType.POST_UPDATE).appendListener(updateListener);
        registry.getEventListenerGroup(EventType.POST_INSERT).appendListener(insertListener);
        registry.getEventListenerGroup(EventType.POST_DELETE).appendListener(deleteListener);
    }
}
