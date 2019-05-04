public class Person {

    private int age;
    public String gender;
    private String name;
    private String Git;

    public Person(){
        this.age=20;
        this.name="leon";
        this.gender="male";
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHi(){
        System.out.println(age+": "+name);
    }

    public void sleep(){
        System.out.println(name+" is sleeping");
    }
}
