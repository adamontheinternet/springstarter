package hello;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by alaplante on 1/25/16.
 */
public interface GreetingRepository extends CrudRepository<Greeting, Long>{
    List<Greeting> findGreetingByContent(String content);
}
