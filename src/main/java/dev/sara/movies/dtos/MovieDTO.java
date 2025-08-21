package dev.sara.movies.dtos;

import com.google.gson.annotations.SerializedName;

import dev.sara.movies.vo.shortInfoVO;

public class MovieDTO {
    
    private String imdbId;

    @SerializedName("short")
    private shortInfoVO shortInfo;

    public String getImdbId() {
        return imdbId;
    }

    public shortInfoVO getShortInfo() {
        return shortInfo;
    }
}
