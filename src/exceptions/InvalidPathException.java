package exceptions;

import java.io.IOException;

public class InvalidPathException extends IOException {

    public InvalidPathException() {
        super("Caminho incorreto. Por favor, informe um caminho correto para o arquivo.");
    }
}
