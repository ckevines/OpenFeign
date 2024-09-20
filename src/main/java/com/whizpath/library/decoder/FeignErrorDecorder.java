package com.whizpath.library.decoder;

import com.whizpath.library.exception.BadRequestException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignErrorDecorder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400:
                return new BadRequestException("Bad request error from Book service");
            case 404:
                return new IllegalArgumentException("Resource Not Found");
            default:
                return new Exception("Generic Error");
        }
    }
}
