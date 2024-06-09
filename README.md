# Clojure Data Processing Pipeline

This project demonstrates a data processing pipeline implemented in Clojure. The pipeline reads data from a CSV file, performs various transformations and aggregations on the data using Clojure's core functions and libraries, and generates a summary report.

## Features

- Reads data from a CSV file using the `clojure.data.csv` library.
- Performs data transformations using Clojure's core functions like `map`, `filter`, `reduce`, etc.
- Uses Clojure's `group-by` function to group data based on specific criteria.
- Utilizes Clojure's `comp` function to create a composed function pipeline for data processing.
- Implements custom higher-order functions to encapsulate complex data transformations.
- Uses Clojure's `pmap` function to parallelize data processing for improved performance.
- Leverages Clojure's `for` macro to perform list comprehensions for data filtering and transformation.
- Uses Clojure's `memoize` function to cache expensive computations and optimize performance.
- Generates a summary report using Clojure's `clojure.pprint` library for formatted output.
- Implements error handling using Clojure's `try`/`catch` constructs.

## Prerequisites

To run this project, you need to have the following installed:

- Java Development Kit (JDK) 8 or above
- Clojure CLI tools

## Getting Started

1. Clone the repository:

   ```
   git clone https://github.com/jaydxyz/clojure-data-pipeline.git
   ```

2. Navigate to the project directory:

   ```
   cd clojure-data-pipeline
   ```

3. Prepare your CSV file:
   - Create a CSV file containing sales data with columns: date, product, quantity, price.
   - Place the CSV file in the project directory.

4. Run the script:

   ```
   clojure -M data_pipeline.clj path/to/your/csv/file.csv
   ```

   Replace `path/to/your/csv/file.csv` with the actual path to your CSV file.

5. View the generated report:
   - The script will process the data and generate a summary report.
   - The report will be printed in the console output.

## Example Dataset

The script expects a CSV file with the following columns:
- date: The date of the sale.
- product: The name of the product sold.
- quantity: The quantity of the product sold.
- price: The price of the product.

Here's an example of the CSV file format:

```
date,product,quantity,price
2023-05-01,Product A,10,19.99
2023-05-01,Product B,5,9.99
2023-05-02,Product A,8,19.99
2023-05-02,Product C,3,14.99
```

## Sample Transformations

The script performs the following sample transformations on the data:

- Calculates the total revenue for each product.
- Finds the top 5 best-selling products.
- Computes the average quantity sold per day.
- Generates a report showing daily sales trends.

You can customize the transformations and aggregations based on your specific requirements by modifying the `summarize-sales` function in the script.

## License

This project is licensed under the [MIT License](LICENSE).

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvement, please open an issue or submit a pull request.

## Acknowledgements

- [Clojure](https://clojure.org/)
- [clojure.data.csv](https://github.com/clojure/data.csv)
- [clojure.pprint](https://clojure.github.io/clojure/clojure.pprint-api.html)
