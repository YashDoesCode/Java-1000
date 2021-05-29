import java.util.*;
public class SubdomainVisitCountStr {

    public List<String> subdomainVisits(String[] cpdomains) { Map<String, Integer> mp = new HashMap<>();
        for (String cd : cpdomains) { int idx = cd.indexOf(' ');
            int count = Integer.parseInt(cd.substring(0, idx));
            String dom = cd.substring(idx + 1);
            mp.put(dom, mp.getOrDefault(dom, 0) + count);
            for (int i = 0;
            i < dom.length();
            i++) if (dom.charAt(i) == '.') { String sub = dom.substring(i + 1);
                mp.put(sub, mp.getOrDefault(sub, 0) + count);
            } } List<String> res = new ArrayList<>();
        for (String k : mp.keySet()) res.add(mp.get(k) + " " + k);
        return res;
    };
}
