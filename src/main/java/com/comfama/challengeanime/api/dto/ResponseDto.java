package com.comfama.challengeanime.api.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseDto<T> {
    Integer status;
    String message;
    T data;

    private ResponseDto() {
        // Constructor privado para forzar el uso del Builder
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {
        Integer status;
        String message;
        T data;

        private Builder() {
            // Constructor privado del Builder
        }

        public Builder<T> status(Integer status) {
            this.status = status;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ResponseDto<T> build() {
            ResponseDto<T> responseDto = new ResponseDto<>();
            responseDto.setStatus(status);
            responseDto.setMessage(message);
            responseDto.setData(data);
            return responseDto;
        }
    }
}
