package controllers;

import exceptions.InvalidPathException;

import java.io.*;
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

        String lastLine = questions.getLast();
        String[] parts = lastLine.split("-", 2);
        int lastNumber = Integer.parseInt(parts[0].trim());

        lastNumber++;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write("\n" + lastNumber + " - " + question);
        } catch (IOException e) {
            throw new InvalidPathException();
        }
    }

    public void deleteQuestion(int questionNumber, String path) throws InvalidPathException {
        List<String> newList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (Integer.parseInt(line.split("\\s")[0]) != questionNumber) {
                    newList.add(line);
                }
            }
            newList.removeIf(x -> Integer.parseInt(String.valueOf(x.charAt(0))) == questionNumber);

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
                for (String question : newList) {
                    bw.write(question + "\n");
                }
            }
        } catch (IOException e) {
            throw new InvalidPathException();
        }
    }

}
