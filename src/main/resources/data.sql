INSERT INTO patient_tb (name, gender, birthdate, email, blood_group_type) VALUES
                                                                              ('Sachin', 'Male', '2005-05-15', 'sachin.p@gmail.com', 'A_POSITIVE'),
                                                                              ('Shivani', 'Female', '2004-06-16', 'shivani.s@gmail.com', 'A_NEGATIVE'),
                                                                              ('Shiva', 'Male', '2003-12-12', 'shiva.s@gmail.com', 'B_POSITIVE'),
                                                                              ('Shiv', 'Male', '2002-04-20', 'yash.s@gmail.com', 'B_POSITIVE'),
                                                                              ('Sid', 'Male', '2000-06-13', 'sid.s@gmail.com', 'A_NEGATIVE');


INSERT INTO doctor(name,specialization,email) VALUES
                                                  ('Dr.Rakesh','Cardiology','rakesh.r@gmail.com'),
                                                  ('Dr.Sneha','Dermatology','sneha.s@gmail.com'),
                                                  ('Dr.Arjun','Orthopedics','arjun.a@gmail.com');



INSERT INTO appointment (appointment_time, reason, doctor_id, patient_id) VALUES
    ('2025-09-07 09:30:00', 'General Checkup', 1, 1),
    ('2025-09-07 11:00:00', 'Follow-up Consultation', 2, 2),
    ('2025-09-08 14:00:00', 'Blood Test Review', 1, 3),
    ('2025-09-09 10:15:00', 'Cardiology Check', 3, 2),
    ('2025-09-09 16:45:00', 'Neurology Consultation', 2, 2),
    ('2025-09-10 12:30:00', 'Dermatology Follow-up', 2, 3);


