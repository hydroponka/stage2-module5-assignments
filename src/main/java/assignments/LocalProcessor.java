package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
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
    private Long period;
    private String processorVersion;
    private Integer valueofCheap;
    private Scanner informationscanner;
    private LinkedList<String> stringArrayList;

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationscanner, LinkedList<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueofCheap = valueOfCheap;
        this.informationscanner = informationscanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        for (int i = 0; i < period; i++) {
            System.out.println(stringArrayList.get(i).hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stringArrayList.size(); i++) {
            sb.append(stringList.get(i)).append(" ");
        }
        return sb.toString();
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName() throws FileNotFoundException {
            while (informationscanner.hasNext()) {
                processorVersion+= informationscanner.nextLine();
            }

    }
}
