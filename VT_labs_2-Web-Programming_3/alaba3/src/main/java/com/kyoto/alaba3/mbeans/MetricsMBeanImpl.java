package com.kyoto.alaba3.mbeans;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import java.io.Serializable;

public class MetricsMBeanImpl extends NotificationBroadcasterSupport implements MetricsMBean, Serializable {

    private long hitsCount;
    private long missedHitsCount;
    private long missedHitsStreakCount;
    int sequenceNumber = 1;
    private final Notification notification = new Notification("4 miss streak", getClass().getSimpleName(), sequenceNumber++, "4 miss streak.");

    public MetricsMBeanImpl() {
        hitsCount = 0;
        missedHitsCount = 0;
        missedHitsStreakCount = 0;
    }

    @Override
    public long hitsInc() {
        hitsCount++;
        return hitsCount;
    }

    @Override
    public long missedAndStreakInc() {
        missedHitsCount++;
        missedHitsStreakCount++;
        if (missedHitsStreakCount % 4 == 0) {
            sendNotification(notification);
        }
        return missedHitsCount;
    }

    @Override
    public long clearMissedStreak() {
        missedHitsStreakCount = 0;
        return 0;
    }

    public long getHitsCount() {
        return hitsCount;
    }

    public long getMissedHitsCount() {
        return missedHitsCount;
    }

    public long getMissedHitsStreakCount() {
        return missedHitsStreakCount;
    }

    public void setHitsCount(long hitsCount) {
        this.hitsCount = hitsCount;
    }

    public void setMissedHitsCount(long missedHitsCount) {
        this.missedHitsCount = missedHitsCount;
    }

    public void setMissedHitsStreakCount(long missedHitsStreakCount) {
        this.missedHitsStreakCount = missedHitsStreakCount;
    }
}
