package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by alaplante on 1/25/16.
 */
@RestController
@RequestMapping(value="/greetings")
public class GreetingController {
    private static final Logger log = LoggerFactory.getLogger(GreetingController.class);

    private final static String template = "Hello there %s at %s";
//    private final AtomicLong counter = new AtomicLong();

    private GreetingRepository greetingRepository;

    @Autowired
    public void setGreetingRepository(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @RequestMapping(method=RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        log.info("greetingRepository is {}", greetingRepository);
        String content = String.format(template, name, System.currentTimeMillis());
        Greeting greeting = new Greeting(content);

        greetingRepository.save(greeting);
        log.info("Saved greeting {}", greeting);

        List<Greeting> greetingList = greetingRepository.findGreetingByContent(content);
        log.info("Fetched {} greetings", greetingList.size());

        if(greetingList.iterator().hasNext()) return greetingList.iterator().next();
        return null;
    }
}
