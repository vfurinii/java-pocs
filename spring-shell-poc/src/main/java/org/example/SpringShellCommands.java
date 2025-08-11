package org.example;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.web.client.RestTemplate;

@ShellComponent
public class SpringShellCommands {

    private final RestTemplate restTemplate;

    public SpringShellCommands(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @ShellMethod(key = "hello", value = "Say hello to someone")
    public String hello(@ShellOption(defaultValue = "name") String name) {
        return "Olá, " + name + "!";
    }

    @ShellMethod(key = "sum", value = "Sum two integers and return the result e.g. sum 5 10")
    public int sum(
            @ShellOption(defaultValue = "a") int a,
            @ShellOption(defaultValue = "b") int b
    ) {
        return a + b;
    }

    @ShellMethod(key = "joke", value = "Displays a random joke from the Chuck Norris API")
    public String joke() {
        return restTemplate.getForObject("https://api.chucknorris.io/jokes/random", String.class);
    }

    @ShellMethod(key = "exit")
    public void exit() {
        System.exit(0);
    }
}
