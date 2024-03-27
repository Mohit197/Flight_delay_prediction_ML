import pandas as pd
from sklearn.model_selection import train_test_split

# Read output2.txt into a pandas DataFrame
df = pd.read_csv('output2.txt', sep='\s+', header=None, names=['Features', 'delay'])

# Perform the random split into training and testing sets
flights_train, flights_test = train_test_split(df, test_size=0.2, random_state=42)

# Check the training set ratio
training_ratio = len(flights_train) / len(df)
print("Training set ratio:", training_ratio)

# Save the training and testing sets to separate files
flights_train.to_csv('flights_train.txt', index=False, sep='\t')
flights_test.to_csv('flights_test.txt', index=False, sep='\t')
