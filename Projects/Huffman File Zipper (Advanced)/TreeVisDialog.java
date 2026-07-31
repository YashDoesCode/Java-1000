import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.*;

public class TreeVisDialog extends JDialog {
    private Map<Character, Integer> freq;
    private HuffmanEngine.Node root;
    private final int RAD = 20;
    private final int LVL_H = 80;
    
    public TreeVisDialog(JFrame parent, Map<Character, Integer> freq) {
        super(parent, "Huffman Tree Visualization", true);
        this.freq = freq;
        
        buildTree();
        initUI();
    }
    
    private void buildTree() {
        HuffmanEngine engine = new HuffmanEngine();
        PriorityQueue<HuffmanEngine.Node> pq = new PriorityQueue<>((a, b) -> a.freq - b.freq);
        
        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            pq.offer(new HuffmanEngine.Node(e.getKey(), e.getValue()));
        }
        
        while (pq.size() > 1) {
            HuffmanEngine.Node left = pq.poll();
            HuffmanEngine.Node right = pq.poll();
            
            HuffmanEngine.Node merged = new HuffmanEngine.Node('\0', left.freq + right.freq);
            merged.left = left;
            merged.right = right;
            
            pq.offer(merged);
        }
        
        root = pq.poll();
    }
    
    private void initUI() {
        setLayout(new BorderLayout());
        
        JPanel vis = new TreePanel();
        vis.setPreferredSize(new Dimension(800, 600));
        vis.setBackground(Color.WHITE);
        
        JScrollPane scroll = new JScrollPane(vis);
        add(scroll, BorderLayout.CENTER);
        
        JPanel info = createInfo();
        add(info, BorderLayout.SOUTH);
        
        JPanel ctrl = new JPanel();
        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(e -> dispose());
        ctrl.add(closeBtn);
        add(ctrl, BorderLayout.NORTH);
        
        setSize(850, 700);
        setLocationRelativeTo(getParent());
    }
    
    private JPanel createInfo() {
        JPanel pan = new JPanel(new GridLayout(1, 2));
        
        JTextArea codeInfo = new JTextArea(8, 30);
        codeInfo.setEditable(false);
        codeInfo.setFont(new Font("Consolas", Font.PLAIN, 11));
        codeInfo.setBackground(new Color(250, 250, 250));
        
        StringBuilder codes = new StringBuilder("CHARACTER CODES:\n");
        codes.append("-".repeat(20)).append("\n");
        
        Map<Character, String> chCodes = genCodes();
        chCodes.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(e -> {
                    char ch = e.getKey();
                    String chDisp = (ch == '\n') ? "\\n" : (ch == '\t') ? "\\t" : String.valueOf(ch);
                    codes.append(String.format("'%s' -> %s\n", chDisp, e.getValue()));
                });
        
        codeInfo.setText(codes.toString());
        
        JTextArea statsInfo = new JTextArea(8, 30);
        statsInfo.setEditable(false);
        statsInfo.setFont(new Font("Consolas", Font.PLAIN, 11));
        statsInfo.setBackground(new Color(250, 250, 250));
        
        StringBuilder stats = new StringBuilder("TREE STATISTICS:\n");
        stats.append("-".repeat(20)).append("\n");
        stats.append("Total characters: ").append(freq.size()).append("\n");
        stats.append("Tree depth: ").append(getDepth(root)).append("\n");
        stats.append("Total frequency: ").append(freq.values().stream().mapToInt(Integer::intValue).sum()).append("\n");
        
        double avgLen = calcAvg(chCodes);
        stats.append("Avg code length: ").append(String.format("%.2f", avgLen)).append("\n");
        
        statsInfo.setText(stats.toString());
        
        pan.add(new JScrollPane(codeInfo));
        pan.add(new JScrollPane(statsInfo));
        
        return pan;
    }
    
    private Map<Character, String> genCodes() {
        Map<Character, String> codes = new HashMap<>();
        genCodesRec(root, "", codes);
        return codes;
    }
    
    private void genCodesRec(HuffmanEngine.Node node, String code, Map<Character, String> codes) {
        if (node == null) return;
        
        if (node.left == null && node.right == null) {
            codes.put(node.ch, code.isEmpty() ? "0" : code);
            return;
        }
        
        genCodesRec(node.left, code + "0", codes);
        genCodesRec(node.right, code + "1", codes);
    }
    
    private int getDepth(HuffmanEngine.Node node) {
        if (node == null) return 0;
        return 1 + Math.max(getDepth(node.left), getDepth(node.right));
    }
    
    private double calcAvg(Map<Character, String> codes) {
        int totLen = 0;
        int totFreq = 0;
        
        for (Map.Entry<Character, String> e : codes.entrySet()) {
            char ch = e.getKey();
            String code = e.getValue();
            int f = freq.get(ch);
            
            totLen += code.length() * f;
            totFreq += f;
        }
        
        return totFreq > 0 ? (double) totLen / totFreq : 0;
    }
    
    private class TreePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            if (root != null) {
                drawTree(g2, root, getWidth() / 2, 50, getWidth() / 4, 0);
            }
        }
        
        private void drawTree(Graphics2D g2, HuffmanEngine.Node node, int x, int y, int gap, int lvl) {
            if (node == null) return;
            
            Color nodeCol = (node.left == null && node.right == null) ? 
                    new Color(100, 200, 100) : new Color(200, 100, 100);
            
            g2.setColor(nodeCol);
            Ellipse2D circle = new Ellipse2D.Double(x - RAD, y - RAD, 2 * RAD, 2 * RAD);
            g2.fill(circle);
            
            g2.setColor(Color.BLACK);
            g2.draw(circle);
            
            g2.setFont(new Font("Arial", Font.BOLD, 10));
            FontMetrics fm = g2.getFontMetrics();
            
            String txt = (node.left == null && node.right == null) ? 
                    String.valueOf(node.ch) : String.valueOf(node.freq);
            
            if (node.ch == '\n') txt = "\\n";
            if (node.ch == '\t') txt = "\\t";
            if (node.ch == ' ') txt = "SP";
            
            int txtX = x - fm.stringWidth(txt) / 2;
            int txtY = y + fm.getAscent() / 2 - 2;
            g2.drawString(txt, txtX, txtY);
            
            if (node.left != null) {
                int childX = x - gap;
                int childY = y + LVL_H;
                
                g2.setColor(Color.BLUE);
                g2.draw(new Line2D.Double(x, y + RAD, childX, childY - RAD));
                
                g2.setColor(Color.BLUE);
                g2.setFont(new Font("Arial", Font.BOLD, 12));
                g2.drawString("0", x - gap/2 - 5, y + LVL_H/2);
                
                drawTree(g2, node.left, childX, childY, gap / 2, lvl + 1);
            }
            
            if (node.right != null) {
                int childX = x + gap;
                int childY = y + LVL_H;
                
                g2.setColor(Color.RED);
                g2.draw(new Line2D.Double(x, y + RAD, childX, childY - RAD));
                
                g2.setColor(Color.RED);
                g2.setFont(new Font("Arial", Font.BOLD, 12));
                g2.drawString("1", x + gap/2 - 5, y + LVL_H/2);
                
                drawTree(g2, node.right, childX, childY, gap / 2, lvl + 1);
            }
        }
    }
}