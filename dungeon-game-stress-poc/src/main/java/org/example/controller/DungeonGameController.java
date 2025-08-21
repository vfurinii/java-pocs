package org.example.controller;

import org.example.model.DungeonGame;
import org.example.service.DungeonGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class DungeonGameController {

    @Autowired
    private DungeonGameService dungeonGameService;

    @GetMapping("/dungeons")
    public ResponseEntity<List<DungeonGame>> findAll() {
        var responses = dungeonGameService.findAll();
        return ResponseEntity.ok(responses);
    }
}
