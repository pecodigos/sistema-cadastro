package controllers;

import exceptions.InvalidPathException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class QuestionController {

    List<String> questions = new ArrayList<>();

    public void registerQuestion(String question, String path) throws InvalidPathException {
        try {
            questions = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            throw new InvalidPathException();
        }

        int lastNumber = 0;
        if (!questions.isEmpty()) {
            String lastLine = questions.getLast();

            String[] parts = lastLine.split("-", 2);
            lastNumber = Integer.parseInt(parts[0].trim());
        }

        lastNumber++;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write("\n" + lastNumber + " - " + question);
        } catch (IOException e) {
            throw new InvalidPathException();
        }
    }

    public void deleteQuestion() {

    }
}
