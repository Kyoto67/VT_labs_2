package com.kyoto.alaba3.mbeans;

public interface MetricsMBean {
    long hitsInc();
    long missedAndStreakInc();
    long clearMissedStreak();
}
