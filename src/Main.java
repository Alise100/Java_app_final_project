import java.util.Scanner; //importējam klassi lai lasīt ko ievada lietotājs
import java.text.Normalizer;

    public class Main {

    //metode teksta normalizācijai( lai garumzīmes neskaitās) un zemam reģistram
    public static String normalizeString(String input) {
        if (input == null) {
            return null;
        }
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD); //nfd atbils par garumzīmem
        String withoutDiacritics = normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        return withoutDiacritics.toLowerCase();
    }

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

        // Sākam do-while ciklu pilnai reģistrācijai
        //Vārds
        do {
            String firstName;
            do {   //do-while vārdam
                System.out.print("Ievadiet jūsu vārdu: ");
                firstName = scanner.nextLine();
                    //vārda validācija par garumu
                    if (firstName.length() < 2) {
                    System.out.println("Vārdam jābūt vismaz 2 simbolus garam! Ievadiet vēlreiz: ");
                }
            } while (firstName.length() < 2);
            firstName = capitalize(firstName);

        //Uzvārds
            String lastName;
            do {
                System.out.print("Ievadiet jūsu uzvārdu: ");
                lastName = scanner.nextLine();
                    if (lastName.length() < 2) {
                    System.out.println("Uzvārdam jābūt vismaz 2 simbolus garam! Ievadiet vēlreiz: ");
                }
            } while (lastName.length() < 2);
            lastName = capitalize(lastName);


            //Vecums
                System.out.print("Ievadiet jūsu vecumu: ");
                int age = scanner.nextInt();

                    while (age < 0) { //cikls atkārtosies, ja būs ievadīts negatīvs vecums
                    System.out.print("Vecums nevar būt negatīvs. Ievadiet vēlreiz: ");
                    age = scanner.nextInt();
                }

            //Augums
                System.out.print("Ievadiet jūsu augumu metros: ");
                double height = scanner.nextDouble();

                    while (height < 0) { //cikls atkārtosies, ja būs ievadīts negatīvs augums
                        System.out.print("Augums nevar būt negatīvs. Ievadiet vēlreiz: ");
                        height = scanner.nextDouble();
                    }

            //Svars
                System.out.print("Ievadiet jūsu svaru kilogrammos: ");
                double weight = scanner.nextDouble();

                    while (weight < 0) { // cikls atkārtosies, ja būs ievadīts negatīvs svars
                        System.out.print("Svars nevar būt negatīvs. Ievadiet vēlreiz: ");
                        weight = scanner.nextDouble();
                    }

                    scanner.nextLine();


        //Valsts
            String country;
            do {
                System.out.print("Ievadiet jūsu dzīvesvietas valsti: ");
                country = scanner.nextLine();
                    if (country == null || country.trim().isEmpty()) {
                    System.out.println("Valsts nevar būt tukša! Ievadiet vēlreiz: ");
                    } else if (country.length() > 50) {
                    System.out.println("Valsts nosaukums ir pārāk garš (maksimāli 50 simboli)! Ievadiet vēlreiz: ");
                }
            } while (country == null || country.trim().isEmpty() || country.length() > 50); //atkārtosies kāmēr būs tukšs laukums vai pārāk garš nosaukums
            country = capitalize(country);


        //Ienākumi
            double income;
            do {
                System.out.print("Ievadiet jūsu mēneša ienākumus EUR: ");
                income = scanner.nextDouble();
                    if (income < 0) {
                    System.out.println("Ienākumi nevar būt negatīvi! Ievadiet vēlreiz: ");
                }
            } while (income < 0);

            scanner.nextLine();


        //Vai patīk programmēt, validācija
            String likesInput;
            boolean likesToProgram;
            do {
                System.out.print("Vai jums patīk programmēt? (Jā/Nē): ");
                likesInput = scanner.nextLine();
                String normalizedLikesInput = normalizeString(likesInput);
                    if (normalizedLikesInput.equals(normalizeString("Jā"))) {
                    likesToProgram = true;
                    break;
                    } else if (normalizedLikesInput.equals(normalizeString("Nē"))) {
                    likesToProgram = false;
                    break;
                    } else {
                    System.out.println("Lūdzu, ievadiet 'Jā' vai 'Nē'!");
                }
            } while (true);


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

//            // jautājam, vai lietotājs grib atkārtot reģistrāciju
            do {
                System.out.print("\nVai vēlaties atkārtot reģistrācijas procesu? (Jā/Nē): ");
                repeat = scanner.nextLine().trim(); // dzēšam nevajadzīgas atstarpes
                String normalizedRepeat = normalizeString(repeat); // normalizējam ievadi
                if (!normalizedRepeat.equals(normalizeString("jā")) && !normalizedRepeat.equals(normalizeString("nē"))) {
                    System.out.println("Lūdzu, ievadiet 'Jā' vai 'Nē'!");
                }
            } while (!normalizeString(repeat).equals(normalizeString("jā")) && !normalizeString(repeat).equals(normalizeString("nē")));
        } while (normalizeString(repeat).equals(normalizeString("jā")));

        System.out.println("Programma ir pabeigta.");
        scanner.close();


            }
        }



