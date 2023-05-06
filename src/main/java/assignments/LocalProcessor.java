package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {

    private String processorName;
    private long period = 10000000000000L;
    protected String processorVersion;
    private int valueOfCheap;
    private Scanner informationScanner;
    static LinkedList<String> stringArrayList = new LinkedList<>();

    public LocalProcessor(String processorName, long period, String processorVersion, int valueOfCheap,
                          Scanner informationScanner, LinkedList<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(LinkedList<String> stringList) {
        for (String s : stringList) {
            System.out.println(s.hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String generateFullNameProcessor(LinkedList<String> stringList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : stringList) {
            stringBuilder.append(str).append(' ');
        }
        processorName = stringBuilder.toString().trim();
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        informationScanner = new Scanner(file);
        while (informationScanner.hasNextLine()) {
            sb.append(informationScanner.nextLine());
        }
        processorName = sb.toString();
    }
}
