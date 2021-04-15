public class SpringBootApp {

    public @interface SpringBootApplication {}
    public @interface RestController {}

    public @interface GetMapping { String value() default ""; }

    public static class SpringApplication {

        public static void run(Class<?> primarySource, String[] args) {
            System.out.println("Spring Boot Application Started");
        }
    }

    @RestController
    public static class HelloController {

        @GetMapping("/")

        public String index() {
            return "Hello Spring Boot";
        }
    }

    @SpringBootApplication

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }
}
