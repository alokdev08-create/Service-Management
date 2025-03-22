System Flow Summary:
-------------------

1.Service providers are registered and categorized.

2.Customers register and search for services.

3.Bookings are created and payments processed.

4.Services are fulfilled, and bookings are marked as completed.

5.Feedback and ratings are collected.

6.Booking history is tracked for future reference and reporting.


Sql Script
----------

CREATE TABLE service_providers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    service_type VARCHAR(50) NOT NULL,
    contact_number VARCHAR(15) NOT NULL,
    email VARCHAR(100),
    address TEXT,
    availability_status BOOLEAN DEFAULT true,
    rating FLOAT CHECK (rating BETWEEN 1.0 AND 5.0),
    special_notes TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


CREATE TABLE service_categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(50) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


CREATE TABLE customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    contact_number VARCHAR(15) NOT NULL,
    email VARCHAR(100),
    address TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


CREATE TABLE service_requests (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    service_provider_id INT NOT NULL,
    service_category_id INT NOT NULL,
    request_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) DEFAULT 'Pending',
    notes TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (service_provider_id) REFERENCES service_providers(id),
    FOREIGN KEY (service_category_id) REFERENCES service_categories(id)
);


CREATE TABLE service_bookings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    service_provider_id INT NOT NULL,
    service_category_id INT NOT NULL,
    booking_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    appointment_date TIMESTAMP NOT NULL,
    status VARCHAR(20) DEFAULT 'Scheduled',
    notes TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (service_provider_id) REFERENCES service_providers(id),
    FOREIGN KEY (service_category_id) REFERENCES service_categories(id)
);


CREATE TABLE booking_history (
    id INT AUTO_INCREMENT PRIMARY KEY,
    booking_id INT NOT NULL,
    customer_id INT NOT NULL,
    service_provider_id INT NOT NULL,
    service_category_id INT NOT NULL,
    booking_date TIMESTAMP NOT NULL,
    completion_date TIMESTAMP,
    status VARCHAR(20) DEFAULT 'Completed',
    feedback TEXT,
    rating FLOAT CHECK (rating BETWEEN 1.0 AND 5.0),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (booking_id) REFERENCES service_bookings(id),
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (service_provider_id) REFERENCES service_providers(id),
    FOREIGN KEY (service_category_id) REFERENCES service_categories(id)
);


CREATE TABLE booking_payments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    booking_id INT NOT NULL,
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    amount DECIMAL(10, 2) NOT NULL,
    payment_status VARCHAR(20) DEFAULT 'Pending',
    payment_method VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (booking_id) REFERENCES service_bookings(id)
);

Basic service type.
-------------------
INSERT INTO service_categories (category_name, description, created_at, updated_at)
VALUES
    ('AC Mechanic', 'Specialized in air conditioning repair and maintenance.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Electrician', 'Handles electrical wiring, fan repairs, and installations.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Plumber', 'Specialized in water pipe repairs and plumbing services.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Carpenter', 'Provides furniture repair and custom woodwork.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Painter', 'Specialized in wall and house painting services.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Gardener', 'Offers gardening and landscaping services.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Home Cleaner', 'Provides home and office cleaning services.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Pest Control Specialist', 'Handles pest control and eradication services.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Appliance Repair Technician', 'Specialized in repairing household appliances.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Roofer', 'Handles roof repairs and installations.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Mason', 'Specialized in masonry and brickwork services.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Welder', 'Offers welding and metal fabrication services.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Locksmith', 'Handles lock repairs and key replacement services.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Mechanic', 'Specialized in automotive repair and maintenance.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('HVAC Specialist', 'Handles heating, ventilation, and air conditioning systems.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('IT Support', 'Provides technical support for computer systems and networks.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Tutor', 'Offers educational tutoring in various subjects.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Event Organizer', 'Provides event planning and organizing services.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Catering Service', 'Offers food preparation and catering for events.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Laundry Service', 'Specialized in laundry and dry-cleaning services.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
