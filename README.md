##Projeto criação de uma API RESTFul, com Java e Spring Boot com integração de um banco de dados relacional, e com Spring Security JWT.

## Diagrama de Classes:

```mermaid
classDiagram
    class User {
        -String name
        -Account account
    }
    
    class Account {
        -String login
        -String password
    }
    
    class Categoria {
        -String icon
        -String name
        -String description
    }
    
    class Item {
        -String Categorias
        -String icon
        -String name
        -double price
        -String description
    }
    
    class Order {
        -String item
    }
    
    User "1" -- "1" Account
    User "1" -- "*" Categoria
    User "1" -- "*" Item
    User "1" -- "*" Order
    Categoria "1" -- "*" Item
    Item "1" -- "*" Order
