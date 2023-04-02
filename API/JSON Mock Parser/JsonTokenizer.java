import java.util.*;

public class JsonTokenizer {

    public enum TokenType { LEFT_BRACE, RIGHT_BRACE, LEFT_BRACKET, RIGHT_BRACKET, COLON, COMMA, STRING, NUMBER, BOOLEAN, NULL }

    public static class Token {

        public TokenType type;
        public String value;

        public Token(TokenType type, String value) {
            this.type = type;
            this.value = value;
        }
    }

    public List<Token> tokenize(String json) {
        List<Token> tokens = new ArrayList<>();
        int i = 0;
        while (i < json.length()) {
            char c = json.charAt(i);
            if (Character.isWhitespace(c)) { i++; continue; }
            if (c == '{') { tokens.add(new Token(TokenType.LEFT_BRACE, "{")); i++; }
            else if (c == '}') { tokens.add(new Token(TokenType.RIGHT_BRACE, "}")); i++; }
            else if (c == '[') { tokens.add(new Token(TokenType.LEFT_BRACKET, "[")); i++; }
            else if (c == ']') { tokens.add(new Token(TokenType.RIGHT_BRACKET, "]")); i++; }
            else if (c == ':') { tokens.add(new Token(TokenType.COLON, ":")); i++; }
            else if (c == ',') { tokens.add(new Token(TokenType.COMMA, ",")); i++; }
            else if (c == '"') {
                int start = ++i;
                while (i < json.length() && json.charAt(i) != '"') i++;
                tokens.add(new Token(TokenType.STRING, json.substring(start, i)));
                i++;
            } else if (Character.isDigit(c) || c == '-') {
                int start = i;
                while (i < json.length() && (Character.isDigit(json.charAt(i)) || json.charAt(i) == '.')) i++;
                tokens.add(new Token(TokenType.NUMBER, json.substring(start, i)));
            } else {
                i++;
            }
        }
        return tokens;
    }
}
