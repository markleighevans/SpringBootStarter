INSERT INTO outgoings_type (index_linked, outgoings_type_name) VALUES (True,"Transport");
INSERT INTO outgoings_type (index_linked, outgoings_type_name) VALUES (True,"Recreation and culture");
INSERT INTO outgoings_type (index_linked, outgoings_type_name) VALUES (True,"Housing net fuel and power");
INSERT INTO outgoings_type (index_linked, outgoings_type_name) VALUES (True,"Other expenditure items");
INSERT INTO outgoings_type (index_linked, outgoings_type_name) VALUES (True,"Food and non-alcoholic drinks");
INSERT INTO outgoings_type (index_linked, outgoings_type_name) VALUES (True,"Restaurants and hotels");
INSERT INTO outgoings_type (index_linked, outgoings_type_name) VALUES (True,"Miscellaneous goods and services");
INSERT INTO outgoings_type (index_linked, outgoings_type_name) VALUES (True,"Household goods and services");
INSERT INTO outgoings_type (index_linked, outgoings_type_name) VALUES (True,"Clothing and footwear");
INSERT INTO outgoings_type (index_linked, outgoings_type_name) VALUES (True,"Communication");
INSERT INTO outgoings_type (index_linked, outgoings_type_name) VALUES (True,"Alcoholic drinks, tobacco and narcotics");
INSERT INTO outgoings_type (index_linked, outgoings_type_name) VALUES (True,"Health");
INSERT INTO outgoings_type (index_linked, outgoings_type_name) VALUES (True,"Education");
INSERT INTO income_type (income_type_name, income_type_weighting, index_linked, stress_outcome) VALUES ("State Pension",100, True, 40);
INSERT INTO income_type (income_type_name, income_type_weighting, index_linked, stress_outcome) VALUES ("Rental Income",80, True, 100);
INSERT INTO income_type (income_type_name, income_type_weighting, index_linked, stress_outcome) VALUES ("Defined Benefit Pension",100, True, 40);
INSERT INTO income_type (income_type_name, income_type_weighting, index_linked, stress_outcome) VALUES ("Annuity",100, False, 50);
INSERT INTO quote_summary (applicant1name, applicant2name, applicant_count, product_description, from_date, to_date, amount, proceeded_with) VALUES ("Mr Smith","Mrs Smith", 2, "RIO 3%", "2019-03-29 00:00:00", "2054-03-29 00:00:00", 150000, false );
INSERT INTO quote_summary (applicant1name, applicant2name, applicant_count, product_description, from_date, to_date, amount, proceeded_with) VALUES ("Mr Jones","Mrs Jones", 2, "55+ 3.4%", "2019-05-13 00:00:00", "2054-05-13 00:00:00", 125000, false);
INSERT INTO quote_summary (applicant1name, applicant2name, applicant_count, product_description, from_date, to_date, amount, proceeded_with) VALUES ("Mr Bond","Mrs Bond", 2, "55+ 3.4%", "2019-05-13 00:00:00", "2054-05-13 00:00:00", 125000, false);
INSERT INTO quote_summary (applicant1name, applicant2name, applicant_count, product_description, from_date, to_date, amount, proceeded_with) VALUES ("Mr Davies","Mrs Davies", 2, "55+ 3.4%", "2019-05-13 00:00:00", "2054-05-13 00:00:00", 140000, false);
INSERT INTO quote_summary (applicant1name, applicant2name, applicant_count, product_description, from_date, to_date, amount, proceeded_with) VALUES ("Mr Kurnow","Mrs Kurnow", 2, "55+ 3.4%", "2019-08-08 00:00:00", "2054-08-08 00:00:00", 160000, false);
INSERT INTO default_outgoings (outgoings_typeid , description, amount) VALUES (1, "Transport", 79.70);
INSERT INTO default_outgoings (outgoings_typeid , description, amount) VALUES (2, "Recreation and culture", 73.5);
INSERT INTO default_outgoings (outgoings_typeid , description, amount) VALUES (3, "Housing net fuel and power", 72.6);
INSERT INTO default_outgoings (outgoings_typeid , description, amount) VALUES (4,  "Other expenditure items", 72.0);
INSERT INTO default_outgoings (outgoings_typeid , description, amount) VALUES (5,  "Food and non-alcoholic drinks", 58.00);
INSERT INTO default_outgoings (outgoings_typeid , description, amount) VALUES (6, "Restaurants and hotels", 50.1);
INSERT INTO default_outgoings (outgoings_typeid , description, amount) VALUES (7, "Miscellaneous goods and services", 41.8);
INSERT INTO default_outgoings (outgoings_typeid , description, amount) VALUES (8, "Household goods and services", 39.3);
INSERT INTO default_outgoings (outgoings_typeid , description, amount) VALUES (9, "Clothing and footwear", 25.10);
INSERT INTO default_outgoings (outgoings_typeid , description, amount) VALUES (10, "Communication" ,17.20);
INSERT INTO default_outgoings (outgoings_typeid , description, amount) VALUES (11,"Alcoholic drinks, tobacco and narcotics", 11.90);
INSERT INTO default_outgoings (outgoings_typeid , description, amount) VALUES (12, "Health", 7.30);
INSERT INTO default_outgoings (outgoings_typeid , description, amount) VALUES (13, "Education", 5.70);
INSERT INTO inflation (inflation_year, inflation) VALUES (2019, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2020, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2021, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2022, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2023, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2024, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2025, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2026, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2027, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2028, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2029, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2030, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2031, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2032, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2033, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2034, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2035, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2036, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2037, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2038, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2039, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2040, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2041, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2042, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2043, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2044, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2045, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2046, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2047, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2048, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2049, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2050, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2051, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2052, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2053, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2054, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2055, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2056, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2057, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2058, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2059, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2060, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2061, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2062, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2063, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2064, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2065, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2066, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2067, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2068, 2.5);
INSERT INTO inflation (inflation_year, inflation) VALUES (2069, 2.5);




