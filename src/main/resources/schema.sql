create table patients(
                         patientId int not null primary key,
                         firstName varchar(50),
                         lastName varchar(50),
                         city varchar(50),
                         createdAt timestamp
)  as select * from CSVREAD('..\demo\src\main\resources\patients.csv');

create table practitioners(
                              practitionerId int not null primary key,
                              specialization varchar(50)
)
as select * from CSVREAD('..\demo\src\main\resources\practitioners.csv');

create table visits(
                       visitId int not null primary key,
                       practitionerId int ,
                       patientId int
) as select * from CSVREAD('..\demo\src\main\resources\visits.csv');
ALTER TABLE visits ADD FOREIGN KEY (patientId) REFERENCES patients(patientId);
ALTER TABLE visits ADD FOREIGN KEY (practitionerId) REFERENCES practitioners(practitionerId);

create table patient2practitioner(
                                     patientId int,
                                     practitionerId int
)
as select * from CSVREAD('..\demo\src\main\resources\patient2practitioner.csv');
ALTER TABLE patient2practitioner ADD FOREIGN KEY (patientId) REFERENCES patients(PATIENTID);
ALTER TABLE patient2practitioner ADD FOREIGN KEY (practitionerId) REFERENCES practitioners(PRACTITIONERID);