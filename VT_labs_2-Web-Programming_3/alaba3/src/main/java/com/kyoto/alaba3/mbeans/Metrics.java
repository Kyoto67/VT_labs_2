package com.kyoto.alaba3.mbeans;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import java.io.Serializable;

public class Metrics extends NotificationBroadcasterSupport implements MetricsMBean, Serializable {

    private Integer hitsCount = null;
    private Integer missedHitsCount = null;
    private Integer missedHitsStreakCount = null;
    int sequenceNumber = 1;

    public Metrics() {
        hitsCount = 0;
        missedHitsCount = 0;
        missedHitsStreakCount = 0;
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

    public Integer getHitsCount() {
        return hitsCount;
    }

    public Integer getMissedHitsCount() {
        return missedHitsCount;
    }

    public Integer getMissedHitsStreakCount() {
        return missedHitsStreakCount;
    }

    public void setHitsCount(Integer hitsCount) {
        this.hitsCount = hitsCount;
    }

    public void setMissedHitsCount(Integer missedHitsCount) {
        this.missedHitsCount = missedHitsCount;
    }

    public void setMissedHitsStreakCount(Integer missedHitsStreakCount) {
        this.missedHitsStreakCount = missedHitsStreakCount;
    }
}
