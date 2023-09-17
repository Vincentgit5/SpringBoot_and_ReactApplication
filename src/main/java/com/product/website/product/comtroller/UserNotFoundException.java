package com.product.website.product.comtroller;

public class UserNotFoundException extends Throwable {
    public UserNotFoundException(String message) {
        super( message);
    }
}
