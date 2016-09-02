import java.util.*;

public class App {
    public static void main(String args[]){

        List<Tuple> originalTupleList = new ArrayList<>();
        List<Tuple> skyLineList = new ArrayList<>();
        List<Tuple> candidateList = new ArrayList<>();

        Scanner scan =new Scanner(System.in);

        System.out.println("Enter tuple no: ");
        int tuple_no = scan.nextInt();

        System.out.println("Enter attribute no: ");
        int attribute_no = scan.nextInt();

        System.out.println("Enter Group Size less than or equal to " + tuple_no + " : ");
        int group_no = scan.nextInt();

        System.out.println("Enter Tuple value(First element name and then the values):");

        for (int i = 0; i < tuple_no; i++){ //taking input from user
            String name = scan.next();
            int attribute[] = new int[attribute_no];
            for ( int j = 0; j < attribute_no; j++){
                attribute[j] = scan.nextInt();
            }
            originalTupleList.add(new Tuple(name, attribute, true));
        }

        candidateList = originalTupleList; // here declare C1
        skyLineList = SkyLineCalculator.calculateSkyLine(candidateList, tuple_no, attribute_no); //calculate S1 using C1

        System.out.println("Candidate Group_1: ");
        for (Tuple t: candidateList) {
            System.out.println(t.getName() + " : " + Arrays.toString(t.getTupl()));
        }

        System.out.println("SkyLine Group_1: ");
        for (Tuple t: skyLineList) {
            System.out.println(t.getName() + " : " + Arrays.toString(t.getTupl()));
        }

        for (int g = 0; g < group_no - 1; g ++) {
            candidateList = CandidateGenerator.generateCandidateSet(originalTupleList, g+2, skyLineList); //iteratively loop for calculating candidate list
            skyLineList = SkyLineCalculator.calculateSkyLine(candidateList, candidateList.size(), attribute_no); // creating SkyLine Group

            System.out.println("Candidate Group_" + (g+2) + ": ");
            for (Tuple t: candidateList) {
                System.out.println(t.getName() + " : " + Arrays.toString(t.getTupl()));
            }

            System.out.println("SkyLine Group_" + (g+2) + ": ");
            for (Tuple t: skyLineList) {
                System.out.println(t.getName() + " : " + Arrays.toString(t.getTupl()));
            }
        }

    }
}
