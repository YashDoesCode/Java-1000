import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class SmartHuffmanCompressor extends JFrame {
    private JTextArea log;
    private JProgressBar pBar;
    private JLabel status;
    private HuffmanEngine engine;
    private CompareEngine compare;
    
    public SmartHuffmanCompressor() {
        engine = new HuffmanEngine();
        compare = new CompareEngine();
        initGUI();
    }
    
    private void initGUI() {
        setTitle("Smart Huffman Compressor - AI/ML Era File Optimization");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        createMenu();
        createMain();
        createStatus();
        
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        showWelcome();
    }
    
    private void createMenu() {
        JMenuBar menu = new JMenuBar();
        
        JMenu file = new JMenu("File");
        JMenuItem compItem = new JMenuItem("ðŸ—œï¸ Compress File");
        JMenuItem decompItem = new JMenuItem("ðŸ“‚ Decompress File");
        JMenuItem benchItem = new JMenuItem("âš¡ Benchmark Compression");
        JMenuItem exitItem = new JMenuItem("âŒ Exit");
        
        compItem.addActionListener(e -> compress());
        decompItem.addActionListener(e -> decompress());
        benchItem.addActionListener(e -> benchmark());
        exitItem.addActionListener(e -> System.exit(0));
        
        file.add(compItem);
        file.add(decompItem);
        file.addSeparator();
        file.add(benchItem);
        file.addSeparator();
        file.add(exitItem);
        
        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("ðŸ“– About Huffman & AI/ML");
        about.addActionListener(e -> showInfo());
        help.add(about);
        
        menu.add(file);
        menu.add(help);
        setJMenuBar(menu);
    }
    
    private void createMain() {
        JPanel main = new JPanel(new BorderLayout());
        
        JPanel btns = new JPanel(new GridLayout(2, 2, 10, 10));
        btns.setBorder(BorderFactory.createTitledBorder("Quick Actions"));
        
        JButton compBtn = makeBtn("ðŸ—œï¸ Compress File", Color.BLUE);
        JButton decompBtn = makeBtn("ðŸ“‚ Decompress File", Color.GREEN);
        JButton benchBtn = makeBtn("âš¡ Benchmark Test", Color.ORANGE);
        JButton visBtn = makeBtn("ðŸ“Š Visualize Tree", Color.MAGENTA);
        
        compBtn.addActionListener(e -> compress());
        decompBtn.addActionListener(e -> decompress());
        benchBtn.addActionListener(e -> benchmark());
        visBtn.addActionListener(e -> showTree());
        
        btns.add(compBtn);
        btns.add(decompBtn);
        btns.add(benchBtn);
        btns.add(visBtn);
        
        log = new JTextArea();
        log.setEditable(false);
        log.setBackground(new Color(250, 250, 250));
        log.setFont(new Font("Consolas", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(log);
        scroll.setBorder(BorderFactory.createTitledBorder("Compression Log & Analysis"));
        
        main.add(btns, BorderLayout.NORTH);
        main.add(scroll, BorderLayout.CENTER);
        
        add(main, BorderLayout.CENTER);
    }
    
    private void createStatus() {
        JPanel statusPan = new JPanel(new BorderLayout());
        statusPan.setBorder(BorderFactory.createEtchedBorder());
        
        status = new JLabel("Ready for compression operations");
        pBar = new JProgressBar();
        pBar.setStringPainted(true);
        
        statusPan.add(status, BorderLayout.WEST);
        statusPan.add(pBar, BorderLayout.EAST);
        
        add(statusPan, BorderLayout.SOUTH);
    }
    
    private JButton makeBtn(String text, Color color) {
        JButton btn = new JButton(text);
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial", Font.BOLD, 12));
        return btn;
    }
    
    private void compress() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Select File to Compress");
        
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File input = fc.getSelectedFile();
            
            fc.setDialogTitle("Save Compressed File As");
            fc.setSelectedFile(new File(input.getName() + ".huf"));
            
            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File output = fc.getSelectedFile();
                
                SwingWorker<Void, String> work = new SwingWorker<Void, String>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        publish("ðŸ”„ Starting compression process...");
                        pBar.setIndeterminate(true);
                        
                        long start = System.currentTimeMillis();
                        engine.comp(input.getAbsolutePath(), output.getAbsolutePath());
                        long end = System.currentTimeMillis();
                        
                        long origSize = input.length();
                        long compSize = output.length();
                        double ratio = (double) compSize / origSize * 100;
                        
                        publish("âœ… Compression completed!");
                        publish("ðŸ“Š COMPRESSION STATISTICS:");
                        publish("   Original size: " + fmtBytes(origSize));
                        publish("   Compressed size: " + fmtBytes(compSize));
                        publish("   Compression ratio: " + String.format("%.2f%%", ratio));
                        publish("   Time taken: " + (end - start) + "ms");
                        publish("   Space saved: " + fmtBytes(origSize - compSize));
                        
                        showFreq(engine.getLastFreq());
                        
                        return null;
                    }
                    
                    @Override
                    protected void process(List<String> msgs) {
                        for (String msg : msgs) {
                            log.append(msg + "\n");
                        }
                        log.setCaretPosition(log.getDocument().getLength());
                    }
                    
                    @Override
                    protected void done() {
                        pBar.setIndeterminate(false);
                        status.setText("Compression completed successfully");
                    }
                };
                
                work.execute();
            }
        }
    }
    
    private void decompress() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Select Compressed File (.huf)");
        
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File input = fc.getSelectedFile();
            
            fc.setDialogTitle("Save Decompressed File As");
            String outName = input.getName().replaceAll("\\.huf$", "_restored.txt");
            fc.setSelectedFile(new File(outName));
            
            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File output = fc.getSelectedFile();
                
                SwingWorker<Void, String> work = new SwingWorker<Void, String>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        publish("ðŸ”„ Starting decompression process...");
                        pBar.setIndeterminate(true);
                        
                        long start = System.currentTimeMillis();
                        engine.decomp(input.getAbsolutePath(), output.getAbsolutePath());
                        long end = System.currentTimeMillis();
                        
                        publish("âœ… Decompression completed!");
                        publish("   Time taken: " + (end - start) + "ms");
                        publish("   Restored file: " + output.getName());
                        
                        return null;
                    }
                    
                    @Override
                    protected void process(List<String> msgs) {
                        for (String msg : msgs) {
                            log.append(msg + "\n");
                        }
                        log.setCaretPosition(log.getDocument().getLength());
                    }
                    
                    @Override
                    protected void done() {
                        pBar.setIndeterminate(false);
                        status.setText("Decompression completed successfully");
                    }
                };
                
                work.execute();
            }
        }
    }
    
    private void benchmark() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Select File for Compression Benchmark");
        
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File test = fc.getSelectedFile();
            
            SwingWorker<Void, String> work = new SwingWorker<Void, String>() {
                @Override
                protected Void doInBackground() throws Exception {
                    publish("ðŸš€ COMPRESSION BENCHMARK ANALYSIS");
                    publish("=".repeat(50));
                    publish("File: " + test.getName());
                    publish("Original size: " + fmtBytes(test.length()));
                    publish("");
                    
                    pBar.setIndeterminate(true);
                    
                    BenchRes huff = benchHuff(test);
                    BenchRes gzip = benchGzip(test);
                    BenchRes zip = benchZip(test);
                    
                    publish("ðŸ“Š BENCHMARK RESULTS:");
                    publish("-".repeat(30));
                    publish(String.format("%-12s | %8s | %6s | %8s", "Algorithm", "Size", "Ratio", "Time"));
                    publish("-".repeat(30));
                    publish(String.format("%-12s | %8s | %5.1f%% | %6dms", "Huffman", 
                            fmtBytes(huff.size), huff.ratio, huff.time));
                    publish(String.format("%-12s | %8s | %5.1f%% | %6dms", "GZIP", 
                            fmtBytes(gzip.size), gzip.ratio, gzip.time));
                    publish(String.format("%-12s | %8s | %5.1f%% | %6dms", "ZIP", 
                            fmtBytes(zip.size), zip.ratio, zip.time));
                    
                    publish("");
                    publish("ðŸ† WINNER ANALYSIS:");
                    BenchRes winner = Collections.min(Arrays.asList(huff, gzip, zip), 
                            Comparator.comparingDouble(r -> r.ratio));
                    publish("   Best compression: " + winner.algo + " (" + 
                            String.format("%.1f%%", winner.ratio) + ")");
                    
                    publish("");
                    publish("ðŸ¤– AI/ML RELEVANCE:");
                    publish("   â€¢ Model storage optimization: " + 
                            String.format("%.1fMB saved per GB", (100 - winner.ratio) * 10));
                    publish("   â€¢ Cloud transfer efficiency: " + 
                            String.format("%.0f%% faster uploads", 100 - winner.ratio));
                    publish("   â€¢ Dataset compression for distributed training");
                    
                    return null;
                }
                
                @Override
                protected void process(List<String> msgs) {
                    for (String msg : msgs) {
                        log.append(msg + "\n");
                    }
                    log.setCaretPosition(log.getDocument().getLength());
                }
                
                @Override
                protected void done() {
                    pBar.setIndeterminate(false);
                    status.setText("Benchmark analysis completed");
                }
            };
            
            work.execute();
        }
    }
    
    private BenchRes benchHuff(File file) throws Exception {
        long start = System.currentTimeMillis();
        File temp = File.createTempFile("huff_test", ".huf");
        engine.comp(file.getAbsolutePath(), temp.getAbsolutePath());
        long end = System.currentTimeMillis();
        
        long compSize = temp.length();
        double ratio = (double) compSize / file.length() * 100;
        
        temp.delete();
        return new BenchRes("Huffman", compSize, ratio, end - start);
    }
    
    private BenchRes benchGzip(File file) throws Exception {
        long start = System.currentTimeMillis();
        File temp = File.createTempFile("gzip_test", ".gz");
        
        try (FileInputStream fis = new FileInputStream(file);
             FileOutputStream fos = new FileOutputStream(temp);
             GZIPOutputStream gzos = new GZIPOutputStream(fos)) {
            
            byte[] buf = new byte[1024];
            int read;
            while ((read = fis.read(buf)) != -1) {
                gzos.write(buf, 0, read);
            }
        }
        
        long end = System.currentTimeMillis();
        long compSize = temp.length();
        double ratio = (double) compSize / file.length() * 100;
        
        temp.delete();
        return new BenchRes("GZIP", compSize, ratio, end - start);
    }
    
    private BenchRes benchZip(File file) throws Exception {
        long start = System.currentTimeMillis();
        File temp = File.createTempFile("zip_test", ".zip");
        
        try (FileInputStream fis = new FileInputStream(file);
             FileOutputStream fos = new FileOutputStream(temp);
             ZipOutputStream zos = new ZipOutputStream(fos)) {
            
            ZipEntry entry = new ZipEntry(file.getName());
            zos.putNextEntry(entry);
            
            byte[] buf = new byte[1024];
            int read;
            while ((read = fis.read(buf)) != -1) {
                zos.write(buf, 0, read);
            }
            zos.closeEntry();
        }
        
        long end = System.currentTimeMillis();
        long compSize = temp.length();
        double ratio = (double) compSize / file.length() * 100;
        
        temp.delete();
        return new BenchRes("ZIP", compSize, ratio, end - start);
    }
    
    private void showTree() {
        Map<Character, Integer> freq = engine.getLastFreq();
        if (freq == null || freq.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No compression data available. Compress a file first!", 
                    "No Data", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        TreeVisDialog dlg = new TreeVisDialog(this, freq);
        dlg.setVisible(true);
    }
    
    private void showFreq(Map<Character, Integer> freq) {
        log.append("\nðŸ“ˆ CHARACTER FREQUENCY ANALYSIS:\n");
        log.append("-".repeat(30) + "\n");
        
        List<Map.Entry<Character, Integer>> sorted = new ArrayList<>(freq.entrySet());
        sorted.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        int total = freq.values().stream().mapToInt(Integer::intValue).sum();
        int shown = 0;
        
        for (Map.Entry<Character, Integer> e : sorted) {
            if (shown++ >= 10) break;
            
            char ch = e.getKey();
            int f = e.getValue();
            double pct = (double) f / total * 100;
            
            String chDisp = ch == '\n' ? "\\n" : ch == '\t' ? "\\t" : String.valueOf(ch);
            log.append(String.format("'%s': %4d (%5.1f%%) %s\n", 
                    chDisp, f, pct, "â–ˆ".repeat((int)(pct / 2))));
        }
        
        if (sorted.size() > 10) {
            log.append("... and " + (sorted.size() - 10) + " more characters\n");
        }
        log.append("\n");
    }
    
    private void showInfo() {
        String msg = """
                ðŸ¤– HUFFMAN COMPRESSION IN THE AI/ML ERA
                
                ðŸ“Š Big Data & ML Applications:
                â€¢ Dataset compression for distributed training
                â€¢ Model parameter storage optimization
                â€¢ Faster data pipeline processing
                â€¢ Reduced cloud storage costs
                
                ðŸš€ Modern Relevance:
                â€¢ Neural network weight quantization concepts
                â€¢ Information theory foundations for AI
                â€¢ Entropy-based feature selection
                â€¢ Compression for edge computing
                
                ðŸ’¡ Industry Impact:
                â€¢ 30-60% reduction in ML model storage
                â€¢ Faster model deployment and transfer
                â€¢ Efficient data streaming for real-time AI
                â€¢ Reduced bandwidth for IoT and edge devices
                
                This classic algorithm remains fundamental to
                modern AI infrastructure optimization!
                """;
        
        JOptionPane.showMessageDialog(this, msg, "Huffman in AI/ML Era", 
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void showWelcome() {
        log.append("ðŸŽ‰ WELCOME TO SMART HUFFMAN COMPRESSOR\n");
        log.append("=".repeat(50) + "\n");
        log.append("Built in 2021, Enhanced for AI/ML Era 2025\n");
        log.append("\nðŸš€ Features:\n");
        log.append("â€¢ Advanced Huffman compression with visualization\n");
        log.append("â€¢ Benchmark against GZIP, ZIP algorithms\n");
        log.append("â€¢ AI/ML storage optimization insights\n");
        log.append("â€¢ Interactive frequency analysis\n");
        log.append("â€¢ Professional GUI with progress tracking\n");
        log.append("\nðŸ’¡ Ready to compress files efficiently!\n");
        log.append("-".repeat(50) + "\n\n");
    }
    
    private String fmtBytes(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return String.format("%.1f KB", bytes / 1024.0);
        if (bytes < 1024 * 1024 * 1024) return String.format("%.1f MB", bytes / (1024.0 * 1024));
        return String.format("%.1f GB", bytes / (1024.0 * 1024 * 1024));
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeel());
            } catch (Exception e) {
                // Use default look and feel
            }
            
            new SmartHuffmanCompressor().setVisible(true);
        });
    }
    
    private static class BenchRes {
        String algo;
        long size;
        double ratio;
        long time;
        
        BenchRes(String algo, long size, double ratio, long time) {
            this.algo = algo;
            this.size = size;
            this.ratio = ratio;
            this.time = time;
        }
    }
    
    private static class CompareEngine {
        // Placeholder for future compression comparisons
    }
}