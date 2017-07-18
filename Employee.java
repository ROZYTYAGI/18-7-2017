package com.employee;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee { 
	
@Id	
private int id;  
private String firstName,lastName;  
  
public int getId() {  
    return id;  
}  
@Override
public String toString() {
	return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
}
public void setId(int id) {  
    this.id = id;  
}  
public String getFirstName() {  
    return firstName;  
}  
public void setFirstName(String firstName) {  
    this.firstName = firstName;  
}  
public String getLastName() {  
    return lastName;  
}  
public void setLastName(String lastName) {  
    this.lastName = lastName;  
}  
  
  
}  