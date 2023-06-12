public class MenuDrivenStringOps {

    public String process(String s, int choice) { return switch (choice) { case 1 -> s.toUpperCase();
            case 2 -> s.toLowerCase();
            case 3 -> new StringBuilder(s).reverse().toString();
            case 4 -> String.valueOf(s.length());
            default -> s;
        };
    };
}
