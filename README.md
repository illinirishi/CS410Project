# CS410Project
</b>Analyzing Text for Topics Modeling and Entity Identification using Amazon Comprehend using EDGAR 10-K filings.</b></br></br>
Data for the project has been used from https://github.com/Vaslo/CS410_Team32_FinalProj.
An excellent tutorial for Topic Analysis is available on the above site. We have taken this dataset to analyse the same using Amazon Comprehend's Topic Modelling capabilities. The datasets work reasonable well in generating a Unigram Output using Comprehend. 
For Entity Identifications we have used a seperate dataset from https://data.world/jumpyaf/2013-2016-cleaned-parsed-10-k-filings-with-the-sec . 
We found that the Management's Discussion and Analysis section was sufficient for us to extract the Identities, we were mainly concerned about identifying key persons and events. This was done using a Java text extractor.


