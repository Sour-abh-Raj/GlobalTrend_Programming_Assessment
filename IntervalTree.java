import java.util.*;

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class IntervalTree {
    private List<Interval> intervals;

    public IntervalTree() {
        intervals = new ArrayList<>();
    }

    public void insertInterval(int start, int end) {
        intervals.add(new Interval(start, end));
    }

    public void deleteInterval(int start, int end) {
        intervals.removeIf(interval -> interval.start == start && interval.end == end);
    }

    public List<Interval> findOverlappingIntervals(int start, int end) {
        List<Interval> result = new ArrayList<>();
        for (Interval interval : intervals) {
            if (interval.start <= end && interval.end >= start) {
                result.add(interval);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        IntervalTree tree = new IntervalTree();
        tree.insertInterval(1, 5);
        tree.insertInterval(6, 10);
        tree.insertInterval(12, 15);

        List<Interval> overlapping = tree.findOverlappingIntervals(4, 13);
        for (Interval interval : overlapping) {
            System.out.println("[" + interval.start + ", " + interval.end + "]");
        }

        tree.deleteInterval(6, 10);
        overlapping = tree.findOverlappingIntervals(4, 13);
        for (Interval interval : overlapping) {
            System.out.println("[" + interval.start + ", " + interval.end + "]");
        }
    }
}
