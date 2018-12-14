Java Extractor to extract Management’s Discussion and Analysis section from EDGAR 10-k reports

This file can be executed with the following commands.
 
1.	Copy the file to any folder

2.	Given below are the commands to compile in CMD window (JDK 8 is required)
Javac MDAExtract_FileReader.java
Java MDAExtract_FileReader
 
3.	The Java Extractor needs 2 inputs. (Input file location & output file location), then processes the files. 
Output MDA files will be created at the output location. 
These are the files that are to be uploaded to the Amazon S3 bucket that you would then use for Entity Identification jobs on Amazon Comprehend
  
4.	Following are the steps that this program does.
 
1.	Read files from input location
2.	Read data from file
3.	Read Management’s Discussion and Analysis between Item 7 to item 8 and copy to new file. The 10-k cleaned-parsed files
 ( https://data.world/jumpyaf/2013-2016-cleaned-parsed-10-k-filings-with-the-sec) have a degree ° separator between sections that helps separate two sections.

