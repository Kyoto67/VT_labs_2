package verifyer;

import java.util.ArrayList;
import java.util.List;

public class ResultContainer {

    private List<Result> results;

    public ResultContainer(){
        this(new ArrayList<>());
    }

    public ResultContainer(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }
}
