
/**
 * This class construct information about the country, capital and photo of flag we want to use in our quiz
 */
public class Qns {
        private String country;
        private String capital;
        private String photoPath;

        public Qns(String country, String capital, String photoPath){
            setCountry(country);
            setCapital(capital);
            setPhotoPath(photoPath);
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCapital() {
            return capital;
        }

        public void setCapital(String capital) {
            this.capital = capital;
        }

        public String getPhotoPath() {
            return photoPath;
        }

        public void setPhotoPath(String photoPath) {
            this.photoPath = photoPath;
        }


}
