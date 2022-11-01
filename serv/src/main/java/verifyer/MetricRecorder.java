package verifyer;

import io.prometheus.client.Counter;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class MetricRecorder {

    private Counter shotCounter;
    private Counter hitCounter;

    @PostConstruct
    public void init() {
        shotCounter = Counter.build("shot_counter", "Counts all shots").register();
        hitCounter = Counter.build("user_hit_counts", "How much shots hitted plain").register();
    }

    public void shotInc(){
        shotCounter.inc();
    }

    public void hitInc(){
        hitCounter.inc();
    }

}
