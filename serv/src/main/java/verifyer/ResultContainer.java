package verifyer;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ResultContainer {

    private List<Result> results;

    public ResultContainer(){
        this(new ArrayList<>());
    }

    public ResultContainer(List<Result> results) {
        this.results = results;
    }

}
