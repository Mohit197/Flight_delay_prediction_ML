#!/usr/bin/env python

import sys
import math

for line in sys.stdin:
    # Remove leading and trailing whitespaces, then split the line into fields
    fields = line.strip().split(',')

    # Check if the line is the header
    if fields[0] == 'mon':
        continue  # Skip the header line

    # Check if the line has the expected number of fields
    if len(fields) == 10:
        # Extract the required columns
        mon, dom, dow, carrier, _, org, _, depart, duration, delay = fields

        # Check if 'delay' value is present and not 'NA'
        if delay != 'null' and delay != 'NA':
            # Convert 'mile' to 'km' and drop it
            mile_in_km = math.ceil(float(fields[6]) * 1.60934)

            # Create 'label' column indicating whether a flight is delayed or not
            label = 1 if int(delay) > 0 else 0

            # Output the processed line
            print(f"{mon},{dom},{dow},{carrier},{org},{depart},{duration},{delay},{mile_in_km},{label}")
