package com.kyoto.alaba3.mbeans;

public interface MetricsMXBean {
    int hitsInc();

    int missedAndStreakInc();

    int clearMissedStreak();

    int getHitsCount();

    int getMissedHitsCount();

    int getMissedHitsStreakCount();

//    void setHitsCount(int hitsCount);
//
//    void setMissedHitsCount(int missedHitsCount);
//
//    void setMissedHitsStreakCount(int missedHitsStreakCount);
}
