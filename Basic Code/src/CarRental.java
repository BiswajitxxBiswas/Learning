import java.util.Scanner;
public class CarRental{
    private int Carid;
    private String Cartype;
    private float Rent;

    public void GetCar(int Carid, String Cartype){
        this.Carid = Carid;
        this.Cartype=Cartype;
        this.Rent = GetRent();
    }

    public float GetRent() {
        switch(Cartype.toLowerCase()){
            case "small car":
                return 1000;
            case "van":
                return 800;
            case "suv":
                return 2500;
                default:
            return 0;
        }
    }
    void ShowCar(){
        System.out.println("CarId :" + Carid);
        System.out.println("Cartype :" + Cartype);
        System.out.println("Rent :" + Rent);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CarRental carRental = new CarRental();

        System.out.println("Enter Car Id");
        int Carid = in.nextInt();

        in.nextLine();

        System.out.println("Enter Car Type");
        String Cartype = in.nextLine();

        carRental.GetCar(Carid,Cartype);
        carRental.ShowCar();
    }

}
