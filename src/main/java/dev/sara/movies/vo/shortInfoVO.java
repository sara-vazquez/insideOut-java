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
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            result = prime * result + Arrays.hashCode(genre);
            result = prime * result + ((releaseYear == null) ? 0 : releaseYear.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            shortInfoVO other = (shortInfoVO) obj;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            if (!Arrays.equals(genre, other.genre))
                return false;
            if (releaseYear == null) {
                if (other.releaseYear != null)
                    return false;
            } else if (!releaseYear.equals(other.releaseYear))
                return false;
            return true;
        }
}
