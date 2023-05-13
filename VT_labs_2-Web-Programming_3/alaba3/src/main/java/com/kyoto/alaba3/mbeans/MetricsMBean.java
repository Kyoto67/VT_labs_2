package com.kyoto.alaba3.mbeans;

public interface MetricsMBean {
    int hitsInc();

    int missedAndStreakInc();

    int clearMissedStreak();

    Integer getHitsCount();

    Integer getMissedHitsCount();

    Integer getMissedHitsStreakCount();

    void setHitsCount(Integer hitsCount);

    void setMissedHitsCount(Integer missedHitsCount);

    void setMissedHitsStreakCount(Integer missedHitsStreakCount);
}
