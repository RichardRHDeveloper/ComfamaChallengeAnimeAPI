package com.comfama.challengeanime.api.service;

import com.comfama.challengeanime.api.dto.ResponseDto;
import com.comfama.challengeanime.api.dto.jikan.ResponseJikanDto;

public interface IJikanService {
    ResponseDto<ResponseJikanDto> getListAnimeByTitle(Integer page, Integer limit, String search);
}
