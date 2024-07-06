# Fraudulent Transactions Analysis Project 
## Description
The primary goal of this project is to analyze a dataset of financial transactions to detect fraudulent activities and gain insights into fraud patterns based on various categories, time periods, and geographic locations. 
## Dataset Used
The dataset "fraud transactions dataset" is accessible on [Kaggle](https://www.kaggle.com/datasets/dermisfit/fraud-transactions-dataset/data). This dataset includes detailed information on transactions, such as:
- **Date and time of the transaction**
- **Transaction amount in USD**
- **Credit card number**
- **Merchant involved in the transaction**
- **Transaction category** (e.g., food, entertainment, etc.)
- **Personal information of the cardholder** (e.g. First name, Last name, Gender, Address, City, State, ZIP code, Date of birth, Occupation)  
- **Fraud indicator**: 1 for fraudulent transactions, 0 for legitimate transactions
## Technologies Used
<p align="center">
  <img src="https://upload.wikimedia.org/wikipedia/commons/3/38/Apache_Hadoop_logo.svg" alt="Hadoop" width="100" height="50">
  <img src="https://upload.wikimedia.org/wikipedia/commons/f/f3/Apache_Spark_logo.svg" alt="Spark" width="100" height="50">
  <img src="https://upload.wikimedia.org/wikipedia/commons/0/05/Apache_kafka.svg" alt="Kafka" width="100" height="50">
  <img src="https://upload.wikimedia.org/wikipedia/en/4/45/MongoDB-Logo.svg" alt="MongoDB" width="100" height="50">
</p>

## Project Architecture Explained
We employed a Lambda architecture to process the data, enabling both real-time and batch processing to provide comprehensive insights into fraudulent transactions:

![image](https://github.com/eyaraouine/BigData_Pipeline_For_Fraudulent_Transactions_Analysis/assets/98587427/404b110e-d9dc-4903-90ef-b6020d763572)

### Batch Processing
For batch processing, we implemented 2 MapReduce jobs:

#### MapReduce Job for Transaction Category Analysis

- **Objective**: To count the number of fraudulent transactions for each transaction category.
- **Process**:
  1. Read data from the Hadoop Distributed File System (HDFS).
  2. Apply a MapReduce job to aggregate the number of fraudulent transactions per category.
  3. Store the results in MongoDB for further analysis and visualization.

#### MapReduce Job for Date and City Analysis

- **Objective**: To analyze the number of fraudulent transactions by year and city.
- **Process**:
  1. Read data from HDFS.
  2. Apply a MapReduce job to aggregate the number of fraudulent transactions per year and city.
  3. Store the results in MongoDB for further analysis and visualization.

### Streaming Processing

#### Socket Server

- **Objective**: To read data in real-time and send it continuously for streaming processing.
- **Process**:
  1. A socket server listens on a specified port (e.g., 9999).
  2. Data is read line by line from the dataset and transmitted asynchronously to the streaming processing system.

#### Kafka

- **Objective**: To handle real-time data ingestion and processing.
- **Producer**:
  - Reads data line by line from the dataset.
  - Creates Kafka messages for each line, including a key (line ID) and a value (line content).
  - Sends the messages to a Kafka cluster.
- **Consumer**:
  - Receives messages from the Kafka cluster.
  - Applies real-time processing using Spark Streaming.
  - Stores the processed data in MongoDB.
### Data Storage

#### MySQL

- **Purpose**: To store structured and historical data from batch processing.
- **Usage**:
  - Stores results from the MapReduce jobs.
  - Supports querying and report generation for historical analysis.

#### MongoDB

- **Purpose**: To store real-time and unstructured data from streaming processing.
- **Usage**:
  - Stores results from both batch and streaming processing.
  - Supports interactive visualizations and real-time analytics.
