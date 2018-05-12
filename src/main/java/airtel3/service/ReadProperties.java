package airtel3.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Component
@PropertySource("classpath:application.properties")
public class ReadProperties {
@Value("${filename}")
 private String filename ;
@Value("${time}")
 private int time ;

@Value("${batchsize}")
private int batchsize ;
public String getFilename() {
	return filename;
	

}
public void setFilename(String filename) {
	this.filename = filename;
}
public int getTime() {
	return time;
}
public void setTime(int time) {
	this.time = time;
}
public int  getBatchsize() {
	// TODO Auto-generated method stub
	return batchsize;
}
public void setBatchsize(int batchsize) {
	this.batchsize = batchsize;
}

 
}
