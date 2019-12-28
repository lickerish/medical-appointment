-- Addresses --
INSERT INTO address (city, country, house_number, postal_code, street) VALUES ('Poznan', 'Poland', 12, '61-034', 'Wolkowyska');
INSERT INTO address (city, country, house_number, postal_code, street) VALUES ('Krakow', 'Poland', 43, '79-137', 'Bałtycka');

-- Doctors --
INSERT INTO doctor (first_name, last_name, specialization) VALUES ('Michal','Luzny','Dermatolog');
INSERT INTO doctor (first_name, last_name, specialization) VALUES ('Krzysztof','Bronski','Internista');

-- Patients --
INSERT INTO patient (first_name, last_name, address_id) VALUES ('Lech','Roch', 1);
INSERT INTO patient (first_name, last_name, address_id) VALUES ('Marysia','Dancka', 2);

-- Appointments --
INSERT INTO appointment (date, place, time, doctor_id, patient_id) VALUES ('2019-09-13', 'Poznan','12:45',2,1);
INSERT INTO appointment (date, place, time, doctor_id, patient_id) VALUES ('2019-10-15', 'Poznan','14:25',2,1);


