
public class Tuple {
    private String name;
    private int[] tupl;
    private boolean is_skyline;

    public Tuple(String name, int[] tupl, boolean is_skyline) {
        this.name = name;
        this.tupl = tupl;
        this.is_skyline = is_skyline;
    }

    public String getName() {
        return name;
    }

    public int[] getTupl() {
        return tupl;
    }

    public boolean is_skyline() {
        return is_skyline;
    }

    public void setIs_skyline(boolean is_skyline) {
        this.is_skyline = is_skyline;
    }
}
