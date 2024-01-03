package com.comfama.challengeanime.api.service;

import com.comfama.challengeanime.api.dto.ResponseDto;
import com.comfama.challengeanime.api.dto.jikan.AnimeDataDto;
import com.comfama.challengeanime.api.dto.jikan.ResponseJikanDto;
import com.comfama.challengeanime.api.enums.RecommendationMessages;
import com.comfama.challengeanime.api.provider.jikan.IJikanClient;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class JikanService implements IJikanService{

    IJikanClient iJikanClient;
    @Override
    public ResponseDto<ResponseJikanDto> getListAnimeByTitle(Integer page, Integer limit, String search) {
        ResponseJikanDto responseApi = this.iJikanClient.getListAnimeByTitle(page, limit, search);
        responseApi.getData().forEach(this::getRecommendationMessage);

        return ResponseDto.<ResponseJikanDto>builder()
                .status(HttpStatus.OK.value())
                .data(responseApi)
                .build();
    }

    private void getRecommendationMessage(AnimeDataDto animeDataDTO){
        if(Objects.isNull(animeDataDTO.getScore())){
            animeDataDTO.setRecommendation(RecommendationMessages.NA.getMessage());
        } else if (animeDataDTO.getScore() < 5){
            animeDataDTO.setRecommendation(RecommendationMessages.LOW.getMessage());
        } else if (animeDataDTO.getScore() < 8) {
            animeDataDTO.setRecommendation(RecommendationMessages.MODERATE.getMessage());
        } else {
            animeDataDTO.setRecommendation(RecommendationMessages.HIGH.getMessage());
        }
    }
}
