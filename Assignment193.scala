def main(args: Array[String]) {
 
    /**
      * Create RDD and Apply Transformations
      */
val data = Range(1,100)                     // create Array of Integers
val dataRDD = sc.parallelize(data)                  // create an RDD
val dataDF = dataRDD.toDF()                         // convert RDD to DataFrame
dataDF.write.parquet("data.parquet")                // write to parquet
val newDataDF = sqlContext.
                read.parquet("data.parquet")        // read back parquet to DF
newDataDF.show()        

}