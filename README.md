# Fraudulent Transactions Analysis Project Overview
## Project Objective
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
  <img src="https://upload.wikimedia.org/wikipedia/commons/3/38/Apache_Hadoop_logo.svg" alt="Hadoop" width="100" height="60">
  <img src="https://upload.wikimedia.org/wikipedia/commons/f/f3/Apache_Spark_logo.svg" alt="Spark" width="100" height="60">
  <img src="https://upload.wikimedia.org/wikipedia/commons/0/05/Apache_kafka.svg" alt="Kafka" width="100" height="60">
  <img src="https://upload.wikimedia.org/wikipedia/commons/9/93/MongoDB_Logo.svg" alt="MongoDB" width="100" height="60">
</p>

## Architecture and Pipeline
We employed a Lambda architecture to process the data, enabling both real-time and batch processing to provide comprehensive insights into fraudulent transactions:

![image](https://github.com/eyaraouine/BigData_Pipeline_For_Fraudulent_Transactions_Analysis/assets/98587427/404b110e-d9dc-4903-90ef-b6020d763572)

### Batch Processing
- **MapReduce Job for Transaction Category Analysis:** Aggregates the number of fraudulent transactions for each transaction category and stores the results in MongoDB.
- **MapReduce Job for Date and City Analysis:** Analyzes fraudulent transactions by year and city, storing the results in MongoDB.

### Streaming Processing
- **Socket Server:** Continuously reads data in real-time and sends it for streaming processing.
- **Kafka:** Manages real-time data ingestion and processing:
  - Producer: Reads data line by line, creates Kafka messages, and sends them to the Kafka cluster.
  - Consumer: Processes real-time data using Spark Streaming and stores the results in MongoDB.

## Data Storage
- **MySQL:** Stores structured and historical data from batch processing, supporting querying and report generation.
- **MongoDB:** Manages real-time and unstructured data from streaming processing, enabling interactive visualizations and real-time analytics.

## Data Visualization (Dashboarding)
- **MongoDB Charts:** Utilized to create interactive visualizations and dashboards, helping to identify trends and generate reports on fraudulent transactions.


## Execution Steps
### Batch Processing
1. **Setup:** Ensure Hadoop and HDFS are installed and configured. Upload the dataset to HDFS.
2. **Execution:** Run MapReduce jobs for transaction category and date-city analysis.
3. **Storage:** Store the results in MongoDB.

### Streaming Processing
1. **Setup:** Ensure Kafka is installed and configured. Start the Kafka cluster.
2. **Socket Server:** Read and transmit data in real-time.
3. **Kafka Producer:** Send data to Kafka.
4. **Kafka Consumer:** Process data using Spark Streaming and store results in MongoDB.

## Visualization
- **MongoDB Charts:** Connect to the database and create visualizations.
- **Reports:** Generate and analyze reports based on the visualized data.
