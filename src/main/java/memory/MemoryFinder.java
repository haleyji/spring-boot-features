package memory;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemoryFinder {
    public Memory get() {
        long max = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        long free = Runtime.getRuntime().freeMemory();
        long used = totalMemory - free;
        return new Memory(used, max);
    }

    @PostConstruct
    public void init() {
        log.info("init MemoryFinder");

    }
}
