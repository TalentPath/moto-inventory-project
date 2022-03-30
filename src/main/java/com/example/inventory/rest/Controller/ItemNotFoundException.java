package com.example.inventory.rest.Controller;

public class ItemNotFoundException extends RuntimeException {
    ItemNotFoundException(Long id) {super("Could not find item in repository");}
}
