import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;

public class FluxAndMono {
    public static void main(String[] args) {
        //Создать реактивный конвейер обработки сообщений
        Mono<Integer> mono = Mono.just(1);
        Flux<Integer> flux = Flux.just(1, 2, 3);
        Flux<Integer> fluxInts = Flux.range(1, 3);
        Flux<Integer> fluxFromIter = Flux.fromIterable(Arrays.asList(3, 2, 1));

        //Преобразование из одного типа конвейера в другой
        Flux<Integer> fluxFromMono = mono.flux();
        Mono<Boolean> monoBoolean = flux.any(s -> s.equals(1));
        Mono<Integer> monoInteger = flux.elementAt(1);
        //Вывод в консоль, включив подписчика
        //fluxFromIter.subscribe(System.out::println);

        //infGenerate();

        //finGenerate();
    }

    public static void infGenerate() {
        //Бесконечный генератор
        //Что будет, если исключить подписчика
        Flux.<String>generate(sink -> {
            sink.next("hello");
        })
                .take(5) //2
                .delayElements(Duration.ofMillis(1000)) //3
                .subscribe(System.out::println); //1

        try {
            Thread.sleep(5000); //4
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void finGenerate(){
        //Конечный генератор с условием
        Flux.generate(
                () -> 2023,
                (state, sink) -> {
                    if (state>2050)
                        sink.complete();
                    else sink.next("step: "+state);
                    return state+2;
                }
        )
                .subscribe(System.out::println);
    }
}
