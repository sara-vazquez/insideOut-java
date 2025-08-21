package dev.sara.movies.vo;

import java.util.Arrays;

public class shortInfoVO {
    private String name;
    private String url;
    private String[] genre;
    private String releaseDate;
    private String creationDate;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String[] getGenre() {
        return genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getCreationDate() {
        return creationDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ShortInfoVO other = (ShortInfoVO) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (url == null) {
            if (other.url != null)
                return false;
        } else if (!url.equals(other.url))
            return false;
        if (image == null) {
            if (other.image != null)
                return false;
        } else if (!image.equals(other.image))
            return false;
        if (!Arrays.equals(genre, other.genre))
            return false;
        return true;
    }
}
