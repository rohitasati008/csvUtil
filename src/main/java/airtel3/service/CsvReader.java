package airtel3.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

 

import airtel3.App;
import airtel3.bean.Csv;

@Component
public class CsvReader {
    @Autowired
	private CsvRepo csvRepo ;

private void readCsv(String filename) throws IOException
{
	System.out.println("hello Rohit  ");
	String fileSource = "src/resources/"+filename ;
	System.out.println(fileSource);
	BufferedReader reader = new BufferedReader(new FileReader(fileSource));

	// read file line by line
	String line = null;
	Scanner scanner = null;
	int index = 0;
	

	while ((line = reader.readLine()) != null) {
		//Employee emp = new Employee();
		scanner = new Scanner(line);
		scanner.useDelimiter(",");
		while (scanner.hasNext()) {
			String data = scanner.next();
			if (index == 0)
				System.out.println("first word " +data);
			else if (index == 1)
				System.out.println("second word " +data);
			 
			else
				System.out.println("invalid data::" + data);
			index++;
		}
		index = 0;
		 
	}
	
	//close reader
	reader.close();
	
 
	
}

private void readCsvDb(int batchsize)
{
	int jobsize = getJobSize() ;
	int iteration = jobsize /  batchsize ;
	if(jobsize % batchsize == 0)
		iteration+=1 ;
	for (int i =0 ; i < iteration ; i++)
	{
		
	int 	offset = i * batchsize ;
	processdata(offset,batchsize);
		
	}
	Iterable<Csv> mylist =  csvRepo.findAll();
	System.out.println("hello");
	
	
}
	
  private void processdata(int offset, int batchsize) {
	// TODO Auto-generated method stub
	
}

int getJobSize() {
	// TODO Auto-generated method stub
	return 5;
}

public static void main(String[] args) throws IOException {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
	CsvReader csvReader = ctx.getBean(CsvReader.class);
	CsvRepo csv = ctx.getBean(CsvRepo.class);
	
	ReadProperties readProperties = ctx.getBean(ReadProperties.class);
	
	System.out.println(readProperties.getFilename());
	csvReader.readCsv(readProperties.getFilename());
	csvReader.readCsvDb(readProperties.getBatchsize());
}
}
