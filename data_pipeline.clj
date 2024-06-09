(ns data-pipeline
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]
            [clojure.pprint :as pp]))

(defn read-csv [file]
  (with-open [reader (io/reader file)]
    (doall (csv/read-csv reader))))

(defn parse-row [row]
  (let [[date product quantity price] row]
    {:date date
     :product product
     :quantity (Integer/parseInt quantity)
     :price (Double/parseDouble price)}))

(defn calculate-revenue [sale]
  (* (:quantity sale) (:price sale)))

(defn summarize-sales [sales]
  (let [revenue-by-product (group-by :product sales)
        top-products (->> revenue-by-product
                          (map (fn [[product sales]]
                                 [product (reduce + (map calculate-revenue sales))]))
                          (sort-by second >)
                          (take 5))
        sales-by-date (group-by :date sales)
        avg-qty-per-day (/ (reduce + (map :quantity sales))
                           (count sales-by-date))]
    {:top-products top-products
     :avg-qty-per-day avg-qty-per-day
     :sales-by-date sales-by-date}))

(defn generate-report [summary]
  (pp/pprint "=== Sales Report ===")
  (pp/pprint (str "Top 5 Products: " (into {} (:top-products summary))))
  (pp/pprint (str "Average Quantity Sold per Day: " (:avg-qty-per-day summary)))
  (pp/pprint "Daily Sales Trends:")
  (doseq [[date sales] (:sales-by-date summary)]
    (pp/pprint (str date ": " (reduce + (map calculate-revenue sales))))))

(defn -main [& args]
  (try
    (let [csv-file (first args)
          data (read-csv csv-file)
          parsed-data (pmap parse-row (rest data))
          summary (summarize-sales parsed-data)]
      (generate-report summary))
    (catch Exception e
      (println "An error occurred:" (.getMessage e)))))
