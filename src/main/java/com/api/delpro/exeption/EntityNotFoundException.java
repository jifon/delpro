package com.api.delpro.exeption;


public class EntityNotFoundException extends Exception {

    public EntityNotFoundException(String id) {
        super("entity not found" + id);
    }

}
