-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               12.2.2-MariaDB - MariaDB Server
-- Server OS:                    Win64
-- HeidiSQL Version:             12.15.0.7171
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Data exporting was unselected.

-- Data exporting was unselected.

-- Data exporting was unselected.

-- Data exporting was unselected.

-- Data exporting was unselected.

-- Data exporting was unselected.

-- Data exporting was unselected.

-- Data exporting was unselected.

-- Data exporting was unselected.

-- Data exporting was unselected.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

-- Property Addresses
INSERT INTO property_address (
    property_address_id, created_time_stamp, last_update_time_stamp,
    door_no, street, city, pincode, country
) VALUES
('PA001', NOW(), NOW(), '12-34', 'MG Road', 'Bengaluru', '560001', 'India'),
('PA002', NOW(), NOW(), '45', 'Park Street', 'Kolkata', '700016', 'India'),
('PA003', NOW(), NOW(), '22B', 'Marine Drive', 'Mumbai', '400020', 'India');

-- Addresses (for users or owners)
INSERT INTO address (
    id, created_time_stamp, last_update_time_stamp,
    door_no, street, city, pincode, country
) VALUES
('A001', NOW(), NOW(), '101', 'Brigade Road', 'Bengaluru', '560025', 'India'),
('A002', NOW(), NOW(), '7-8-9', 'Connaught Place', 'New Delhi', '110001', 'India'),
('A003', NOW(), NOW(), '56', 'Baner Road', 'Pune', '411045', 'India');

-- Properties
INSERT INTO property (
    property_id, name, description, number_of_rooms,
    owner_id, property_address_property_address_id,
    created_time_stamp, last_update_time_stamp
) VALUES
('P001', 'Sunshine Residency', 'Modern apartments with amenities', 2, 'U001', 'PA001', NOW(), NOW()),
('P002', 'Green View Apartments', 'Spacious flats near park', 2, 'U002', 'PA002', NOW(), NOW()),
('P003', 'Ocean Breeze Towers', 'Sea-facing luxury apartments', 2, 'U003', 'PA003', NOW(), NOW());

-- Rooms
INSERT INTO room (
    room_d, property_id, room_number, floor, description,
    sharing, number_of_beds, created_time_stamp, last_update_time_stamp
) VALUES
('R001', 'P001', '101', '1', 'Single room with balcony', 1, 1, NOW(), NOW()),
('R002', 'P001', '102', '1', 'Double sharing room with attached bath', 2, 2, NOW(), NOW()),
('R003', 'P002', '201', '2', 'Triple sharing furnished room', 3, 3, NOW(), NOW()),
('R004', 'P002', '202', '2', 'Single room with study desk', 1, 1, NOW(), NOW()),
('R005', 'P003', '301', '3', 'Large room with 4 beds', 4, 4, NOW(), NOW()),
('R006', 'P003', '302', '3', 'Compact double sharing room', 2, 2, NOW(), NOW());

-- Property-Rooms mapping
INSERT INTO property_rooms (property_property_id, rooms_room_d) VALUES
('P001', 'R001'),
('P001', 'R002'),
('P002', 'R003'),
('P002', 'R004'),
('P003', 'R005'),
('P003', 'R006');
