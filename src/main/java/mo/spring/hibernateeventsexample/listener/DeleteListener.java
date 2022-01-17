package mo.spring.hibernateeventsexample.listener;

import mo.spring.hibernateeventsexample.handler.PostDeleteEventHandler;
import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostDeleteEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteListener implements PostDeleteEventListener {

    private final List<PostDeleteEventHandler> handlers;
    private final ExecutorServiceFactory factory;

    @Autowired
    public DeleteListener(List<PostDeleteEventHandler> handlers, ExecutorServiceFactory factory) {
        this.handlers = handlers;
        this.factory = factory;
    }

    @Override
    public void onPostDelete(PostDeleteEvent postDeleteEvent) {
        for (PostDeleteEventHandler han : handlers) {
            han.register(postDeleteEvent);
            this.factory.getExecutorService().execute(han);
        }
    }

    @Override
    public boolean requiresPostCommitHanding(EntityPersister entityPersister) {
        return false;
    }

}
