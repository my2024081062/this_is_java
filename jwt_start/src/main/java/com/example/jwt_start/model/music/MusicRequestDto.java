package com.example.jwt_start.model.music;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MusicRequestDto implements IMusic {
    private Long id;
    @Size(min = 1, max = 100)
    private String title;
    @Size(min = 1, max = 50)
    private String artist;
    @Pattern(regexp = "^[0-9]{2}:[0-9]{2}|^[0-9]{2}:[0-9]{2}:[0-9]{2}", message = "xx:xx")
    private String playtime;
    @JsonIgnore
    private String createId;
    @JsonIgnore
    private LocalDateTime createDt;
    @JsonIgnore
    private String updateId;
    @JsonIgnore
    private LocalDateTime updateDt;
    @JsonIgnore
    private String deleteId;
    @JsonIgnore
    private LocalDateTime deleteDt;
}
