package org.example;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class MyCommands {

    @ShellMethod(key = "hello")
    public String hello(@ShellOption(defaultValue = "name") String name) {
        return "Olá, " + name + "!";
    }

    @ShellMethod(key = "sum")
    public int sum(
            @ShellOption(defaultValue = "a") int a,
            @ShellOption(defaultValue = "b") int b
    ) {
        return a + b;
    }

    @ShellMethod(key = "exit")
    public void exit() {
        System.exit(0);
    }
}
