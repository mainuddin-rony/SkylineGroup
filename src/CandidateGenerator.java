import com.sun.deploy.util.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CandidateGenerator {
    public static List<Tuple> generateCandidateSet(List<Tuple> sequence, int setSize, List<Tuple> skylineSet) {

        int[] binary = new int[(int) Math.pow(2, sequence.size())];
        List<Tuple> candidateList = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, sequence.size()); i++) //loop for creating fixed number of subset
        {
            int b = 1;
            binary[i] = 0;
            int num = i, count = 0;
            while (num > 0)
            {
                if (num % 2 == 1)
                    count++;
                binary[i] += (num % 2) * b;
                num /= 2;
                b = b * 10;
            }
            if (count == setSize)
            {
                List<Tuple> tpl = new ArrayList<>();
                List<String> tplName = new ArrayList<>();
                for (int j = 0; j < sequence.size(); j++)
                {
                    if (binary[i] % 10 == 1){
                        tpl.add(sequence.get(j));
                        tplName.add(sequence.get(j).getName());
                    }
                    binary[i] /= 10;
                }

                Collections.sort(tplName); //sort the tuple names
                String result = StringUtils.join(tplName, ", "); //join the tuple name
                int attrb_size = sequence.get(0).getTupl().length;
                int candid[] = new int[attrb_size]; // creating the array for new Tuple value after calculating the minimum value

                boolean tuple_containes = false;

                for(Tuple tp: skylineSet) { // here is the mechanism for input pruning, if skyline of previous iteration is p1 and p3 it
                    if (result.contains(tp.getName())){ // will discard any combination that does not have either p1 or p3
                        tuple_containes = true;
                    }
                }
                if (tuple_containes) {
                    for ( int at = 0; at < attrb_size; at++) {
                        List<Integer> attrList = new ArrayList<>();
                        for(int tp = 0; tp < tpl.size(); tp ++) {
                            attrList.add(tpl.get(tp).getTupl()[at]);
                        }
                        Collections.sort(attrList);
                        candid[at] = attrList.get(0);   //calculate minimum of attrList
                    }
                    candidateList.add(new Tuple(result, candid, true));
                }

            }

        }

        return candidateList;
    }
}
