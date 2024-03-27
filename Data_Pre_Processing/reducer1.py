#!/usr/bin/env python

import sys

for line in sys.stdin:
    # Remove leading and trailing whitespaces, then split the line into fields
    fields = line.strip().split(',')

    # Format 'mile_in_km' to one decimal place
    fields[8] = "{:.1f}".format(float(fields[8]))

    # Output the processed line
    print(','.join(fields))
