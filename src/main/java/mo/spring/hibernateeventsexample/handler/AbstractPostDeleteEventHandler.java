package mo.spring.hibernateeventsexample.handler;

import org.hibernate.event.spi.PostDeleteEvent;

public abstract class AbstractPostDeleteEventHandler implements PostDeleteEventHandler{
    protected PostDeleteEvent event;

    @Override
    public final void register(PostDeleteEvent ev) {
        this.event = ev;
    }
}
