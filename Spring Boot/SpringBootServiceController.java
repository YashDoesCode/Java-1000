public class SpringBootServiceController {

    @interface RestController {}
    @interface GetMapping { String value() default ""; }

    @RestController
    public static class ServiceEndpoint {

        @GetMapping("/info")
        public String info() {
            return "Spring Boot Service Running";
        }
    }
}
