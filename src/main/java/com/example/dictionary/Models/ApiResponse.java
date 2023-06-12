package com.example.dictionary.Models;

import java.util.List;

import lombok.Data;

@Data
public class ApiResponse {
    private Boolean success;
        private String message;
        private List<Words> results;

        public ApiResponse(Boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public ApiResponse(Boolean success, List<Words> results) {
            this.success = success;
            this.results = results;
        }
}
