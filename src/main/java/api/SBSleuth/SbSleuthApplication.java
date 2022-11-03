package api.SBSleuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class SbSleuthApplication {
	
	@Autowired
	private Tracer tracer;

	public static void main(String[] args) {
		SpringApplication.run(SbSleuthApplication.class, args);
	}

	@GetMapping("/")
	public String test() {
		System.out.println("traceID : " + (tracer.currentSpan()).context().traceId());
		System.out.println("spanID : " + (tracer.currentSpan()).context().spanId());
		System.out.println("test done");
		return "f";
	}
}
