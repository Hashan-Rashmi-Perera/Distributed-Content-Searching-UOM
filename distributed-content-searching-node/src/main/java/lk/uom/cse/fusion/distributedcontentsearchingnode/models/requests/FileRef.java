package lk.uom.cse.fusion.distributedcontentsearchingnode.models.requests;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicReference;

@Getter
public class FileRef {

    private final AtomicReference<String> filePath = new AtomicReference<String>("");

    public String update() {
    String current = filePath.get();
    String newValue = current;
    while (!filePath.compareAndSet(current, newValue)) {
        current = filePath.get();
         newValue = current;
        }
    return filePath.get();
    }

    public AtomicReference<String> getFilePath() {
        return filePath;
    }
}


