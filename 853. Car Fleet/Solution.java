import java.util.Arrays;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // Create an array of cars with their position and time needed to reach the target.
        Car[] cars = new Car[n];
        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], (double)(target - position[i]) / speed[i]);
        }

        // Sort the cars by their positions in descending order.
        Arrays.sort(cars, (a, b) -> Double.compare(b.position, a.position));

        int fleets = 0;
        double currentTime = 0.0;

        // Iterate through the sorted cars to determine fleets.
        for (int i = 0; i < n; i++) {
            if (cars[i].time > currentTime) {
                fleets++; // This car forms a new fleet.
                currentTime = cars[i].time; // Update the current time.
            }
        }

        return fleets;
    }

    // Helper class to represent a car with position and time.
    class Car {
        double position;
        double time;

        public Car(double position, double time) {
            this.position = position;
            this.time = time;
        }
    }
}
