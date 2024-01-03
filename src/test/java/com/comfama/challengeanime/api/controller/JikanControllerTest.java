package com.comfama.challengeanime.api.controller;

import com.comfama.challengeanime.api.dto.ResponseDto;
import com.comfama.challengeanime.api.dto.jikan.ResponseJikanDto;
import com.comfama.challengeanime.api.service.IJikanService;
import examples.AnimeDtos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JikanControllerTest {
    @Mock
    private IJikanService iJikanService;
    @InjectMocks
    private JikanController jikanController;

    @Test
    void shouldReturnHttpStatusOk() {
        var responseDto = ResponseDto.<ResponseJikanDto>builder()
                .status(HttpStatus.OK.value())
                .data(AnimeDtos.getResponseJikanDto())
                .build();

        when(this.iJikanService.getListAnimeByTitle(eq(1), eq(20), eq("Naruto"))).thenReturn(responseDto);

        var response = this.jikanController.getListAnimeByTitle(1,20,"Naruto");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(responseDto, response.getBody());
    }
}