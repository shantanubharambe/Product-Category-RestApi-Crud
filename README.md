# Product-Category REST API (CRUD)

## Overview
This is a **Spring Boot REST API** that allows CRUD operations on **Categories** and **Products** with a **one-to-many relationship**. The API also supports **server-side pagination**.

##  Technologies Used
- **Spring Boot** (REST API)
- **Spring Data JPA** (ORM & Hibernate)
- **MySQL** (Relational Database)
- **Spring Boot Pagination**

##  Features
   CRUD operations for **Categories**  
   CRUD operations for **Products**  
   One-to-Many relationship between **Category and Product**  
   **Pagination support** for large datasets  
   **Exception handling** for invalid requests  

##  API Endpoints

### ** Category APIs**
| Method | Endpoint | Description |
|--------|---------|-------------|
| **POST** | `/api/categories` | Create a new category |
| **GET** | `/api/categories?page=0&size=10` | Get paginated list of categories |
| **GET** | `/api/categories/{id}` | Get category details by ID |
| **PUT** | `/api/categories/{id}` | Update an existing category |
| **DELETE** | `/api/categories/{id}` | Delete a category by ID |

### ** Product APIs**
| Method | Endpoint | Description |
|--------|---------|-------------|
| **POST** | `/api/products` | Create a new product |
| **GET** | `/api/products?page=0&size=10` | Get paginated list of products |
| **GET** | `/api/products/{id}` | Get product details by ID |
| **PUT** | `/api/products/{id}` | Update an existing product |
| **DELETE** | `/api/products/{id}` | Delete a product by ID |

---
