import java.util.*;

class FoodRatings {
    // food -> cuisine
    private Map<String, String> foodToCuisine;
    // food -> current rating
    private Map<String, Integer> foodToRating;
    // cuisine -> max-heap of (rating, food). Use Integer rating and String food.
    private Map<String, PriorityQueue<FoodEntry>> cuisineHeap;

    // helper class for heap entries
    private static class FoodEntry {
        int rating;
        String food;
        FoodEntry(int r, String f) { rating = r; food = f; }
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineHeap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToCuisine.put(food, cuisine);
            foodToRating.put(food, rating);

            cuisineHeap.computeIfAbsent(cuisine, k -> new PriorityQueue<>(
                (a, b) -> {
                    if (a.rating != b.rating) return b.rating - a.rating; // higher rating first
                    return a.food.compareTo(b.food); // lexicographically smaller first
                }
            )).offer(new FoodEntry(rating, food));
        }
    }

    public void changeRating(String food, int newRating) {
        // update rating map
        foodToRating.put(food, newRating);
        String cuisine = foodToCuisine.get(food);
        // push new entry into corresponding cuisine heap (lazy deletion)
        PriorityQueue<FoodEntry> heap = cuisineHeap.get(cuisine);
        heap.offer(new FoodEntry(newRating, food));
    }

    public String highestRated(String cuisine) {
        PriorityQueue<FoodEntry> heap = cuisineHeap.get(cuisine);
        while (!heap.isEmpty()) {
            FoodEntry top = heap.peek();
            int currentRating = foodToRating.get(top.food);
            if (top.rating == currentRating) {
                return top.food;
            } else {
                heap.poll(); // stale entry; discard
            }
        }
        return ""; // problem constraints guarantee existence, but safe fallback
    }
}
