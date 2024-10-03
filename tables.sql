CREATE TABLE DOCTOR(
	doctor_ID INT NOT NULL,
    license_num INT NOT NULL,
    last_Name VARCHAR(50), 
    first_Name VARCHAR(50),
    field VARCHAR(50), 
    specialization VARCHAR(50), 
    contact_number INT, 
    email VARCHAR(50), 
    dep_ID INT NOT NULL,
    work_hrs VARCHAR(50),
    CONSTRAINT DOCTOR_PK PRIMARY KEY(doctor_ID),
    CONSTRAINT DOCTOR_FK FOREIGN KEY(dep_ID) REFERENCES DEPARTMENT(department_ID)
);


/* Viewing portion

SELECT * FROM DOCTOR 
LEFT JOIN 
*/