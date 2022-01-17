package mo.spring.hibernateeventsexample.handler;

import org.springframework.stereotype.Component;

@Component
public class LoggingPostDeleteEventHandler extends AbstractPostDeleteEventHandler{
    @Override
    public void run() {
        System.out.println("------HIBERNATE PostDelete EVENT------");
        System.out.println("Thread ID of event listener: " + Thread.currentThread().getId());

        String sb = "New entity " +
                this.event.getPersister().getEntityMetamodel().getName() +
                " with ID " +
                this.event.getId() +
                " was deleted by Hibernate.\n";
        System.out.println(sb);

        System.out.println(this.event.getEntity());
    }
}
