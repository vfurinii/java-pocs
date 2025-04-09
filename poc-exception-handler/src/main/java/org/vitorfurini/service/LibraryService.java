package org.vitorfurini.service;

import org.springframework.stereotype.Service;
import org.vitorfurini.exception.BookNameException;
import org.vitorfurini.model.LibraryModel;

@Service
public class LibraryService {

    public LibraryModel salvar(LibraryModel model) {
        validValues(model);
        model.setId(1L);
        return model;
    }

    private void validValues(LibraryModel model) {
        if (model.getBookName() == null || model.getBookName().isBlank()) {
            throw new BookNameException("The model name cannot be null or blank");
        }
    }
}
