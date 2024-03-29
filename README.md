# **Predict Flight Delays Using Machine Learning on PySpark**

*Rutgers ECE 494/579 - Cloud Computing & Big Data (Fall 2023)*

*By: Mohit Agarwal & Arslan Tariq*

![Intro Background](Intro_Background.png)
## Introduction

As part of this project, the objective is to predict flight delays using PySpark. PySpark is the Python API for Apache Spark, enabling real-time, large-scale data processing in a distributed environment using Python. An ensemble of basic classification-based machine learning models, namely Decision Tree, Random Forest, Logistic Regression, and Naive Bayes, will be experimented with to achieve this task. The ML model implementation will be done by interacting with Spark using the PySpark library.

## Problem Statement

Flight delays disrupt air travel and incur losses for airlines. Leveraging Machine Learning and Data Science, this project aims to accurately predict flight delays using datasets from open-source platforms like Kaggle.

## Approach

<img src="PySpark_Pic.png" alt="PySpark" width="400"/> <img src="Hadoop_Pic.png" alt="Hadoop" width="400"/>

We will leverage PySpark and Hadoop for processing large datasets. Our analysis will involve employing a variety of machine learning algorithms including Decision Tree, Logistic Regression, Naive Bayes, Random Forest, and Support Vector Machines.

<img src="ML_Explanation_Pic.png" alt="ML Explanation" width="600"/>

## Workflow

![Intro Background](Workflow_Diagram.png)

## Method 1: PySpark

## Data Pre-processing

1. Import the CSV file and create a SparkSession to store the file contents into a Data Frame.
2. Display the data frame and delete records with missing values.
3. Create binary labels to indicate flight delays:
   - 0 = Not delayed (Negative value in Data Frame)
   - 1 = Delayed (Positive value in Data Frame)
4. Assign numerical values to categorical data (carrier and organization) for inclusion in training. Categorical data is converted to quantitative data.
## Feature Engineering:
   - Feature selection step: Use an assembler object to consolidate predictor columns (features) after implementing One-Hot Encoding (OHE) on categorical data.
   - Columns included: ['mon', 'dom', 'dow', 'carrier_idx', 'org_idx', 'km', 'depart', 'duration']
   - Output column: 'features'
   - Predicted label column: 'delay' (converted into binary column)
## Train/Test Split:
   - Machine Learning consists of two processes: Model Training and Model Testing.
   - Testing Data Selection involves ensuring:
     - Data is large enough for meaningful statistical results.
     - Test data has similar characteristics to training data.
   - Ideal partition: 80:20 ratio.
   - 80% of the dataset is used for training, 20% for testing.
   - Method used: `DataFrame.randomSplit()`.
   - Inputs: Seed and Weights.


## Method 2: Hadoop


## Results and Discussion

![Intro Background](Result_Pic.png)

## Conclusion

[Conclusion here]
