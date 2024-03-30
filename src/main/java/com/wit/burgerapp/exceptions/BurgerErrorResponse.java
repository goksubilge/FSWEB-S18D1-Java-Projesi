package com.wit.burgerapp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BurgerErrorResponse {
    private String message;
}
