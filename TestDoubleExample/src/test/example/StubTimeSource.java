package test.example;

import main.example.TimeSource;

import java.time.LocalDateTime;

public class StubTimeSource implements TimeSource {
    @Override
    public LocalDateTime currentTime(){
        return LocalDateTime.now();
    }
}
