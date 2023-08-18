package korean.prometheus.grafana.metric;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShoutingService {
	private final MeterRegistry registry;
	private final Shouter shouter = new Shouter("shouter", "개 짖는 소리좀 안 나게 해라!!");

	public String shout() {
		Counter shoutCounter = Counter.builder("my.shout")
				.tag("class", this.getClass().getName())
				.tag("method", "shout")
				.description("The number of shouts")
				.register(registry);

		shoutCounter.increment();
		return shouter.shout();
	}

	public String mumble() {
		Counter mumbleCounter = Counter.builder("my.mumble")
				.tag("class", this.getClass().getName())
				.tag("method", "mumble") // <- 다른 태그를 더 달아줌으로써 구분할 수 있다.
				.description("The number of mumbles")
				.register(registry);

		mumbleCounter.increment();
		return shouter.mumble();
	}
}
