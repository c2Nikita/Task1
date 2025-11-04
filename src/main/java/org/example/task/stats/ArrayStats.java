package org.example.task.stats;

public class ArrayStats {
    private int sum;
    private double avg;
    private int max;
    private int min;

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
