package main.example;

import java.time.LocalDateTime;

public interface TimeSource {
    LocalDateTime currentTime();
}
