package com.comfama.challengeanime.api.service;

import com.comfama.challengeanime.api.dto.ResponseDto;
import com.comfama.challengeanime.api.dto.jikan.ResponseJikanDto;
import com.comfama.challengeanime.api.provider.jikan.IJikanClient;
import examples.AnimeDtos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JikanServiceTest {
    @Mock
    private IJikanClient iJikanClient;
    @InjectMocks
    private JikanService jikanService;

    @Test
    void shouldReturnResponseDtoWithResponseJikanDto() {
        var responseDto = ResponseDto.<ResponseJikanDto>builder()
                .status(HttpStatus.OK.value())
                .data(AnimeDtos.getResponseJikanDto())
                .build();

        when(this.iJikanClient.getListAnimeByTitle(eq(1), eq(25), eq("Naruto")))
                .thenReturn(AnimeDtos.getResponseJikanDto());

        var response = this.jikanService.getListAnimeByTitle(1, 25, "Naruto");

        assertEquals(responseDto, response);
        verify(this.iJikanClient, times(1)).getListAnimeByTitle(1, 25, "Naruto");
    }
}