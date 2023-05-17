package com.kyoto.alaba3.mbeans;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import java.io.Serializable;

public class Metrics extends NotificationBroadcasterSupport implements MetricsMXBean, Serializable {

    private int hitsCount = 0;
    private int missedHitsCount = 0;
    private int missedHitsStreakCount = 0;
    int sequenceNumber = 1;

    public Metrics() {
    }

    @Override
    public int hitsInc() {
        hitsCount++;
        return hitsCount;
    }

    @Override
    public int missedAndStreakInc() {
        missedHitsCount++;
        missedHitsStreakCount++;
        if (missedHitsStreakCount % 4 == 0) {
            final Notification notification = new Notification("4 miss streak", this, sequenceNumber++, "4 miss streak.");
            sendNotification(notification);
        }
        return missedHitsStreakCount;
    }

    @Override
    public int clearMissedStreak() {
        missedHitsStreakCount = 0;
        return 0;
    }

    public int getHitsCount() {
        return hitsCount;
    }

    public int getMissedHitsCount() {
        return missedHitsCount;
    }

    public int getMissedHitsStreakCount() {
        return missedHitsStreakCount;
    }

//    public void setHitsCount(int hitsCount) {
//        this.hitsCount = hitsCount;
//    }
//
//    public void setMissedHitsCount(int missedHitsCount) {
//        this.missedHitsCount = missedHitsCount;
//    }
//
//    public void setMissedHitsStreakCount(int missedHitsStreakCount) {
//        this.missedHitsStreakCount = missedHitsStreakCount;
//    }
}
