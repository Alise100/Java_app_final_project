import java.util.Scanner; //pievienojam klassi lai lasīt ko ievada lietotājs


public class Main {

    //Metode lai pirmais burts būtu liels

    public static String capitalize(String str){
        if (str == null || str.isEmpty()) { //ja tukšs laukums, izvada to pašu bez izmaiņām
            return str;
        }
        String[] words = str.split("\\s+"); //līnija sadalās ar atstarpēm
        StringBuilder capitalized = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                capitalized.append(Character.toUpperCase(word.charAt(0))) //katrais pirmais burts liels
                        .append(word.substring(1).toLowerCase()) //pārējie mazi
                        .append(" ");
            }
        }
        return capitalized.toString().trim(); //viss  saliekas kopā ar atstarpēm un pedēja atstarpe dzēšas ar trim
    }


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in); //scanner objekts, kurš lasa ko ievada lietotājs
        String repeat; // repeat mainīga kurā saglabājas lietotāja atbilde par atkārtoto registrāciju

        // Sākam do-while ciklu
        do {
                System.out.print("Ievadiet jūsu vārdu: ");
                String firstName = scanner.nextLine(); //nextLine turpina darbību no jaunas rindas
                firstName = capitalize(firstName);

                System.out.print("Ievadiet jūsu uzvārdu: ");
                String lastName = scanner.nextLine();
                lastName = capitalize(lastName);

                System.out.print("Ievadiet jūsu vecumu: ");
                int age = scanner.nextInt();

                    while (age < 0) { //cikls atkārtosies, ja būs ievadīts negatīvs vecums
                    System.out.print("Vecums nevar būt negatīvs. Ievadiet vēlreiz: ");
                    age = scanner.nextInt();
                }

                System.out.print("Ievadiet jūsu augumu metros: ");
                double height = scanner.nextDouble();

                    while (height < 0) { //cikls atkārtosies, ja būs ievadīts negatīvs augums
                        System.out.print("Augums nevar būt negatīvs. Ievadiet vēlreiz: ");
                        height = scanner.nextDouble();
                    }

                    System.out.print("Ievadiet jūsu svaru kilogrammos: ");
                    double weight = scanner.nextDouble();

                    while (weight < 0) { // cikls atkārtosies, ja būs ievadīts negatīvs svars
                        System.out.print("Svars nevar būt negatīvs. Ievadiet vēlreiz: ");
                        weight = scanner.nextDouble();
                    }

                    scanner.nextLine();

                    System.out.print("Ievadiet jūsu dzīvesvietas valsti: ");
                    String country = scanner.nextLine();
                    country = capitalize(country);

                    System.out.print("Ievadiet jūsu mēneša ienākumus EUR: ");
                    double income = scanner.nextDouble();
                    scanner.nextLine(); // Поглощаем перевод строки после nextDouble()

                    System.out.print("Vai jums patīk programmēt? (Jā/Nē): ");
                    String likesInput = scanner.nextLine();
                    boolean likesToProgram = likesInput.equalsIgnoreCase("jā");

                // Taisam Person objektu
                Student student = new Student(firstName, lastName, age, height, weight, country, income, likesToProgram, "Programmēšanas pamati ar Madaru");
                student.printInfo();
                student.studyInfo();




        // Aprēķini
        int ageInDays = age * 365;
        double heightInCm = height * 100;
        double yearlyIncome = income * 12;
        double bmi = weight / (height * height);

        //Rezultātu izvads
        System.out.println("Vecums dienās: " + ageInDays);
        System.out.println("Augums centimetros: " + heightInCm);
        System.out.println("Gada ienākumi: " + yearlyIncome + " EUR");
        System.out.println("Ķermeņa masas indeks (BMI): " + bmi);

        //BMI kategorija
        if (bmi < 18.5) {
            System.out.println("Kategorija: Nepietiekams svars");
        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println("Kategorija: Normāls svars");
        } else if (bmi >= 25 && bmi < 30) {
            System.out.println("Kategorija: Liekais svars");
        } else {
            System.out.println("Kategorija: Aptaukošanās");
        }

        //Valsts un ienākumu pārbaude
        if (country.equalsIgnoreCase("Latvija")) {
            System.out.println("Jūs dzīvojat Latvijā. Vidējie ienākumi šeit ir ap 1500 EUR.");
            if (income < 1000) {
                System.out.println("Jūsu ienākumi ir mazāk par vidējiem.");
            }
        } else {
            System.out.println("Jūs dzīvojat " + country + ". Informācija par vidējiem ienākumiem šajā valstī nav pieejama.");
        }

            // jautājam, vai lietotājs grib atkārtot reģistrāciju
            System.out.print("\nVai vēlaties atkārtot reģistrācijas procesu? (Jā/Nē): ");
            repeat = scanner.nextLine().trim().toLowerCase();
        } while (repeat.equals("jā")); // Ja atbilde ir "jā", yad turpinam, ja nē tad beidzam processu.
        System.out.println("Programma ir pabeigta.");
        scanner.close();


            }
        }



