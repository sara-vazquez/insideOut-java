package dev.sara.movies.dtos;

public class MovieDTO {
    
    private String imdbId;

    @SerializedName("short")
    private ShortInfoVO shortInfo;

    public String getImdbId() {
        return imdbId;
    }

    public ShortInfoVO getShortInfo() {
        return shortInfo;
    }
}
