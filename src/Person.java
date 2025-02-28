//pievienojam mainīgus, ko vēlāk izmantosim
public class Person {
        private String firstName;       // vārds
        private String lastName;        // uzvārds
        private int age;                // vecums
        private double height;          // augums metros
        private double weight;          // svars kilogramos
        private String country;         // dzīvošanas valsts
        private double income;          // mēneša ienākumi
        private boolean likesToProgram; // vai patīk programmēt

    //taisam konstruktoru, kurā piešķiram mainīgo nozīmes
    public Person(String firstName, String lastName, int age, double height, double weight, String country, double income, boolean likesToProgram) {
        this.firstName = firstName; //"this" ir šīs klases parametrs
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.country = country;
        this.income = income;
        this.likesToProgram = likesToProgram;
    }

    //metode, kas izvada informāciju par cilvēku
    public void printInfo() {
        System.out.println("Vārds: " + firstName);
        System.out.println("Uzvārds: " + lastName);
        System.out.println("Vecums: " + age);
        System.out.println("Augums: " + height + " m");
        System.out.println("Svars: " + weight + " kg");
        System.out.println("Valsts: " + country);
        System.out.println("Ienākumi: " + income + " EUR/mēnesī");
        System.out.println("Patīk programmēt: " + (likesToProgram ? "Jā" : "Nē"));
    }
    }

