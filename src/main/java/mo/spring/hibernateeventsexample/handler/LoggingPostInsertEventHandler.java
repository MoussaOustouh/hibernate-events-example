package mo.spring.hibernateeventsexample.handler;

import org.springframework.stereotype.Component;

@Component
public class LoggingPostInsertEventHandler extends AbstractPostInsertEventHandler {
    @Override
    public void run() {
        System.out.println("------HIBERNATE PostInsert EVENT------");
        System.out.println("Thread ID of event listener: " + Thread.currentThread().getId());

        String sb = "New entity " +
                this.event.getPersister().getEntityMetamodel().getName() +
                " with ID " +
                this.event.getId() +
                " was committed by Hibernate.\n";
        System.out.println(sb);
    }
}
