import java.util.ArrayList;
import java.util.List;

/**
 * This class controls the logic of the quiz
 */

public class QuizController {
    private List<Qns> qnsList;
    private int index = 0;

    public QuizController() {
        qnsList = new ArrayList<>();
        addQns();
    }

    public void addQns() {
        qnsList.add(new Qns("Brasil", "Brasilia", "brazil.jpg"));
        qnsList.add(new Qns("China", "Beijing", "china.jpg"));
        qnsList.add(new Qns("Colombia", "Bogota", "colombia.jpg"));
        qnsList.add(new Qns("Jamaika", "Kingston", "jamaika.jpg"));
        qnsList.add(new Qns("Sverige", "Stockholm", "sverige.png"));
        qnsList.add(new Qns("Syria", " Damaskus", "syria.jpg"));
    }


    public Qns getCurrentQns() {
        return qnsList.get(index);
    }

    public int getIndex() {
        return index;
    }

    public void addIndex() {
        index++;
    }

    public void getNextQns() {
        addIndex();
        getCurrentQns();
    }

    public String getImage() {
        Qns qns = getCurrentQns();
        String photoPath = qns.getPhotoPath();
        return photoPath;
    }


    public String getCountry() {
        Qns qns = getCurrentQns();
        String  country = qns.getCountry();
        return country;
    }


    public List<Qns> getAll() {
        return qnsList;
    }


}
