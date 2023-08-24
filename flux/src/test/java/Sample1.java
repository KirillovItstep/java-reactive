import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.*;

import static org.hamcrest.MatcherAssert.assertThat;

public class Sample1 {

    @Test
    public void check(){
        List<Integer> elements = new ArrayList<>();

        Flux.just(1, 2, 3, 4)
                .log()
                .subscribe(elements::add);

        //assertThat(elements, Arrays.asList(1, 2, 3, 4));
    }
}
