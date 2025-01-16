package GoldManSachs.Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem is apache log

1.Implement findTopIpAddress() correctly.

/**
 * String findTopIpAddress(String lines[])
 * Given a apache log file, return IP address(es) which access the side most often.
 * Our log is in this format(common log format). One netry per line and it starts with an IP address which addressed the site followed by a white space.
 * 10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] "GET /a.gif HTTP/1.0" 200 234
 * Log entry are passed as an array.
 * 
 */
 

public class ApacheLog {
    public static String findTopIpAddress(String[] lines) {
        // Map to store the frequency of each IP address
        Map<String, Integer> ipFrequencyMap = new HashMap<>();

        // Loop through each line in the log
        for (String line : lines) {
            // Split the line by spaces and get the first part (IP address)
            String ipAddress = line.split(" ")[0];
            

            // Increment the frequency of the IP address in the map
            ipFrequencyMap.put(ipAddress, ipFrequencyMap.getOrDefault(ipAddress, 0) + 1);
        }

    
        // Now find the IP address with the maximum count
        String topIpAddress = null;
        int maxCount = 0;

        // Loop through the map to find the IP with the highest count
        for (Map.Entry<String, Integer> entry : ipFrequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                topIpAddress = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        // Return the IP address with the highest frequency
        return topIpAddress;
    }

    public static void main(String[] args) {
        String[] logs = {
            "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
            "10.0.0.3 - john [10/Dec/2000:12:35:00 -0500] \"POST /b.gif HTTP/1.0\" 200 245",
            "10.0.0.1 - frank [10/Dec/2000:12:35:10 -0500] \"GET /c.gif HTTP/1.0\" 200 256",
            "10.0.0.3 - alice [10/Dec/2000:12:36:00 -0500] \"GET /d.gif HTTP/1.0\" 200 267",
            "10.0.0.3 - frank [10/Dec/2000:12:36:30 -0500] \"GET /e.gif HTTP/1.0\" 200 278"
        };

        System.out.println(findTopIpAddress(logs)); // Output should be "10.0.0.3"
    }
}
