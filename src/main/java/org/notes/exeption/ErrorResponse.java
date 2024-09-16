package org.notes.exeption;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class ErrorResponse {

    String message;

    public static ErrorResponse of(String message) {
        return new ErrorResponse(message);
    }
}
