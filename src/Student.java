public class Student extends Person{ //extends pārmanto mainīgus un metodes no person klasses
    private String studyProgram; //šeit glābājas info par mācību programmu

    //veidojam konstruktoru studentam
    public Student(String firstName, String lastName, int age, double height, double weight, String country, double income, boolean likesToProgram, String studyProgram) {
        //super izsauc konstruktoru no person klasses
        super(firstName, lastName, age, height, weight, country, income, likesToProgram);

        //pievienojam mainīgo studyprogram ar "this", lai atšķirt klases parametru no konstruktora parametra
        this.studyProgram = studyProgram;
    }

    //pievienojam metodi studyinfo
    public void studyInfo() {
        System.out.println("Mācību programma: " + studyProgram);
    }
}
