package ru.test.JavaOOP.runner;

import ru.test.JavaOOP.task.Task;

public class StartTask {
    public static void main(String[] args) {

        System.out.println("Привет! Сколько нужно компаний? (min: 1 | max 10):");
        Task.startHandler();
    }
}
