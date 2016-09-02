import java.util.ArrayList;
import java.util.List;

public class SkyLineCalculator {
    public static List<Tuple> calculateSkyLine(List<Tuple> tupleList, int tuple_no, int attribute_no){ // main mechanism for calculating skyline tuple
        for(int i = 0; i < tuple_no; i ++){
            Tuple present = tupleList.get(i);
            int present_attrb[] = present.getTupl();
            for ( int j = 1; j < tuple_no; j++){
                Tuple next = tupleList.get((i + j) % tuple_no);
                int next_attrb[] = next.getTupl();
                int k = 0;
                boolean atelast_one_bigger = false;
                boolean dominant = true;
                while(k < attribute_no) {
                    if (present_attrb[k] <= next_attrb[k]) {
                        if (present_attrb[k] < next_attrb[k]){
                            atelast_one_bigger = true;
                        }
                    }
                    else {
                        dominant = false;
                        break;
                    }
                    k++;
                }
                if (dominant && atelast_one_bigger) {
                    present.setIs_skyline(false);
                }
            }
        }

        List<Tuple> intermediateList = new ArrayList<>();
        for(Tuple tupl: tupleList) {
            if (tupl.is_skyline()) {
                intermediateList.add(tupl);
            }
        }

        return intermediateList;
    }
}
