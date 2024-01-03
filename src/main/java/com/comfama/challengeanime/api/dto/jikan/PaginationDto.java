package com.comfama.challengeanime.api.dto.jikan;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaginationDto {

     @JsonProperty("last_visible_page")
     Integer lastVisiblePage;

     @JsonProperty("has_next_page")
     Boolean hasNextPage;

     @JsonProperty("current_page")
     Integer currentPage;

     ItemsDto items;
}
