package com.comfama.challengeanime.api.controller;

import com.comfama.challengeanime.api.dto.ResponseDto;
import com.comfama.challengeanime.api.dto.jikan.ResponseJikanDto;
import com.comfama.challengeanime.api.service.IJikanService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jikan")
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JikanController {
    IJikanService iJikanService;

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDto<ResponseJikanDto>> getListAnime(
            @RequestParam Integer page,
            @RequestParam Integer limit,
            @RequestParam String search
    ) {
        return ResponseEntity.ok().body(this.iJikanService.getListAnimeByTitle(page,limit,search));
    }
}
