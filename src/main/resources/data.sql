insert into countries (id, code, name, continent, wikipedia_link, keywords)
                     SELECT * FROM CSVREAD('classpath:countries.csv');
insert into airports (id, ident, type, name, latitude_deg, longitude_deg, elevation_ft,
                     continent, iso_country, iso_region, municipality, scheduled_service, gps_code,
                     iata_code,local_code, home_link, wikipedia_link, keywords)
                     SELECT * FROM CSVREAD('classpath:airports.csv');
insert into runways (id, airport_ref, airport_ident, length_ft, width_ft, surface, lighted,
                     closed, le_ident, le_latitude_deg, le_longitude_deg, le_elevation_ft,
                     le_heading_degT, le_displaced_threshold_ft, he_ident, he_latitude_deg,
                     he_longitude_deg, he_elevation_ft, he_heading_degT, he_displaced_threshold_ft)
                     SELECT * FROM CSVREAD('classpath:runways.csv');
