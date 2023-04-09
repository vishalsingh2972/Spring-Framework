package demo;

public class Nurse implements Staff {
    public void assist() { //nurse can assist others
        System.out.println("Nurse is assisting");
    }

//Setter and Getter Injection - Injecting Properties via XML
    private String qualification;

    public String getQualification() {
        System.out.println("Sita");
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

}
