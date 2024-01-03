package com.comfama.challengeanime.api.provider.jikan;

import com.comfama.challengeanime.api.dto.jikan.ResponseJikanDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "jikanClient", url = "${apiAnime.urlBase}")
public interface IJikanClient {
    @GetMapping
    ResponseJikanDto getListAnimeByTitle(
            @RequestParam Integer page,
            @RequestParam Integer limit,
            @RequestParam String q
    );
}
