//Time = O(n log n)
//Space = O(n)

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0; // No meetings, no rooms needed
        }

        // Convert the intervals into a list of start and end times
        int n = intervals.length;

        // Arrays to store the start and end times separately
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];

        // Populate startTimes and endTimes arrays
        for (int i = 0; i < n; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        // Sort start times and end times
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        // Initialize pointers for start and end times
        int startPointer = 0;
        int endPointer = 0;

        // Initialize a variable to keep track of the number of rooms required
        int rooms = 0;

        // Loop through the start times
        while (startPointer < n) {
            // If a meeting starts before the earliest ending meeting ends
            if (startTimes[startPointer] < endTimes[endPointer]) {
                rooms++; // We need a new room
            } else {
                endPointer++; // The meeting room is now free
            }
            startPointer++;
        }

        return rooms;
    }
}
