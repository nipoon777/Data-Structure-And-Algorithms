CREATE table PatientInfo(
  First_name VARCHAR(25),
  Last_name VARCHAR(25),
  age INT,
  PatientID INT(4) UNIQUE,
  DoctorID INT(4),
  PRIMARY KEY(PatientID)
);
INSERT INTO PatientInfo(First_name, Last_name, age, PatientID, DoctorID)
VALUES
("Paul", "Smith", 23, 1000, 1001);
INSERT INTO PatientInfo(First_name, Last_name, age, PatientID, DoctorID)
VALUES
("Brian", "Johnson", 56, 1001, 2010);
INSERT INTO PatientInfo(First_name, Last_name, age, PatientID, DoctorID)
VALUES
("Stephnie", "Jones", 38, 1002, 4045);
INSERT INTO PatientInfo(First_name, Last_name, age, PatientID, DoctorID)
VALUES
("Nancy", "Brown", 86, 1003, 1001);
INSERT INTO PatientInfo(First_name, Last_name, age, PatientID, DoctorID)
VALUES
("Steve", "Martin", 54, 1004, 4045);
INSERT INTO PatientInfo(First_name, Last_name, age, PatientID, DoctorID)
VALUES
("Josh", "Lee", 36, 1005, 3001);
INSERT INTO PatientInfo(First_name, Last_name, age, PatientID, DoctorID)
VALUES
("Jose", "Ramirez", 29, 1006, 1001); 

CREATE table Doctor(
  First_name VARCHAR(25),
  Last_name VARCHAR(25),
  Specilization VARCHAR(25),
  Hospital VARCHAR(25),
  DoctorID INT(4) UNIQUE,
  PRIMARY KEY(DoctorID)
);

INSERT INTO Doctor(First_name, Last_name, Specilization, Hospital, DoctorID)
VALUES
("Andy", "Moore", "Family medicine", "Banner", 1001);
INSERT INTO Doctor(First_name, Last_name, Specilization, Hospital, DoctorID)
VALUES
("Paul", "Anderson", "Neurology", "Phoenix Children", 2010);
INSERT INTO Doctor(First_name, Last_name, Specilization, Hospital, DoctorID)
VALUES 
("John", "Doe", "Pathology", "HonorHealth", 3001);
INSERT INTO Doctor(First_name, Last_name, Specilization, Hospital, DoctorID)
VALUES 
("Josh", "Anderson", "Family medicine", "Banner", 1010);
INSERT INTO Doctor(First_name, Last_name, Specilization, Hospital, DoctorID)
VALUES
("Eric", "Lopez", "Internal Medicine ", "Abrazo", 4045); 


