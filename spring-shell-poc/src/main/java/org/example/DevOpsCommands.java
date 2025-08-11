package org.example;

import org.springframework.shell.command.annotation.Option;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.web.client.RestTemplate;

@ShellComponent
public class DevOpsCommands {

    private final RestTemplate restTemplate;

    public DevOpsCommands(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @ShellMethod(key = "check-app", value = "Checks if a REST application is responding")
    public String checkApp(
            @Option(longNames = "url", required = true, description = "URL base") String url) {
        try {
            var response = restTemplate.getForEntity(url, String.class);
            return "Status: 🆙 (" + response.getStatusCode() + ")";
        } catch (Exception e) {
            return "Status: DOWN ⬇️ (" + e.getMessage() + ")";
        }
    }
}
