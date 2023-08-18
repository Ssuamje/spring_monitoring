package korean.prometheus.grafana.metric;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Shouter {
	private final String name;
	private final String shout;

	public String shout() {
		System.out.println(name + " is saying " + shout);
		return shout;
	}

	public String mumble() {
		System.out.println(name + " is mumbling");
		return "mumble";
	}

}
