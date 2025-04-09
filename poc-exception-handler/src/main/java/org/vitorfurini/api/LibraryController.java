package org.vitorfurini.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vitorfurini.model.LibraryModel;
import org.vitorfurini.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping
    public LibraryModel postLibrary(@RequestBody LibraryModel libraryModel) {
        return libraryService.salvar(libraryModel);
    }
}
