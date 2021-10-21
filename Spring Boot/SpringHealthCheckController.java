import java.util.*;

public class SpringHealthCheckController {

    @interface RestController {}
    @interface GetMapping { String value() default ""; }

    @RestController
    public static class HealthEndpoint {

        @GetMapping("/health")
        public Map<String, Object> health() {
            Map<String, Object> status = new LinkedHashMap<>();
            status.put("status", "UP");
            status.put("timestamp", System.currentTimeMillis());
            return status;
        }
    }
}
