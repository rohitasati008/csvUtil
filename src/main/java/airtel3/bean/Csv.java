package airtel3.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="csv")
public class Csv {
	
@Id
@Column(name = "cafno")
int cafno ;
@Column(name ="imsi")
int imsi ;
public int getCafNo() {
	return cafno;
}
public void setCafNo(int cafNo) {
	this.cafno = cafNo;
}
public int getImsi() {
	return imsi;
}
public void setImsi(int imsi) {
	this.imsi = imsi;
}
}
