# CS410 Project
<b>Analyzing Text for Topics Modeling and Entity Identification using Amazon Comprehend using EDGAR 10-K filings.</b></br></br>
Data for Topic Modeling has been used from https://github.com/Vaslo/CS410_Team32_FinalProj.</br>
An excellent tutorial for Topic Analysis is available on the above site. We have taken this pre processed dataset to analyse the documents using Amazon Comprehend's Topic Modelling capabilities. 
The datasets work reasonably well in generating a Unigram Output using Comprehend. </br>

Latent Dirichlet Allocation (LDA) model is used by Amazon Comprehend to determine the topics in a set of documents. It only gives out unigram topic term outputs. The text in the documents does not need to be annotated. It gives you two outputs one is the topic-terms.csv file which gives the top terms by topic according to their weight which represents a probability distribution over the words in a given topic. Comprehend only returns the top 10 words for each topic and the weights typically do not sum to 1. The number of topics can be set and you can detect up to 100 topics, the number of topics depends on the job at hand and the domain of analysis.
The second output file is the doc-topics.csv file which lists the documents associated with a topic and the proportion of the document that is concerned with the topic. The proportion of topics in a given document sums to 1. 
Amazon comprehend uses the Lemmatization Lists Dataset by MBM which are available at http://www.lexiconista.com/datasets/lemmatization/ 
We have used data from 2013-2016 for TopicModeling.
Comprehend requires that all files be in UTF-8 format only. 
There are three ways in which you can access the topic modelling capabilities of Amazon Comprehend:
1.	For single document analysis the console can be used to run topic modelling. 
2.	Up to 25 documents can be analyzed using the API
3.	For anything more than 25 documents you should have a S3 bucket set up on Amazon, which allows you to first store your pre-processed (remove background words etc, come up with a bag of words for LDA to use for topic modeling). Then a topic modelling job has to be created, Amazon Comprehend then runs the job as an asynchronous process. The output files again need a location on the S3 bucket for storage. The output is in a tar.gz format. The API needs to call a job based on its ID and receives the JSON file with the tar.gz file. 
The outputs can be then fed as a csv data source to Tableau or Excel for further analysis. 
Some of the constraints that were found using Amazon Comprehend are as under.
1.	Only files in UTF-8 format are analyzed, so you need to convert some of the files to UTF-8 format before you can run the job which otherwise would fail.
2.	Only 10 terms per topic are available. This is seen as a limitation as more words can provide more insight into the topic identification.

3.	The visualizations using Tableau or Excel were found to be limiting in comparison to what could have been achieved with Gensim and LDAVis which allows for projection of results using a distance matrix.
4.	Topic modeling in Amazon comprehend is unsupervised. 
5.	Parameter optimization is not something that is available at this point. 

For Entity Identifications we have used a seperate dataset from https://data.world/jumpyaf/2013-2016-cleaned-parsed-10-k-filings-with-the-sec . </br>
We have used data from 2013.
We found that the Management's Discussion and Analysis section was sufficient for us to extract the Identities, we were mainly concerned about identifying key persons and events. A java extractor was used to extract the Management's discussion and Analysis section from the files cleaned-parsed 10-k filings cited above as the previous dataset only has a bag of words for LDA based topic modeling. This was considered as sufficient data for Entity Identification.

Entity Detection in Amazon Comprehend can be done using the console and the API. Console allows for testing of a string of characters, such as a sentence or a paragraph or a document with 5000 characters. You can also use the API to submit a single document as a string for analysis. The API can further handle a batch of 25 documents and get the required result in a JSON format.<br> 
Higher number of documents require that you create a job using the Amazon Comprehend console from within AWS. The process of creating a job and generating the output is similar to that of Topic Modelling. It is an asynchronous process and the entity detection output is a JSON file.  For entity detection Amazon comprehend uses its own pre-processing pipeline (ie. Gathering the data, extracting raw text, sentence splitting, tokenization, stemming, lemmatization, stop-word removal, POS tagging etc). <br>
Analysis of this JSON file can be done by creating a data source in Tableau, saving the file as a CSV and then using Excel to analyze the results by filtering data as not all data is relevant. The entities are differentiated by the type. 

