
    Counting Frequencies:
        Create an empty frequencyMap as a HashMap to store the frequencies of numbers.
        Iterate through the input array nums using a for-each loop.
        For each number num in nums, increment its count in the frequencyMap. If it doesn't exist in the map, initialize it to 1.
        After this step, frequencyMap contains the count of each unique number in the nums array.

    Creating Buckets:
        Initialize an array of lists called buckets, where each index represents a frequency, and the lists at each index will store numbers with that frequency.
        Iterate through the keys (numbers) in the frequencyMap using a for-each loop.
        For each number in the map, retrieve its frequency.
        Check if a list for that frequency exists in the buckets array. If not, create an empty list for that frequency.
        Add the number to the list corresponding to its frequency in the buckets array.
        After this step, you have grouped numbers by their frequencies in the buckets array.

    Collecting the k Most Frequent Numbers:
        Initialize an empty list called result to store the k most frequent numbers.
        Iterate through the buckets array in reverse order (from highest frequency to lowest frequency).
        For each bucket (list) in the array:
            Check if the bucket is not null (i.e., it contains numbers with that frequency).
            If the bucket is not null, add all the numbers in that bucket to the result list.
            Continue this process until result contains k numbers or you've gone through all buckets.

    Converting to int[]:
        Create an integer array called topKFrequentArray with a length of k.
        Iterate through the result list and copy the first k elements into the topKFrequentArray.
        This step ensures that the final array contains the k most frequent numbers in descending order of frequency.

    Returning the Result:
        Return the topKFrequentArray as the result of the topKFrequent method.

    Testing in the main Method:
        In the main method, an instance of the Solution class is created.
        An example input array nums and a value for k are defined.
        The topKFrequent method is called with these inputs, and the result is stored in the result array.
        The Arrays.toString(result) method is used to convert and print the result to the console.
        The output of the code is [1, 2] for the given example, indicating that the numbers 1 and 2 are the most frequent numbers in the nums array when k is set to 2.