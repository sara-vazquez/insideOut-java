package dev.sara.movies.vo;

import java.util.Arrays;

public class shortInfoVO {

        private String name;
        private String[] genre;
        private String releaseYear;
    
        public String getName() {
            return name;
        }
    
        public String[] getGenre() {
            return genre;
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
            if (!Arrays.equals(genre, other.genre))
                return false;
            return true;
        }
}
