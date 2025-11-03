package org.example.task.entity;

public class ArrayStats {
    private final int sum;
    private final double avg;
    private  final int max;
    private final int min;

    public ArrayStats(int sum, double avg, int max, int min) {
        this.sum = sum;
        this.avg = avg;
        this.max = max;
        this.min = min;
    }

    public int getSum() {
        return sum;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public double getAvg() {
        return avg;
    }
}
