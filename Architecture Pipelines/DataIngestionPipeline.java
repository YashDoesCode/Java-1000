import java.util.*;
public class DataIngestionPipeline {

    public static class Record {

        public String id;
        public String payload;

        public Record(String id, String payload) {
            this.id = id;
            this.payload = payload;
        }
    }

    private List<Record> ingestedBuffer = new ArrayList<>();

    public void ingest(Record record) {
        if (record != null && record.id != null) {
            ingestedBuffer.add(record);
        }
    }

    public int getIngestedCount() {
        return ingestedBuffer.size();
    }

    public void flush() {
        ingestedBuffer.clear();
    }
}
