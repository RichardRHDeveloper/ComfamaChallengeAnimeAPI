package examples;

import com.comfama.challengeanime.api.dto.jikan.*;

import java.util.List;

public class AnimeDtos {
    public static ItemsDto getItemsDto() {
        return ItemsDto.builder()
                .count(10)
                .count(30)
                .perPage(10)
                .build();
    }

    public static PaginationDto getPaginationDto() {
        return PaginationDto.builder()
                .items(AnimeDtos.getItemsDto())
                .lastVisiblePage(3)
                .hasNextPage(true)
                .currentPage(1)
                .build();
    }

    public static ImageTypeDto getImageTypeDto() {
        return ImageTypeDto.builder()
                .imageUrl("https://cdn.myanimelist.net/images/anime/13/17405.jpg")
                .build();
    }

    public static ImagesDto getImagesDto() {
        return  ImagesDto.builder()
                .jpg(AnimeDtos.getImageTypeDto())
                .build();
    }
    public static AnimeDataDto getAnimeDataDto() {
        return  AnimeDataDto.builder()
                .title("Naruto")
                .images(AnimeDtos.getImagesDto())
                .score(7.99)
                .recommendation("You may have fun.")
                .build();
    }

    public static ResponseJikanDto getResponseJikanDto() {
        return ResponseJikanDto.builder()
                .pagination(AnimeDtos.getPaginationDto())
                .data(List.of(AnimeDtos.getAnimeDataDto()))
                .build();
    }
}
