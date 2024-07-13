package stream;

public class Person {
    private String name;
    private int height;
    private int mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;

    public Person(String name, int height, int mass, String hair_color, String skin_color, String eye_color, String birth_year, String gender) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hair_color = hair_color;
        this.skin_color = skin_color;
        this.eye_color = eye_color;
        this.birth_year = birth_year;
        this.gender = gender;
    }

    public void showInfo(){
        System.out.printf("name: %s\n",this.name);
        System.out.printf("height: %d\n",this.height);
        System.out.printf("mass: %d\n",this.mass);
        System.out.printf("hair_color: %s\n",this.hair_color);
        System.out.printf("skin_color: %s\n",this.skin_color);
        System.out.printf("eye_color: %s\n",this.eye_color);
        System.out.printf("birth_year: %s\n",this.birth_year);
        System.out.printf("gender: %s\n",this.gender);
        System.out.println("--------------------------");
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getMass() {
        return mass;
    }

    public String getHair_color() {
        return hair_color;
    }

    public String getSkin_color() {
        return skin_color;
    }

    public String getEye_color() {
        return eye_color;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public String getGender() {
        return gender;
    }
}
