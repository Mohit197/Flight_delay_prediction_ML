#!/usr/bin/env python3

import sys

# Define the index mapping for carrier and org
carrier_index = {"AA": 0.0, "AQ": 1.0, "B6": 2.0, "HA": 3.0, "OH": 4.0, "OO": 5.0, "UA": 6.0, "US": 7.0, "WN": 8.0}
org_index = {"JFK": 0.0, "LGA": 1.0, "OGG": 2.0, "ORD": 3.0, "SFO": 4.0, "SJC": 5.0, "SMF": 6.0, "TUS": 7.0}

# Open a file for writing the output
with open("output1.txt", "w") as output_file:
    for line in sys.stdin:
        # Remove leading and trailing whitespaces
        line = line.strip()

        # Split the input line into fields
        fields = line.split(',')

        # Extract relevant fields
        mon, dom, dow, carrier, org, depart, duration, delay, km, label = fields[:10]

        # Convert carrier and org to their respective indices
        carrier_idx = carrier_index.get(carrier, -1.0)
        org_idx = org_index.get(org, -1.0)

        # Print the original line along with the new indices
        output_line = f"{line},{carrier_idx},{org_idx}"

        # Write the output line to the file
        output_file.write(output_line + "\n")

        