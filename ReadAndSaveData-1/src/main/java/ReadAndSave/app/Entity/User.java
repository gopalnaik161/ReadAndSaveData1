package ReadAndSave.app.Entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long user_Id;
	
	@Column(nullable = false)
	private String user_name;
	

	private String  address;
	

	private String  contact_number;

	private String admin_id;
	

	private String created_by;
	
	
	private Date  date ;
	

	private String is_active;

	 private String result;


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public long getUser_Id() {
		return user_Id;
	}


	public void setUser_Id(long user_Id) {
		this.user_Id = user_Id;
	}


	public String getUser_name() {
		return user_name;
	}





	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


//	public long getContact_number() {
//		return contact_number;
//	}
//
//
//	public void setContact_number(long contact_number) {
//		this.contact_number = contact_number;
//	}
	


	public String getAdmin_id() {
		return admin_id;
	}


	public String getContact_number() {
		return contact_number;
	}


	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}


	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}


	public String getCreated_by() {
		return created_by;
	}


	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getIs_active() {
		return is_active;
	}


	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	
}
