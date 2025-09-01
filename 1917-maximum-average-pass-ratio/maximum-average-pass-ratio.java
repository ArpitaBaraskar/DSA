import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Max heap based on the "gain" if we add 1 student
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b[0], a[0])
        );
        
        // Precompute initial gains and push into heap
        for (int[] c : classes) {
            int pass = c[0], total = c[1];
            double gain = gain(pass, total);
            pq.offer(new double[]{gain, pass, total});
        }
        
        // Distribute extra students
        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            
            pass++;
            total++;
            
            double newGain = gain(pass, total);
            pq.offer(new double[]{newGain, pass, total});
        }
        
        // Calculate final average
        double sum = 0.0;
        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            int pass = (int) cur[1];
            int total = (int) cur[2];
            sum += (double) pass / total;
        }
        
        return sum / classes.length;
    }
    
    // Helper: compute gain of adding one student
    private double gain(int pass, int total) {
        return (double)(pass + 1) / (total + 1) - (double) pass / total;
    }
}
