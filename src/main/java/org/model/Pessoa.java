// package org.model;

// import java.util.Objects;

// import javax.persistence.*;
// import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

// @Entity
// public class Pessoa extends PanacheEntityBase {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column
//     private String name;

//     @Column
//     private Double calories;

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public Double getCalories() {
//         return calories;
//     }

//     public void setCalories(Double calories) {
//         this.calories = calories;
//     }

//     @Override
//     public boolean equals(Object o) {
//         if (this == o) return true;
//         if (o == null || getClass() != o.getClass()) return false;
//         Pessoa Pessoa = (Pessoa) o;
//         return Objects.equals(id, Pessoa.id);
//     }

//     @Override
//     public int hashCode() {
//         return Objects.hash(id);
//     }
// }