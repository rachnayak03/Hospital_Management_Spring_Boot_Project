INSERT INTO patient (name, gender, birth_date, email, blood_group) VALUES
('John Doe', 'Male', '1985-03-12', 'john.doe@example.com', 'A_POSITIVE'),
('Emily Smith', 'Female', '1990-07-25', 'emily.smith@example.com', 'B_NEGATIVE'),
('Michael Johnson', 'Male', '1978-11-09', 'michael.j@example.com', 'O_POSITIVE'),
('Sarah Williams', 'Female', '2001-02-17', 'sarah.w@example.com', 'AB_POSITIVE'),
('David Brown', 'Male', '1995-06-30', 'david.b@example.com', 'A_NEGATIVE');


INSERT INTO doctor (name, specialization, email)
VALUES ('Dr. Sarah Thompson', 'Cardiology', 'sarah.thompson@example.com');


INSERT INTO doctor (name, specialization, email)
VALUES ('Dr. James Wilson', 'Neurology', 'james.wilson@example.com');


INSERT INTO doctor (name, specialization, email)
VALUES ('Dr. Emily Carter', 'Pediatrics', 'emily.carter@example.com');


INSERT INTO doctor (name, specialization, email)
VALUES ('Dr. Rajesh Mehta','Pediatrics', 'rajesh.mehta@example.com');

INSERT INTO appointment (appointment_time, reason, patient_id, doctor_id)
VALUES ('2025-08-10 10:00:00', 'Routine check-up', 1, 2);

INSERT INTO appointment (appointment_time, reason, patient_id, doctor_id)
VALUES ('2025-08-11 14:30:00', 'Headache and dizziness', 2, 1);

INSERT INTO appointment (appointment_time, reason, patient_id, doctor_id)
VALUES ('2025-08-12 09:15:00', 'Follow-up for surgery', 3, 4);

INSERT INTO appointment (appointment_time, reason, patient_id, doctor_id)
VALUES ('2025-08-13 11:45:00', 'Skin rash consultation', 4, 4);

INSERT INTO appointment (appointment_time, reason, patient_id, doctor_id)
VALUES ('2025-08-14 16:00:00', 'Child vaccination', 5, 3);

