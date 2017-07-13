package com.devil.interfaceDefault;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by zhangtong on 2017/7/13.
 */
public class Streams {

    private enum Status {
        OPEN, CLOSED
    }

    ;

    public static final class Task {
        private final Status status;
        private final Integer points;

        public Task(Status status, Integer points) {
            this.status = status;
            this.points = points;
        }

        public Status getStatus() {
            return status;
        }

        public Integer getPoints() {
            return points;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "status=" + status +
                    ", points=" + points +
                    '}';
        }
    }

    public static void main(String[] args) {
        final Collection<Task> collector = Arrays.asList(new Task(Status.OPEN, 5),
                new Task(Status.OPEN, 13),
                new Task(Status.CLOSED, 8));
        final long totalPointsOfOpenTasks = collector.stream().
                filter(task -> task.getStatus().equals(Status.OPEN))
                .collect(Collectors.summingLong(Task::getPoints));
        System.out.println("totalPointsOfOpenTasks = " + totalPointsOfOpenTasks);
    }
}
