
-- Database Creation for Atm Machine Project
create database Atm;

-- Using the Atm db
use Atm;

-- Table Creation 
create table Atmusers (Accno INT(9) NOT NULL,
			Name VARCHAR(25) NOT NULL,
			Pin INT(5) NOT NULL,
			Dob DATE,
			Balance INT(10) NOT NULL,
			Mobile BIGINT(11) NOT NULL,
			Gender VARCHAR(6) NOT NULL);
		
--Displaying the table			
show tables;		

--Describing the table structure
desc Atmusers;	

-- Duplicate Value Insertion
Insert into Atmusers (Accno,Name,Pin,Dob,Balance,Mobile,Gender) Values (123456,"John",9798,'1945-05-05',100000,97979797,"Male");

