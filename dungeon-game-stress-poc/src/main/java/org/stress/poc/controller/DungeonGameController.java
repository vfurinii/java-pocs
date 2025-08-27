package org.stress.poc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stress.poc.model.DungeonGameRequest;
import org.stress.poc.model.DungeonGameResponse;
import org.stress.poc.service.DungeonGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class DungeonGameController {

    @Autowired
    private DungeonGameService dungeonGameService;

    @GetMapping("/dungeons")
    public ResponseEntity<List<DungeonGameResponse>> findAll() {
        var responses = dungeonGameService.findAll();
        return ResponseEntity.ok(responses);
    }

    @PostMapping("/dungeons")
    public ResponseEntity<DungeonGameResponse> calculateMinimumHealth(@RequestBody DungeonGameRequest request) {
        var response = dungeonGameService.calculateAndSave(request.getDungeon());
        return ResponseEntity.ok(response);
    }

}
