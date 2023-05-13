package com.kyoto.alaba3.mbeans;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import java.io.Serializable;

public class MetricsMBeanImpl extends NotificationBroadcasterSupport implements MetricsMBean, Serializable {

    private long hitsCount = 0;
    private long missedHitsCount = 0;
    private long missedHitsStreakCount = 0;
    int sequenceNumber = 1;
    private final Notification notification = new Notification("4 miss streak", getClass().getSimpleName(), sequenceNumber++, "4 miss streak.");


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
}
