import java.util.*;

public class CSCalculator {
  private Map<String,Integer> prec = new HashMap<>();
  private BooleanAlgebra bool = new BooleanAlgebra();
  private NumberSystemConverter conv = new NumberSystemConverter();
  private ComplexityAnalyzer comp = new ComplexityAnalyzer();
  private DataTypeHelper dtype = new DataTypeHelper();

  public CSCalculator() {
    prec.put("(",0); prec.put(")",0);
    prec.put("+",1); prec.put("-",1);
    prec.put("*",2); prec.put("/",2); prec.put("%",2);
    prec.put("^",3);
  }

  public double calculate(String s) throws Exception {
    if (s==null || s.trim().isEmpty()) throw new IllegalArgumentException("empty");
    s = pre(s);
    List<String> t = toks(s);
    List<String> post = infixToPost(t);
    return evalPost(post);
  }

  private String pre(String s){
    s = s.replaceAll("\\s+","");
    StringBuilder r = new StringBuilder();
    for(int i=0;i<s.length();i++){
      char c=s.charAt(i); r.append(c);
      if(i<s.length()-1){
        char n=s.charAt(i+1);
        if((Character.isDigit(c)&&n=='(') || (c==')'&&Character.isDigit(n)) || (c==')'&&n=='(')) r.append('*');
      }
    }
    return r.toString();
  }

  private List<String> toks(String s){
    List<String> t=new ArrayList<>(); StringBuilder cur=new StringBuilder();
    for(int i=0;i<s.length();i++){
      char c=s.charAt(i);
      if(Character.isDigit(c)||c=='.'){ cur.append(c); }
      else{
        if(cur.length()>0){ t.add(cur.toString()); cur.setLength(0); }
        if(c=='-' && (i==0 || s.charAt(i-1)=='(' || isOp(s.charAt(i-1)))) cur.append(c);
        else t.add(String.valueOf(c));
      }
    }
    if(cur.length()>0) t.add(cur.toString());
    return t;
  }

  private List<String> infixToPost(List<String> t){
    List<String> out=new ArrayList<>();
    Deque<String> ops=new ArrayDeque<>();
    for(String x:t){
      if(isNum(x)) out.add(x);
      else if(x.equals("(")) ops.push(x);
      else if(x.equals(")")){
        while(!ops.isEmpty() && !ops.peek().equals("(")) out.add(ops.pop());
        if(!ops.isEmpty()) ops.pop();
      } else if(isOp(x.charAt(0))){
        while(!ops.isEmpty() && !ops.peek().equals("(") && gp(ops.peek())>=gp(x)) out.add(ops.pop());
        ops.push(x);
      }
    }
    while(!ops.isEmpty()) out.add(ops.pop());
    return out;
  }

  private double evalPost(List<String> post) throws Exception{
    Deque<Double> st=new ArrayDeque<>();
    for(String x:post){
      if(isNum(x)) st.push(Double.parseDouble(x));
      else{
        if(st.size()<2) throw new IllegalArgumentException("bad expr");
        double b=st.pop(), a=st.pop();
        st.push(op(a,b,x.charAt(0)));
      }
    }
    if(st.size()!=1) throw new IllegalArgumentException("bad expr");
    return st.pop();
  }

  private double op(double a,double b,char o) throws Exception{
    switch(o){
      case '+': return a+b;
      case '-': return a-b;
      case '*': return a*b;
      case '/': if(b==0) throw new ArithmeticException("div0"); return a/b;
      case '%': return a%b;
      case '^': return Math.pow(a,b);
      default: throw new IllegalArgumentException("op");
    }
  }

  private boolean isNum(String x){ try{ Double.parseDouble(x); return true; }catch(Exception e){ return false; } }
  private boolean isOp(char c){ return c=='+'||c=='-'||c=='*'||c=='/'||c=='%'||c=='^'; }
  private int gp(String o){ return prec.getOrDefault(o,0); }

  public BooleanAlgebra getBooleanAlgebra(){ return bool; }
  public NumberSystemConverter getConverter(){ return conv; }
  public ComplexityAnalyzer getComplexityAnalyzer(){ return comp; }
  public DataTypeHelper getDataTypeHelper(){ return dtype; }
}

class BooleanAlgebra {
  public boolean eval(String s, Map<Character,Boolean> v){
    s=s.replaceAll("\\s+","");
    Deque<Boolean> vals=new ArrayDeque<>();
    Deque<Character> ops=new ArrayDeque<>();
    for(int i=0;i<s.length();i++){
      char c=s.charAt(i);
      if(Character.isLetter(c)) vals.push(v.getOrDefault(c,false));
      else if(c=='(') ops.push(c);
      else if(c==')'){ while(!ops.isEmpty()&&ops.peek()!='(') ap(vals,ops.pop()); ops.pop(); }
      else if(c=='!'||c=='&'||c=='|'||c=='^'){
        while(!ops.isEmpty()&&ops.peek()!='('&& bp(ops.peek())>=bp(c)) ap(vals,ops.pop());
        ops.push(c);
      }
    }
    while(!ops.isEmpty()) ap(vals,ops.pop());
    return vals.pop();
  }
  private void ap(Deque<Boolean> st,char o){
    switch(o){
      case '!': if(!st.isEmpty()) st.push(!st.pop()); break;
      case '&': {boolean b=st.pop(),a=st.pop(); st.push(a&&b);} break;
      case '|': {boolean b=st.pop(),a=st.pop(); st.push(a||b);} break;
      case '^': {boolean b=st.pop(),a=st.pop(); st.push(a^b);} break;
    }
  }
  private int bp(char o){ if(o=='!') return 3; if(o=='&') return 2; return 1; }
}

class NumberSystemConverter {
  public String decToBin(int n){ if(n==0) return "0"; boolean neg=n<0; n=Math.abs(n); StringBuilder sb=new StringBuilder(); while(n>0){ sb.append(n%2); n/=2; } String r=sb.reverse().toString(); return neg? "-"+r:r; }
  public int binToDec(String b){ boolean neg=b.startsWith("-"); if(neg) b=b.substring(1); if(!b.matches("[01]+")) throw new IllegalArgumentException("bin"); int d=0,p=0; for(int i=b.length()-1;i>=0;i--){ if(b.charAt(i)=='1') d+= (1<<p); p++; } return neg? -d:d; }
  public String decToOct(int n){ if(n==0) return "0"; boolean neg=n<0; n=Math.abs(n); StringBuilder sb=new StringBuilder(); while(n>0){ sb.append(n%8); n/=8; } String r=sb.reverse().toString(); return neg? "-"+r:r; }
  public int octToDec(String o){ boolean neg=o.startsWith("-"); if(neg) o=o.substring(1); if(!o.matches("[0-7]+")) throw new IllegalArgumentException("oct"); int d=0,p=0; for(int i=o.length()-1;i>=0;i--){ int g=o.charAt(i)-'0'; d+= g*(int)Math.pow(8,p++); } return neg? -d:d; }
  public String decToHex(int n){ if(n==0) return "0"; boolean neg=n<0; n=Math.abs(n); char[] H="0123456789ABCDEF".toCharArray(); StringBuilder sb=new StringBuilder(); while(n>0){ sb.append(H[n%16]); n/=16; } String r=sb.reverse().toString(); return neg? "-"+r:r; }
  public int hexToDec(String h){ boolean neg=h.startsWith("-"); if(neg) h=h.substring(1); if(!h.matches("[0-9A-Fa-f]+")) throw new IllegalArgumentException("hex"); h=h.toUpperCase(); int d=0,p=0; for(int i=h.length()-1;i>=0;i--){ char c=h.charAt(i); int v=(c<='9')? c-'0': c-'A'+10; d+= v*(int)Math.pow(16,p++); } return neg? -d:d; }
  public String binToOct(String b){ return decToOct(binToDec(b)); }
  public String binToHex(String b){ return decToHex(binToDec(b)); }
  public String octToBin(String o){ return decToBin(octToDec(o)); }
  public String octToHex(String o){ return decToHex(octToDec(o)); }
  public String hexToBin(String h){ return decToBin(hexToDec(h)); }
  public String hexToOct(String h){ return decToOct(hexToDec(h)); }
  public String chToBin(char c){ return decToBin((int)c); }
  public String strToBin(String s){ StringBuilder r=new StringBuilder(); for(char c:s.toCharArray()) r.append(chToBin(c)).append(" "); return r.toString().trim(); }
  public int chToAsc(char c){ return (int)c; }
  public char ascToCh(int a){ if(a<0||a>127) throw new IllegalArgumentException("ascii"); return (char)a; }
  public long bytesToBits(long x){ return x*8; }
  public double bitsToBytes(long x){ return x/8.0; }
}

class ComplexityAnalyzer {
  private Map<String,String> desc=new HashMap<>();
  private Map<String,Integer> rank=new HashMap<>();
  public ComplexityAnalyzer(){
    desc.put("O(1)","const"); desc.put("O(log n)","log"); desc.put("O(n)","lin"); desc.put("O(n log n)","nlogn");
    desc.put("O(n²)","quad"); desc.put("O(n³)","cube"); desc.put("O(2^n)","exp"); desc.put("O(n!)","fact");
    rank.put("O(1)",1); rank.put("O(log n)",2); rank.put("O(n)",3); rank.put("O(n log n)",4); rank.put("O(n²)",5);
    rank.put("O(n³)",6); rank.put("O(2^n)",7); rank.put("O(n!)",8);
  }
  public String getDesc(String c){ return desc.getOrDefault(c,"?"); }
  public String cmp(String a,String b){ Integer r1=rank.get(a), r2=rank.get(b); if(r1==null||r2==null) return "na"; if(r1<r2) return a+" better"; if(r1>r2) return b+" better"; return "same"; }
  public long ops(String c,long n){
    switch(c){
      case "O(1)": return 1;
      case "O(log n)": return (long)(Math.log(n)/Math.log(2));
      case "O(n)": return n;
      case "O(n log n)": return (long)(n*Math.log(n)/Math.log(2));
      case "O(n²)": return n*n;
      case "O(n³)": return n*n*n;
      case "O(2^n)": return n>60? Long.MAX_VALUE : (long)Math.pow(2,n);
      case "O(n!)": return fact(n);
      default: return -1;
    }
  }
  private long fact(long n){ if(n>20) return Long.MAX_VALUE; long r=1; for(int i=2;i<=n;i++) r*=i; return r; }
  public String analyze(String s){
    s=s.toLowerCase();
    if(s.contains("nested")||s.contains("double loop")) return "O(n²)";
    if(s.contains("triple")) return "O(n³)";
    if(s.contains("single loop")||s.contains("linear search")) return "O(n)";
    if(s.contains("binary search")||s.contains("divide and conquer")) return "O(log n)";
    if(s.contains("merge sort")||s.contains("heap sort")) return "O(n log n)";
    if(s.contains("constant")||s.contains("hash")) return "O(1)";
    if(s.contains("exponential")) return "O(2^n)";
    if(s.contains("permutation")) return "O(n!)";
    return "na";
  }
}

class DataTypeHelper {
  private Map<String,Info> map=new HashMap<>();
  public DataTypeHelper(){
    map.put("byte", new Info("byte",1,-128,127,"i8"));
    map.put("short",new Info("short",2,-32768,32767,"i16"));
    map.put("int",  new Info("int",4,-2147483648L,2147483647L,"i32"));
    map.put("long", new Info("long",8,Long.MIN_VALUE,Long.MAX_VALUE,"i64"));
    map.put("float",new Info("float",4,-3.4e38,3.4e38,"f32"));
    map.put("double",new Info("double",8,-1.7e308,1.7e308,"f64"));
    map.put("char", new Info("char",2,0,65535,"u16"));
    map.put("boolean", new Info("boolean",1,0,1,"bool"));
  }
  public Info info(String t){ return map.get(t.toLowerCase()); }
  public void printAll(){
    for(Info i: map.values()){
      System.out.printf("%-7s %dB min=%s max=%s %s%n", i.name,i.size,fmt(i.min),fmt(i.max),i.desc);
    }
  }
  private String fmt(double v){ return v==(long)v? String.valueOf((long)v) : String.format("%.2e",v); }
  public String bytes(long b){
    if(b<1024) return b+" B";
    if(b<1024*1024) return String.format("%.2f KB", b/1024.0);
    if(b<1024L*1024*1024) return String.format("%.2f MB", b/(1024.0*1024));
    return String.format("%.2f GB", b/(1024.0*1024*1024));
  }
  public boolean fits(String t,double v){ Info i=info(t); if(i==null) return false; return v>=i.min && v<=i.max; }
  public String suggest(double v){
    if(v==(long)v){
      long x=(long)v;
      if(fits("byte",x)) return "byte";
      if(fits("short",x)) return "short";
      if(fits("int",x)) return "int";
      return "long";
    } else {
      return Math.abs(v)<=3.4e38? "float":"double";
    }
  }
  static class Info{
    String name; int size; double min,max; String desc;
    Info(String n,int s,double mn,double mx,String d){ name=n; size=s; min=mn; max=mx; desc=d; }
  }
}
