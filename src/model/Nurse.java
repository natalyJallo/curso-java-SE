package model;

public class Nurse extends User{
    private String especiality;

    public String getEspeciality() {
        return especiality;
    }

    public void setEspeciality(String especiality) {
        this.especiality = especiality;
    }

    public Nurse(String name, String email) {
        super(name, email);
    }

    @Override
    public void showDatUser() {
        System.out.println("Hospital: Ñahui");
    }
}
