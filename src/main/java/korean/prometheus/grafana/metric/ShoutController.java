package korean.prometheus.grafana.metric;

import io.micrometer.core.instrument.Counter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShoutController {
	private final ShoutingService shoutingService;

	@GetMapping("/shout")
	public String getShout() {
		return shoutingService.shout();
	}

	@GetMapping("/mumble")
	public String getMumble() {
		return shoutingService.mumble();
	}
}
