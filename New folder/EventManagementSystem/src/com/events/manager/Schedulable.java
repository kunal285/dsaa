package com.events.manager;

/**
 * Contract for Schedulable behavior.
 */
public interface Schedulable {
    boolean scheduleEvent();
    String eventStatus();
}